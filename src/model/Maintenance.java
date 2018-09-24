/** **********
 *
 *      Class:         Maintenance.java
 *      Package:       model
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: The Maintenance model class is used to represent a Maintenance
 *                  event and includes all relevant constructors, getter methods and 
 *                  setter methods.
 *
 *
 *********** */
package model;

import java.util.Date;

public class Maintenance {
    
    //Instance variables
    private int maintenanceID;
    private int aircraftID;
    private Date startDate;
    private Date endDate;
    private boolean resetMaintenance;
    private String maintDescr;

    //Constructor with maintenance ID parameter 
    public Maintenance(int maintenanceID, int aircraftID, Date startDate, Date endDate, String maintDesce) {
        this.maintenanceID = maintenanceID;
        this.aircraftID = aircraftID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maintDescr = maintDesce;
    }
    
   //Constructor without maintenance ID parameter
    public Maintenance(int aircraftID, Date startDate, Date endDate, String maintDesce) {
        this.aircraftID = aircraftID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maintDescr = maintDesce;
    }

    //Constructor without maintenance ID parameter and with resetMaintenance parameter
    public Maintenance(int aircraftID, Date startDate, Date endDate, boolean resetMaintenance, String maintDesce) {
        this.aircraftID = aircraftID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.resetMaintenance = resetMaintenance;
        this.maintDescr = maintDesce;
    }

    //Default construtor
    public Maintenance() {
    }

    //Getters and Setters
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
    
    public boolean getResetMaintenance() {
        return resetMaintenance;
    }
    
    public void setResetMaintenance(boolean resetMaintenance) {
        this.resetMaintenance = resetMaintenance;
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
