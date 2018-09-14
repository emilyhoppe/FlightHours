/** **********
 *
 *      Class:         MainPanel.java
 *      Package:       view
 *      Date:          September, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: The MainPanel class extends JPanel.  This panel sits 
 *              on the Main Frame and uses the CardLayout layout manager.  Aircraft,
 *              Operations, and Maintenance panels are added to this layout as 
 *              cards, so they can be switched between to show the user different
 *              screens.
 *
 *
 *********** */
package view;

public class MainPanel extends javax.swing.JPanel {

    //Getter for aircraftView object used to pass data to view
    public AircraftView getAircraftView() {
        return aircraftView;
    }

    //Getter for maintenanceView object used to pass data to view
    public MaintenanceView getMaintenanceView() {
        return maintenanceView;
    }

    //Getter for operationsView object used to pass data to view
    public OperationsView getOperationsView() {
        return operationsView;
    }

    //Constructor
    public MainPanel() {
        initComponents();
    }

    //Initialize all Swing components and place them in the JPanel using CardLayout
    private void initComponents() {//GEN-BEGIN:initComponents

        aircraftView = new view.AircraftView();
        operationsView = new view.OperationsView();
        maintenanceView = new view.MaintenanceView();

        setLayout(new java.awt.CardLayout());
        add(aircraftView, "aircraftView");
        add(operationsView, "operationsView");
        add(maintenanceView, "maintenanceView");
    }//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.AircraftView aircraftView;
    private view.MaintenanceView maintenanceView;
    private view.OperationsView operationsView;
    // End of variables declaration//GEN-END:variables
}
