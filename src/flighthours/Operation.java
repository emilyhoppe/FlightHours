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
public class Operation {
    private int operationID;
    private int aircraftID;
    private int stationID;
    private int missionID;
    private String operationName;
    private int operationStartDate;
    private int operationEndDate;
    private int operationFlighHour;

    public Operation() {
    }

    public Operation(int operationID, int aircraftID, int stationID, int missionID, String operationName, int operationStartDate, int operationEndDate, int operationFlighHour) {
        this.operationID = operationID;
        this.aircraftID = aircraftID;
        this.stationID = stationID;
        this.missionID = missionID;
        this.operationName = operationName;
        this.operationStartDate = operationStartDate;
        this.operationEndDate = operationEndDate;
        this.operationFlighHour = operationFlighHour;
    }

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

    public int getOperationStartDate() {
        return operationStartDate;
    }

    public void setOperationStartDate(int operationStartDate) {
        this.operationStartDate = operationStartDate;
    }

    public int getOperationEndDate() {
        return operationEndDate;
    }

    public void setOperationEndDate(int operationEndDate) {
        this.operationEndDate = operationEndDate;
    }

    public int getOperationFlighHour() {
        return operationFlighHour;
    }

    public void setOperationFlighHour(int operationFlighHour) {
        this.operationFlighHour = operationFlighHour;
    }

    @Override
    public String toString() {
        return "Operation{" + "operationID=" + operationID + ", aircraftID=" + aircraftID + ", stationID=" + stationID + ", missionID=" + missionID + ", operationName=" + operationName + ", operationStartDate=" + operationStartDate + ", operationEndDate=" + operationEndDate + ", operationFlighHour=" + operationFlighHour + '}';
    }
    
    
}
