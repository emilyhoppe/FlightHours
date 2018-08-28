/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthours;

/**
 *
 * @author tamerjj1
 */
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

        } catch (Exception except) {
            except.printStackTrace();
        }
        
        //createConnection();
    }
    private static void createConnection() {
        try {
            
            conn = DriverManager.getConnection(dbURL);
            selectStationByType = conn.prepareStatement("SELECT * FROM STATIONS WHERE STATION_TYPE = ?");

        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    private static void selectAllStations() {

        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i = 1; i <= numberCols; i++) {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i) + "\t\t");
            }

            System.out.println("\n-------------------------------------------------");

            while (results.next()) {
                int id = results.getInt(1);
                String restName = results.getString(2);
                String cityName = results.getString(3);
                System.out.println(id + "\t\t" + restName + "\t\t" + cityName);
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
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
