/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthours;

/**
 *
 * @author ehoppe
 */
import model.Maintenance;
import controller.MaintenanceDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TestMaintenanceDAO {

    private static String dbURL = "jdbc:derby:FlightHours";
    private static String tableName = "AIRCRAFT";

    private static Connection conn = null;
    private static MaintenanceDAO mtQueries;
    private static JTable mtTable;
    private static DefaultTableModel mtTableModel;

    public static void main(String args[]) {
        int result;
        try {
            conn = DriverManager.getConnection(dbURL);

        } catch (Exception except) {
            except.printStackTrace();
        }

        mtQueries = new MaintenanceDAO();
        int aircraftID = 4;
        mtTableModel = mtQueries.selectMaintenanceByAircraft(aircraftID);

        //Section below is to test and print results
        int rowCount = mtTableModel.getRowCount();
        int columnCount = mtTableModel.getColumnCount();
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                System.out.print(mtTableModel.getValueAt(row, column) + ", ");
            }
            System.out.println();
        }

        //New Maintenance Test Verified
        int maintenanceID = 1;
        //Date(String is giving the compile warning: 
        //warning: [deprecation] Date(String) in Date has been deprecated
        //Changing to use SimpleDateFormat instead - JG
        //Date start = new Date("5/10/2018");
        //Date end = new Date("5/11/2018");
        Date start = null;
        Date end = null;
        try {
            start = new SimpleDateFormat("MM/dd/yyyy").parse("5/10/2018");
            end = new SimpleDateFormat("MM/dd/yyyy").parse("5/10/2018");
        } catch (ParseException ex) {
        }

        //System.out.println(start.toString());
        String desc = "testing";
        Maintenance inMaintenance = new Maintenance();
        inMaintenance.setMaintenanceID(maintenanceID);
        inMaintenance.setAircraftID(aircraftID);
        inMaintenance.setStartDate(start);
        inMaintenance.setEndDate(end);
        inMaintenance.setMaintDescr(desc);

        //int success = mtQueries.insertNewMaintenance(inMaintenance);
        //System.out.println(String.valueOf(success));
        //int success = mtQueries.modifyMaintenance(inMaintenance);
        //System.out.println(String.valueOf(success));
        System.out.println("Stop Here");
    }

}
