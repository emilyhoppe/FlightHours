/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthours;

import model.Mission;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import controller.MissionDAO;

/**
 *
 * @author tamerjj1
 */
public class TestMissionDAO {

    private static String dbURL = "jdbc:derby:FlightHours";
    private static String tableName = "STATIONS";

    private static Connection conn = null;
    private static MissionDAO missionQueries;
    private static List<Mission> missionList;

    public static void main(String args[]) {
        int result;
        new TestMissionDAO();
        try {
            conn = DriverManager.getConnection(dbURL);

        } catch (Exception except) {
            except.printStackTrace();
        }

        missionQueries = new MissionDAO();

        missionList = missionQueries.selectAllMissions();

        System.out.println(missionList.size());

        for (Mission temp : missionList) {
            System.out.println(temp.getMissionName());
        }

    }

}


