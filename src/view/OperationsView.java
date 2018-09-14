/** **********
 *
 *      Class:         OperationsView.java
 *      Package:       view
 *      Date:          September, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: OperationsView is a GUI view class which extends JPanel.
 *          A table with aircraft operations will be provided, showing all 
 *          operations related to the previously selected aircraft.  The 
 *          user can select an operation from the table and click Add Operation
 *          or Modify Operation to open input dialog boxes.  A Back button is provided
 *          which will switch the card layout back to the Aircraft Search view.
 *
 *
 *********** */
package view;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class OperationsView extends javax.swing.JPanel {

    //Instance variables
    private String tailNumber;

    //Set tail number public method
    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
        tailNumberTextField.setText(tailNumber);
    }

    //Constructor
    public OperationsView() {
        initComponents();
    }

    //Initialize all Swing components and place them in the JDialog using GridBag layout
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        logoLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        topPanel = new javax.swing.JPanel();
        tailNumberLabel = new javax.swing.JLabel();
        tailNumberTextField = new javax.swing.JTextField();
        operationsTableScrollPane = new javax.swing.JScrollPane();
        operationsTable = new javax.swing.JTable();
        bottomPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        addOperationButton = new javax.swing.JButton();
        modifyOperationButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Logo.png"))); // NOI18N
        logoLabel.setName(""); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 10, 10);
        add(logoLabel, gridBagConstraints);

        titleLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        titleLabel.setText("Aircraft Operations");
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

        operationsTable.setModel(temporary.TemporaryFunctions.getOperationsTableModel());
        //Hide ID column in table but still allow application access to it
        operationsTable.getColumnModel().getColumn(0).setMinWidth(0);
        operationsTable.getColumnModel().getColumn(0).setMaxWidth(0);
        operationsTable.getColumnModel().getColumn(0).setWidth(0);
        operationsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        operationsTableScrollPane.setViewportView(operationsTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(operationsTableScrollPane, gridBagConstraints);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(backButton);

        addOperationButton.setText("Add Operation");
        addOperationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOperationButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(addOperationButton);

        modifyOperationButton.setText("Modify Operation");
        modifyOperationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyOperationButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(modifyOperationButton);

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

    private void addOperationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOperationButtonActionPerformed
        // TODO add your handling code here:
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        AddOperationView addOperationView = new AddOperationView(frame, true, tailNumber);
        addOperationView.setVisible(true);
    }//GEN-LAST:event_addOperationButtonActionPerformed

    private void modifyOperationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyOperationButtonActionPerformed
        //Open modify operation window when modify operation button is pressed
        //Retrieve selected table row and pass all data to new window
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        try {
            int selectedRow = operationsTable.getSelectedRow();
            String operationID = operationsTable.getValueAt(selectedRow,0).toString();
            String name = operationsTable.getValueAt(selectedRow, 1).toString();
            String location = operationsTable.getValueAt(selectedRow, 2).toString();
            String mission = operationsTable.getValueAt(selectedRow, 3).toString();
            String startDate = operationsTable.getValueAt(selectedRow, 4).toString();
            String endDate = operationsTable.getValueAt(selectedRow,5).toString();
            String flightHours = operationsTable.getValueAt(selectedRow, 6).toString();
            ModifyOperationView modifyOperationView = new ModifyOperationView(frame,
                    true, tailNumber,operationID, name, location, mission, startDate, 
                    endDate, flightHours);

            modifyOperationView.setVisible(true);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(topPanel, "Please select an operation to modify", "Notice", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_modifyOperationButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addOperationButton;
    private javax.swing.JButton backButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton modifyOperationButton;
    private javax.swing.JTable operationsTable;
    private javax.swing.JScrollPane operationsTableScrollPane;
    private javax.swing.JLabel tailNumberLabel;
    private javax.swing.JTextField tailNumberTextField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
