/** **********
 *
 *      Class:         AboutView.java
 *      Package:       view
 *      Date:          September, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: AboutView is a GUI JDialog window which displays the 
 *          current version of the FHS application and lists its creators.
 *
 *
 *********** */
package view;

import javax.swing.SwingUtilities;

public class AboutView extends javax.swing.JDialog {

    //Constructor
    public AboutView(java.awt.Frame parent, boolean model) {
        super(parent, model);
        initComponents();
        //Set close button to respond to enter key
        SwingUtilities.getRootPane(closeButton).setDefaultButton(closeButton);
    }

    //Initialize all Swing components and place them in the JDialog using GridBag layout
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        closeButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        aboutLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About FHS Flight Hours System");
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 15, 15);
        getContentPane().add(closeButton, gridBagConstraints);

        mainPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        aboutLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        aboutLabel.setText("<html> <Center>\nFHS<BR>\nFlight Hours System<BR>\nVersion 0.1 BETA<BR>\n<BR>\nThis application was developed<BR>\nfor UMUC CMSC495 Fall 2018 by:<BR>\nJohn Tamer<BR>\nJason Grimard<BR>\nDemetrius Billups<BR>\n&<BR>\nEmily Hoppe");
        aboutLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        mainPanel.add(aboutLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        getContentPane().add(mainPanel, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        //Close the dialog box
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aboutLabel;
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
