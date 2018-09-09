/************   
 * 
 *      Class:         ModifyMaintenanceView.java
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

import javax.swing.SwingUtilities;

public class ModifyMaintenanceView extends javax.swing.JDialog {

    private String tailNumber;
    
    public ModifyMaintenanceView(java.awt.Frame parent, boolean modal, String tailNumber) {
        super(parent, modal);
        this.tailNumber = tailNumber;
        initComponents();
        //Set modify maintenance button to respond to enter key
        SwingUtilities.getRootPane(modifyMaintenanceButton).setDefaultButton(modifyMaintenanceButton);
    }

    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        outerPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        innerMiddlePanel = new javax.swing.JPanel();
        tailNumberLabel = new javax.swing.JLabel();
        startDateLabel = new javax.swing.JLabel();
        endDateLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        tailNumberTextField = new javax.swing.JTextField(tailNumber);
        startDateTextField = new javax.swing.JTextField();
        endDateTextField = new javax.swing.JTextField();
        descriptionScrollPane = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        innerBottomPanel = new javax.swing.JPanel();
        modifyMaintenanceButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modify Maintenance");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        outerPanel.setLayout(new java.awt.GridBagLayout());

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleLabel.setText("Modify Maintenance");
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

        startDateLabel.setText("Start Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(startDateLabel, gridBagConstraints);

        endDateLabel.setText("End Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(endDateLabel, gridBagConstraints);

        descriptionLabel.setText("Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(descriptionLabel, gridBagConstraints);

        tailNumberTextField.setEditable(false);
        tailNumberTextField.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(tailNumberTextField, gridBagConstraints);

        startDateTextField.setColumns(10);
        startDateTextField.setText("7/28/2018");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(startDateTextField, gridBagConstraints);

        endDateTextField.setColumns(10);
        endDateTextField.setText("7/28/2018");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(endDateTextField, gridBagConstraints);

        descriptionTextArea.setColumns(30);
        descriptionTextArea.setRows(5);
        descriptionTextArea.setTabSize(4);
        descriptionTextArea.setText("Replace front landing gear");
        descriptionScrollPane.setViewportView(descriptionTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerMiddlePanel.add(descriptionScrollPane, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 15, 0);
        outerPanel.add(innerMiddlePanel, gridBagConstraints);

        innerBottomPanel.setLayout(new java.awt.GridBagLayout());

        modifyMaintenanceButton.setText("Modify Maintenance");
        modifyMaintenanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyMaintenanceButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        innerBottomPanel.add(modifyMaintenanceButton, gridBagConstraints);

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

    private void modifyMaintenanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyMaintenanceButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_modifyMaintenanceButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JScrollPane descriptionScrollPane;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JTextField endDateTextField;
    private javax.swing.JPanel innerBottomPanel;
    private javax.swing.JPanel innerMiddlePanel;
    private javax.swing.JButton modifyMaintenanceButton;
    private javax.swing.JPanel outerPanel;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JTextField startDateTextField;
    private javax.swing.JLabel tailNumberLabel;
    private javax.swing.JTextField tailNumberTextField;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
