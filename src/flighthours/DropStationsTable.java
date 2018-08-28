/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthours;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropStationsTable {

    public static void main(String args[]) {
        final String CONNECTION = "jdbc:derby:FlightHours;create=true";

            try (Connection conn = DriverManager.getConnection(CONNECTION);
                    Statement statement = conn.createStatement()) {
                statement.executeUpdate("DROP TABLE STATIONS");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        
    }

}
