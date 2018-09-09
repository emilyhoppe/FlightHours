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
 *          have been implemented in real code.
 *
 *
 *********** */
package temporary;

//This class is holding temporary functions used by the GUI until real
import javax.swing.table.DefaultTableModel;

//functions are created
public class TemporaryFunctions {

    //Returns an array of strings for the locations combo boxes until sql code
    //is implemented
    public static String[] getLocationArray() {
        String[] locationArray = {
            "McAllen Air and Marine Branch",
            "Laredo Air Branc",
            "San Antonio Air Unit",
            "Uvalde Air Branch",
            "Del Rio Air Unit",
            "San Angelo Air Unit",
            "El Paso Air Branch",
            "Deming Air Unit",
            "Tucson Air Branch",
            "Sierra Vista Air Unit",
            "Yuma Air Branch",
            "San Diego Air and Marine Branch",
            "Riverside Air Unit",
            "Brown Field Air Unit",
            "Sacramento Air Unit",
            "Pine Valley Air Unit",
            "McAllen",
            "Rio Grande City",
            "Brownsville",
            "Imperial Beach",
            "Chula Vista",
            "Alpine",
            "Sanderson",
            "Marfa",
            "Presidio",
            "Yuma",
            "Wellton",
            "Boulevard"};
        return locationArray;
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
        String[] aircraftTypeArray = {"FIXED WING", "ROTARY WING", "UAV"};
        return aircraftTypeArray;
    }

    //Returns a table model for the search aircraft table until SQL code is implemented
    public static DefaultTableModel getAircraftTableModel() {

        //Array of for table column names
        Object[] tableColumns = {"ID", "Tail Number", "Type", "Location",
            "Mission", "Max Speed", "Max Altitude", "Total Hours", "Maint Flag",
            "Maint Threshold", "End of Service"};

        //2D array of table row data
        Object[][] tableData = {
            {"1", "A2K2J5", "FIXED WING", "San Angelo Air Unit", "Disaster Relief", "555", "22000", "50100", "FALSE", "2000", ""},
            {"2", "A2K2J6", "FIXED WING", "Riverside Air Unit", "Interdiction", "550", "36200", "50000", "FALSE", "1000", ""},
            {"3", "A2K2J7", "FIXED WING", "Mcallen Air and Marine Branch", "Surveillance", "550", "35200", "50700", "FALSE", "3000", ""},
            {"4", "A2K2J8", "ROTARY WING", "Riverside Air Unit", "Disaster Relief", "550", "35000", "50000", "TRUE", "6000", ""},
            {"5", "A2K2J9", "FIXED WING", "Riverside Air Unit", "Transport", "350", "35000", "50000", "FALSE", "3000", ""},
            {"6", "A2K2K0", "FIXED WING", "Riverside Air Unit", "Interdiction", "450", "31000", "50000", "FALSE", "3000", ""},
            {"7", "A2K2K1", "FIXED WING", "", "", "550", "35000", "50000", "FALSE", "2000", "12/25/2017"},
            {"8", "A2K2K2", "UAV", "Brownsville", "Surveillance", "550", "35000", "50000", "FALSE", "3000", ""},
            {"9", "A2K2K3", "FIXED WING", "Brownsville", "Search and Rescue", "550", "35000", "50000", "FALSE", "3000", ""},
            {"10", "A2K2K4", "UAV", "San Angelo Air Unit", "Surveillance", "550", "35000", "50000", "FALSE", "3000", ""},
            {"11", "A2K2K5", "ROTARY WING", "San Angelo Air Unit", "Interdiction", "550", "35000", "50000", "FALSE", "3000", ""},
            {"12", "A2K2K6", "FIXED WING", "Brownsville", "Tactical Ops", "550", "35000", "50000", "FALSE", "3000", ""},
            {"13", "A2K2K7", "UAV", "Brownsville", "Surveillance", "550", "35000", "50000", "FALSE", "3000", ""},
            {"14", "A2K2Z5", "FIXED WING", "Brownsville", "Search and Rescue", "550", "35000", "50000", "FALSE", "3000", ""},
            {"15", "A2K2Z6", "FIXED WING", "Brownsville", "Transport", "555", "35000", "50000", "FALSE", "3000", ""},
            {"16", "A2K2Z7", "ROTARY WING", "San Angelo Air Unit", "Interdiction", "550", "35000", "50000", "FALSE", "3000", ""},
            {"17", "A2K2Z8", "FIXED WING", "Brownsville", "Transport", "550", "35000", "50000", "FALSE", "3000", ""}
        };

        DefaultTableModel aircraftTableModel = new DefaultTableModel(tableData, tableColumns) {
            //Override default table model method and make all cells non-editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        return aircraftTableModel;
    }

    //Returns a table model for the search aircraft table until SQL code is implemented
    public static DefaultTableModel getOperationsTableModel() {

        //Array of for table column names
        Object[] tableColumns = {"ID", "Name", "Location", "Mission", "Start Date", "End Date", "Flight Hours"};

        //2D array of table row data
        Object[][] tableData = {
            {"1","Operation A", "San Angelo Air Unit", "Disaster Relief", "8/30/2018", "8/30/2018", "5"},
            {"2","Operation B", "Brownsville", "Interdiction", "8/31/2018", "8/31/2018", "6"}
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
}
