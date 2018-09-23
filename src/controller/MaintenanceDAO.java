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

import model.Maintenance;
import java.sql.Connection;
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
    private PreparedStatement selectMaintenanceByAircraft;
    private PreparedStatement insertNewMaintenance;
    private PreparedStatement modifyMaintenance;
    private PreparedStatement modifyAircraftCurrentHours;
    private DefaultTableModel mtTableModel;

    public MaintenanceDAO() {
        try {
            conn = DriverManager.getConnection(dbURL);
            selectMaintenanceByAircraft = conn.prepareStatement("SELECT * FROM maintenance"
                    + " WHERE aircraft_id = ?"
                    + " ORDER BY maintenance_end_date DESC");

            insertNewMaintenance = conn.prepareStatement("INSERT INTO maintenance"
                    + " (aircraft_id,"
                    + " maintenance_start_date,"
                    + " maintenance_end_date,"
                    + " maintenance_description)"
                    + "VALUES (?,?,?,?)");

            modifyMaintenance = conn.prepareStatement("UPDATE maintenance SET"
                    + " maintenance_start_date = ?,"
                    + " maintenance_end_date = ?,"
                    + " maintenance_description = ?"
                    + " WHERE maintenance_id = ?");
            
            modifyAircraftCurrentHours = conn.prepareStatement("UPDATE aircraft SET"
                    + " current_maintenance_hours = ?"
                    + " WHERE aircraft_id = ?");

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
        int aircraftID = inMaintenance.getAircraftID();
        try {                        
            insertNewMaintenance.setInt(1, aircraftID);
            insertNewMaintenance.setDate(2, new java.sql.Date(inMaintenance.getStartDate().getTime()));
            insertNewMaintenance.setDate(3, new java.sql.Date(inMaintenance.getEndDate().getTime()));
            insertNewMaintenance.setString(4, inMaintenance.getMaintDescr());
            result = insertNewMaintenance.executeUpdate();
            
            if (inMaintenance.getResetMaintenance() && result == 1) {
               modifyAircraftCurrentHours.setInt(1, 0);
               modifyAircraftCurrentHours.setInt(2, aircraftID);
               result = modifyAircraftCurrentHours.executeUpdate();
            } 

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
