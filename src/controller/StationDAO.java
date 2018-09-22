/** **********
 *
 *      Class:         StationDAO.java
 *      Package:       controller
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: StationDAO accesses the embedded Apache Derby Database
 *                  and performs the main station functions.
 *
 *
 *********** */
package controller;

import model.Station;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

public class StationDAO {

    private String dbURL = "jdbc:derby:FlightHours";
    //private static String tableName = "STATIONS";
    // jdbc Connection
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement selectStationByType;
    private PreparedStatement selectAllStations;
    private PreparedStatement insertNewStation;
    private List<Station> stationList;

    /* public static void main(String[] args) {
        createConnection();
        //selectAllStations();
        //selectStationType("AMO");
        stationList = selectStationByType("AMO");
        System.out.println(stationList.size());
        shutdown();
     } */
    public StationDAO() {
        try {
            //StationDAO.conn = conn;
            conn = DriverManager.getConnection(dbURL);
            selectStationByType = conn.prepareStatement("SELECT * FROM stations WHERE station_type = ?");
            selectAllStations = conn.prepareStatement("SELECT * FROM stations");

            insertNewStation = conn.prepareStatement("INSERT INTO stations (station_name, station_type)"
                    + "VALUES (?, ?)");

        } catch (Exception except) {
            except.printStackTrace();
        }

        //createConnection();
    }

    public List< Station> selectAllStations() {

        List<Station> results = null;
        ResultSet resultSet = null;

        try {
            resultSet = selectAllStations.executeQuery();
            results = new ArrayList<Station>();

            while (resultSet.next()) {
                results.add(new Station(
                        resultSet.getInt("station_id"),
                        resultSet.getString("station_name"),
                        resultSet.getString("station_type")));
            }

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException sqlExcept) {
                sqlExcept.printStackTrace();
            }
        }

        return results;
    }

    public List<Station> selectStationByType(String stationType) {

        List<Station> results = null;
        ResultSet resultSet = null;
        try {
            selectStationByType.setString(1, stationType);
            resultSet = selectStationByType.executeQuery();
            results = new ArrayList<Station>();

            while (resultSet.next()) {
                results.add(new Station(
                        resultSet.getInt("station_id"),
                        resultSet.getString("station_name"),
                        resultSet.getString("station_type")));
            }

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException sqlExcept) {
                sqlExcept.printStackTrace();
            }
        }
        return results;
    }

    public int addStation(Station inStation) {
        int result = 0;

        try {
            insertNewStation.setString(1, inStation.getStationName());
            insertNewStation.setString(2, inStation.getStationType());
            result = insertNewStation.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }

        return result;
    }

    private void shutdown() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                //DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }
        } catch (SQLException sqlExcept) {

        }

    }

}
