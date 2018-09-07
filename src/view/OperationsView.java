/************   
 * 
 *      Class:         OperationsView.java
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

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class OperationsView extends javax.swing.JPanel {

    public OperationsView() {
        initComponents();
    }

    //Make all table cells non-editable
    private final DefaultTableModel tableModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

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
        tailNumberTextField.setText("A2K2J5");
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

        operationsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Operation A", "Mcallen Air and Marine Branch", "Top Secret", "8/30/2018", "8/30/2018", "5"},
                {"Operation B", "Mcallen Air and Marine Branch", "Mission 2", "8/31/2018", "8/31/2018", "6"},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Location", "Mission", "Start Date", "End Date", "Flight Hours"
            }
        ));
        operationsTable.setName(""); // NOI18N
        operationsTable.setRequestFocusEnabled(false);
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
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();
        JPanel buttonPanel = (JPanel)button.getParent();
        JPanel outerPanel = (JPanel)buttonPanel.getParent();
        JPanel cardLayoutPanel = (JPanel) outerPanel.getParent();
        CardLayout layout = (CardLayout) cardLayoutPanel.getLayout();
        layout.show(cardLayoutPanel,"aircraftView");

    }//GEN-LAST:event_backButtonActionPerformed

    private void addOperationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOperationButtonActionPerformed
        // TODO add your handling code here:
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        AddOperationView addOperationView = new AddOperationView(frame, true);
        addOperationView.setVisible(true);
    }//GEN-LAST:event_addOperationButtonActionPerformed

    private void modifyOperationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyOperationButtonActionPerformed
        // TODO add your handling code here:
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        ModifyOperationView modifyOperationView = new ModifyOperationView(frame, true);
        modifyOperationView.setVisible(true);
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
