/** **********
 *
 *      Class:         OperationDAO.java
 *      Package:       controller
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: OperationDAO accesses the embedded Apache Derby Database
 *                  and performs the main operation functions.
 *
 *
 *********** */
package controller;

import model.Operation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class OperationDAO {

    private String dbURL = "jdbc:derby:FlightHours";
    private Connection conn = null;
    private PreparedStatement selectOperationByAircraft;
    private PreparedStatement insertNewOperation;
    private PreparedStatement modifyOperation;
    private PreparedStatement modifyAircraftCurrentHours;
    private PreparedStatement modifyAircraftTotalHours;
    private PreparedStatement retrieveAircraftCurrentHours;
    private PreparedStatement retrieveAircraftTotalHours;
    private PreparedStatement retrieveOperationHours;
    private PreparedStatement retrieveLastMaintenanceDate;
    private DefaultTableModel opTableModel;

    public OperationDAO() {
        try {
            conn = DriverManager.getConnection(dbURL);
            selectOperationByAircraft = conn.prepareStatement("SELECT "
                    + "operations.operation_id, "
                    + "operations.aircraft_id, "
                    + "operations.station_id, "
                    + "operations.mission_id, "
                    + "operations.operation_name, "
                    + "stations.station_name, "
                    + "missions.mission_name, "
                    + "operations.operation_start_date, "
                    + "operations.operation_end_date, "
                    + "operations.operation_flight_hours "
                    + "FROM operations "
                    + "INNER JOIN stations ON operations.station_id = stations.station_id "
                    + "INNER JOIN missions on operations.mission_id = missions.mission_id "
                    + "WHERE aircraft_id = ? "
                    + "ORDER BY operation_id");

            insertNewOperation = conn.prepareStatement("INSERT INTO operations"
                    + " (aircraft_id,"
                    + " station_id,"
                    + " mission_id,"
                    + " operation_name,"
                    + " operation_start_date,"
                    + " operation_end_date,"
                    + " operation_flight_hours)"
                    + "VALUES (?,?,?,?,?,?,?)");

            retrieveAircraftCurrentHours = conn.prepareStatement("SELECT current_maintenance_hours"
                    + " FROM aircraft WHERE aircraft_id = ?");

            retrieveAircraftTotalHours = conn.prepareStatement("SELECT total_flight_hours"
                    + " FROM aircraft WHERE aircraft_id = ?");

            modifyAircraftCurrentHours = conn.prepareStatement("UPDATE aircraft SET"
                    + " current_maintenance_hours = ?"
                    + " WHERE aircraft_id = ?");

            modifyAircraftTotalHours = conn.prepareStatement("UPDATE aircraft SET"
                    + " total_flight_hours = ?"
                    + " WHERE aircraft_id = ?");

            retrieveOperationHours = conn.prepareStatement("SELECT operation_flight_hours"
                    + " FROM operations WHERE operation_id = ?");

            retrieveLastMaintenanceDate = conn.prepareStatement("SELECT maintenance_end_date"
                    + " FROM maintenance WHERE aircraft_id = ? ORDER BY maintenance_end_date DESC");

            modifyOperation = conn.prepareStatement("UPDATE operations SET"
                    + " station_id = ?,"
                    + " mission_id = ?,"
                    + " operation_name = ?,"
                    + " operation_start_date = ?,"
                    + " operation_end_date = ?,"
                    + " operation_flight_hours = ?"
                    + " WHERE operation_id = ?");

        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    public DefaultTableModel selectOperationsByAircraft(int aircraftID) {

        ResultSet resultSet = null;
        try {
            selectOperationByAircraft.setInt(1, aircraftID);
            resultSet = selectOperationByAircraft.executeQuery();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        opTableModel = createOperationTableModel(resultSet);
        return opTableModel;
    }

    public int insertNewOperation(Operation inOperation) {
        int result = 0;
        int additionalHours = inOperation.getOperationFlightHour();
        try {
            insertNewOperation.setInt(1, inOperation.getAircraftID());
            insertNewOperation.setInt(2, inOperation.getStationID());
            insertNewOperation.setInt(3, inOperation.getMissionID());
            insertNewOperation.setString(4, inOperation.getOperationName());
            insertNewOperation.setDate(5, new java.sql.Date(inOperation.getOperationStartDate().getTime()));
            insertNewOperation.setDate(6, new java.sql.Date(inOperation.getOperationEndDate().getTime()));
            insertNewOperation.setInt(7, additionalHours);
            result = insertNewOperation.executeUpdate();

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        adjustTotalHours(inOperation, additionalHours);
        if (afterMaintenanceDate(inOperation)) {
            adjustCurrentHours(inOperation, additionalHours);
        }
        return result;
    }
    
    public int modifyOperation(Operation inOperation) {
        int result = 0;
        ResultSet resultSet = null;
        int previousHours = 0;
        int newHours = inOperation.getOperationFlightHour();
        //Date lastMaintenanceDate = null;
        Date startDate = new java.sql.Date(inOperation.getOperationStartDate().getTime());
        Date endDate = new java.sql.Date(inOperation.getOperationEndDate().getTime());
        try {
            //Retrieve previous Operation flight hours for modifications to Aircraft's current and total flight hours
            retrieveOperationHours.setInt(1, inOperation.getOperationID());
            resultSet = retrieveOperationHours.executeQuery();
            resultSet.next();
            previousHours = resultSet.getInt(1);

            //Main Operation modifications
            modifyOperation.setInt(1, inOperation.getStationID());
            modifyOperation.setInt(2, inOperation.getMissionID());
            modifyOperation.setString(3, inOperation.getOperationName());
            modifyOperation.setDate(4, startDate);
            modifyOperation.setDate(5, endDate);
            modifyOperation.setInt(6, newHours);
            modifyOperation.setInt(7, inOperation.getOperationID());
            result = modifyOperation.executeUpdate();
            
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

        //If modification was successful, check if Aircraft's current or total hours need modification
        if (result == 1) {

            //If Operation's flight hours are changed and modification was successful
            if (previousHours != newHours) {

                //Calculate Hours Difference (Positive or Negative)                        
                int difference = newHours - previousHours;

                //Change Aircraft Total Hours
                result = adjustTotalHours(inOperation, difference);

                //Check Last Maintenance and change current Aircraft Hours if needed
                // and if the total hours adjustment was successful
                if (afterMaintenanceDate(inOperation) && result == 1) {
                    result = adjustCurrentHours(inOperation, difference);
                }
            }
        }
        
        return result;
    }

    //Used within modifyOperation and insertNewOperation methods above
    public int adjustCurrentHours(Operation inOperation, int difference) {
        int result = 0;
        int newHours = 0;
        int oldHours = 0;
        int aircraftID = inOperation.getAircraftID();
        ResultSet resultSet = null;
        try {
            //Retrieve aircraft's current hours from the database
            retrieveAircraftCurrentHours.setInt(1, aircraftID);
            resultSet = retrieveAircraftCurrentHours.executeQuery();
            resultSet.next();
            oldHours = resultSet.getInt(1);

            //Caluculating new total for aircraft's total hours
            newHours = oldHours + difference;
            //Prevent hours from becoming negative
            if (newHours < 0) {
                newHours = 0;
            }
            //Change the current hours
            modifyAircraftCurrentHours.setInt(1, newHours);
            modifyAircraftCurrentHours.setInt(2, aircraftID);
            result = modifyAircraftCurrentHours.executeUpdate();

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return result;
    }

    //Used within modifyOperation and insertNewOperation methods above
    public int adjustTotalHours(Operation inOperation, int difference) {
        int result = 0;
        int newHours = 0;
        int oldHours = 0;
        int aircraftID = inOperation.getAircraftID();
        ResultSet resultSet = null;
        try {
            //Retrieve aircraft's total hours from the database
            retrieveAircraftTotalHours.setInt(1, aircraftID);
            resultSet = retrieveAircraftTotalHours.executeQuery();
            resultSet.next();
            oldHours = resultSet.getInt(1);

            //Caluculating new total for aircraft's total hours
            newHours = oldHours + difference;
            //Prevent hours from becoming negative
            if (newHours < 0) {
                newHours = 0;
            }
            //Change the total hours
            modifyAircraftTotalHours.setInt(1, newHours);
            modifyAircraftTotalHours.setInt(2, aircraftID);
            result = modifyAircraftTotalHours.executeUpdate();

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return result;
    }

    //Used within modifyOperation and insertNewOperation methods above
    // to check for the Last Maintenance Date
    public boolean afterMaintenanceDate(Operation inOperation) {
        boolean result = false;
        ResultSet resultSet = null;
        Date lastMaintenanceDate = null;
        Date endDate = new java.sql.Date(inOperation.getOperationEndDate().getTime());
        try {
            retrieveLastMaintenanceDate.setInt(1, inOperation.getAircraftID());
            resultSet = retrieveLastMaintenanceDate.executeQuery();

            if (resultSet.next()) {
                lastMaintenanceDate = resultSet.getDate(1);
            }
            //If the new End Date is after the last Maintenance Date
            //Or Last Maintenance Date is null
            if (lastMaintenanceDate == null || 0 < endDate.compareTo(lastMaintenanceDate)) {
                result = true;
            }
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return result;
    }

    private DefaultTableModel createOperationTableModel(ResultSet results) {

        Vector<String> tableColumns = new Vector<String>();
        Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();

        tableColumns.add("ID");
        tableColumns.add("Aircraft ID");
        tableColumns.add("Station ID");
        tableColumns.add("Mission ID");
        tableColumns.add("Name");
        tableColumns.add("USBP Station");
        tableColumns.add("Mission");
        tableColumns.add("Start Date");
        tableColumns.add("End Date");
        tableColumns.add("Flight Hours");

        try {
            //Fill all rows with results
            while (results.next()) {
                Vector<Object> vector = new Vector<Object>();
                vector.add(results.getObject(1));
                vector.add(results.getObject(2));
                vector.add(results.getObject(3));
                vector.add(results.getObject(4));
                vector.add(results.getObject(5));
                vector.add(results.getObject(6));
                vector.add(results.getObject(7));
                vector.add(results.getObject(8));
                vector.add(results.getObject(9));
                vector.add(results.getObject(10));
                tableData.add(vector);
            }
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

        DefaultTableModel operationTableModel = new DefaultTableModel(tableData, tableColumns) {
            //Override default table model method and make all cells non-editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        return operationTableModel;

    }
}
