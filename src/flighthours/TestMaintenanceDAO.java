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

import controller.MaintenanceDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.List;
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
        Date start = new Date("5/10/2018");
        Date end = new Date("5/11/2018");
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
