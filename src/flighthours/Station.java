package flighthours;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tamerjj1
 */
public class Station {
    
    private int stationID;
    private String stationName;
    private String stationType;

    public Station(int stationID, String stationName, String stationType) {
        this.stationID = stationID;
        this.stationName = stationName;
        this.stationType = stationType;
    }

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
    public String toString() {
        return "Station{" + "stationID=" + stationID + ", stationName=" + stationName + ", stationType=" + stationType + '}';
    }
    
    
    
}
