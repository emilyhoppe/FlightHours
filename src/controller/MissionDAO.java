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

import flighthours.Mission;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

public class MissionDAO {

    private String dbURL = "jdbc:derby:FlightHours";
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement selectAllMissions;
    private List<Mission> MissionList;

    public MissionDAO() {
        try {
            //MissionDAO.conn = conn;
            conn = DriverManager.getConnection(dbURL);
            selectAllMissions = conn.prepareStatement("SELECT * FROM MISSIONS ORDER BY MISSION_NAME");

        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    public List<Mission> selectAllMissions() {

        List<Mission> results = null;
        ResultSet resultSet = null;
        
        try {
            resultSet = selectAllMissions.executeQuery();
            results = new ArrayList<Mission>();

            while (resultSet.next()) {
                results.add(new Mission(
                        resultSet.getInt("MISSION_ID"),
                        resultSet.getString("MISSION_NAME")));
            }

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException sqlExcept) {
                sqlExcept.printStackTrace();
            }
        }

        return results;

       
    }

}
