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
                        + " maintenance_id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
                        + " aircraft_id INT NOT NULL REFERENCES aircraft(aircraft_id),"
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
                            + "(20,'2014-01-20','2014-01-21','Maintenance operation 1'),"
                            + "(25,'2014-01-31','2014-02-03','Maintenance operation 2'),"
                            + "(5,'2014-02-09','2014-02-12','Maintenance operation 3'),"
                            + "(5,'2014-02-10','2014-02-13','Maintenance operation 4'),"
                            + "(18,'2014-02-14','2014-02-17','Maintenance operation 5'),"
                            + "(18,'2014-02-25','2014-03-03','Maintenance operation 6'),"
                            + "(26,'2014-02-25','2014-03-03','Maintenance operation 7'),"
                            + "(2,'2014-03-10','2014-03-11','Maintenance operation 9'),"
                            + "(30,'2014-03-19','2014-03-23','Maintenance operation 10'),"
                            + "(20,'2014-03-19','2014-03-28','Maintenance operation 11'),"
                            + "(31,'2014-04-18','2014-04-20','Maintenance operation 12'),"
                            + "(30,'2014-05-04','2014-05-10','Maintenance operation 13'),"
                            + "(12,'2014-06-10','2014-06-14','Maintenance operation 14'),"
                            + "(3,'2014-06-22','2014-06-28','Maintenance operation 15'),"
                            + "(32,'2014-06-25','2014-06-30','Maintenance operation 16'),"
                            + "(1,'2014-06-29','2014-06-30','Maintenance operation 17'),"
                            + "(16,'2014-06-30','2014-07-03','Maintenance operation 18'),"
                            + "(8,'2014-07-23','2014-07-26','Maintenance operation 20'),"
                            + "(20,'2014-07-29','2014-08-01','Maintenance operation 21'),"
                            + "(29,'2014-08-08','2014-08-12','Maintenance operation 22'),"
                            + "(25,'2014-08-11','2014-08-17','Maintenance operation 23'),"
                            + "(19,'2014-08-18','2014-08-19','Maintenance operation 24'),"
                            + "(3,'2014-09-05','2014-09-08','Maintenance operation 25'),"
                            + "(32,'2014-09-21','2014-09-27','Maintenance operation 26'),"
                            + "(27,'2014-09-30','2014-10-08','Maintenance operation 27'),"
                            + "(26,'2014-10-06','2014-10-11','Maintenance operation 28'),"
                            + "(4,'2014-10-11','2014-10-18','Maintenance operation 29'),"
                            + "(20,'2014-10-21','2014-10-22','Maintenance operation 30'),"
                            + "(18,'2014-10-27','2014-10-28','Maintenance operation 31'),"
                            + "(1,'2014-11-15','2014-11-20','Maintenance operation 32'),"
                            + "(16,'2014-11-17','2014-11-26','Maintenance operation 33'),"
                            + "(20,'2014-11-20','2014-11-21','Maintenance operation 34'),"
                            + "(24,'2014-12-01','2014-12-02','Maintenance operation 35'),"
                            + "(15,'2014-12-05','2014-12-15','Maintenance operation 36'),"
                            + "(30,'2014-12-12','2014-12-13','Maintenance operation 37'),"
                            + "(26,'2014-12-19','2014-12-28','Maintenance operation 38'),"
                            + "(22,'2014-12-22','2014-12-27','Maintenance operation 39'),"
                            + "(1,'2014-12-30','2015-01-09','Maintenance operation 40'),"
                            + "(14,'2015-01-02','2015-01-10','Maintenance operation 41'),"
                            + "(6,'2015-01-15','2015-01-17','Maintenance operation 42'),"
                            + "(22,'2015-01-23','2015-01-29','Maintenance operation 43'),"
                            + "(1,'2015-02-16','2015-02-22','Maintenance operation 44'),"
                            + "(21,'2015-02-21','2015-02-23','Maintenance operation 45'),"
                            + "(12,'2015-03-04','2015-03-05','Maintenance operation 46'),"
                            + "(13,'2015-03-04','2015-03-05','Maintenance operation 47'),"
                            + "(17,'2015-03-09','2015-03-14','Maintenance operation 48'),"
                            + "(25,'2015-03-11','2015-03-17','Maintenance operation 49'),"
                            + "(7,'2015-05-03','2015-05-13','Maintenance operation 50'),"
                            + "(22,'2015-05-12','2015-05-15','Maintenance operation 51'),"
                            + "(19,'2015-05-15','2015-05-16','Maintenance operation 52'),"
                            + "(10,'2015-05-27','2015-05-31','Maintenance operation 53'),"
                            + "(27,'2015-05-27','2015-05-29','Maintenance operation 54'),"
                            + "(8,'2015-06-02','2015-06-10','Maintenance operation 55'),"
                            + "(27,'2015-06-24','2015-06-30','Maintenance operation 56'),"
                            + "(28,'2015-06-28','2015-07-06','Maintenance operation 57'),"
                            + "(28,'2015-07-11','2015-07-16','Maintenance operation 58'),"
                            + "(32,'2015-09-04','2015-09-05','Maintenance operation 59'),"
                            + "(25,'2015-09-04','2015-09-13','Maintenance operation 60'),"
                            + "(7,'2015-09-07','2015-09-11','Maintenance operation 61'),"
                            + "(2,'2015-09-08','2015-09-15','Maintenance operation 62'),"
                            + "(6,'2015-09-27','2015-10-07','Maintenance operation 63'),"
                            + "(32,'2015-10-01','2015-10-07','Maintenance operation 64'),"
                            + "(15,'2015-10-09','2015-10-15','Maintenance operation 65'),"
                            + "(12,'2015-10-27','2015-10-28','Maintenance operation 66'),"
                            + "(16,'2015-11-29','2015-12-02','Maintenance operation 67'),"
                            + "(32,'2015-12-11','2015-12-21','Maintenance operation 68'),"
                            + "(2,'2015-12-14','2015-12-21','Maintenance operation 69'),"
                            + "(20,'2015-12-21','2015-12-25','Maintenance operation 70'),"
                            + "(25,'2015-12-29','2016-01-02','Maintenance operation 71'),"
                            + "(31,'2016-01-18','2016-01-25','Maintenance operation 72'),"
                            + "(29,'2016-01-31','2016-02-03','Maintenance operation 73'),"
                            + "(11,'2016-02-08','2016-02-18','Maintenance operation 74'),"
                            + "(18,'2016-02-19','2016-02-20','Maintenance operation 76'),"
                            + "(22,'2016-02-23','2016-02-24','Maintenance operation 77'),"
                            + "(12,'2016-03-04','2016-03-12','Maintenance operation 78'),"
                            + "(21,'2016-03-14','2016-03-23','Maintenance operation 79'),"
                            + "(28,'2016-03-31','2016-04-10','Maintenance operation 81'),"
                            + "(24,'2016-03-31','2016-04-06','Maintenance operation 82'),"
                            + "(15,'2016-04-07','2016-04-08','Maintenance operation 83'),"
                            + "(16,'2016-04-07','2016-04-09','Maintenance operation 84'),"
                            + "(31,'2016-04-11','2016-04-20','Maintenance operation 85'),"
                            + "(8,'2016-05-07','2016-05-09','Maintenance operation 86'),"
                            + "(20,'2016-05-08','2016-05-11','Maintenance operation 87'),"
                            + "(1,'2016-05-09','2016-05-14','Maintenance operation 88'),"
                            + "(27,'2016-05-10','2016-05-15','Maintenance operation 89'),"
                            + "(25,'2016-05-13','2016-05-18','Maintenance operation 90'),"
                            + "(27,'2016-05-19','2016-05-28','Maintenance operation 91'),"
                            + "(6,'2016-06-08','2016-06-16','Maintenance operation 92'),"
                            + "(10,'2016-06-13','2016-06-15','Maintenance operation 94'),"
                            + "(27,'2016-07-02','2016-07-04','Maintenance operation 95'),"
                            + "(13,'2016-07-16','2016-07-24','Maintenance operation 96'),"
                            + "(10,'2016-07-17','2016-07-23','Maintenance operation 97'),"
                            + "(14,'2016-07-22','2016-07-26','Maintenance operation 98'),"
                            + "(3,'2016-08-02','2016-08-10','Maintenance operation 99'),"
                            + "(6,'2016-08-15','2016-08-23','Maintenance operation 100'),"
                            + "(11,'2016-08-27','2016-09-01','Maintenance operation 101'),"
                            + "(7,'2016-08-30','2016-08-31','Maintenance operation 102'),"
                            + "(32,'2016-09-04','2016-09-11','Maintenance operation 103'),"
                            + "(18,'2016-09-17','2016-09-27','Maintenance operation 104'),"
                            + "(32,'2016-09-18','2016-09-28','Maintenance operation 105'),"
                            + "(19,'2016-09-20','2016-09-27','Maintenance operation 106'),"
                            + "(6,'2016-10-30','2016-11-01','Maintenance operation 107'),"
                            + "(4,'2016-11-04','2016-11-09','Maintenance operation 108'),"
                            + "(27,'2016-11-19','2016-11-24','Maintenance operation 109'),"
                            + "(31,'2016-11-24','2016-11-30','Maintenance operation 110'),"
                            + "(6,'2016-11-27','2016-12-02','Maintenance operation 111'),"
                            + "(15,'2016-12-01','2016-12-02','Maintenance operation 112'),"
                            + "(1,'2016-12-09','2016-12-13','Maintenance operation 113'),"
                            + "(5,'2016-12-31','2017-01-01','Maintenance operation 114'),"
                            + "(23,'2017-01-31','2017-02-07','Maintenance operation 115'),"
                            + "(9,'2017-02-06','2017-02-08','Maintenance operation 116'),"
                            + "(31,'2017-02-13','2017-02-18','Maintenance operation 117'),"
                            + "(22,'2017-02-15','2017-02-25','Maintenance operation 118'),"
                            + "(29,'2017-02-25','2017-02-28','Maintenance operation 119'),"
                            + "(18,'2017-02-26','2017-03-06','Maintenance operation 120'),"
                            + "(30,'2017-03-05','2017-03-15','Maintenance operation 121'),"
                            + "(30,'2017-03-14','2017-03-20','Maintenance operation 122'),"
                            + "(28,'2017-03-20','2017-03-23','Maintenance operation 123'),"
                            + "(17,'2017-04-13','2017-04-17','Maintenance operation 124'),"
                            + "(18,'2017-05-02','2017-05-06','Maintenance operation 125'),"
                            + "(24,'2017-05-10','2017-05-13','Maintenance operation 126'),"
                            + "(22,'2017-05-20','2017-05-30','Maintenance operation 127'),"
                            + "(27,'2017-05-20','2017-05-29','Maintenance operation 128'),"
                            + "(4,'2017-05-21','2017-05-29','Maintenance operation 129'),"
                            + "(4,'2017-05-23','2017-06-02','Maintenance operation 130'),"
                            + "(26,'2017-06-01','2017-06-05','Maintenance operation 131'),"
                            + "(27,'2017-06-07','2017-06-11','Maintenance operation 132'),"
                            + "(11,'2017-06-16','2017-06-20','Maintenance operation 134'),"
                            + "(3,'2017-06-28','2017-07-04','Maintenance operation 135'),"
                            + "(25,'2017-07-12','2017-07-18','Maintenance operation 136'),"
                            + "(30,'2017-07-18','2017-07-27','Maintenance operation 137'),"
                            + "(22,'2017-10-03','2017-10-07','Maintenance operation 138'),"
                            + "(4,'2017-10-10','2017-10-12','Maintenance operation 139'),"
                            + "(17,'2017-10-20','2017-10-30','Maintenance operation 140'),"
                            + "(22,'2017-11-01','2017-11-10','Maintenance operation 141'),"
                            + "(16,'2017-11-26','2017-12-03','Maintenance operation 142'),"
                            + "(9,'2017-12-05','2017-12-11','Maintenance operation 143'),"
                            + "(2,'2017-12-11','2017-12-19','Maintenance operation 144'),"
                            + "(9,'2017-12-17','2017-12-27','Maintenance operation 145'),"
                            + "(2,'2017-12-19','2017-12-28','Maintenance operation 146'),"
                            + "(27,'2017-12-30','2018-01-02','Maintenance operation 147'),"
                            + "(9,'2018-01-01','2018-01-07','Maintenance operation 148'),"
                            + "(20,'2018-01-04','2018-01-07','Maintenance operation 149')");
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
