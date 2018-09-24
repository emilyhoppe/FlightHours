/** **********
 *
 *      Class:         Operation.java
 *      Package:       model
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: The Operation model class is used to represent an Operation
 *                  and includes all relevant constructors, getter methods and
 *                  setter methods.
 *
 *
 *********** */
package model;

import java.util.Date;

public class Operation {

    //Instance variables
    private int operationID;
    private int aircraftID;
    private int stationID;
    private int missionID;
    private String operationName;
    private Date operationStartDate;
    private Date operationEndDate;
    private int operationFlighHour;

    //Default constructor
    public Operation() {
    }

    //Constructor with Operation ID parameter
    public Operation(int operationID, int aircraftID, int stationID, int missionID,
            String operationName, Date operationStartDate, Date operationEndDate,
            int operationFlighHour) {
        this.operationID = operationID;
        this.aircraftID = aircraftID;
        this.stationID = stationID;
        this.missionID = missionID;
        this.operationName = operationName;
        this.operationStartDate = operationStartDate;
        this.operationEndDate = operationEndDate;
        this.operationFlighHour = operationFlighHour;
    }

    //Constructor without Operation ID parameter
    public Operation(int aircraftID, int stationID, int missionID,
            String operationName, Date operationStartDate, Date operationEndDate,
            int operationFlighHour) {
        this.aircraftID = aircraftID;
        this.stationID = stationID;
        this.missionID = missionID;
        this.operationName = operationName;
        this.operationStartDate = operationStartDate;
        this.operationEndDate = operationEndDate;
        this.operationFlighHour = operationFlighHour;
    }

    //Getters and Setters
    public int getOperationID() {
        return operationID;
    }

    public void setOperationID(int operationID) {
        this.operationID = operationID;
    }

    public int getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(int aircraftID) {
        this.aircraftID = aircraftID;
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public int getMissionID() {
        return missionID;
    }

    public void setMissionID(int missionID) {
        this.missionID = missionID;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public Date getOperationStartDate() {
        return operationStartDate;
    }

    public void setOperationStartDate(Date operationStartDate) {
        this.operationStartDate = operationStartDate;
    }

    public Date getOperationEndDate() {
        return operationEndDate;
    }

    public void setOperationEndDate(Date operationEndDate) {
        this.operationEndDate = operationEndDate;
    }

    public int getOperationFlightHour() {
        return operationFlighHour;
    }

    public void setOperationFlightHour(int operationFlighHour) {
        this.operationFlighHour = operationFlighHour;
    }

    @Override
    public String toString() {
        return "Operation{" + "operationID=" + operationID + ", aircraftID=" + aircraftID + ", stationID=" + stationID + ", missionID=" + missionID + ", operationName=" + operationName + ", operationStartDate=" + operationStartDate + ", operationEndDate=" + operationEndDate + ", operationFlighHour=" + operationFlighHour + '}';
    }

}
