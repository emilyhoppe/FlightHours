/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

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

/**
 *
 * @author tamerjj1
 */
public class createAircraftTable {

    public static void main(String args[]) {
        final String CONNECTION = "jdbc:derby:FlightHours;create=true";
        boolean okayToCreate = false;

        try {
            Connection conn = DriverManager.getConnection(CONNECTION);
            Statement s = conn.createStatement();
            s.execute("SELECT '1' FROM AIRCRAFT");
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
                statement.executeUpdate("CREATE TABLE AIRCRAFT ( "
                        + " AIRCRAFT_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY, "
                        + " TAIL_NUMBER   VARCHAR (10) NOT NULL,"
                        + " AIRCRAFT_TYPE VARCHAR (20) NOT NULL,"
                        + " STATION_ID INT NOT NULL,"
                        + " PRIMARY_MISSION INT NOT NULL,"
                        + " MAX_SPEED INT NOT NULL,"
                        + " MAX_ALTITUDE INT NOT NULL,"
                        + " TOTAL_FILGHT_HOURS INT NOT NULL,"
                        + " MAINTENANCE_FLAG BOOLEAN NOT NULL,"
                        + " CURRENT_MAINTENANCE_HOURS INT NOT NULL,"
                        + " END_OF_SERVICE_DATE DATE) ");
                System.out.println("AIRCRAFT table created.");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
/*
    private String tailNumber;
    private String aircraftType;
    private int stationID;
    private String primaryMission;
    private int maxSpeed;
    private int maxAltitude;  
    private int totalFlightHours;
    private boolean maintenanceFlag;
    private int currentMaintenanceHours;
    private int maintenanceHoursThreshold;
    private Date endOfServiceDate;
*/
