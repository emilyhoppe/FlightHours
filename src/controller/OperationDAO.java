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
import java.util.Vector;
import javax.swing.JOptionPane;
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
                    + "ORDER BY operations.operation_end_date DESC");

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

            modifyOperation = conn.prepareStatement("UPDATE operations SET"
                    + " station_id = ?,"
                    + " mission_id = ?,"
                    + " operation_name = ?,"
                    + " operation_start_date = ?,"
                    + " operation_end_date = ?,"
                    + " operation_flight_hours = ?"
                    + " WHERE operation_id = ?");

        } catch (SQLException except) {
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel selectOperationsByAircraft(int aircraftID) {

        ResultSet resultSet = null;
        try {
            selectOperationByAircraft.setInt(1, aircraftID);
            resultSet = selectOperationByAircraft.executeQuery();
        } catch (SQLException sqlExcept) {
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        //If operation modification is successful
        if (result == 1) {
            result = modifyTotalHours(inOperation, additionalHours);
        }
        //If operation modification was successful, adjustTotalHours was successful.
        if (result == 1) {
            result = modifyCurrentHours(inOperation, additionalHours);
        }
        return result;
    }

    public int modifyOperation(Operation inOperation) {
        int result = 0;
        try {
            modifyOperation.setInt(1, inOperation.getStationID());
            modifyOperation.setInt(2, inOperation.getMissionID());
            modifyOperation.setString(3, inOperation.getOperationName());
            modifyOperation.setDate(4, new java.sql.Date(inOperation.getOperationStartDate().getTime()));
            modifyOperation.setDate(5, new java.sql.Date(inOperation.getOperationEndDate().getTime()));
            modifyOperation.setInt(6, inOperation.getOperationFlightHour());
            modifyOperation.setInt(7, inOperation.getOperationID());
            result = modifyOperation.executeUpdate();

        } catch (SQLException sqlExcept) {
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    //Used within insertNewOperation method above
    public int modifyCurrentHours(Operation inOperation, int additionalHours) {
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
            newHours = oldHours + additionalHours;

            //Change the current hours
            modifyAircraftCurrentHours.setInt(1, newHours);
            modifyAircraftCurrentHours.setInt(2, aircraftID);
            result = modifyAircraftCurrentHours.executeUpdate();

        } catch (SQLException sqlExcept) {
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    //Used within insertNewOperation method above
    public int modifyTotalHours(Operation inOperation, int additionalHours) {
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
            newHours = oldHours + additionalHours;

            //Change the total hours
            modifyAircraftTotalHours.setInt(1, newHours);
            modifyAircraftTotalHours.setInt(2, aircraftID);
            result = modifyAircraftTotalHours.executeUpdate();

        } catch (SQLException sqlExcept) {
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
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
