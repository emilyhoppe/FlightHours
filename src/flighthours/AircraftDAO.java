/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthours;

/**
 *
 * @author jjtam
 */
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

public class AircraftDAO {

    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement selectAllAircraft;
    private static PreparedStatement selectAircraftByLocation;
    private static PreparedStatement selectAircraftByTailNumber;
    private static PreparedStatement selectAircraftByMaintFlag;
    private static PreparedStatement insertNewAircraft;
    private static PreparedStatement modifyAircraft;
    private static List<Aircraft> AircraftList;

    public AircraftDAO(Connection conn) {
        try {
            AircraftDAO.conn = conn;
            //conn = DriverManager.getConnection(dbURL);
            selectAllAircraft = conn.prepareStatement("SELECT * FROM AIRCRAFT ORDER BY TAIL_NUMBER");

        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    public static List<Aircraft> selectAllAircraft() {

        List<Aircraft> results = null;
        ResultSet resultSet = null;

        return results;
    }

    public static List<Aircraft> selectAircraftbyLocation() {

        List<Aircraft> results = null;
        ResultSet resultSet = null;

        return results;
    }

    public static Aircraft selectAircraftByTailnumber() {

        Aircraft results = null;
        ResultSet resultSet = null;

        return results;
    }

    public static List<Aircraft> selectAircraftbyMaintFlag() {

        List<Aircraft> results = null;
        ResultSet resultSet = null;

        return results;
    }

    public int insertNewAircraft(Aircraft inAircraft) {
        int result = 0;

        return result;
    }

    public int modifyAircraft(Aircraft inAircraft) {
        int result = 0;

        return result;
    }
}
