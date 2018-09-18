/** **********
 *
 *      Class:         TemporaryFunctions.java
 *      Package:       temporary
 *      Date:          September, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description:
 *          Temporary functions for GUI.  Do not delete until all temporary items
 *          have been implemented in real code.  Comment out functions as they
 *          are removed instead of deleting them.  Then when we are done we 
 *          can delete this entire class.
 *
 *
 *********** */
package temporary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

//This class is holding temporary functions used by the GUI until real
//functions are created
public class TemporaryFunctions {

    //Returns an array of strings for the AMO stations combo boxes until sql code
    //is implemented
    //This is used for the Add and Modify Aircraft dialogs
    public static String[] getAmoStationsArray() {
        String[] amoStationsArray = {
            "McAllen Air and Marine Branch",
            "Laredo Air Branch",
            "San Antonio Air Unit",
            "Uvalde Air Branch",
            "Del Rio Air Unit",
            "San Angelo Air Unit",
            "El Paso Air Branch",
            "Alpine Air Unit",
            "Deming Air Unit",
            "Tucson Air Branch",
            "Sierra Vista Air Unit",
            "Yuma Air Branch",
            "San Diego Air and Marine Branch",
            "Riverside Air Unit",
            "Brown Field Air Unit",
            "Sacramento Air Unit",
            "Pine Valley Air Unit"};
        return amoStationsArray;
    }

    //Returns an array of strings for the USBP stations combo boxes until sql code
    //is implemented
    //This is used for the Add and Modify Operations dialogs
    public static String[] getUsbpStationsArray() {
        String[] usbpStationsArray = {
            "McAllen",
            "Rio Grande City",
            "Brownsville",
            "Imperial Beach",
            "Boulevard",
            "Chula Vista",
            "Alpine",
            "Sanderson",
            "Marfa",
            "Presidio",
            "Yuma",
            "Wellton"};
        return usbpStationsArray;
    }

    //Returns an array of strings for the mission combo boxes until sql code
    //is implemented
    public static String[] getMissionArray() {
        String[] missionArray = {"Interdiction", "Surveillance", "Intelligence", "Tactical Ops", "Transport", "Search and Rescue", "Disaster Relief"};
        return missionArray;
    }

    //Returns an array of strings for the aircraft type combo boxes.
    //Not sure where we will put this code permanently
    public static String[] getAircraftTypeArray() {
        String[] aircraftTypeArray = {"Fixed Wing", "Rotary Wing", "UAV"};
        return aircraftTypeArray;
    }

//    //Returns a table model for the Aircraft Search table until SQL code is implemented
//    public static DefaultTableModel getAircraftTableModel() {
//
//        //Array of for table column names
//        Object[] tableColumns = {"ID", "Tail Number", "Type", "Station", "Max Speed", "Max Altitude", "Total Hours", "Maint Flag", "Maint Hours",
//            "Maint Threshold", "End of Service"};
//
//        //2D array of table row data
//        Object[][] tableData = {
//            {"1", "A2K2J5", "FIXED WING", "San Diego Air and Marine Branch", "555", "22000", "50100", "FALSE", "575", "2000", ""},
//            {"2", "A2K2J6", "FIXED WING", "Alpine Air Unit", "550", "36200", "50000", "FALSE", "505", "1000", ""},
//            {"3", "A2K2J7", "FIXED WING", "McAllen Air and Marine Branch", "550", "35200", "50700", "FALSE", "50", "3000", ""},
//            {"4", "A2K2J8", "ROTARY WING", "McAllen Air and Marine Branch", "550", "35000", "50000", "TRUE", "6521", "6000", ""},
//            {"5", "A2K2J9", "FIXED WING", "Laredo Air Branch", "350", "35000", "50000", "FALSE", "50", "3000", ""},
//            {"6", "A2K2K0", "FIXED WING", "Sacramento Air Unit", "450", "31000", "50000", "FALSE", "50", "3000", ""},
//            {"7", "A2K2K1", "FIXED WING", "Alpine Air Unit", "550", "35000", "50000", "FALSE", "0", "2000", "12/25/2017"},
//            {"8", "A2K2K2", "UAV", "Brown Field Air Unit", "550", "35000", "50000", "FALSE", "50", "3000", ""},
//            {"9", "A2K2K3", "FIXED WING", "Tucson Air Branch", "550", "35000", "50000", "FALSE", "10", "3000", ""},
//            {"10", "A2K2K4", "UAV", "Brown Field Air Unit", "550", "35000", "50000", "FALSE", "10", "3000", ""},
//            {"11", "A2K2K5", "ROTARY WING", "Sacramento Air Unit", "550", "35000", "50000", "FALSE", "150", "3000", ""},
//            {"12", "A2K2K6", "FIXED WING", "Tucson Air Branch", "550", "35000", "50000", "FALSE", "50", "3000", ""},
//            {"13", "A2K2K7", "UAV", "Tucson Air Branch", "550", "35000", "50000", "FALSE", "50", "3000", ""},
//            {"14", "A2K2Z5", "FIXED WING", "Alpine Air Unit", "550", "35000", "50000", "FALSE", "50", "3000", ""},
//            {"15", "A2K2Z6", "FIXED WING", "Laredo Air Branch", "555", "35000", "50000", "FALSE", "50", "3000", ""},
//            {"16", "A2K2Z7", "ROTARY WING", "Brown Field Air Unit", "550", "35000", "50000", "FALSE", "50", "3000", ""},
//            {"17", "A2K2Z8", "FIXED WING", "San Diego Air and Marine Branch", "550", "35000", "50000", "FALSE", "500", "3000", ""}
//        };
//
//        DefaultTableModel aircraftTableModel = new DefaultTableModel(tableData, tableColumns) {
//            //Override default table model method and make all cells non-editable
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//        };
//
//        return aircraftTableModel;
//    }

