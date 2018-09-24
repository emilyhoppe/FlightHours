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

import model.Aircraft;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AircraftDAO {

    //Instance variables
    private String dbURL = "jdbc:derby:FlightHours";
    private Connection conn = null;
    private PreparedStatement selectAllAircraft;
    private PreparedStatement selectAircraftByStation;
    private PreparedStatement selectAircraftByTailNumber;
    private PreparedStatement selectAircraftByMaintFlag;
    private PreparedStatement insertNewAircraft;
    private PreparedStatement modifyAircraft;
    private PreparedStatement tailNumberExists;
    private DefaultTableModel acTableModel;

    //Constructor
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

            tailNumberExists = conn.prepareStatement("SELECT COUNT(*) FROM aircraft WHERE tail_number = ?");

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
                    + "WHERE tail_number = ?");

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
                    + "WHERE maintenance_flag = ?");

            insertNewAircraft = conn.prepareStatement("INSERT INTO aircraft"
                    + "(tail_number,"
                    + " aircraft_type,"
                    + " station_id,"
                    + " max_speed,"
                    + " max_altitude,"
                    + " total_flight_hours,"
                    + " current_maintenance_hours,"
                    + " maintenance_hours_threshold)"
                    + "VALUES (?,?,?,?,?,?,?,?)");

            modifyAircraft = conn.prepareStatement("UPDATE AIRCRAFT SET"
                    + " tail_number   = ?,"
                    + " aircraft_type = ?,"
                    + " station_id    = ?,"
                    + " max_speed     = ?,"
                    + " max_altitude  = ?,"
                    + " total_flight_hours         = ?,"
                    + " current_maintenance_hours  = ?,"
                    + " maintenance_hours_threshold= ?,"
                    + " end_of_service_date        = ?"
                    + "WHERE aircraft_id           = ?");

        } catch (SQLException except) {
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Select all aircraft from database and return a DefaultTableModel object
    public DefaultTableModel selectAllAircraft() {

        ResultSet resultSet = null;

        try {
            resultSet = selectAllAircraft.executeQuery();

        } catch (SQLException sqlExcept) {
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        acTableModel = createAircraftTableModel(resultSet);
        return acTableModel;
    }

    //Select all aircraft by station from database and return a DefaultTableModel object
    public DefaultTableModel selectAircraftByStation(int inStationID) {

        ResultSet resultSet = null;

        try {
            selectAircraftByStation.setInt(1, inStationID);
            resultSet = selectAircraftByStation.executeQuery();

        } catch (SQLException sqlExcept) {
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        acTableModel = createAircraftTableModel(resultSet);
        return acTableModel;
    }

    //Select aircraft by tail number from database and return a DefaultTableModel object
    public DefaultTableModel selectAircraftByTailnumber(String inTailNumber) {

        ResultSet resultSet = null;
        try {
            selectAircraftByTailNumber.setString(1, inTailNumber);
            resultSet = selectAircraftByTailNumber.executeQuery();

        } catch (SQLException sqlExcept) {
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        acTableModel = createAircraftTableModel(resultSet);
        return acTableModel;
    }

    //Select all aircraft by maint flag from database and return a DefaultTableModel object
    public DefaultTableModel selectAircraftByMaintFlag(boolean inMaintFlag) {

        ResultSet resultSet = null;
        try {
            selectAircraftByMaintFlag.setBoolean(1, inMaintFlag);
            resultSet = selectAircraftByMaintFlag.executeQuery();

        } catch (SQLException sqlExcept) {
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        acTableModel = createAircraftTableModel(resultSet);
        return acTableModel;
    }

    //Insert a new aircraft into the database
    public int insertNewAircraft(Aircraft inAircraft) {
        int result = 0;

        try {
            insertNewAircraft.setString(1, inAircraft.getTailNumber());
            insertNewAircraft.setString(2, inAircraft.getAircraftType());
            insertNewAircraft.setInt(3, inAircraft.getStationID());
            insertNewAircraft.setInt(4, inAircraft.getMaxSpeed());
            insertNewAircraft.setInt(5, inAircraft.getMaxAltitude());
            insertNewAircraft.setInt(6, inAircraft.getTotalFlightHours());
            insertNewAircraft.setInt(7, inAircraft.getCurrentMaintenanceHours());
            insertNewAircraft.setInt(8, inAircraft.getMaintenanceHoursThreshold());
            result = insertNewAircraft.executeUpdate();

        } catch (SQLException sqlExcept) {
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }

    //Modify an existing aircraft in the database
    public int modifyAircraft(Aircraft inAircraft) {
        int result = 0;

        try {
            modifyAircraft.setString(1, inAircraft.getTailNumber());
            modifyAircraft.setString(2, inAircraft.getAircraftType());
            modifyAircraft.setInt(3, inAircraft.getStationID());
            modifyAircraft.setInt(4, inAircraft.getMaxSpeed());
            modifyAircraft.setInt(5, inAircraft.getMaxAltitude());
            modifyAircraft.setInt(6, inAircraft.getTotalFlightHours());
            modifyAircraft.setInt(7, inAircraft.getCurrentMaintenanceHours());
            modifyAircraft.setInt(8, inAircraft.getMaintenanceHoursThreshold());
            if (inAircraft.getEndOfServiceDate() != null) {
                modifyAircraft.setDate(9, new java.sql.Date(inAircraft.getEndOfServiceDate().getTime()));
            } else {
                modifyAircraft.setDate(9, null);
            }
            modifyAircraft.setInt(10, inAircraft.getAircraftID());

            result = modifyAircraft.executeUpdate();

        } catch (SQLException sqlExcept) {
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }

    //Check database to see if a tail number already exists, they must be unique
    public boolean tailNumberExists(String tailNumber) {

        boolean result = false;
        ResultSet resultSet = null;

        try {
            tailNumberExists.setString(1, tailNumber);
            resultSet = tailNumberExists.executeQuery();
            resultSet.next();
            int number = resultSet.getInt(1);

            if (number > 0) {
                result = true;
            }

        } catch (SQLException sqlExcept) {
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }

    //Create a DefaultTableModel from a ResultSet for the Aircraft Table
    private DefaultTableModel createAircraftTableModel(ResultSet results) {

        Vector<String> tableColumns = new Vector<String>();
        Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();

        tableColumns.add("ID");
        tableColumns.add("Tail Number");
        tableColumns.add("Type");
        tableColumns.add("AMO Station");
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
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        DefaultTableModel aircraftTableModel = new DefaultTableModel(tableData, tableColumns) {
            //Override isCellEditable method and make all cells non-editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            //Override getColumnClass to set column types correctly for proper sorting
            //This also makes the boolean values show as checkboxes which is nice
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return Integer.class;
                    case 5:
                        return Integer.class;
                    case 6:
                        return Integer.class;
                    case 7:
                        return Boolean.class;
                    case 8:
                        return Integer.class;
                    case 9:
                        return Integer.class;
                    case 10:
                        return Date.class;
                    default:
                        return String.class;
                }
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
