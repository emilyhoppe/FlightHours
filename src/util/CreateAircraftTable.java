/** **********
 *
 *      Class:         CreateAircraftTable.java
 *      Package:       util
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: CreateAircraftTable is a static utility class that is
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
import javax.swing.JOptionPane;

public class CreateAircraftTable {

    public static void createTable() {
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
                JOptionPane.showMessageDialog(null, "CreateAircraftTable Database Error: " + theError,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (okayToCreate) {
            //Create table in database
            try (Connection conn = DriverManager.getConnection(CONNECTION);
                    Statement statement = conn.createStatement()) {
                statement.executeUpdate("CREATE TABLE aircraft ( "
                        + " aircraft_id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
                        + " tail_number   VARCHAR (10) NOT NULL UNIQUE,"
                        + " aircraft_type VARCHAR (20) NOT NULL,"
                        + " station_id INT NOT NULL REFERENCES stations(station_id),"
                        + " max_speed INT NOT NULL,"
                        + " max_altitude INT NOT NULL,"
                        + " total_flight_hours INT NOT NULL,"
                        + " maintenance_flag BOOLEAN GENERATED ALWAYS AS "
                        + "     (current_maintenance_hours >= maintenance_hours_threshold),"
                        + " current_maintenance_hours INT NOT NULL,"
                        + " maintenance_hours_threshold INT NOT NULL,"
                        + " end_of_service_date DATE)");
                System.out.println("AIRCRAFT table created.");
                //Insert rows of sample data into the table
                try {
                    Statement insertStatement = conn.createStatement();
                    insertStatement.executeUpdate("INSERT INTO aircraft"
                            + "(tail_number,"
                            + " aircraft_type,"
                            + " station_id,"
                            + " max_speed,"
                            + " max_altitude,"
                            + " total_flight_hours,"
                            + " current_maintenance_hours,"
                            + " maintenance_hours_threshold,"
                            + " end_of_service_date)"
                            + "VALUES"
                            + "('N7255N','Rotary Wing',12,130,15000,10713,5251,6000,NULL),"
                            + "('N6506R','Fixed Wing',17,174,18000,10889,2416,4000,NULL),"
                            + "('N7166P','UAV',16,260,26000,10205,717,1500,NULL),"
                            + "('N3707R','Rotary Wing',8,150,20000,18853,4475,4000,NULL),"
                            + "('N8877N','Rotary Wing',17,130,15000,8769,2580,4000,NULL),"
                            + "('N4900P','Fixed Wing',15,270,31000,11862,2278,5000,NULL),"
                            + "('N1010N','Fixed Wing',13,174,18000,14635,2657,4000,NULL),"
                            + "('N2233R','Fixed Wing',10,270,31000,6636,552,5000,NULL),"
                            + "('N4576P','Fixed Wing',2,270,31000,9470,162,4000,NULL),"
                            + "('N4398N','Rotary Wing',9,130,15000,12767,465,4000,'2016-01-31'),"
                            + "('N0987P','Rotary Wing',8,130,15000,12709,2118,4000,NULL),"
                            + "('N0789R','Rotary Wing',15,130,15000,11895,2924,4000,NULL),"
                            + "('N6671P','UAV',7,260,26000,9176,47,1500,NULL),"
                            + "('N6681P','Rotary Wing',1,150,20000,6102,1280,6000,NULL),"
                            + "('N7781R','Rotary Wing',8,130,15000,19628,674,4000,NULL),"
                            + "('N8778R','Rotary Wing',1,130,15000,6391,4572,5000,NULL),"
                            + "('N0980N','Fixed Wing',2,270,31000,16121,4103,4000,NULL),"
                            + "('N0190N','Fixed Wing',14,174,18000,15732,1491,1500,NULL),"
                            + "('N8801R','Fixed Wing',1,270,31000,14577,3347,4000,NULL),"
                            + "('N8903R','Rotary Wing',17,150,20000,16777,816,5000,NULL),"
                            + "('N4867N','Rotary Wing',2,130,15000,9342,2728,4000,NULL),"
                            + "('N4890N','Rotary Wing',11,150,20000,13097,4315,4000,NULL),"
                            + "('N3402N','Rotary Wing',16,130,15000,7594,2047,4000,NULL),"
                            + "('N4509P','UAV',9,260,26000,16821,4060,5000,NULL),"
                            + "('N3980R','Rotary Wing',4,130,15000,16859,3989,5000,NULL),"
                            + "('N3911R','Rotary Wing',7,150,20000,18300,1232,4000,NULL),"
                            + "('N2497N','Fixed Wing',10,270,31000,17916,1146,6000,'1998-06-13'),"
                            + "('N2587N','Fixed Wing',11,174,18000,17974,3399,4000,NULL),"
                            + "('N0989R','Fixed Wing',9,270,31000,18900,6129,6000,NULL),"
                            + "('N0667P','Rotary Wing',5,130,15000,10931,1699,5000,NULL),"
                            + "('N0898N','Rotary Wing',1,150,20000,11978,3858,4000,NULL),"
                            + "('N2121N','Fixed Wing',4,130,15000,8192,1287,6000,NULL)");
                    System.out.println("AIRCRAFT inserted");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "CreateAircraftTable Database Error: " + e,
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "CreateAircraftTable Database Error: " + e,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

}
