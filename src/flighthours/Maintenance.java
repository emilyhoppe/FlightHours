/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthours;

public class Maintenance {
    
    private int maintenanceID;
    private int aircraftID;
    private int startDate;
    private int endDate;
    private String maintDesce;

    public Maintenance(int maintenanceID, int aircraftID, int startDate, int endDate, String maintDesce) {
        this.maintenanceID = maintenanceID;
        this.aircraftID = aircraftID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maintDesce = maintDesce;
    }

    public Maintenance() {
    }

    public int getMaintenanceID() {
        return maintenanceID;
    }

    public void setMaintenanceID(int maintenanceID) {
        this.maintenanceID = maintenanceID;
    }

    public int getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(int aircraftID) {
        this.aircraftID = aircraftID;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public String getMaintDesce() {
        return maintDesce;
    }

    public void setMaintDesce(String maintDesce) {
        this.maintDesce = maintDesce;
    }

    @Override
    public String toString() {
        return "Maintenance{" + "maintenanceID=" + maintenanceID + ", aircraftID=" + aircraftID + ", startDate=" + startDate + ", endDate=" + endDate + ", maintDesce=" + maintDesce + '}';
    }
    
    
    
}
