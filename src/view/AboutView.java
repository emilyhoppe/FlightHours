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

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

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
        GridBagConstraints gridBagConstraints;

        closeButton = new JButton();
        mainPanel = new JPanel();
        aboutLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About FHS Flight Hours System");
        setModalityType(ModalityType.APPLICATION_MODAL);
        getContentPane().setLayout(new GridBagLayout());

        closeButton.setText("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(5, 15, 15, 15);
        getContentPane().add(closeButton, gridBagConstraints);

        mainPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        mainPanel.setLayout(new GridBagLayout());

        aboutLabel.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        aboutLabel.setText("<html> <Center>\nFHS<BR>\nFlight Hours System<BR>\nVersion 0.1 BETA<BR>\n<BR>\nThis application was developed<BR>\nfor UMUC CMSC495 Fall 2018 by:<BR>\nJohn Tamer<BR>\nJason Grimard<BR>\nDemetrius Billups<BR>\n&<BR>\nEmily Hoppe");
        aboutLabel.setToolTipText("");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(20, 20, 20, 20);
        mainPanel.add(aboutLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(15, 15, 15, 15);
        getContentPane().add(mainPanel, gridBagConstraints);

        pack();
    }//GEN-END:initComponents

    private void closeButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        //Close the dialog box
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel aboutLabel;
    private JButton closeButton;
    private JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
