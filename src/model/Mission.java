/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Mission {
    
    private int missionID;
    private String missionName;

    public Mission() {
    }

    public Mission(int missionID, String missionName) {
        this.missionID = missionID;
        this.missionName = missionName;
    }

    public int getMissionID() {
        return missionID;
    }

    public void setMissionID(int missionID) {
        this.missionID = missionID;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    @Override
    //Used for populating JComboBoxes
    public String toString() {
        return missionName;
    }
    
    
    
}
