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
import controller.StationDAO;
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

public class TestStationAccess {

    private static String dbURL = "jdbc:derby:FlightHours";
    private static String tableName = "STATIONS";

    private static Connection conn = null;
    private static StationDAO stationQueries;
    private static List<Station> stationList;

    public static void main(String args[]) {
        int result;
        new TestStationAccess();
        try {
            conn = DriverManager.getConnection(dbURL);

        } catch (Exception except) {
            except.printStackTrace();
        }
        
        stationQueries = new StationDAO();
        
        Station inStation = new Station(0, "JHUAPL", "USBP");

        //stationQueries = new StationDAO(conn);
        //stationList = stationQueries.selectStationByType("AMO");
        stationList = stationQueries.selectAllStations();

        result = stationQueries.addStation(inStation);
        System.out.println(result);
        System.out.println(stationList.size());

        for (Station temp : stationList) {
            System.out.println(temp.getStationName());
        }

    }

}
