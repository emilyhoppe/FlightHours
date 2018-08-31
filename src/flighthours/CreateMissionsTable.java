/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthours;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateMissionsTable {

    public static void main(String args[]) {
        final String CONNECTION = "jdbc:derby:FlightHours;create=true";
        boolean okayToCreate = false;

        try {
            Connection conn = DriverManager.getConnection(CONNECTION);
            Statement s = conn.createStatement();
            s.execute("SELECT '1' FROM MISSIONS");
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
                statement.executeUpdate("CREATE TABLE MISSIONS ( "
                        + " MISSION_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY, "
                        + " MISSION_NAME VARCHAR (50) NOT NULL)");
                System.out.println("MISSIONS table created.");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try (Connection conn = DriverManager.getConnection(CONNECTION);
                Statement statement = conn.createStatement()) {
            statement.executeUpdate("INSERT INTO MISSIONS (MISSION_NAME) VALUES "
                    + "('Interdiction'), "
                    + "('Surveillance'), "
                    + "('Intelligence'), "
                    + "('Tactical Ops'), "
                    + "('Transport'), "
                    + "('Search and Rescue'), "
                    + "('Disaster Relief') ");
            System.out.println("Missions inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}


