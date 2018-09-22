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
import flighthours.Aircraft;
import flighthours.Station;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

public class ModifyAircraftView extends javax.swing.JDialog {

    //Instance variables
    private final Frame parent;
    private final String aircraftID;
    private final String tailNumber;
    private final String type;
    private final String stationString;
    private final String maxSpeed;
    private final String maxAltitude;
    private final String totalFlightHours;
    private final String currentMaintHours;
    private final String maintHoursThreshold;
    private final String endOfServiceDate;
    private JPanel buttonPanel;
    private JButton cancelButton;
    private JLabel currentMaintHoursLabel;
    private JTextField currentMaintHoursTextField;
    private JPanel dataPanel;
    private JLabel endOfServiceLabel;
    private JTextField endOfServiceTextField;
    private JLabel maintThresholdLabel;
    private JTextField maintThresholdTextField;
    private JLabel maxAltitudeLabel;
    private JTextField maxAltitudeTextField;
    private JLabel maxSpeedLabel;
    private JTextField maxSpeedTextField;
    private JButton modifyAircraftButton;
    private JPanel outerPanel;
    private JComboBox stationComboBox;
    private JLabel stationLabel;
    private JLabel tailNumberLabel;
    private JTextField tailNumberTextField;
    private JLabel titleLabel;
    private JLabel totalFlightHoursLabel;
    private JTextField totalFlightHoursTextField;
    private JComboBox<String> typeComboBox;
    private JLabel typeLabel;

    //Constructor with parameters
    public ModifyAircraftView(Frame parent, boolean modal, String aircraftID, String tailNumber,
            String type, String stationString, String maxSpeed,
            String maxAltitude, String totalFlightHours, String currentMaintHours,
            String maintHoursThreshold, String endOfServiceDate) {
        super(parent, modal);
        this.parent = parent;
        this.aircraftID = aircraftID;
        this.tailNumber = tailNumber;
        this.type = type;
        this.stationString = stationString;
        this.maxSpeed = maxSpeed;
        this.maxAltitude = maxAltitude;
        this.totalFlightHours = totalFlightHours;
        this.currentMaintHours = currentMaintHours;
        this.maintHoursThreshold = maintHoursThreshold;
        this.endOfServiceDate = endOfServiceDate;
        initComponents();
        //Set modify aircraft button to respond to enter key
        SwingUtilities.getRootPane(modifyAircraftButton).setDefaultButton(modifyAircraftButton);
    }

    //Initialize all Swing components and place them in the JDialog using GridBag layout
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        outerPanel = new JPanel();
        titleLabel = new JLabel();
        dataPanel = new JPanel();
        tailNumberLabel = new JLabel();
        typeLabel = new JLabel();
        stationLabel = new JLabel();
        maxSpeedLabel = new JLabel();
        maxAltitudeLabel = new JLabel();
        currentMaintHoursLabel = new JLabel();
        maintThresholdLabel = new JLabel();
        endOfServiceLabel = new JLabel();
        tailNumberTextField = new JTextField(tailNumber);
        typeComboBox = new JComboBox<>(AircraftDAO.getAircraftTypeArray());
        int stationComboBoxIndex;
        StationDAO stationDAO = new StationDAO();
        List<Station> stationArrayList = new ArrayList<>(stationDAO.selectStationByType("AMO"));
        //Find selected index to use for station combo box
        stationComboBoxIndex = -1;
        for (Station currentStation : stationArrayList) {
            stationComboBoxIndex++;
            if (currentStation.getStationName().equals(stationString)) {
                break;
            }
        }
        Station[] stationArray = stationArrayList.toArray(new Station[0]);
        stationComboBox = new JComboBox<>(stationArray);
        maxSpeedTextField = new JTextField(maxSpeed);
        maxAltitudeTextField = new JTextField(maxAltitude);
        totalFlightHoursTextField = new JTextField(totalFlightHours);
        maintThresholdTextField = new JTextField(maintHoursThreshold);
        endOfServiceTextField = new JTextField(endOfServiceDate);
        currentMaintHoursTextField = new JTextField(currentMaintHours);
        totalFlightHoursLabel = new JLabel();
        buttonPanel = new JPanel();
        modifyAircraftButton = new JButton();
        cancelButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modify Aircraft");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new GridBagLayout());

        outerPanel.setLayout(new GridBagLayout());

        titleLabel.setFont(new Font("Tahoma", 1, 18));
        titleLabel.setText("Modify Aircraft");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        outerPanel.add(titleLabel, gridBagConstraints);

        dataPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        dataPanel.setToolTipText("");
        dataPanel.setLayout(new GridBagLayout());

        tailNumberLabel.setText("Tail Number");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(tailNumberLabel, gridBagConstraints);

        typeLabel.setText("Type");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(typeLabel, gridBagConstraints);

        stationLabel.setText("AMO Station");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(stationLabel, gridBagConstraints);

        maxSpeedLabel.setText("Max Speed");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(maxSpeedLabel, gridBagConstraints);

        maxAltitudeLabel.setText("Max Altitude");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(maxAltitudeLabel, gridBagConstraints);

        currentMaintHoursLabel.setText("Current Maintenance Hours");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(currentMaintHoursLabel, gridBagConstraints);

        maintThresholdLabel.setText("Maintenance Hours Threshold");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(maintThresholdLabel, gridBagConstraints);

        endOfServiceLabel.setText("End of Service Date");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(endOfServiceLabel, gridBagConstraints);

        tailNumberTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(tailNumberTextField, gridBagConstraints);

