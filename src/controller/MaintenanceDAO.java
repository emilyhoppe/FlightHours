/** **********
 *
 *      Class:         MaintenanceDAO.java
 *      Package:       controller
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: MaintenanceDAO accesses the embedded Apache Derby Database
 *                  and performs the main maintenance functions.
 *
 *
 *********** */
package controller;

import flighthours.Maintenance;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class MaintenanceDAO {    
    
    private String dbURL = "jdbc:derby:FlightHours";
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement selectMaintenanceByAircraft;
    private PreparedStatement insertNewMaintenance;
    private PreparedStatement modifyMaintenance;
    private DefaultTableModel mtTableModel;

    public MaintenanceDAO() {
        try {
            conn = DriverManager.getConnection(dbURL);
            selectMaintenanceByAircraft = conn.prepareStatement("select * from MAINTENANCE "
                    + "where AIRCRAFT_ID = ?");
            
            insertNewMaintenance = conn.prepareStatement("INSERT INTO MAINTENANCE"
                    + " (AIRCRAFT_ID,"
                    + " MAINTENANCE_START_DATE,"
                    + " MAINTENANCE_END_DATE,"
                    + " MAINTENANCE_DESCRIPTION)"
                    + "VALUES (?,?,?,?)");
            
            modifyMaintenance = conn.prepareStatement("UPDATE MAINTENANCE SET"
                    + " MAINTENANCE_START_DATE = ?,"
                    + " MAINTENANCE_END_DATE = ?,"
                    + " MAINTENANCE_DESCRIPTION = ?"
                    + " WHERE MAINTENANCE_ID = ?");

        } catch (Exception except) {
            except.printStackTrace();
        }
    }
    
    public DefaultTableModel selectMaintenanceByAircraft(int aircraftID) {
        
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
    
    public int insertNewMaintenance(Maintenance inMaintenance) {
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
        try {
            modifyMaintenance.setDate(1, new java.sql.Date(inMaintenance.getStartDate().getTime()));
            modifyMaintenance.setDate(2, new java.sql.Date(inMaintenance.getEndDate().getTime()));
            modifyMaintenance.setString(3, inMaintenance.getMaintDescr());
            modifyMaintenance.setInt(4, inMaintenance.getMaintenanceID());
            result = modifyMaintenance.executeUpdate();

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return result;
    }
    
    private DefaultTableModel createMaintenanceTableModel(ResultSet results) {

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