/** **********
 *
 *      Class:         CreateStationsTable.java
 *      Package:       util
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: CreateStationsTable is a static utility class that is
 *                  used to create a table in the database and fill it with
 *                  sample data.
 *
 *
 *********** */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStationsTable {

    public static void main(String args[]) {
        final String CONNECTION = "jdbc:derby:FlightHours;create=true";
        boolean okayToCreate = false;

        try {
            Connection conn = DriverManager.getConnection(CONNECTION);
            Statement s = conn.createStatement();
            s.execute("SELECT '1' FROM STATIONS");
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
                statement.executeUpdate("CREATE TABLE STATIONS ( "
                        + " STATION_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY, "
                        + " STATION_NAME VARCHAR (50) NOT NULL, "
                        + " STATION_TYPE VARCHAR (10) NOT NULL)");
                System.out.println("STATIONS table created.");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try (Connection conn = DriverManager.getConnection(CONNECTION);
                Statement statement = conn.createStatement()) {
            statement.executeUpdate("INSERT INTO STATIONS (STATION_NAME, STATION_TYPE) VALUES "
                    + "('McAllen Air and Marine Branch', 'AMO'), "
                    + "('Laredo Air Branch', 'AMO'), "
                    + "('San Antonio Air Unit', 'AMO'), "
                    + "('Uvalde Air Branch', 'AMO'), "
                    + "('Del Rio Air Unit', 'AMO'), "
                    + "('San Angelo Air Unit', 'AMO'), "
                    + "('El Paso Air Branch', 'AMO'), "
                    + "('Alpine Air Unit', 'AMO'), "
                    + "('Deming Air Unit', 'AMO'), "
                    + "('Tucson Air Branch', 'AMO'), "
                    + "('Sierra Vista Air Unit', 'AMO'), "
                    + "('Yuma Air Branch', 'AMO'), "
                    + "('San Diego Air and Marine Branch', 'AMO'), "
                    + "('Riverside Air Unit', 'AMO'), "
                    + "('Brown Field Air Unit', 'AMO'), "
                    + "('Sacramento Air Unit', 'AMO'), "
                    + "('Pine Valley Air Unit', 'AMO'), "
                    + "('McAllen', 'USBP'), "
                    + "('Rio Grande City', 'USBP'), "
                    + "('Brownsville', 'USBP'), "
                    + "('Imperial Beach', 'USBP'), "
                    + "('Boulevard', 'USBP'), "
                    + "('Chula Vista', 'USBP'), "
                    + "('Alpine', 'USBP'), "
                    + "('Sanderson', 'USBP'), "
                    + "('Marfa', 'USBP'), "
                    + "('Presidio', 'USBP'), "
                    + "('Yuma', 'USBP'), "
                    + "('Wellton', 'USBP') ");
            System.out.println("STATIONS inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
