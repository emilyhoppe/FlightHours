/************   
 * 
 *      Class:         AddAircraftView.java
 *      Package:       view      
 *      Date:          September, 2018 
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
 ************/

package view;

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
import temporary.TemporaryFunctions;

public class AddAircraftView extends javax.swing.JDialog {
    
    //Constructor
    public AddAircraftView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Set add aircraft button to respond to enter key
        SwingUtilities.getRootPane(addAircraftButton).setDefaultButton(addAircraftButton);
    }

    //Initialize all Swing components and place them in the JDialog using GridBag layout
    private void initComponents() {//GEN-BEGIN:initComponents
        GridBagConstraints gridBagConstraints;

        outerPanel = new JPanel();
        titleLabel = new JLabel();
        innerMiddlePanel = new JPanel();
        tailNumberLabel = new JLabel();
        typeLabel = new JLabel();
        locationLabel = new JLabel();
        maxSpeedLabel = new JLabel();
        maxAltitudeLabel = new JLabel();
        maintThresholdLabel = new JLabel();
        tailNumberTextField = new JTextField();
        typeComboBox = new JComboBox<>(TemporaryFunctions.getAircraftTypeArray());
        locationComboBox = new JComboBox<>(TemporaryFunctions.getLocationArray());
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

        titleLabel.setFont(new Font("Tahoma", 1, 18)); // NOI18N
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

        locationLabel.setText("Location");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(locationLabel, gridBagConstraints);

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
        innerMiddlePanel.add(locationComboBox, gridBagConstraints);

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
    }//GEN-END:initComponents

    private void addAircraftButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_addAircraftButtonActionPerformed
        //TODO Validate all user input
        //TODO Call SQL function
        //TODO Temporarily show message box with values
        JOptionPane.showMessageDialog(outerPanel,
                "Adding a new Aircraft record to the database" + "\n"
                + "Aircraft ID: " + "Auto Generated by Database" + "\n"
                + "Tail Number: " + tailNumberTextField.getText() + "\n"
                + "Type: " + typeComboBox.getSelectedItem() + "\n"
                + "Location: " + locationComboBox.getSelectedItem() + "\n"
                + "Max Speed: " + maxSpeedTextField.getText() + "\n"
                + "Max Altitude: " + maxAltitudeTextField.getText() + "\n"
                + "Maintenance Threshold: " + maintThresholdTextField.getText(),
                "Notice", JOptionPane.PLAIN_MESSAGE);
        dispose();
    }//GEN-LAST:event_addAircraftButtonActionPerformed

    private void cancelButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        //Cancel adding aircraft and close window
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton addAircraftButton;
    private JButton cancelButton;
    private JPanel innerBottomPanel;
    private JPanel innerMiddlePanel;
    private JComboBox<String> locationComboBox;
    private JLabel locationLabel;
    private JLabel maintThresholdLabel;
    private JTextField maintThresholdTextField;
    private JLabel maxAltitudeLabel;
    private JTextField maxAltitudeTextField;
    private JLabel maxSpeedLabel;
    private JTextField maxSpeedTextField;
    private JPanel outerPanel;
    private JLabel tailNumberLabel;
    private JTextField tailNumberTextField;
    private JLabel titleLabel;
    private JComboBox<String> typeComboBox;
    private JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
