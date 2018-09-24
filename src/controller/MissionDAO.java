/** **********
 *
 *      Class:         MissionDAO.java
 *      Package:       controller
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: MissionDAO accesses the embedded Apache Derby Database
 *                  and performs the main mission functions.
 *
 *
 *********** */
package controller;

import model.Mission;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MissionDAO {

    //Instance variables
    private String dbURL = "jdbc:derby:FlightHours";
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement selectAllMissions;
    private List<Mission> MissionList;

    //Constructor
    public MissionDAO() {
        try {
            conn = DriverManager.getConnection(dbURL);
            selectAllMissions = conn.prepareStatement("SELECT * FROM missions ORDER BY mission_name");

        } catch (SQLException except) {
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Select all missions from database and return a List of Missions objects
    public List<Mission> selectAllMissions() {

        List<Mission> results = null;
        ResultSet resultSet = null;

        try {
            resultSet = selectAllMissions.executeQuery();
            results = new ArrayList<Mission>();

            while (resultSet.next()) {
                results.add(new Mission(
                        resultSet.getInt("mission_id"),
                        resultSet.getString("mission_name")));
            }

        } catch (SQLException sqlExcept) {
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException sqlExcept) {
                JOptionPane.showMessageDialog(null,
                        "Database Error",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return results;
    }
}
