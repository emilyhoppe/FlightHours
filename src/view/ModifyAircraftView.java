/** **********
 *
 *      Class:         ModifyAircraftView.java
 *      Package:       view
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: ModifyAircraftView is a GUI view class which extends JDialog.
 *              It provides text fields and combo boxes for the user to modify
 *              existing aircraft in the database.  When a user clicks the Modify 
 *              Aircraft button, the inputs will be validated and updated in 
 *              the database.
 *
 *
 *********** */
package view;

import controller.AircraftDAO;
import controller.StationDAO;
import flighthours.Station;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import temporary.TemporaryFunctions;

public class ModifyAircraftView extends javax.swing.JDialog {

    //Instance variables
    private String ID;
    private String tailNumber;
    private String type;
    private String station;
    private String maxSpeed;
    private String maxAltitude;
    private String currentMaintHours;
    private String maintHoursThreshold;
    private String endOfServiceDate;

    //Constructor with parameters
    public ModifyAircraftView(Frame parent, boolean modal, String ID, String tailNumber,
            String type, String station, String maxSpeed,
            String maxAltitude, String currentMaintHours, String maintHoursThreshold,
            String endOfServiceDate) {
        super(parent, modal);
        this.ID = ID;
        this.tailNumber = tailNumber;
        this.type = type;
        this.station = station;
        this.maxSpeed = maxSpeed;
        this.maxAltitude = maxAltitude;
        this.currentMaintHours = currentMaintHours;
        this.maintHoursThreshold = maintHoursThreshold;
        this.endOfServiceDate = endOfServiceDate;
        initComponents();
        //Make dialog appear in canter of parent frame
        setLocationRelativeTo(parent);
        //Set modify aircraft button to respond to enter key
        SwingUtilities.getRootPane(modifyAircraftButton).setDefaultButton(modifyAircraftButton);
    }

    //Initialize all Swing components and place them in the JDialog using GridBag layout
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        outerPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        dataPanel = new javax.swing.JPanel();
        tailNumberLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        stationLabel = new javax.swing.JLabel();
        maxSpeedLabel = new javax.swing.JLabel();
        maxAltitudeLabel = new javax.swing.JLabel();
        maintThresholdLabel = new javax.swing.JLabel();
        endOfServiceLabel = new javax.swing.JLabel();
        tailNumberTextField = new javax.swing.JTextField(tailNumber);
        typeComboBox = new javax.swing.JComboBox<>(controller.AircraftDAO.getAircraftTypeArray());
        int stationComboBoxIndex;
        controller.StationDAO stationDAO = new StationDAO();
        List<Station> stationArrayList = new ArrayList<>(stationDAO.selectStationByType("AMO"));
        //Find selected index to use for station combo box
        stationComboBoxIndex = -1;
        for(Station currentStation : stationArrayList){
            stationComboBoxIndex++;
            if(currentStation.getStationName().equals(station)){
                break;
            }
        }
        Station[] stationArray = stationArrayList.toArray(new Station[0]);
        stationComboBox = new javax.swing.JComboBox<>(stationArray);
        maxSpeedTextField = new javax.swing.JTextField(maxSpeed);
        maxAltitudeTextField = new javax.swing.JTextField(maxAltitude);
        maintThresholdTextField = new javax.swing.JTextField(maintHoursThreshold);
        endOfServiceTextField = new javax.swing.JTextField(endOfServiceDate);
        currentMaintHoursLabel = new javax.swing.JLabel();
        currentMaintHoursTextField = new javax.swing.JTextField(currentMaintHours);
        buttonPanel = new javax.swing.JPanel();
        modifyAircraftButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modify Aircraft");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        outerPanel.setLayout(new java.awt.GridBagLayout());

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleLabel.setText("Modify Aircraft");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        outerPanel.add(titleLabel, gridBagConstraints);

        dataPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dataPanel.setToolTipText("");
        dataPanel.setLayout(new java.awt.GridBagLayout());

