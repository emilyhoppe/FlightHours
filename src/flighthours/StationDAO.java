/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Test commit/push
 */
package flighthours;

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

    private static String dbURL = "jdbc:derby:FlightHours";
    private static String tableName = "STATIONS";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement selectStationByType;
    private static PreparedStatement selectAllStations;
    private static PreparedStatement insertNewStation;
    private static List<Station> stationList;

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

            conn = DriverManager.getConnection(dbURL);
            selectStationByType = conn.prepareStatement("SELECT * FROM STATIONS WHERE STATION_TYPE = ?");
            selectAllStations = conn.prepareStatement("SELECT * FROM STATIONS");

            insertNewStation = conn.prepareStatement("INSERT INTO STATIONS (STATION_NAME, STATION_TYPE)"
                    + "VALUES (?, ?)");

        } catch (Exception except) {
            except.printStackTrace();
        }

        //createConnection();
    }

    public static List< Station> selectAllStations() {

        List<Station> results = null;
        ResultSet resultSet = null;

        try {
            resultSet = selectAllStations.executeQuery();
            results = new ArrayList<Station>();

            while (resultSet.next()) {
                results.add(new Station(
                        resultSet.getInt("STATION_ID"),
                        resultSet.getString("STATION_NAME"),
                        resultSet.getString("STATION_TYPE")));
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

    public static List< Station> selectStationByType(String stationType) {

        List<Station> results = null;
        ResultSet resultSet = null;
        try {
            selectStationByType.setString(1, stationType);
            resultSet = selectStationByType.executeQuery();
            results = new ArrayList<Station>();

            while (resultSet.next()) {
                results.add(new Station(
                        resultSet.getInt("STATION_ID"),
                        resultSet.getString("STATION_NAME"),
                        resultSet.getString("STATION_TYPE")));
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

    private static void shutdown() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }
        } catch (SQLException sqlExcept) {

        }

    }

}
