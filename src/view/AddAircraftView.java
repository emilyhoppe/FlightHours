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

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

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
        java.awt.GridBagConstraints gridBagConstraints;

        outerPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        innerMiddlePanel = new javax.swing.JPanel();
        tailNumberLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        maxSpeedLabel = new javax.swing.JLabel();
        maxAltitudeLabel = new javax.swing.JLabel();
        maintThresholdLabel = new javax.swing.JLabel();
        tailNumberTextField = new javax.swing.JTextField();
        typeComboBox = new javax.swing.JComboBox<>(temporary.TemporaryFunctions.getAircraftTypeArray());
        locationComboBox = new javax.swing.JComboBox<>(temporary.TemporaryFunctions.getLocationArray());
        maxSpeedTextField = new javax.swing.JTextField();
        maxAltitudeTextField = new javax.swing.JTextField();
        maintThresholdTextField = new javax.swing.JTextField();
        innerBottomPanel = new javax.swing.JPanel();
        addAircraftButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Aircraft");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        outerPanel.setLayout(new java.awt.GridBagLayout());

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleLabel.setText("Add Aircraft");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        outerPanel.add(titleLabel, gridBagConstraints);

        innerMiddlePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        innerMiddlePanel.setToolTipText("");
        innerMiddlePanel.setLayout(new java.awt.GridBagLayout());

        tailNumberLabel.setText("Tail Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(tailNumberLabel, gridBagConstraints);

        typeLabel.setText("Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(typeLabel, gridBagConstraints);

        locationLabel.setText("Location");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(locationLabel, gridBagConstraints);

        maxSpeedLabel.setText("Max Speed");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(maxSpeedLabel, gridBagConstraints);

        maxAltitudeLabel.setText("Max Altitude");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(maxAltitudeLabel, gridBagConstraints);

        maintThresholdLabel.setText("Maintenance Hours Threshold");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(maintThresholdLabel, gridBagConstraints);

        tailNumberTextField.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(tailNumberTextField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(typeComboBox, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(locationComboBox, gridBagConstraints);

        maxSpeedTextField.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(maxSpeedTextField, gridBagConstraints);

        maxAltitudeTextField.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(maxAltitudeTextField, gridBagConstraints);

        maintThresholdTextField.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(maintThresholdTextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 15, 0);
        outerPanel.add(innerMiddlePanel, gridBagConstraints);

        innerBottomPanel.setLayout(new java.awt.GridBagLayout());

        addAircraftButton.setText("Add Aircraft");
        addAircraftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAircraftButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerBottomPanel.add(addAircraftButton, gridBagConstraints);

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
        innerBottomPanel.add(cancelButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        outerPanel.add(innerBottomPanel, gridBagConstraints);

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

    private void addAircraftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAircraftButtonActionPerformed
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

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        //Cancel adding aircraft and close window
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAircraftButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel innerBottomPanel;
    private javax.swing.JPanel innerMiddlePanel;
    private javax.swing.JComboBox<String> locationComboBox;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JLabel maintThresholdLabel;
    private javax.swing.JTextField maintThresholdTextField;
    private javax.swing.JLabel maxAltitudeLabel;
    private javax.swing.JTextField maxAltitudeTextField;
    private javax.swing.JLabel maxSpeedLabel;
    private javax.swing.JTextField maxSpeedTextField;
    private javax.swing.JPanel outerPanel;
    private javax.swing.JLabel tailNumberLabel;
    private javax.swing.JTextField tailNumberTextField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JComboBox<String> typeComboBox;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
