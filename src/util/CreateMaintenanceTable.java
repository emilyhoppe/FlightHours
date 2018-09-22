/** **********
 *
 *      Class:         CreateMaintenanceTable.java
 *      Package:       util
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: CreateMaintenanceTable is a static utility class that is
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

public class CreateMaintenanceTable {

    public static void createTable() {
        final String CONNECTION = "jdbc:derby:FlightHours;create=true";
        boolean okayToCreate = false;

        try {
            Connection conn = DriverManager.getConnection(CONNECTION);
            Statement s = conn.createStatement();
            s.execute("SELECT '1' FROM maintenance");
        } catch (SQLException sqle) {
            String theError = (sqle).getSQLState();
            if (theError.equals("42X05")) // Table does not exist
            {
                okayToCreate = true;
            } else {
                JOptionPane.showMessageDialog(null, "CreateMaintenanceTable Database Error: " + theError,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (okayToCreate) {
            try (Connection conn = DriverManager.getConnection(CONNECTION);
                    Statement statement = conn.createStatement()) {
                statement.executeUpdate("CREATE TABLE maintenance ( "
                        + " maintenance_id INT NOT NULL GENERATED ALWAYS AS IDENTITY, "
                        + " aircraft_id INT NOT NULL,"
                        + " maintenance_start_date DATE NOT NULL,"
                        + " maintenance_end_date DATE NOT NULL,"
                        + " maintenance_description VARCHAR(100) NOT NULL)");

                System.out.println("MAINTENANCE table created.");

                //Insert rows of sample data into the table
                try {
                    Statement insertStatement = conn.createStatement();
                    insertStatement.executeUpdate("INSERT INTO maintenance"
                            + "(aircraft_id,"
                            + "maintenance_start_date,"
                            + "maintenance_end_date,"
                            + "maintenance_description)"
                            + "VALUES"
                            + "(27,'2018-09-04','2018-09-07','Test Maintenance 1'),"
                            + "(4,'2018-04-14','2018-04-17','Test Maintenance 2'),"
                            + "(26,'2018-04-11','2018-04-14','Test Maintenance 3'),"
                            + "(34,'2018-06-04','2018-06-07','Test Maintenance 4'),"
                            + "(17,'2018-07-02','2018-07-05','Test Maintenance 5'),"
                            + "(12,'2018-08-25','2018-08-28','Test Maintenance 6'),"
                            + "(16,'2018-07-22','2018-07-25','Test Maintenance 7'),"
                            + "(5,'2018-08-12','2018-08-15','Test Maintenance 8'),"
                            + "(32,'2018-06-13','2018-06-16','Test Maintenance 9'),"
                            + "(22,'2018-07-14','2018-07-17','Test Maintenance 10'),"
                            + "(8,'2018-07-16','2018-07-19','Test Maintenance 11'),"
                            + "(26,'2018-06-19','2018-06-22','Test Maintenance 12'),"
                            + "(31,'2018-08-09','2018-08-12','Test Maintenance 13'),"
                            + "(23,'2018-03-19','2018-03-22','Test Maintenance 14'),"
                            + "(4,'2018-05-07','2018-05-10','Test Maintenance 15'),"
                            + "(32,'2018-07-17','2018-07-20','Test Maintenance 16'),"
                            + "(9,'2018-03-13','2018-03-16','Test Maintenance 17'),"
                            + "(33,'2018-08-26','2018-08-29','Test Maintenance 18'),"
                            + "(23,'2018-08-15','2018-08-18','Test Maintenance 19'),"
                            + "(5,'2018-03-24','2018-03-27','Test Maintenance 20'),"
                            + "(15,'2018-05-12','2018-05-15','Test Maintenance 21'),"
                            + "(16,'2018-04-21','2018-04-24','Test Maintenance 22'),"
                            + "(3,'2018-08-05','2018-08-08','Test Maintenance 23'),"
                            + "(30,'2018-04-20','2018-04-23','Test Maintenance 24'),"
                            + "(17,'2018-04-06','2018-04-09','Test Maintenance 25')");
                    System.out.println("MAINTENANCE inserted");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "CreateMaintenanceTable Database Error: " + e,
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "CreateMaintenanceTable Database Error: " + e,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

}