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
    
    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement selectAllMissions;
    private static List<Mission> MissionList;
    
    public MissionDAO(Connection conn) {
        try {
            MissionDAO.conn = conn;
            //conn = DriverManager.getConnection(dbURL);
            selectAllMissions = conn.prepareStatement("SELECT * FROM MISSIONS");

        } catch (Exception except) {
            except.printStackTrace();
        }
    }
    public static List<Mission> selectAllMissions() {

        List<Mission> results = null;
        ResultSet resultSet = null;

        return results;
    }
    
}