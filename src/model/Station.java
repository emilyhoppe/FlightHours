/** **********
 *
 *      Class:         Station.java
 *      Package:       model
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: The Station model class is used to represent a Station
 *                  and includes all relevant constructors, getter methods and
 *                  setter methods.
 *
 *
 *********** */
package model;

public class Station {

    //Instance variables
    private int stationID;
    private String stationName;
    private String stationType;

    //Parameterized constructor
    public Station(int stationID, String stationName, String stationType) {
        this.stationID = stationID;
        this.stationName = stationName;
        this.stationType = stationType;
    }

    //Getters and Setters
    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    @Override
    //This is used by the JComboBoxes in the GUI
    public String toString() {
        return stationName;
    }

}
