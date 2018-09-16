/** **********
 *
 *      Class:         ModifyMaintenanceView.java
 *      Package:       view
 *      Date:          September, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: ModifyMaintenance is a GUI view class which extends JDialog.
 *              It provides text fields and combo boxes for the user to modify
 *              existing maintenance events in the database.  When a user clicks the Modify 
 *              Maintenance button, the inputs will be validated and updated in 
 *              the database.
 *
 *
 *********** */
package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class ModifyMaintenanceView extends javax.swing.JDialog {

    //Instance variables
    private String tailNumber;
    private String maintenanceID;
    private String startDate;
    private String endDate;
    private String description;

    //Constructor with parameters
    public ModifyMaintenanceView(java.awt.Frame parent, boolean modal, String tailNumber,
            String maintenanceID, String startDate, String endDate, String description) {
        super(parent, modal);
        this.tailNumber = tailNumber;
        this.maintenanceID = maintenanceID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        initComponents();
        //Make dialog appear in canter of parent frame
        setLocationRelativeTo(parent);
        //Set modify maintenance button to respond to enter key
        SwingUtilities.getRootPane(modifyMaintenanceButton).setDefaultButton(modifyMaintenanceButton);
    }
    
    //Initialize all Swing components and place them in the JDialog using GridBag layout
    private void initComponents() {//GEN-BEGIN:initComponents
        GridBagConstraints gridBagConstraints;

        outerPanel = new JPanel();
        titleLabel = new JLabel();
        innerMiddlePanel = new JPanel();
        tailNumberLabel = new JLabel();
        startDateLabel = new JLabel();
        endDateLabel = new JLabel();
        descriptionLabel = new JLabel();
        tailNumberTextField = new JTextField(tailNumber);
        startDateTextField = new JTextField(startDate);
        endDateTextField = new JTextField(endDate);
        descriptionScrollPane = new JScrollPane();
        descriptionTextArea = new JTextArea(description);
        innerBottomPanel = new JPanel();
        modifyMaintenanceButton = new JButton();
        cancelButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modify Maintenance");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new GridBagLayout());

        outerPanel.setLayout(new GridBagLayout());

        titleLabel.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        titleLabel.setText("Modify Maintenance");
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

        startDateLabel.setText("Start Date");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(startDateLabel, gridBagConstraints);

        endDateLabel.setText("End Date");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(endDateLabel, gridBagConstraints);

        descriptionLabel.setText("Description");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(descriptionLabel, gridBagConstraints);

        tailNumberTextField.setEditable(false);
        tailNumberTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(tailNumberTextField, gridBagConstraints);

        startDateTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(startDateTextField, gridBagConstraints);

        endDateTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(endDateTextField, gridBagConstraints);

        descriptionTextArea.setColumns(30);
        descriptionTextArea.setRows(5);
        descriptionTextArea.setTabSize(4);
        descriptionScrollPane.setViewportView(descriptionTextArea);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(descriptionScrollPane, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new Insets(15, 0, 15, 0);
        outerPanel.add(innerMiddlePanel, gridBagConstraints);

        innerBottomPanel.setLayout(new GridBagLayout());

        modifyMaintenanceButton.setText("Modify Maintenance");
        modifyMaintenanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                modifyMaintenanceButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerBottomPanel.add(modifyMaintenanceButton, gridBagConstraints);

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

    private void modifyMaintenanceButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_modifyMaintenanceButtonActionPerformed
        //TODO Call SQL function
        //Temporarily show message box with values
        JOptionPane.showMessageDialog(outerPanel,
                "Modify Maintenance Database record for aircraft tail number: " + tailNumberTextField.getText() + "\n"
                + "Maintenance ID: " + maintenanceID + "\n"
                + "Start Date: " + startDateTextField.getText() + "\n"
                + "End Date: " + endDateTextField.getText()+ "\n"
                + "Description: " + descriptionTextArea.getText(),
                "Notice", JOptionPane.PLAIN_MESSAGE);
        dispose();
    }//GEN-LAST:event_modifyMaintenanceButtonActionPerformed

    private void cancelButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        //Cancel modifying maintenance record and close window
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton cancelButton;
    private JLabel descriptionLabel;
    private JScrollPane descriptionScrollPane;
    private JTextArea descriptionTextArea;
    private JLabel endDateLabel;
    private JTextField endDateTextField;
    private JPanel innerBottomPanel;
    private JPanel innerMiddlePanel;
    private JButton modifyMaintenanceButton;
    private JPanel outerPanel;
    private JLabel startDateLabel;
    private JTextField startDateTextField;
    private JLabel tailNumberLabel;
    private JTextField tailNumberTextField;
    private JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
