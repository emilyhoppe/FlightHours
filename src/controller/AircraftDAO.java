/** **********
 *
 *      Class:         AircraftDAO.java
 *      Package:       controller
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: Data access class used to interact with AIRCRAFT database table.
 *
 *
 *********** */
package controller;

import flighthours.Aircraft;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class AircraftDAO {

    private String dbURL = "jdbc:derby:FlightHours";
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement selectAllAircraft;
    private PreparedStatement selectAircraftByStation;
    private PreparedStatement selectAircraftByTailNumber;
    private PreparedStatement selectAircraftByMaintFlag;
    private PreparedStatement insertNewAircraft;
    private PreparedStatement modifyAircraft;
    private PreparedStatement tailNumberExists;
    private List<Aircraft> AircraftList;
    private DefaultTableModel acTableModel;

    public AircraftDAO() {
        try {
            conn = DriverManager.getConnection(dbURL);
            selectAllAircraft = conn.prepareStatement("SELECT "
                    + "aircraft_id, "
                    + "tail_number, "
                    + "aircraft_type, "
                    + "stations.station_name, "
                    + "max_speed, "
                    + "max_altitude, "
                    + "total_flight_hours, "
                    + "maintenance_flag, "
                    + "current_maintenance_hours, "
                    + "maintenance_hours_threshold, "
                    + "end_of_service_date "
                    + "FROM aircraft "
                    + "INNER JOIN stations ON aircraft.station_id = stations.station_id");

            tailNumberExists = conn.prepareStatement("SELECT COUNT(*) FROM AIRCRAFT WHERE TAIL_NUMBER = ?");

            selectAircraftByStation = conn.prepareStatement("SELECT "
                    + "aircraft_id, "
                    + "tail_number, "
                    + "aircraft_type, "
                    + "stations.station_name, "
                    + "max_speed, "
                    + "max_altitude, "
                    + "total_flight_hours, "
                    + "maintenance_flag, "
                    + "current_maintenance_hours, "
                    + "maintenance_hours_threshold, "
                    + "end_of_service_date "
                    + "FROM aircraft "
                    + "INNER JOIN stations ON aircraft.station_id = stations.station_id "
                    + "WHERE aircraft.station_id = ?");

            selectAircraftByTailNumber = conn.prepareStatement("SELECT "
                    + "aircraft_id, "
                    + "tail_number, "
                    + "aircraft_type, "
                    + "stations.station_name, "
                    + "max_speed, "
                    + "max_altitude, "
                    + "total_flight_hours, "
                    + "maintenance_flag, "
                    + "current_maintenance_hours, "
                    + "maintenance_hours_threshold, "
                    + "end_of_service_date "
                    + "FROM aircraft "
                    + "INNER JOIN stations ON aircraft.station_id = stations.station_id "
                    + "WHERE TAIL_NUMBER = ?");

            selectAircraftByMaintFlag = conn.prepareStatement("SELECT "
                    + "aircraft_id, "
                    + "tail_number, "
                    + "aircraft_type, "
                    + "stations.station_name, "
                    + "max_speed, "
                    + "max_altitude, "
                    + "total_flight_hours, "
                    + "maintenance_flag, "
                    + "current_maintenance_hours, "
                    + "maintenance_hours_threshold, "
                    + "end_of_service_date "
                    + "FROM aircraft "
                    + "INNER JOIN stations ON aircraft.station_id = stations.station_id "
                    + "WHERE MAINTENANCE_FLAG = ?");

            insertNewAircraft = conn.prepareStatement("INSERT INTO aircraft"
                    + "(tail_number,"
                    + " aircraft_type,"
                    + " station_id,"
                    + " max_speed,"
                    + " max_altitude,"
                    + " total_flight_hours,"
                    + " maintenance_flag,"
                    + " current_maintenance_hours,"
                    + " maintenance_hours_threshold)"
                    + "VALUES (?,?,?,?,?,?,?,?,?)");

        } catch (Exception except) {
            except.printStackTrace();
        }

    }

    public DefaultTableModel selectAllAircraft() {

        ResultSet resultSet = null;

        try {
            resultSet = selectAllAircraft.executeQuery();

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

        acTableModel = createAircraftTableModel(resultSet);
        return acTableModel;
    }

    public DefaultTableModel selectAircraftByStation(int inStationID) {

        ResultSet resultSet = null;

        try {
            selectAircraftByStation.setInt(1, inStationID);
            resultSet = selectAircraftByStation.executeQuery();

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

        acTableModel = createAircraftTableModel(resultSet);
        return acTableModel;
    }

    public DefaultTableModel selectAircraftByTailnumber(String inTailNumber) {

        ResultSet resultSet = null;
        try {
            selectAircraftByTailNumber.setString(1, inTailNumber);
            resultSet = selectAircraftByTailNumber.executeQuery();

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

        acTableModel = createAircraftTableModel(resultSet);
        return acTableModel;
    }

    public DefaultTableModel selectAircraftByMaintFlag(boolean inMaintFlag) {

        ResultSet resultSet = null;
        try {
            selectAircraftByMaintFlag.setBoolean(1, inMaintFlag);
            resultSet = selectAircraftByMaintFlag.executeQuery();

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

        acTableModel = createAircraftTableModel(resultSet);
        return acTableModel;
    }

    public int insertNewAircraft(Aircraft inAircraft) {
        int result = 0;

        try {
            insertNewAircraft.setString(1, inAircraft.getTailNumber());
            insertNewAircraft.setString(2, inAircraft.getAircraftType());
            insertNewAircraft.setInt(3, inAircraft.getStationID());
            insertNewAircraft.setInt(4, inAircraft.getMaxSpeed());
            insertNewAircraft.setInt(5, inAircraft.getMaxAltitude());
            insertNewAircraft.setInt(6, inAircraft.getTotalFlightHours());
            insertNewAircraft.setBoolean(7, inAircraft.getMaintenanceFlag());
            insertNewAircraft.setInt(8, inAircraft.getCurrentMaintenanceHours());
            insertNewAircraft.setInt(9, inAircraft.getMaintenanceHoursThreshold());

            //java.util.Date myDate = new java.util.Date(inAircraft.getEndOfServiceDate());
            //java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
            //insertNewAircraft.setNull(9, 1); 
            result = insertNewAircraft.executeUpdate();

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

        return result;
    }

    //TODO CREATE FUNCTION
    public int modifyAircraft(Aircraft inAircraft) {
        int result = 0;

        return result;
    }

    public boolean tailNumberExists(String tailNumber) {

        boolean result = false;
        ResultSet resultSet = null;
        
        try {
            tailNumberExists.setString(1, tailNumber);
            resultSet = tailNumberExists.executeQuery();
            resultSet.next();
            int nrows = resultSet.getInt(1);
            
            if (nrows > 0) {
                result = true;
            }

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        
        
        return result;
    }

    private DefaultTableModel createAircraftTableModel(ResultSet results) {

        Vector<String> tableColumns = new Vector<String>();
        Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();

        tableColumns.add("ID");
        tableColumns.add("Tail Number");
        tableColumns.add("Type");
        tableColumns.add("Station");
        tableColumns.add("Max Speed");
        tableColumns.add("Max Altitude");
        tableColumns.add("Total Hours");
        tableColumns.add("Maint Flag");
        tableColumns.add("Maint Hours");
        tableColumns.add("Maint Threshold");
        tableColumns.add("End of Service");

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
                vector.add(results.getObject(11));
                tableData.add(vector);
            }
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

        DefaultTableModel aircraftTableModel = new DefaultTableModel(tableData, tableColumns) {
            //Override default table model method and make all cells non-editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        return aircraftTableModel;

    }

    //Returns an array of strings for the aircraft type combo boxes.
    public static String[] getAircraftTypeArray() {
        String[] aircraftTypeArray = {"Fixed Wing", "Rotary Wing", "UAV"};
        return aircraftTypeArray;
    }
}