        tailNumberLabel.setText("Tail Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        dataPanel.add(tailNumberLabel, gridBagConstraints);

        typeLabel.setText("Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        dataPanel.add(typeLabel, gridBagConstraints);

        stationLabel.setText("Station");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        dataPanel.add(stationLabel, gridBagConstraints);

        maxSpeedLabel.setText("Max Speed");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        dataPanel.add(maxSpeedLabel, gridBagConstraints);

        maxAltitudeLabel.setText("Max Altitude");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        dataPanel.add(maxAltitudeLabel, gridBagConstraints);

        maintThresholdLabel.setText("Maintenance Hours Threshold");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        dataPanel.add(maintThresholdLabel, gridBagConstraints);

        endOfServiceLabel.setText("End of Service Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        dataPanel.add(endOfServiceLabel, gridBagConstraints);

        tailNumberTextField.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        dataPanel.add(tailNumberTextField, gridBagConstraints);

        typeComboBox.setSelectedItem(type);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        dataPanel.add(typeComboBox, gridBagConstraints);

        stationComboBox.setSelectedIndex(stationComboBoxIndex);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        dataPanel.add(stationComboBox, gridBagConstraints);

        maxSpeedTextField.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        dataPanel.add(maxSpeedTextField, gridBagConstraints);

        maxAltitudeTextField.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        dataPanel.add(maxAltitudeTextField, gridBagConstraints);

        maintThresholdTextField.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        dataPanel.add(maintThresholdTextField, gridBagConstraints);

        endOfServiceTextField.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        dataPanel.add(endOfServiceTextField, gridBagConstraints);

        currentMaintHoursLabel.setText("Current Maintenance Hours");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        dataPanel.add(currentMaintHoursLabel, gridBagConstraints);

        currentMaintHoursTextField.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        dataPanel.add(currentMaintHoursTextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 15, 0);
        outerPanel.add(dataPanel, gridBagConstraints);

        buttonPanel.setLayout(new java.awt.GridBagLayout());

        modifyAircraftButton.setText("Modify Aircraft");
        modifyAircraftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyAircraftButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        buttonPanel.add(modifyAircraftButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        buttonPanel.add(cancelButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        outerPanel.add(buttonPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 30, 30);
        getContentPane().add(outerPanel, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }//GEN-END:initComponents

    private void modifyAircraftButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_modifyAircraftButtonActionPerformed
        //Validate user input
        boolean isValid = true;
        if (!util.InputValidator.isAlphaNumeric(tailNumberTextField.getText())) {
            isValid = false;
            JOptionPane.showMessageDialog(outerPanel, "Tail Number is invalid",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (!util.InputValidator.isPositiveNumber(maxSpeedTextField.getText())) {
            isValid = false;
            JOptionPane.showMessageDialog(outerPanel, "Max Speed is invalid",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (!util.InputValidator.isPositiveNumber(maxAltitudeTextField.getText())) {
            isValid = false;
            JOptionPane.showMessageDialog(outerPanel, "Max Altitude is invalid",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (!util.InputValidator.isPositiveNumber(currentMaintHoursTextField.getText())) {
            isValid = false;
            JOptionPane.showMessageDialog(outerPanel, "Current Maintenance Hours is invalid",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else if (!util.InputValidator.isPositiveNumber(maintThresholdTextField.getText())) {
            isValid = false;
            JOptionPane.showMessageDialog(outerPanel, "Maintenance Threshold is invalid",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            //This date field can be empty, if so, skip date validation
        } else if (!endOfServiceTextField.getText().equals("")) {
            if (!util.InputValidator.isValidDate(endOfServiceTextField.getText())) {
                isValid = false;
                JOptionPane.showMessageDialog(outerPanel, 
                        "End of Service Date is invalid\n" +
                        "Please use format MM/DD/YYYY\n" + 
                        "or leave field empty",
                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }
        //Run only if all user inputs are valid
        if (isValid) {
            //TODO Call SQL function
            //TODO Validate that tail number does not already exist in DATABASE only if it 
            //  is being changed, (first check to see if it matches what is already in 
            //  the table, then there is no need to validate)
            //TODO Temporarily show message box with values
            JOptionPane.showMessageDialog(outerPanel,
                    "Modifying Aircraft Database values for aircraft ID: " + ID + "\n"
                    + "Tail Number: " + tailNumberTextField.getText() + "\n"
                    + "Type: " + typeComboBox.getSelectedItem() + "\n"
                    + "Station: " + stationComboBox.getSelectedItem() + "\n"
                    + "Max Speed: " + maxSpeedTextField.getText() + "\n"
                    + "Max Altitude: " + maxAltitudeTextField.getText() + "\n"
                    + "Current Maintenance Hours: " + currentMaintHoursTextField.getText() + "\n"
                    + "Maintenance Threshold: " + maintThresholdTextField.getText() + "\n"
                    + "End of Service Date: " + endOfServiceTextField.getText(),
                    "Notice", JOptionPane.PLAIN_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_modifyAircraftButtonActionPerformed

    private void cancelButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        //Cancel modifying aircraft and close window
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel currentMaintHoursLabel;
    private javax.swing.JTextField currentMaintHoursTextField;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JLabel endOfServiceLabel;
    private javax.swing.JTextField endOfServiceTextField;
    private javax.swing.JLabel maintThresholdLabel;
    private javax.swing.JTextField maintThresholdTextField;
    private javax.swing.JLabel maxAltitudeLabel;
    private javax.swing.JTextField maxAltitudeTextField;
    private javax.swing.JLabel maxSpeedLabel;
    private javax.swing.JTextField maxSpeedTextField;
    private javax.swing.JButton modifyAircraftButton;
    private javax.swing.JPanel outerPanel;
    /*TODO REMOVE THIS LINE
    private javax.swing.JComboBox<String> stationComboBox;
    */
    private javax.swing.JComboBox stationComboBox;
    private javax.swing.JLabel stationLabel;
    private javax.swing.JLabel tailNumberLabel;
    private javax.swing.JTextField tailNumberTextField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JComboBox<String> typeComboBox;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
