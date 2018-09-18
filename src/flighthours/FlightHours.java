/** **********
 *
 *      Class:         FlightHours.java
 *      Package:       flighthours
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: FlightHours contains the main method of the FHS
 *              application.  It first creates the database and tables and loads
 *              the tables with sample data.  It then starts the GUI using the
 *              SwingUtilities.invokeLater method which prevents any visible lag
 *              in the GUI when background tasks are processing.
 *
 *
 *********** */
package flighthours;

import javax.swing.SwingUtilities;
import view.MainFrame;

public class FlightHours {

    public static void main(String[] args) {
        // TODO code application logic here, etc, etc
        System.out.println("Hello Team!");
        System.out.println("Welcome to CMSC495 FlightHours on GitHub!");

        //Create tables and load with sample data
        util.CreateStationsTable.createTable();
        util.CreateMissionsTable.createTable();
        util.CreateAircraftTable.createTable();
        util.CreateOperationsTable.createTable();
        util.CreateMissionsTable.createTable();

        //Start GUI, this is needed to avoid unresponsive GUI on slow tasks
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    //Create applicaiton frame and set it to visible
    private static void createAndShowGUI() {
        MainFrame mainView = new MainFrame();
        mainView.setVisible(true);
    }

}
