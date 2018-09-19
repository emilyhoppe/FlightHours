/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author tamerjj1
 */
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
    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement selectAllMissions;
    private static List<Mission> MissionList;

    public MissionDAO() {
        try {
            //MissionDAO.conn = conn;
            conn = DriverManager.getConnection(dbURL);
            selectAllMissions = conn.prepareStatement("SELECT * FROM MISSIONS");

        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    public static List<Mission> selectAllMissions() {

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
