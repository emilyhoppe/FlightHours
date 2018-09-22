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

import model.Operation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class OperationDAO {

    private String dbURL = "jdbc:derby:FlightHours";
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement selectOperationByAircraft;
    private PreparedStatement insertNewOperation;
    private PreparedStatement modifyOperation;
    private PreparedStatement modifyAircraftCurrentHours;
    private PreparedStatement modifyAircraftTotalHours;
    private PreparedStatement retrieveAircraftCurrentHours;
    private PreparedStatement retrieveAircraftTotalHours;
    private PreparedStatement retrieveOperationHours;
    private PreparedStatement retrieveLastMaintenanceDate;
    private DefaultTableModel opTableModel;

    public OperationDAO() {
        try {
            conn = DriverManager.getConnection(dbURL);
            selectOperationByAircraft = conn.prepareStatement("SELECT "
                    + "operations.operation_id, "
                    + "operations.aircraft_id, "
                    + "operations.station_id, "
                    + "operations.mission_id, "
                    + "operations.operation_name, "
                    + "stations.station_name, "
                    + "missions.mission_name, "
                    + "operations.operation_start_date, "
                    + "operations.operation_end_date, "
                    + "operations.operation_flight_hours "
                    + "FROM operations "
                    + "INNER JOIN stations ON operations.station_id = stations.station_id "
                    + "INNER JOIN missions on operations.mission_id = missions.mission_id "
                    + "WHERE aircraft_id = ? "
                    + "ORDER BY operation_id");

            insertNewOperation = conn.prepareStatement("INSERT INTO OPERATIONS"
                    + " (AIRCRAFT_ID,"
                    + " STATION_ID,"
                    + " MISSION_ID,"
                    + " OPERATION_NAME,"
                    + " OPERATION_START_DATE,"
                    + " OPERATION_END_DATE,"
                    + " OPERATION_FLIGHT_HOURS)"
                    + "VALUES (?,?,?,?,?,?,?)");

            retrieveAircraftCurrentHours = conn.prepareStatement("SELECT current_maintenance_hours"
                    + " FROM AIRCRAFT WHERE aircraft_id = ?");

            retrieveAircraftTotalHours = conn.prepareStatement("SELECT total_flight_hours"
                    + " FROM AIRCRAFT WHERE aircraft_id = ?");

            modifyAircraftCurrentHours = conn.prepareStatement("UPDATE AIRCRAFT SET"
                    + " current_maintenance_hours = ?"
                    + " WHERE aircraft_id = ?");

            modifyAircraftTotalHours = conn.prepareStatement("UPDATE AIRCRAFT SET"
                    + " total_flight_hours = ?"
                    + " WHERE aircraft_id = ?");

            retrieveOperationHours = conn.prepareStatement("SELECT OPERATION_FLIGHT_HOURS"
                    + " FROM OPERATIONS WHERE OPERATION_ID = ?");

            retrieveLastMaintenanceDate = conn.prepareStatement("SELECT MAINTENANCE_END_DATE"
                    + " FROM MAINTENANCE WHERE AIRCRAFT_ID = ? ORDER BY MAINTENANCE_END_DATE DESC");

            modifyOperation = conn.prepareStatement("UPDATE OPERATIONS SET"
                    + " STATION_ID = ?,"
                    + " MISSION_ID = ?,"
                    + " OPERATION_NAME = ?,"
                    + " OPERATION_START_DATE = ?,"
                    + " OPERATION_END_DATE = ?,"
                    + " OPERATION_FLIGHT_HOURS = ?"
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

    //Must use in conjunction with insertOpAdjustCurrentHours and insertOpAdjustTotalHours methods directly below
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

    //Must use with insertNewOperation Method above
    public int insertOpAdjustCurrentHours(Operation inOperation) {
        int result = -1;

        int newHours = 0;
        int oldHours = retrieveAircraftCurrentHours(inOperation.getAircraftID());
        int additionalHours = inOperation.getOperationFlightHour();

        if (oldHours > -1) {
            //Caluculating new total for aircraft's current hours
            newHours = oldHours + additionalHours;
            result = modifyAircraftCurrentHours(inOperation.getAircraftID(), newHours);
        }

        //Returns -1 if retrieval of the current hours failed
        //Returns 0 if the modification of current hours failed
        //Returns 1 if successful
        return result;
    }

    //Must use with insertNewOperation Method above
    public int insertOpAdjustTotalHours(Operation inOperation) {
        int result = -1;

        int newHours = 0;
        int oldHours = retrieveAircraftTotalHours(inOperation.getAircraftID());
        int additionalHours = inOperation.getOperationFlightHour();

        if (oldHours > -1) {
            //Caluculating new total for aircraft's total hours
            newHours = oldHours + additionalHours;
            result = modifyAircraftTotalHours(inOperation.getAircraftID(), newHours);
        }

        //Returns -1 if retrieval of the total hours failed
        //Returns 0 if the modification of total hours failed
        //Returns 1 if successful
        return result;
    }

    //Must use in conjunction with modifyOpReadjustCurrentHours and modifyOpReadjustTotalHours methods directly below
    public int modifyOperation(Operation inOperation) {
        int result = 0;
        ResultSet resultSet = null;
        int previousHours = -1;
        int newHours = inOperation.getOperationFlightHour();
        //Date previousEndDate = null;
        Date lastMaintenanceDate = null;
        Date startDate = new java.sql.Date(inOperation.getOperationStartDate().getTime());
        Date endDate = new java.sql.Date(inOperation.getOperationEndDate().getTime());
        try {
            //Retrieve previous Operation flight hours for modifications to Aircraft's current and total flight hours
            retrieveOperationHours.setInt(1, inOperation.getOperationID());
            resultSet = retrieveOperationHours.executeQuery();
            resultSet.next();
            previousHours = resultSet.getInt(1);

            //If previousHours retrieval was successful than proceed with modification
            if (previousHours > -1) {

                //Main Operation modifications
                modifyOperation.setInt(1, inOperation.getStationID());
                modifyOperation.setInt(2, inOperation.getMissionID());
                modifyOperation.setString(3, inOperation.getOperationName());
                modifyOperation.setDate(4, startDate);
                modifyOperation.setDate(5, endDate);
                modifyOperation.setInt(6, newHours);
                modifyOperation.setInt(7, inOperation.getOperationID());
                result = modifyOperation.executeUpdate();

                //If modification was successful, check if Aircraft current or total hours need modification
                if (result == 1) {

                    //If Operation's flight hours are changed and modification was successful
                    if (previousHours != newHours) {

                        //Retrieve last maintenance date to see if hours should be updated
                        retrieveLastMaintenanceDate.setInt(1, inOperation.getAircraftID());
                        resultSet = retrieveLastMaintenanceDate.executeQuery();
                        resultSet.next();

                        if (resultSet.wasNull()) {
                            lastMaintenanceDate = resultSet.getDate(1);
                        }

                        //Calculate Hours Difference (Positive or Negative)                        
                        int difference = newHours - previousHours;
                        System.out.println(String.valueOf(difference));
                        int resultOfACMod = 0;

                        //If the new End Date is after the last Maintenance Date 
                        //Then change Aircraft's current and total hours                
                        if (lastMaintenanceDate == null || 0 < endDate.compareTo(lastMaintenanceDate)) { //returns 1 if endDate comes after lastMaintenanceDate
                            //Adjust total hours
                            resultOfACMod = modifyOpAdjustTotalHours(inOperation, difference);
                            //Assign success or specific failure to result
                            switch (resultOfACMod) {
                                case 1:
                                    result = 3;
                                    break;
                                case 0:
                                    result = -3;
                                    break;
                                default:
                                    result = -5;
                                    break;
                            }
                            //If modification of total hours was successful proceed with changing current hours
                            if (result == 3) {
                                //Adjust current hours
                                resultOfACMod = modifyOpAdjustCurrentHours(inOperation, difference);
                                //Assign success or specific failure to result
                                switch (resultOfACMod) {
                                    case 1:
                                        break;
                                    case 0:
                                        result = -4;
                                        break;
                                    default:
                                        result = -6;
                                        break;
                                }
                            }

                        } //Else only change total hours
                        else {
                            //Adjust total hours
                            resultOfACMod = modifyOpAdjustTotalHours(inOperation, difference);
                            //Assign success or specific failure to result
                            switch (resultOfACMod) {
                                case 1:
                                    result = 2;
                                    break;
                                case 0:
                                    result = -2;
                                    break;
                                default:
                                    result = -5;
                                    break;
                            }
                        }
                    }
                } else {
                    result = -1;
                }
            } else {
                result = 0;
            }
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        //Successes    
        //Returns 1 if Operation modification was successful 
        // and there were no Operation or Aircraft flight hours changes.
        //Returns 2 if Operation modification was successful 
        // and only total Aircraft hours were changed.
        //Returns 3 if Operation modification was successful 
        // and current and total Aircraft hours were changed.
        //Main Failures
        //Returns 0 if retrieval of previous Operation flight hours failed
        // and no modification of Operation or Aircraft hours were completed.
        //Returns -1 if Operation modification failed
        // and no Aircraft hours modifications were made.
        //Returns -2 if Operation modification was successful
        // but the total Aircraft hours modification failed.
        //Returns -3 if Operation modification was successful,
        // but the total Aircraft hours modification failed,
        // and the current Aircraft hours modification was never attempted but needed.
        //Returns -4 if Operation modification was successful,
        // the needed total Aircraft hours modification was successful,
        // but the current Aircraft hours modification failed.     
        //Failures within secondary methods directly below(modifyOpAdjustTotalHours or modifyOpAdjustCurrentHours)
        //Return -5 if retrieval of the total hours failed
        //Return - 6 if retrieval of the current hours failed
        return result;
    }

    //Used within modifyOperation Method above
    public int modifyOpAdjustCurrentHours(Operation inOperation, int difference) {
        int result = -1;

        int newHours = 0;
        int oldHours = retrieveAircraftCurrentHours(inOperation.getAircraftID());

        if (oldHours > -1) {
            //Caluculating new total for aircraft's current hours
            newHours = oldHours + difference;
            System.out.println("new hours " + String.valueOf(newHours));
            System.out.println("old hours " + String.valueOf(oldHours));
            System.out.println("difference " + String.valueOf(difference));
            if (newHours < 0) {
                newHours = 0;
            }
            result = modifyAircraftCurrentHours(inOperation.getAircraftID(), newHours);
            System.out.println(String.valueOf(result));
        }

        //Returns -1 if retrieval of the current hours failed
        //Returns 0 if the modification of current hours failed
        //Returns 1 if successful
        return result;
    }

    //Use within modifyOperation Method above
    public int modifyOpAdjustTotalHours(Operation inOperation, int difference) {
        int result = -1;

        int newHours = 0;
        int oldHours = retrieveAircraftTotalHours(inOperation.getAircraftID());

        if (oldHours > -1) {
            //Caluculating new total for aircraft's total hours
            newHours = oldHours + difference;
            System.out.println("new hours " + String.valueOf(newHours));
            System.out.println("old hours " + String.valueOf(oldHours));
            System.out.println("difference " + String.valueOf(difference));
            result = modifyAircraftTotalHours(inOperation.getAircraftID(), newHours);
            System.out.println(String.valueOf(result));
        }

        //Returns -1 if retrieval of the total hours failed
        //Returns 0 if the modification of total hours failed
        //Returns 1 if successful
        return result;
    }

//Methods below are helper methods for Aircraft Hours Adjustments
    public int retrieveAircraftCurrentHours(int aircraftID) {
        int result = -1;
        ResultSet resultSet = null;
        try {
            retrieveAircraftCurrentHours.setInt(1, aircraftID);
            resultSet = retrieveAircraftCurrentHours.executeQuery();
            resultSet.next();
            result = resultSet.getInt(1);
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return result;
    }

    public int modifyAircraftCurrentHours(int aircraftID, int newHours) {
        int result = 0;
        try {
            modifyAircraftCurrentHours.setInt(1, newHours);
            modifyAircraftCurrentHours.setInt(2, aircraftID);
            result = modifyAircraftCurrentHours.executeUpdate();

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return result;
    }

    public int retrieveAircraftTotalHours(int aircraftID) {
        int result = -1;
        ResultSet resultSet = null;
        try {
            retrieveAircraftTotalHours.setInt(1, aircraftID);
            resultSet = retrieveAircraftTotalHours.executeQuery();
            resultSet.next();
            result = resultSet.getInt(1);
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return result;
    }

    public int modifyAircraftTotalHours(int aircraftID, int newHours) {
        int result = 0;
        try {
            modifyAircraftTotalHours.setInt(1, newHours);
            modifyAircraftTotalHours.setInt(2, aircraftID);
            result = modifyAircraftTotalHours.executeUpdate();

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return result;
    }
//End of helper methods for Aircraft Hours Adjustments

    private DefaultTableModel createOperationTableModel(ResultSet results) {

        Vector<String> tableColumns = new Vector<String>();
        Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();

        tableColumns.add("ID");
        tableColumns.add("Aircraft ID");
        tableColumns.add("Station ID");
        tableColumns.add("Mission ID");
        tableColumns.add("Name");
        tableColumns.add("USBP Station");
        tableColumns.add("Mission");
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
                vector.add(results.getObject(9));
                vector.add(results.getObject(10));
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
