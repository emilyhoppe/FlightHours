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
import model.Operation;
import controller.OperationDAO;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TestOperationDAO {

    private static String dbURL = "jdbc:derby:FlightHours";
    private static String tableName = "AIRCRAFT";

    private static Connection conn = null;
    private static OperationDAO opQueries;
    private static JTable opTable;
    private static DefaultTableModel opTableModel;

    public static void main(String args[]) {

        opQueries = new OperationDAO();
        int aircraftID = 1;
        opTableModel = opQueries.selectOperationsByAircraft(aircraftID);

        //Section below is to test and print results
        int rowCount = opTableModel.getRowCount();
        int columnCount = opTableModel.getColumnCount();
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                System.out.print(opTableModel.getValueAt(row, column) + ", ");
            }
            System.out.println();
        }

        //New Maintenance Test Verified
        int operationID = 1;
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
        Operation inOperation = new Operation();
        inOperation.setOperationID(operationID);
        inOperation.setAircraftID(aircraftID);
        inOperation.setOperationName("Testing Insert Op");
        inOperation.setStationID(3);
        inOperation.setMissionID(2);
        inOperation.setOperationStartDate(start);
        inOperation.setOperationEndDate(end);
        inOperation.setOperationFlightHour(60);

        //Insert Operation Test
        /*int success = opQueries.insertNewOperation(inOperation);
        int success1 = opQueries.insertOpAdjustCurrentHours(inOperation);
        int success2 = opQueries.insertOpAdjustTotalHours(inOperation);
        System.out.println(String.valueOf(success));
        System.out.println(String.valueOf(success1));
        System.out.println(String.valueOf(success2));*/
        //Modify Operation Test
        //int success = opQueries.modifyOperation(inOperation);
        //System.out.println(String.valueOf(success));
        System.out.println("Stop Here");
    }

}
