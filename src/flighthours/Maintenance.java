/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthours;

import java.util.Date;

public class Maintenance {
    
    private int maintenanceID;
    private int aircraftID;
    private Date startDate;
    private Date endDate;
    private String maintDescr;

    public Maintenance(int maintenanceID, int aircraftID, Date startDate, Date endDate, String maintDesce) {
        this.maintenanceID = maintenanceID;
        this.aircraftID = aircraftID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maintDescr = maintDesce;
    }
    
    public Maintenance(int aircraftID, Date startDate, Date endDate, String maintDesce) {
        this.aircraftID = aircraftID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maintDescr = maintDesce;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getMaintDescr() {
        return maintDescr;
    }

    public void setMaintDescr(String maintDescr) {
        this.maintDescr = maintDescr;
    }

    @Override
    public String toString() {
        return "Maintenance{" + "maintenanceID=" + maintenanceID + ", aircraftID=" + aircraftID + ", startDate=" + startDate + ", endDate=" + endDate + ", maintDescr=" + maintDescr + '}';
    }
    
    
    
}
