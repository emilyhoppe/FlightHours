/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthours;

/**
 *
 * @author jjtam
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import javax.swing.JTable;

public class TestAircraftDAO {
    private static String dbURL = "jdbc:derby:FlightHours";
    private static String tableName = "AIRCRAFT";

    private static Connection conn = null;
    private static AircraftDAO aircraftQueries;
    //private static List<Station> stationList;
    private static JTable aircraftTable;

    public static void main(String args[]) {
        int result;
        new TestAircraftDAO();
        try {
            conn = DriverManager.getConnection(dbURL);

        } catch (Exception except) {
            except.printStackTrace();
        }
        
        aircraftQueries = new AircraftDAO(conn);
        
        aircraftTable = aircraftQueries.selectAllAircraft();

        System.out.println("Stop Here");

    }

}
