/** **********
 *
 *      Class:         AboutView.java
 *      Package:       view
 *      Date:          October 14, 2018
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
import java.awt.Frame;
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

    //Instance variables
    private final Frame parent;
    private JLabel aboutLabel;
    private JButton closeButton;
    private JPanel mainPanel;

    //Constructor
    public AboutView(Frame parent, boolean model) {
        super(parent, model);
        this.parent = parent;
        initComponents();
        //Set close button to respond to enter key
        SwingUtilities.getRootPane(closeButton).setDefaultButton(closeButton);
    }

    //Initialize all Swing components and place them in the JDialog using GridBag layout
    private void initComponents() {
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
            @Override
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

        aboutLabel.setFont(new Font("Tahoma", 0, 18));
        aboutLabel.setText("<html> <Center> FHS<BR> Flight Hours System<BR> Version 1.0<BR> <BR> This application was developed<BR> for UMUC CMSC495 Fall 2018 by:<BR> John Tamer<BR> Jason Grimard<BR> Demetrius Billups<BR> &<BR> Emily Hoppe");
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
        //Make dialog appear in canter of parent frame
        setLocationRelativeTo(parent);
    }

    private void closeButtonActionPerformed(ActionEvent evt) {
        //Close the dialog box
        dispose();
    }

}
