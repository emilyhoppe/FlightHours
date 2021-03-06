/** **********
 *
 *      Class:         Aircraft.java
 *      Package:       model
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: The Aircraft model class is used to represent an Aircraft
 *                  and includes all relevant constructors, getter methods and 
 *                  setter methods.
 *
 *
 *********** */
package model;

import java.util.Date;

public class Aircraft {

    //Instance variables
    private int aircraftID;
    private String tailNumber;
    private String aircraftType;
    private int stationID;
    private int maxSpeed;
    private int maxAltitude;
    private int totalFlightHours;
    private boolean maintenanceFlag;
    private int currentMaintenanceHours;
    private int maintenanceHoursThreshold;
    private Date endOfServiceDate;

    //Constructor without aircraft ID
    public Aircraft(String tailNumber, String aircraftType, int stationID,
            int maxSpeed, int maxAltitude, int totalFlightHours, boolean maintenanceFlag, int currentMaintenanceHours,
            int maintenanceHoursThreshold) {
        this.tailNumber = tailNumber;
        this.aircraftType = aircraftType;
        this.stationID = stationID;
        this.maxSpeed = maxSpeed;
        this.maxAltitude = maxAltitude;
        this.totalFlightHours = totalFlightHours;
        this.maintenanceFlag = maintenanceFlag;
        this.currentMaintenanceHours = currentMaintenanceHours;
        this.maintenanceHoursThreshold = maintenanceHoursThreshold;
    }

    //Constructor with aircraft ID
    public Aircraft(int aircraftID, String tailNumber, String aircraftType, int stationID,
            int maxSpeed, int maxAltitude, int totalFlightHours, int currentMaintenanceHours,
            int maintenanceHoursThreshold, Date endOfServiceDate) {
        this.aircraftID = aircraftID;
        this.tailNumber = tailNumber;
        this.aircraftType = aircraftType;
        this.stationID = stationID;
        this.maxSpeed = maxSpeed;
        this.maxAltitude = maxAltitude;
        this.totalFlightHours = totalFlightHours;
        this.currentMaintenanceHours = currentMaintenanceHours;
        this.maintenanceHoursThreshold = maintenanceHoursThreshold;
        this.endOfServiceDate = endOfServiceDate;
    }

    //Getters and Setters
    public int getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(int aircraftID) {
        this.aircraftID = aircraftID;
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }
    
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxAltitude() {
        return maxAltitude;
    }

    public void setMaxAltitude(int maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

    public int getTotalFlightHours() {
        return totalFlightHours;
    }

    public void setTotalFlightHours(int totalFlightHours) {
        this.totalFlightHours = totalFlightHours;
    }

    public boolean getMaintenanceFlag() {
        return maintenanceFlag;
    }

    public void setMaintenanceFlag(boolean maintenanceFlag) {
        this.maintenanceFlag = maintenanceFlag;
    }

    public int getCurrentMaintenanceHours() {
        return currentMaintenanceHours;
    }

    public void setCurrentMaintenanceHours(int currentMaintenanceHours) {
        this.currentMaintenanceHours = currentMaintenanceHours;
    }

    public int getMaintenanceHoursThreshold() {
        return maintenanceHoursThreshold;
    }

    public void setMaintenanceHoursThreshold(int maintenanceHoursThreshold) {
        this.maintenanceHoursThreshold = maintenanceHoursThreshold;
    }

    public Date getEndOfServiceDate() {
        return endOfServiceDate;
    }

    public void setEndOfServiceDate(Date endOfServiceDate) {
        this.endOfServiceDate = endOfServiceDate;
    }

    @Override
    public String toString() {
        if (endOfServiceDate != null) {
            return "Aircraft{" + "tailNumber=" + tailNumber + ", aircraftType=" + aircraftType + ", stationID=" + stationID
                    + ", maxSpeed=" + maxSpeed + ", maxAltitude=" + maxAltitude
                    + ", totalFlightHours=" + totalFlightHours + ", maintenanceFlag=" + maintenanceFlag
                    + ", currentMaintenanceHours=" + currentMaintenanceHours + ", maintenanceHoursThreshold=" + maintenanceHoursThreshold + ", endOfServiceDate=" + endOfServiceDate + '}';
        }
        return "Aircraft{" + "tailNumber=" + tailNumber + ", aircraftType=" + aircraftType + ", stationID=" + stationID
                + ", maxSpeed=" + maxSpeed + ", maxAltitude=" + maxAltitude
                + ", totalFlightHours=" + totalFlightHours + ", maintenanceFlag=" + maintenanceFlag
                + ", currentMaintenanceHours=" + currentMaintenanceHours + ", maintenanceHoursThreshold=" + maintenanceHoursThreshold + '}';
    }

}