        typeComboBox.setSelectedItem(type);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(typeComboBox, gridBagConstraints);

        stationComboBox.setSelectedIndex(stationComboBoxIndex);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(stationComboBox, gridBagConstraints);

        maxSpeedTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(maxSpeedTextField, gridBagConstraints);

        maxAltitudeTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(maxAltitudeTextField, gridBagConstraints);

        totalFlightHoursTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(totalFlightHoursTextField, gridBagConstraints);

        maintThresholdTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(maintThresholdTextField, gridBagConstraints);

        endOfServiceTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(endOfServiceTextField, gridBagConstraints);

        currentMaintHoursTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(currentMaintHoursTextField, gridBagConstraints);

        totalFlightHoursLabel.setText("Total Flight Hours");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(totalFlightHoursLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new Insets(15, 0, 15, 0);
        outerPanel.add(dataPanel, gridBagConstraints);

        buttonPanel.setLayout(new GridBagLayout());

        modifyAircraftButton.setText("Modify Aircraft");
        modifyAircraftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                modifyAircraftButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        buttonPanel.add(modifyAircraftButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        buttonPanel.add(cancelButton, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        outerPanel.add(buttonPanel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(30, 30, 30, 30);
        getContentPane().add(outerPanel, gridBagConstraints);

        pack();
        //Make dialog appear in canter of parent frame
        setLocationRelativeTo(parent);
    }

    private void modifyAircraftButtonActionPerformed(ActionEvent evt) {
        //Method Variables
        SimpleDateFormat simpleDateFormat;
        Aircraft aircraft;
        int aircraftIdInt;
        String newTailNumber = "";
        String newAircraftType = "";
        Station newStation;
        int newStationID;
        int newMaxSpeed;
        int newMaxAltitude;
        int newTotalFlightHours;
        int newCurrentMaintenanceHours;
        int newMaintenanceThreshold;
        Date newEndOfServiceDate = null;

        //Validate user input
        if (!util.InputValidator.isAlphaNumeric10(tailNumberTextField.getText())) {
            JOptionPane.showMessageDialog(outerPanel, "Tail Number is invalid",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!util.InputValidator.isPositiveNumber(maxSpeedTextField.getText())) {
            JOptionPane.showMessageDialog(outerPanel, "Max Speed is invalid",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!util.InputValidator.isPositiveNumber(maxAltitudeTextField.getText())) {
            JOptionPane.showMessageDialog(outerPanel, "Max Altitude is invalid",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!util.InputValidator.isPositiveNumber(totalFlightHoursTextField.getText())) {
            JOptionPane.showMessageDialog(outerPanel, "Total Flight Hours input is invalid",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!util.InputValidator.isPositiveNumber(currentMaintHoursTextField.getText())) {
            JOptionPane.showMessageDialog(outerPanel, "Current Maintenance Hours is invalid",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!util.InputValidator.isPositiveNumber(maintThresholdTextField.getText())) {
            JOptionPane.showMessageDialog(outerPanel, "Maintenance Threshold is invalid",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //This date field can be empty, if so, skip date validation
        if (!endOfServiceTextField.getText().equals("")) {
            if (!util.InputValidator.isValidDate(endOfServiceTextField.getText())) {
                JOptionPane.showMessageDialog(outerPanel,
                        "End of Service Date is invalid\n"
                        + "Please use format MM/DD/YYYY\n"
                        + "or leave field empty",
                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        //If user changed tail number text field, check if new tail number is already in database
        AircraftDAO aircraftDAO = new AircraftDAO();
        if (!tailNumber.equals(tailNumberTextField.getText().toUpperCase())) {
            if (aircraftDAO.tailNumberExists(tailNumberTextField.getText().toUpperCase())) {
                JOptionPane.showMessageDialog(outerPanel, "Tail Number already exists in database",
                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        //Retrieve validated user input
        aircraftIdInt = Integer.parseInt(aircraftID);
        newTailNumber = tailNumberTextField.getText().toUpperCase();
        newAircraftType = typeComboBox.getSelectedItem().toString();
        newStation = (Station) stationComboBox.getSelectedItem();
        newStationID = newStation.getStationID();
        newMaxSpeed = Integer.parseInt(maxSpeedTextField.getText());
        newMaxAltitude = Integer.parseInt(maxAltitudeTextField.getText());
        newTotalFlightHours = Integer.parseInt(totalFlightHoursTextField.getText());
        newCurrentMaintenanceHours = Integer.parseInt(currentMaintHoursTextField.getText());
        newMaintenanceThreshold = Integer.parseInt(maintThresholdTextField.getText());
        //Parse user entered date into Date object
        simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            newEndOfServiceDate = simpleDateFormat.parse(endOfServiceTextField.getText());
        } catch (ParseException ex) {
            //Dates are already validated, no exception expected
        }

        //Create new aircraft instance
        aircraft = new Aircraft(aircraftIdInt, newTailNumber, newAircraftType, newStationID,
                newMaxSpeed, newMaxAltitude, newTotalFlightHours,
                newCurrentMaintenanceHours, newMaintenanceThreshold,
                newEndOfServiceDate);

        //Insert maintenance instance into database by calling DAO object
        aircraftDAO = new AircraftDAO();
        int success = aircraftDAO.modifyAircraft(aircraft);
        //Give user feedback
        if (success != 1) {
            JOptionPane.showMessageDialog(outerPanel,
                    "Failed to modify aircraft",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        //Close window
        dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        //Cancel modifying aircraft and close window
        dispose();
    }
}
