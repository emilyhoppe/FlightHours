/** **********
 *
 *      Class:         Mission.java
 *      Package:       model
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: The Mission model class is used to represent a Mission
 *                  and includes all relevant constructors, getter methods and 
 *                  setter methods.
 *
 *
 *********** */
package model;

public class Mission {
    
    //Instance variables
    private int missionID;
    private String missionName;

    //Default constructor
    public Mission() {
    }

    //Parameterized constructor
    public Mission(int missionID, String missionName) {
        this.missionID = missionID;
        this.missionName = missionName;
    }

    //Getters and Setters
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
