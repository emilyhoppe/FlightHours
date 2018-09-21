/** **********
 *
 *      Class:         AddAircraftView.java
 *      Package:       view
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: AddAircraftView is a GUI view class which extends JDialog.
 *              It provides text fields and combo boxes for the user to add a new
 *              aircraft to the database.  When a user clicks the Add
 *              Aircraft button, the inputs will be validated and inserted in
 *              the database.
 *
 *
 *********** */
package view;

import flighthours.Aircraft;
import controller.AircraftDAO;
import controller.StationDAO;
import flighthours.Station;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import util.InputValidator;

public class AddAircraftView extends javax.swing.JDialog {

    //Instance variables
    private Aircraft aircraft;
    private String tailNumber;
    private String aircraftType;
    private Station station;
    private int stationID;
    private int maxSpeed;
    private int maxAltitude;
    private int totalFlightHours;
    private boolean maintenanceFlag;
    private int currentMaintenanceHours;
    private int maintenanceThreshold;

    //Constructor
    public AddAircraftView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Make dialog appear in canter of parent frame
        setLocationRelativeTo(parent);
        //Set add aircraft button to respond to enter key
        SwingUtilities.getRootPane(addAircraftButton).setDefaultButton(addAircraftButton);
    }

    //Initialize all Swing components and place them in the JDialog using GridBag layout
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        outerPanel = new JPanel();
        titleLabel = new JLabel();
        innerMiddlePanel = new JPanel();
        tailNumberLabel = new JLabel();
        typeLabel = new JLabel();
        stationLabel = new JLabel();
        maxSpeedLabel = new JLabel();
        maxAltitudeLabel = new JLabel();
        maintThresholdLabel = new JLabel();
        tailNumberTextField = new JTextField();
        typeComboBox = new JComboBox<>(AircraftDAO.getAircraftTypeArray());
        StationDAO stationDAO = new StationDAO();
        stationComboBox = new JComboBox<>(stationDAO.selectStationByType("AMO").toArray());
        maxSpeedTextField = new JTextField();
        maxAltitudeTextField = new JTextField();
        maintThresholdTextField = new JTextField();
        innerBottomPanel = new JPanel();
        addAircraftButton = new JButton();
        cancelButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Aircraft");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new GridBagLayout());

        outerPanel.setLayout(new GridBagLayout());

        titleLabel.setFont(new Font("Tahoma", 1, 18)); 
        titleLabel.setText("Add Aircraft");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        outerPanel.add(titleLabel, gridBagConstraints);

        innerMiddlePanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        innerMiddlePanel.setToolTipText("");
        innerMiddlePanel.setLayout(new GridBagLayout());

        tailNumberLabel.setText("Tail Number");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(tailNumberLabel, gridBagConstraints);

        typeLabel.setText("Type");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(typeLabel, gridBagConstraints);

        stationLabel.setText("AMO Station");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(stationLabel, gridBagConstraints);

        maxSpeedLabel.setText("Max Speed");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(maxSpeedLabel, gridBagConstraints);

        maxAltitudeLabel.setText("Max Altitude");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(maxAltitudeLabel, gridBagConstraints);

        maintThresholdLabel.setText("Maintenance Hours Threshold");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(maintThresholdLabel, gridBagConstraints);

        tailNumberTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(tailNumberTextField, gridBagConstraints);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(typeComboBox, gridBagConstraints);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(stationComboBox, gridBagConstraints);

        maxSpeedTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(maxSpeedTextField, gridBagConstraints);

        maxAltitudeTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(maxAltitudeTextField, gridBagConstraints);

        maintThresholdTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(maintThresholdTextField, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new Insets(15, 0, 15, 0);
        outerPanel.add(innerMiddlePanel, gridBagConstraints);

        innerBottomPanel.setLayout(new GridBagLayout());

        addAircraftButton.setText("Add Aircraft");
        addAircraftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addAircraftButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerBottomPanel.add(addAircraftButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerBottomPanel.add(cancelButton, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        outerPanel.add(innerBottomPanel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(30, 30, 30, 30);
        getContentPane().add(outerPanel, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }

    private void addAircraftButtonActionPerformed(ActionEvent evt) {
        //Validate all user input
        if (!InputValidator.isAlphaNumeric10(tailNumberTextField.getText())) {
            JOptionPane.showMessageDialog(outerPanel, "Tail Number is invalid",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!InputValidator.isPositiveNumber(maxSpeedTextField.getText())) {
            JOptionPane.showMessageDialog(outerPanel, "Max Speed is invalid",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!InputValidator.isPositiveNumber(maxAltitudeTextField.getText())) {
            JOptionPane.showMessageDialog(outerPanel, "Max Altitude is invalid",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!InputValidator.isPositiveNumber(maintThresholdTextField.getText())) {
            JOptionPane.showMessageDialog(outerPanel, "Maintenance Threshold is invalid",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Validate that tail number is not already in database, it must be unique
        AircraftDAO aircraftDAO = new AircraftDAO();
        if (aircraftDAO.tailNumberExists(tailNumberTextField.getText().toUpperCase())) {
            JOptionPane.showMessageDialog(outerPanel, "Tail Number already exists in database",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Retrieve validated user input
        tailNumber = tailNumberTextField.getText().toUpperCase();
        aircraftType = typeComboBox.getSelectedItem().toString();
        station = (Station) stationComboBox.getSelectedItem();
        stationID = station.getStationID();
        maxSpeed = Integer.parseInt(maxSpeedTextField.getText());
        maxAltitude = Integer.parseInt(maxAltitudeTextField.getText());
        totalFlightHours = 0; //Set to 0, this is a new aircraft
        maintenanceFlag = false; //Set to false, this is a new aircraft
        currentMaintenanceHours = 0; //Set to 0, this is a new aircraft
        maintenanceThreshold = Integer.parseInt(maintThresholdTextField.getText());

        //Instantiate new aircraft object
        aircraft = new Aircraft(tailNumber,
                aircraftType,
                stationID,
                maxSpeed,
                maxAltitude,
                totalFlightHours,
                maintenanceFlag,
                currentMaintenanceHours,
                maintenanceThreshold);

        //Insert aircraft into database by calling DAO object
        int success = aircraftDAO.insertNewAircraft(aircraft);
        if (success == 1) {
            JOptionPane.showMessageDialog(outerPanel,
                    "Aircraft added successfully",
                    "Succes", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(outerPanel,
                    "Failed to add aircraft",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Close the window
        dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        //Cancel adding aircraft and close window
        dispose();
    }

    // Variables declaration - do not modify
    private JButton addAircraftButton;
    private JButton cancelButton;
    private JPanel innerBottomPanel;
    private JPanel innerMiddlePanel;
    private JLabel maintThresholdLabel;
    private JTextField maintThresholdTextField;
    private JLabel maxAltitudeLabel;
    private JTextField maxAltitudeTextField;
    private JLabel maxSpeedLabel;
    private JTextField maxSpeedTextField;
    private JPanel outerPanel;
    /*TODO REMOVE THIS LINE
    private javax.swing.JComboBox<String> stationComboBox;
    */
    private JComboBox stationComboBox;
    private JLabel stationLabel;
    private JLabel tailNumberLabel;
    private JTextField tailNumberTextField;
    private JLabel titleLabel;
    private JComboBox<String> typeComboBox;
    private JLabel typeLabel;
    // End of variables declaration
}
