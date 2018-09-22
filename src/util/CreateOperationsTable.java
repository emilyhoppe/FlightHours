/** **********
 *
 *      Class:         CreateOperationsTable.java
 *      Package:       util
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: CreateOperationsTable is a static utility class that is
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

public class CreateOperationsTable {

    public static void createTable() {
        final String CONNECTION = "jdbc:derby:FlightHours;create=true";
        boolean okayToCreate = false;

        try {
            Connection conn = DriverManager.getConnection(CONNECTION);
            Statement s = conn.createStatement();
            s.execute("SELECT '1' FROM operations");
        } catch (SQLException sqle) {
            String theError = (sqle).getSQLState();
            if (theError.equals("42X05")) // Table does not exist
            {
                okayToCreate = true;
            } else {
                JOptionPane.showMessageDialog(null, "CreateOperationsTable Database Error: " + theError,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (okayToCreate) {
            try (Connection conn = DriverManager.getConnection(CONNECTION);
                    Statement statement = conn.createStatement()) {
                statement.executeUpdate("CREATE TABLE operations ( "
                        + " operation_id INT NOT NULL GENERATED ALWAYS AS IDENTITY, "
                        + " aircraft_id INT NOT NULL,"
                        + " station_id INT NOT NULL,"
                        + " mission_id INT NOT NULL,"
                        + " operation_name VARCHAR(20) NOT NULL,"
                        + " operation_start_date DATE NOT NULL,"
                        + " operation_end_date DATE NOT NULL,"
                        + " operation_flight_hours INT NOT NULL)");

                System.out.println("OPERATIONS table created.");

                //Insert rows of sample data into the table
                try {
                    Statement insertStatement = conn.createStatement();
                    insertStatement.executeUpdate("INSERT INTO operations ("
                            + "aircraft_id,"
                            + "station_id,"
                            + "mission_id,"
                            + "operation_name,"
                            + "operation_start_date,"
                            + "operation_end_date,"
                            + "operation_flight_hours)"
                            + "VALUES"
                            + "(1,19,7,'Test Operation 1','2018-01-05','2018-01-05',3546),"
                            + "(1,26,4,'Test Operation 2','2018-01-13','2018-01-13',2281),"
                            + "(1,25,6,'Test Operation 3','2018-02-16','2018-02-16',9237),"
                            + "(1,22,6,'Test Operation 4','2018-02-23','2018-02-25',19996),"
                            + "(4,26,4,'Test Operation 5','2018-01-05','2018-01-05',4099),"
                            + "(7,23,3,'Test Operation 6','2018-01-13','2018-01-13',1220),"
                            + "(7,23,4,'Test Operation 7','2018-02-16','2018-02-16',14015),"
                            + "(8,23,3,'Test Operation 8','2018-02-23','2018-02-23',21212),"
                            + "(11,29,1,'Test Operation 9','2018-01-05','2018-01-05',3685),"
                            + "(11,18,1,'Test Operation 10','2018-01-13','2018-01-13',4595),"
                            + "(21,20,6,'Test Operation 11','2018-02-16','2018-02-16',9765),"
                            + "(22,21,5,'Test Operation 12','2018-02-23','2018-02-23',5192),"
                            + "(30,22,7,'Test Operation 13','2018-01-05','2018-01-05',12666)");
                    System.out.println("OPERATIONS inserted");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "CreateOperationsTable Database Error: " + e,
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "CreateOperationsTable Database Error: " + e,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

}