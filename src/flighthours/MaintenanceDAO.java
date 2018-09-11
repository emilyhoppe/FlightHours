/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthours;

/**
 *
 * @author jjtam
 * 
 * 
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

public class MaintenanceDAO {
    
    
    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement selectAllMaintenance;
    private static PreparedStatement selectMaintenanceByAircraft;
    private static PreparedStatement insertNewMaintenance;
    private static PreparedStatement modifyMaintenance;
    private static List<Maintenance> MaintenanceList;

    public MaintenanceDAO(Connection conn) {
        try {
            MaintenanceDAO.conn = conn;
            //conn = DriverManager.getConnection(dbURL);
            selectAllMaintenance = conn.prepareStatement("SELECT * FROM MAINTENANCE");

        } catch (Exception except) {
            except.printStackTrace();
        }
    }
    public static List<Maintenance> selectAllMaintenance() {

        List<Maintenance> results = null;
        ResultSet resultSet = null;

        return results;
    }
    
    public static List<Maintenance> selectMaintenanceByAircraft() {

        List<Maintenance> results = null;
        ResultSet resultSet = null;

        return results;
    }
    
    public int insertNewMaintenance(Maintenance inMaintenance) {
        int result = 0;

        return result;
    }

    public int modifyMaintenance(Maintenance inMaintenance) {
        int result = 0;

        return result;
    }
    
    
}
