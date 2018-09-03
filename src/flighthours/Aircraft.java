package flighthours;

import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ehoppe
 */
public class Aircraft {
    
    private String tailNumber;
    private String aircraftType;
    private int stationID;
    private String primaryMission;
    private int maxSpeed;
    private int maxAltitude;  
    private int totalFlightHours;
    private boolean maintenanceFlag;
    private int currentMaintenanceHours;
    private int maintenanceHoursThreshold;
    private Date endOfServiceDate;
    
    public Aircraft(String tailNumber, String aircraftType, int stationID, String primaryMission, 
            int maxSpeed, int maxAltitude, int totalFlightHours, boolean maintenanceFlag, int currentMaintenanceHours,
            int maintenanceHoursThreshold) {
        this.tailNumber = tailNumber;
        this.aircraftType = aircraftType;
        this.stationID = stationID;
        this.primaryMission = primaryMission;
        this.maxSpeed = maxSpeed;
        this.maxAltitude = maxAltitude;
        this.totalFlightHours = totalFlightHours;
        this.maintenanceFlag = maintenanceFlag;
        this.currentMaintenanceHours = currentMaintenanceHours;
        this.maintenanceHoursThreshold = maintenanceHoursThreshold;
    }
    
    public Aircraft(Scanner scanner){
        if (scanner.hasNext()) tailNumber = scanner.next();
        if (scanner.hasNext()) aircraftType = scanner.next();
        if (scanner.hasNextInt()) stationID = scanner.nextInt();
        if (scanner.hasNext()) primaryMission = scanner.next();
        if (scanner.hasNextInt()) maxSpeed = scanner.nextInt();
        if (scanner.hasNextInt()) maxAltitude = scanner.nextInt();
        if (scanner.hasNextInt()) totalFlightHours = scanner.nextInt();
        if (scanner.hasNextBoolean()) maintenanceFlag = scanner.nextBoolean();
        if (scanner.hasNextInt()) currentMaintenanceHours = scanner.nextInt();
        if (scanner.hasNextInt()) maintenanceHoursThreshold = scanner.nextInt();
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

    public String getPrimaryMission() {
        return primaryMission;
    }

    public void setPrimaryMission(String primaryMission) {
        this.primaryMission = primaryMission;
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
    
    @Override
    public String toString() {
        return "Aircraft{" + "tailNumber=" + tailNumber + ", aircraftType=" + aircraftType + ", stationID=" + stationID + 
                ", primaryMission=" + primaryMission + ", maxSpeed=" + maxSpeed + ", maxAltitude=" + maxAltitude + 
                ", totalFlightHours=" + totalFlightHours + ", maintenanceFlag=" + maintenanceFlag + 
                ", currentMaintenanceHours=" + currentMaintenanceHours + ", maintenanceHoursThreshold=" + maintenanceHoursThreshold + '}';
    }
    
}
