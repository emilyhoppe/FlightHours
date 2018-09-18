/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author jjtam
 * methods filled out by ehoppe
 * 
 * 
 */
import flighthours.Maintenance;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class MaintenanceDAO {
    
    
    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement selectAllMaintenance;
    private static PreparedStatement selectMaintenanceByAircraft;
    private static PreparedStatement insertNewMaintenance;
    private static PreparedStatement modifyMaintenance;
    private static List<Maintenance> MaintenanceList;
    private static DefaultTableModel mtTableModel;

    public MaintenanceDAO(Connection conn) {
        try {
            MaintenanceDAO.conn = conn;
            //conn = DriverManager.getConnection(dbURL);
            //selectAllMaintenance = conn.prepareStatement("SELECT * FROM MAINTENANCE");
            selectMaintenanceByAircraft = conn.prepareStatement("select * from MAINTENANCE "
                    + "where AIRCRAFT_ID = ?");
            
            insertNewMaintenance = conn.prepareStatement("INSERT INTO MAINTENANCE"
                    + " (AIRCRAFT_ID,"
                    + " MAINTENANCE_START_DATE,"
                    + " MAINTENANCE_END_DATE,"
                    + " MAINTENANCE_DESCRIPTION)"
                    + "VALUES (?,?,?,?)");

        } catch (Exception except) {
            except.printStackTrace();
        }
    }
    public static List<Maintenance> selectAllMaintenance() {

        List<Maintenance> results = null;
        ResultSet resultSet = null;

        return results;
    }
    
    public static DefaultTableModel selectMaintenanceByAircraft(int aircraftID) {

        List<Maintenance> results = null;
        ResultSet resultSet = null;
        try {
            selectMaintenanceByAircraft.setInt(1, aircraftID);
            resultSet = selectMaintenanceByAircraft.executeQuery();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

        mtTableModel = createMaintenanceTableModel(resultSet);
        return mtTableModel;
    }
    
    public static int insertNewMaintenance(Maintenance inMaintenance) {
        int result = 0;
        try {
            insertNewMaintenance.setInt(1, inMaintenance.getAircraftID());
            insertNewMaintenance.setDate(2, new java.sql.Date(inMaintenance.getStartDate().getTime()));
            insertNewMaintenance.setDate(3, new java.sql.Date(inMaintenance.getEndDate().getTime()));
            insertNewMaintenance.setString(4, inMaintenance.getMaintDescr());  
            result = insertNewMaintenance.executeUpdate();

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return result;
    }

    public int modifyMaintenance(Maintenance inMaintenance) {
        int result = 0;

        return result;
    }
    
    public static DefaultTableModel createMaintenanceTableModel(ResultSet results) {

        Vector<String> tableColumns = new Vector<String>();
        Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();

        tableColumns.add("ID");
        tableColumns.add("Aircraft ID");
        tableColumns.add("Start Date");
        tableColumns.add("End Date");
        tableColumns.add("Description");

        try {
            //Fill all rows with results
            while (results.next()) {
                Vector<Object> vector = new Vector<Object>();
                vector.add(results.getObject(1));
                vector.add(results.getObject(2));
                vector.add(results.getObject(3));
                vector.add(results.getObject(4));
                vector.add(results.getObject(5));
                tableData.add(vector);
            }
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

        DefaultTableModel maintenanceTableModel = new DefaultTableModel(tableData, tableColumns) {
            //Override default table model method and make all cells non-editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        return maintenanceTableModel;

    }
}
