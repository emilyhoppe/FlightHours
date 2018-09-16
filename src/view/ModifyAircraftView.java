/** **********
 *
 *      Class:         ModifyAircraftView.java
 *      Package:       view
 *      Date:          September, 2018
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

import java.awt.Font;
import java.awt.Frame;
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
import temporary.TemporaryFunctions;

public class ModifyAircraftView extends javax.swing.JDialog {

    //Instance variables
    private String ID;
    private String tailNumber;
    private String type;
    private String location;
    private String maxSpeed;
    private String maxAltitude;
    private String currentMaintHours;
    private String maintHoursThreshold;
    private String endOfServiceDate;

    //Constructor with parameters
    public ModifyAircraftView(Frame owner, boolean modal, String ID, String tailNumber,
            String type, String location, String maxSpeed,
            String maxAltitude, String currentMaintHours, String maintHoursThreshold,
            String endOfServiceDate) {
        super(owner, modal);
        this.ID = ID;
        this.tailNumber = tailNumber;
        this.type = type;
        this.location = location;
        this.maxSpeed = maxSpeed;
        this.maxAltitude = maxAltitude;
        this.currentMaintHours = currentMaintHours;
        this.maintHoursThreshold = maintHoursThreshold;
        this.endOfServiceDate = endOfServiceDate;
        initComponents();
        //Set modify aircraft button to respond to enter key
        SwingUtilities.getRootPane(modifyAircraftButton).setDefaultButton(modifyAircraftButton);
    }

    //Initialize all Swing components and place them in the JDialog using GridBag layout
    private void initComponents() {//GEN-BEGIN:initComponents
        GridBagConstraints gridBagConstraints;

        outerPanel = new JPanel();
        titleLabel = new JLabel();
        dataPanel = new JPanel();
        tailNumberLabel = new JLabel();
        typeLabel = new JLabel();
        locationLabel = new JLabel();
        maxSpeedLabel = new JLabel();
        maxAltitudeLabel = new JLabel();
        maintThresholdLabel = new JLabel();
        endOfServiceLabel = new JLabel();
        tailNumberTextField = new JTextField(tailNumber);
        typeComboBox = new JComboBox<>(TemporaryFunctions.getAircraftTypeArray());
        locationComboBox = new JComboBox<>(TemporaryFunctions.getLocationArray());
        maxSpeedTextField = new JTextField(maxSpeed);
        maxAltitudeTextField = new JTextField(maxAltitude);
        maintThresholdTextField = new JTextField(maintHoursThreshold);
        endOfServiceTextField = new JTextField(endOfServiceDate);
        currentMaintHoursLabel = new JLabel();
        currentMaintHoursTextField = new JTextField(currentMaintHours);
        buttonPanel = new JPanel();
        modifyAircraftButton = new JButton();
        cancelButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modify Aircraft");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new GridBagLayout());

        outerPanel.setLayout(new GridBagLayout());

        titleLabel.setFont(new Font("Tahoma", 1, 18)); // NOI18N
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

        locationLabel.setText("Location");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(locationLabel, gridBagConstraints);

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

        maintThresholdLabel.setText("Maintenance Hours Threshold");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(maintThresholdLabel, gridBagConstraints);

        endOfServiceLabel.setText("End of Service Date");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
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

        locationComboBox.setSelectedItem(location);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(locationComboBox, gridBagConstraints);

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

        maintThresholdTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(maintThresholdTextField, gridBagConstraints);

        endOfServiceTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(endOfServiceTextField, gridBagConstraints);

        currentMaintHoursLabel.setText("Current Maintenance Hours");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(currentMaintHoursLabel, gridBagConstraints);

        currentMaintHoursTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        dataPanel.add(currentMaintHoursTextField, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new Insets(15, 0, 15, 0);
        outerPanel.add(dataPanel, gridBagConstraints);

        buttonPanel.setLayout(new GridBagLayout());

        modifyAircraftButton.setText("Modify Aircraft");
        modifyAircraftButton.addActionListener(new ActionListener() {
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
                    + "Location: " + locationComboBox.getSelectedItem() + "\n"
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
    private JPanel buttonPanel;
    private JButton cancelButton;
    private JLabel currentMaintHoursLabel;
    private JTextField currentMaintHoursTextField;
    private JPanel dataPanel;
    private JLabel endOfServiceLabel;
    private JTextField endOfServiceTextField;
    private JComboBox<String> locationComboBox;
    private JLabel locationLabel;
    private JLabel maintThresholdLabel;
    private JTextField maintThresholdTextField;
    private JLabel maxAltitudeLabel;
    private JTextField maxAltitudeTextField;
    private JLabel maxSpeedLabel;
    private JTextField maxSpeedTextField;
    private JButton modifyAircraftButton;
    private JPanel outerPanel;
    private JLabel tailNumberLabel;
    private JTextField tailNumberTextField;
    private JLabel titleLabel;
    private JComboBox<String> typeComboBox;
    private JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
