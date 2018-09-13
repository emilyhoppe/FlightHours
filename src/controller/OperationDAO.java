/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author jjtam
 */
    
import flighthours.Operation;
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

public class OperationDAO {
    
    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement selectAllOperation;
    private static PreparedStatement selectOperationByAircraft;
    private static PreparedStatement insertNewOperation;
    private static PreparedStatement modifyOperation;
    private static List<Operation> OperationList;

    public OperationDAO(Connection conn) {
        try {
            OperationDAO.conn = conn;
            //conn = DriverManager.getConnection(dbURL);
            selectAllOperation = conn.prepareStatement("SELECT * FROM MAINTENANCE");

        } catch (Exception except) {
            except.printStackTrace();
        }
    }
    public static List<Operation> selectAllOperation() {

        List<Operation> results = null;
        ResultSet resultSet = null;

        return results;
    }
    
    public static List<Operation> selectOperationByAircraft() {

        List<Operation> results = null;
        ResultSet resultSet = null;

        return results;
    }
    
    public int insertNewOperation(Operation inOperation) {
        int result = 0;

        return result;
    }

    public int modifyOperation(Operation inOperation) {
        int result = 0;

        return result;
    }
}

    