    //Database Version - Returns a table model for the Aircraft Search table 
    //until SQL code is implemented.
    //This function uses Vectors because DefaultTableModel only supports
    //Vectors.  Unfortunately it does not support ArrayList, otherwise I would
    //have used that....
    public static DefaultTableModel getAircraftTableModelFromDatabase() {
        
        final String CONNECTION = "jdbc:derby:FlightHours;create=true";
        Vector<String> tableColumns = new Vector<String>();
        Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();
        
        try (Connection conn = DriverManager.getConnection(CONNECTION);
                Statement statement = conn.createStatement()) {
            ResultSet results = statement.executeQuery("SELECT * FROM aircraft");
            ResultSetMetaData metaData = results.getMetaData();

            //Create column names
            tableColumns.add("ID");
            tableColumns.add("Tail Number");
            tableColumns.add("Type");
            tableColumns.add("Station");
            tableColumns.add("Max Speed");
            tableColumns.add("Max Altitude");
            tableColumns.add("Total Hours");
            tableColumns.add("Maint Flag");
            tableColumns.add("Maint Hours");
            tableColumns.add("Maint Threshold");
            tableColumns.add("End of Service");

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
                vector.add(25);
                vector.add(results.getObject(10));
                tableData.add(vector);

            }

            //tableModel.setDataVector(data, columnNames);
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

        DefaultTableModel aircraftTableModel = new DefaultTableModel(tableData, tableColumns) {
            //Override default table model method and make all cells non-editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        return aircraftTableModel;
    }

    //Returns a table model for the Aircraft Operations table until SQL code is implemented
    public static DefaultTableModel getOperationsTableModel() {

        //Array of for table column names
        Object[] tableColumns = {"ID", "Name", "Station", "Mission", "Start Date", "End Date", "Flight Hours"};

        //2D array of table row data
        Object[][] tableData = {
            {"1", "Operation A", "McAllen", "Disaster Relief", "8/30/2018", "8/30/2018", "5"},
            {"2", "Operation B", "Imperial Beach", "Interdiction", "8/31/2018", "8/31/2018", "6"}
        };

        DefaultTableModel operationsTableModel = new DefaultTableModel(tableData, tableColumns) {
            //Override default table model method and make all cells non-editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        return operationsTableModel;
    }

    //Returns a table model for the Aircraft Maintenance table until SQL code is implemented
    public static DefaultTableModel getMaintenanceTableModel() {

        //Array of for table column names
        Object[] tableColumns = {"ID", "Start Date", "End Date", "Description"};

        //2D array of table row data
        Object[][] tableData = {
            {"1", "7/28/2018", "7/28/2018", "Replace front landing gear"},
            {"2", "7/30/2018", "7/30/2018", "Upgraded muffler bearings"},};

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
