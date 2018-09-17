/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author tamerjj1
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateOperationsTable {
    
    
    public static void main(String args[]) {
        final String CONNECTION = "jdbc:derby:FlightHours;create=true";
        boolean okayToCreate = false;

        try {
            Connection conn = DriverManager.getConnection(CONNECTION);
            Statement s = conn.createStatement();
            s.execute("SELECT '1' FROM OPERATIONS");
        } catch (SQLException sqle) {
            String theError = (sqle).getSQLState();
            if (theError.equals("42X05")) // Table does not exist
            {
                okayToCreate = true;
            } else {
                System.out.println("Unhandled SQLException" + theError);
            }
        }
        if (okayToCreate) {
            try (Connection conn = DriverManager.getConnection(CONNECTION);
                    Statement statement = conn.createStatement()) {
                statement.executeUpdate("CREATE TABLE OPERATIONS ( "
                        + " OPERATION_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY, "
                        + " AIRCRAFT_ID INT NOT NULL,"
                        + " STATION_ID INT NOT NULL,"
                        + " MISSION_ID INT NOT NULL,"
                        + " OPERATION_NAME VARCHAR(20) NOT NULL,"
                        + " OPERATION_START_DATE DATE NOT NULL,"
                        + " OPERATION_END_DATE DATE NOT NULL,"
                        + " OPERATION_FILGHT_HOURS INT NOT NULL)");
                       
                System.out.println("OPERATIONS table created.");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
/*
    private int operationID;
    private int aircraftID;
    private int stationID;
    private int missionID;
    private String operationName;
    private int operationStartDate;
    private int operationEndDate;
    private int operationFlighHour;
*/
