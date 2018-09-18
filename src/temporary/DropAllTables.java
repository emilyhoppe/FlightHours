/** **********
 *
 *      Class:         DropAllTables.java
 *      Package:       util
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: DropAllTables is a static utility class that is
 *                  used to drop all tables in the FHS database.  It is used for
 *                  testing purposes to clear and is not part of the main application.
 *
 *
 *********** */
package temporary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DropAllTables {

    public static void main(String args[]) {
        final String CONNECTION = "jdbc:derby:FlightHours;create=true";

        //Drop aircraft table
        try (Connection conn = DriverManager.getConnection(CONNECTION);
                Statement statement = conn.createStatement()) {
            statement.executeUpdate("DROP TABLE aircraft");
            System.out.println("AIRCRAFT table dropped.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "DropAllTables Database Error: " + e,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Drop maintenance table
        try (Connection conn = DriverManager.getConnection(CONNECTION);
                Statement statement = conn.createStatement()) {
            statement.executeUpdate("DROP TABLE maintenance");
            System.out.println("MAINTENANCE table dropped.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "DropAllTables Database Error: " + e,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Drop missions table
        try (Connection conn = DriverManager.getConnection(CONNECTION);
                Statement statement = conn.createStatement()) {
            statement.executeUpdate("DROP TABLE missions");
            System.out.println("MISSIONS table dropped.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "DropAllTables Database Error: " + e,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Drop operations table
        try (Connection conn = DriverManager.getConnection(CONNECTION);
                Statement statement = conn.createStatement()) {
            statement.executeUpdate("DROP TABLE operations");
            System.out.println("OPERATIONS table dropped.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "DropAllTables Database Error: " + e,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Drop stations table
        try (Connection conn = DriverManager.getConnection(CONNECTION);
                Statement statement = conn.createStatement()) {
            statement.executeUpdate("DROP TABLE stations");
            System.out.println("STATIONS table dropped.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "DropAllTables Database Error: " + e,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }

}
