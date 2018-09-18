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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

public class AircraftDAO {

    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement selectAllAircraft;
    private static PreparedStatement selectAircraftByLocation;
    private static PreparedStatement selectAircraftByTailNumber;
    private static PreparedStatement selectAircraftByMaintFlag;
    private static PreparedStatement insertNewAircraft;
    private static PreparedStatement modifyAircraft;
    private static PreparedStatement tailNumberExists;
    private static List<Aircraft> AircraftList;

    public AircraftDAO(Connection conn) {
        try {
            AircraftDAO.conn = conn;
                        
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
            
            tailNumberExists = conn.prepareStatement("SELECT * FROM AIRCRAFT WHERE TAIL_NUMBER = ?");
            
            selectAircraftByLocation
                    = conn.prepareStatement("select * from AIRCRAFT where STATION_ID = (SELECT STATION_ID FROM STATIONS WHERE STATION_NAME = ?)");
            
            selectAircraftByTailNumber = conn.prepareStatement("SELECT * FROM AIRCRAFT WHERE TAIL_NUMBER = ?");
            
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

    public static JTable selectAllAircraft() {

        //List<Aircraft> results = null;
        ResultSet resultSet = null;

        try {
            resultSet = selectAllAircraft.executeQuery();
            while (resultSet.next()) {
                System.out.println("Tail Number" + resultSet.getString("TAIL_NUMBER"));
            }

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

        JTable aircraftTable = new JTable(util.DBUtils.resultSetToTableModel(resultSet));

        return aircraftTable;
    }

    public static List<Aircraft> selectAircraftbyLocation(String inLocation) {

        List<Aircraft> results = null;
        ResultSet resultSet = null;

        //System.out.println("Location: " + inLocation);
        try {
            selectAircraftByLocation.setString(1, inLocation);
            resultSet = selectAircraftByLocation.executeQuery();
            while (resultSet.next()) {
                System.out.println("Tail Number" + resultSet.getString("TAIL_NUMBER"));
            }

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

        return results;
    }

    public static Aircraft selectAircraftByTailnumber(String inTailNumber) {

        Aircraft results = null;
        ResultSet resultSet = null;
        try {
            selectAircraftByTailNumber.setString(1, inTailNumber);
            resultSet = selectAircraftByTailNumber.executeQuery();
            
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

        return results;
    }

    public static List<Aircraft> selectAircraftbyMaintFlag() {

        List<Aircraft> results = null;
        ResultSet resultSet = null;

        return results;
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
            insertNewAircraft.setBoolean(6,inAircraft.getMaintenanceFlag());
            insertNewAircraft.setInt(7, inAircraft.getCurrentMaintenanceHours());   
            //insertNewAircraft.setInt(8, inAircraft.getMaintenanceHoursThreshold());   
            
            //java.util.Date myDate = new java.util.Date(inAircraft.getEndOfServiceDate());
            //java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
            
            //insertNewAircraft.setNull(9, 1); 
          
            result = insertNewAircraft.executeUpdate();
                        
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

        return result;
    }

    public int modifyAircraft(Aircraft inAircraft) {
        int result = 0;

        return result;
    }

    public boolean tailNumberExists(String tailNumber) {

        boolean result = false;
        return result;
    }
}
