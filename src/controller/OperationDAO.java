/** **********
 *
 *      Class:         OperationDAO.java
 *      Package:       controller
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: OperationDAO accesses the embedded Apache Derby Database
 *                  and performs the main operation functions.
 *
 *
 *********** */
package controller;

import flighthours.Operation;
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
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class OperationDAO {

    private String dbURL = "jdbc:derby:FlightHours";
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement selectOperationByAircraft;
    private PreparedStatement insertNewOperation;
    private PreparedStatement modifyOperation;
    private DefaultTableModel opTableModel;

    public OperationDAO() {
        try {
            conn = DriverManager.getConnection(dbURL);
            selectOperationByAircraft = conn.prepareStatement("SELECT * FROM OPERATIONS "
                    + "WHERE AIRCRAFT_ID = ?");

            insertNewOperation = conn.prepareStatement("INSERT INTO OPERATIONS"
                    + " (AIRCRAFT_ID,"
                    + " STATION_ID,"
                    + " MISSION_ID,"
                    + " OPERATION_NAME,"
                    + " OPERATION_START_DATE,"
                    + " OPERATION_END_DATE,"
                    + " OPERATION_FILGHT_HOURS)"
                    + "VALUES (?,?,?,?,?,?,?)");

            modifyOperation = conn.prepareStatement("UPDATE OPERATIONS SET"
                    + " STATION_ID = ?,"
                    + " MISSION_ID = ?,"
                    + " OPERATION_NAME = ?,"
                    + " OPERATION_START_DATE = ?,"
                    + " OPERATION_END_DATE = ?,"
                    + " OPERATION_FILGHT_HOURS = ?"
                    + " WHERE OPERATION_ID = ?");

        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    public DefaultTableModel selectOperationsByAircraft(int aircraftID) {

        ResultSet resultSet = null;
        try {
            selectOperationByAircraft.setInt(1, aircraftID);
            resultSet = selectOperationByAircraft.executeQuery();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

        opTableModel = createOperationTableModel(resultSet);

        return opTableModel;
    }

    public int insertNewOperation(Operation inOperation) {
        int result = 0;
        try {
            insertNewOperation.setInt(1, inOperation.getAircraftID());
            insertNewOperation.setInt(2, inOperation.getStationID());
            insertNewOperation.setInt(3, inOperation.getMissionID());
            insertNewOperation.setString(4, inOperation.getOperationName());
            insertNewOperation.setDate(5, new java.sql.Date(inOperation.getOperationStartDate().getTime()));
            insertNewOperation.setDate(6, new java.sql.Date(inOperation.getOperationEndDate().getTime()));
            insertNewOperation.setInt(7, inOperation.getOperationFlightHour());
            result = insertNewOperation.executeUpdate();

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return result;
    }

    public int modifyOperation(Operation inOperation) {
        int result = 0;
        try {
            modifyOperation.setInt(1, inOperation.getStationID());
            modifyOperation.setInt(2, inOperation.getMissionID());
            modifyOperation.setString(3, inOperation.getOperationName());
            modifyOperation.setDate(4, new java.sql.Date(inOperation.getOperationStartDate().getTime()));
            modifyOperation.setDate(5, new java.sql.Date(inOperation.getOperationEndDate().getTime()));
            modifyOperation.setInt(6, inOperation.getOperationFlightHour());
            modifyOperation.setInt(7, inOperation.getOperationID());
            result = modifyOperation.executeUpdate();

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return result;
    }

    public DefaultTableModel createOperationTableModel(ResultSet results) {

        Vector<String> tableColumns = new Vector<String>();
        Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();

        tableColumns.add("ID");
        tableColumns.add("Aircraft ID");
        tableColumns.add("Station ID");
        tableColumns.add("Mission ID");
        tableColumns.add("Name");
        tableColumns.add("Start Date");
        tableColumns.add("End Date");
        tableColumns.add("Flight Hours");

        try {
            //Fill all rows with results
            while (results.next()) {
                Vector<Object> vector = new Vector<Object>();
                vector.add(results.getObject(1));
                vector.add(results.getObject(2));
                vector.add(results.getObject(3));
                vector.add(results.getObject(4));
                vector.add(results.getObject(5));
                vector.add(results.getObject(6));
                vector.add(results.getObject(7));
                vector.add(results.getObject(8));
                tableData.add(vector);
            }
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

        DefaultTableModel operationTableModel = new DefaultTableModel(tableData, tableColumns) {
            //Override default table model method and make all cells non-editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        return operationTableModel;

    }
}
