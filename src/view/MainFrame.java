/** **********
 *
 *      Class:         MainFrame.java
 *      Package:       view
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: The MainFrame class extends JFrame and is the base
 *          of the GUI which all other GUI components sit on.  This class also
 *          creates the menu bar and menu items.
 *
 *
 *********** */
package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

public class MainFrame extends javax.swing.JFrame {

    //Instance variables
    private JMenuItem aboutMenuItem;
    private JMenuItem exitMenuItem;
    private JMenu fileMenu;
    private JMenu helpMenu;
    private MainPanel mainPanel;
    private JMenuBar menuBar;

    //Returns mainPanel object so cardLayout can be changed by user, aka switch screens
    public MainPanel getMainPanel() {
        return mainPanel;
    }

    //Constructor
    public MainFrame() {
        initComponents();
    }

    //Initialize all Swing components and place them in the JFrame using GridBag layout
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        mainPanel = new MainPanel();
        menuBar = new JMenuBar();
        fileMenu = new JMenu();
        exitMenuItem = new JMenuItem();
        helpMenu = new JMenu();
        aboutMenuItem = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("FHS Flight Hours System");
        setName("MainFrame");
        setSize(new Dimension(700, 500));
        getContentPane().setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(mainPanel, gridBagConstraints);

        fileMenu.setText("File");

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        setSize(new Dimension(966, 739));
        setLocationRelativeTo(null);
    }

    //Exit the system
    private void exitMenuItemActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    //Display the AboutView dialog
    private void aboutMenuItemActionPerformed(ActionEvent evt) {
        AboutView aboutView = new AboutView(this, true);
        aboutView.setVisible(true);

    }
}
