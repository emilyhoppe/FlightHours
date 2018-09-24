/** **********
 *
 *      Class:         StationDAO.java
 *      Package:       controller
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: StationDAO accesses the embedded Apache Derby Database
 *                  and performs the main station functions.
 *
 *
 *********** */
package controller;

import model.Station;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class StationDAO {

    //Instance variables
    private String dbURL = "jdbc:derby:FlightHours";
    private Connection conn = null;
    private PreparedStatement selectStationByType;
    private PreparedStatement selectAllStations;
    private PreparedStatement insertNewStation;

    //Default constructor
    public StationDAO() {
        try {
            conn = DriverManager.getConnection(dbURL);
            selectStationByType = conn.prepareStatement("SELECT * FROM stations WHERE station_type = ?");
            selectAllStations = conn.prepareStatement("SELECT * FROM stations");

            insertNewStation = conn.prepareStatement("INSERT INTO stations (station_name, station_type)"
                    + "VALUES (?, ?)");

        } catch (SQLException except) {
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    //Select all stations from the database and return a List of Station objects
    public List<Station> selectAllStations() {

        List<Station> results = null;
        ResultSet resultSet = null;

        try {
            resultSet = selectAllStations.executeQuery();
            results = new ArrayList<Station>();

            while (resultSet.next()) {
                results.add(new Station(
                        resultSet.getInt("station_id"),
                        resultSet.getString("station_name"),
                        resultSet.getString("station_type")));
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

    //Select stations by type from the database and return a List of Station objects
    public List<Station> selectStationByType(String stationType) {

        List<Station> results = null;
        ResultSet resultSet = null;
        try {
            selectStationByType.setString(1, stationType);
            resultSet = selectStationByType.executeQuery();
            results = new ArrayList<Station>();

            while (resultSet.next()) {
                results.add(new Station(
                        resultSet.getInt("station_id"),
                        resultSet.getString("station_name"),
                        resultSet.getString("station_type")));
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

    //Add a new station to the database
    public int addStation(Station inStation) {
        int result = 0;

        try {
            insertNewStation.setString(1, inStation.getStationName());
            insertNewStation.setString(2, inStation.getStationType());
            result = insertNewStation.executeUpdate();

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    "Database Error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }
}
