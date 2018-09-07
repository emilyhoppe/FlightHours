/************
 *
 *      Class:         MainPanel.java
 *      Package:       view
 *      Date:          September, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description:
 *
 *
 ************/
package view;

public class MainPanel extends javax.swing.JPanel {

    public MainPanel() {
        initComponents();
    }

    private void initComponents() {//GEN-BEGIN:initComponents

        aircraftView = new view.AircraftView();
        operationsView = new view.OperationsView();
        maintenanceView = new view.MaintenanceView();

        setLayout(new java.awt.CardLayout());
        add(aircraftView, "aircraftView");
        add(operationsView, "operationsView");
        operationsView.getAccessibleContext().setAccessibleName("");

        add(maintenanceView, "maintenanceView");
        maintenanceView.getAccessibleContext().setAccessibleName("");
    }//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.AircraftView aircraftView;
    private view.MaintenanceView maintenanceView;
    private view.OperationsView operationsView;
    // End of variables declaration//GEN-END:variables
}
