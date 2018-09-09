/** **********
 *
 *      Class:         Maintenanceview.java
 *      Package:       view
 *      Date:          September, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description:
 *
 *
 *********** */
package view;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MaintenanceView extends javax.swing.JPanel {

    private String tailNumber = "";

    //Set tail number public method
    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
        tailNumberTextField.setText(tailNumber);
    }

    public MaintenanceView() {
        initComponents();
    }

    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        logoLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        topPanel = new javax.swing.JPanel();
        tailNumberLabel = new javax.swing.JLabel();
        tailNumberTextField = new javax.swing.JTextField(tailNumber);
        maintenanceTableScrollPane = new javax.swing.JScrollPane();
        maintenanceTable = new javax.swing.JTable();
        bottomPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        addMaintenanceButton = new javax.swing.JButton();
        modifyMaintenanceButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Logo.png"))); // NOI18N
        logoLabel.setName(""); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 10, 10);
        add(logoLabel, gridBagConstraints);

        titleLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        titleLabel.setText("Aircraft Maintenance");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(titleLabel, gridBagConstraints);

        topPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        topPanel.setLayout(new java.awt.GridBagLayout());

        tailNumberLabel.setText("Tail Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        topPanel.add(tailNumberLabel, gridBagConstraints);

        tailNumberTextField.setEditable(false);
        tailNumberTextField.setColumns(10);
        tailNumberTextField.setMinimumSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        topPanel.add(tailNumberTextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(topPanel, gridBagConstraints);

        maintenanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"7/28/2018", "7/28/2018", "Replaced front landing gear"},
                {"7/30/2018", "7/30/2018", "Upgraded muffler bearings"},
                {null, null, null}
            },
            new String [] {
                "Start Date", "End Date", "Description"
            }
        ));
        maintenanceTable.setName(""); // NOI18N
        maintenanceTable.setRequestFocusEnabled(false);
        maintenanceTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        maintenanceTableScrollPane.setViewportView(maintenanceTable);
        if (maintenanceTable.getColumnModel().getColumnCount() > 0) {
            maintenanceTable.getColumnModel().getColumn(0).setMaxWidth(100);
            maintenanceTable.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(maintenanceTableScrollPane, gridBagConstraints);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(backButton);

        addMaintenanceButton.setText("Add Maintenance");
        addMaintenanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMaintenanceButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(addMaintenanceButton);

        modifyMaintenanceButton.setText("Modify Maintenance");
        modifyMaintenanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyMaintenanceButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(modifyMaintenanceButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 20, 10);
        add(bottomPanel, gridBagConstraints);
    }//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        //Switch to aircraft view on card layout when aircraft back button is pressed
        //Gaining control of CardLayout by getting mainPanel from root frame
        Component component = (Component) evt.getSource();
        MainFrame frame = (MainFrame) SwingUtilities.getRoot(component);
        MainPanel mainPanel = frame.getMainPanel();
        CardLayout layout = (CardLayout) mainPanel.getLayout();        
        layout.show(mainPanel, "aircraftView");
    }//GEN-LAST:event_backButtonActionPerformed

    private void addMaintenanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMaintenanceButtonActionPerformed
        // TODO add your handling code here:
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        AddMaintenanceView addMaintenanceView = new AddMaintenanceView(frame, true, tailNumber);
        addMaintenanceView.setVisible(true);
    }//GEN-LAST:event_addMaintenanceButtonActionPerformed

    private void modifyMaintenanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyMaintenanceButtonActionPerformed
        // TODO add your handling code here:
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        ModifyMaintenanceView modifyMaintenanceView = new ModifyMaintenanceView(frame, true, tailNumber);
        modifyMaintenanceView.setVisible(true);
    }//GEN-LAST:event_modifyMaintenanceButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMaintenanceButton;
    private javax.swing.JButton backButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JTable maintenanceTable;
    private javax.swing.JScrollPane maintenanceTableScrollPane;
    private javax.swing.JButton modifyMaintenanceButton;
    private javax.swing.JLabel tailNumberLabel;
    private javax.swing.JTextField tailNumberTextField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
