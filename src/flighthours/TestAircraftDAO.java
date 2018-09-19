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
import controller.AircraftDAO;
import controller.MaintenanceDAO;
//import java.sql.Connection;
//import java.sql.DriverManager;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TestAircraftDAO {

    private static String dbURL = "jdbc:derby:FlightHours";
    private static String tableName = "AIRCRAFT";

    //private static Connection conn = null;
    private static AircraftDAO aircraftQueries;
    private static MaintenanceDAO mtQueries;
    private static List<Aircraft> aircraftList;
    private static JTable aircraftTable;
    private static DefaultTableModel acTableModel;

    public static void main(String args[]) {
        int result;
        //new TestAircraftDAO();
        try {
            //conn = DriverManager.getConnection(dbURL);

        } catch (Exception except) {
            except.printStackTrace();
        }

        aircraftQueries = new AircraftDAO();

        acTableModel = aircraftQueries.selectAllAircraft();
        //Added Section below to see results - Emily
        int rowCount = acTableModel.getRowCount();
        int columnCount = acTableModel.getColumnCount();
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                System.out.print(acTableModel.getValueAt(row, column) + ", ");
            }
            System.out.println();
        }

        String loc = "Laredo Air Branch";
        AircraftDAO aircraftDAO = new AircraftDAO();
        acTableModel = aircraftDAO.selectAircraftbyLocation(loc);

        //aircraftList = AircraftDAO.selectAircraftbyLocation(loc);
        System.out.println("Stop Here");

    }

}
