/** **********
 *
 *      Class:         AircraftView.java
 *      Package:       view
 *      Date:          September, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description:  AircraftView is the default GUI view that opens when 
 *          the user starts the application.  This view allows the user to search 
 *          a list of aircraft by tail number, maintenance flag or location.  
 *          A table with aircraft data will be produced.  The user is then allowed 
 *          to switch to the aircraft operations view or the aircraft maintenance 
 *          view.  Also, the user can open dialog boxes by pressing the add aircraft
 *          or modify aircraft buttons.
 * 
 *
 *********** */
package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import temporary.TemporaryFunctions;

public class AircraftView extends javax.swing.JPanel {

    //Constructor
    public AircraftView() {
        initComponents();
    }

    //Initialize all Swing components and place them in the JPanel using GridBag layout
    private void initComponents() {//GEN-BEGIN:initComponents
        GridBagConstraints gridBagConstraints;

        searchButtonGroup = new ButtonGroup();
        logoLabel = new JLabel();
        titleLabel = new JLabel();
        topPanel = new JPanel();
        tailNumberRadioButton = new JRadioButton();
        maintFlagRadioButton = new JRadioButton();
        locationRadioButton = new JRadioButton();
        tailNumberLabel = new JLabel();
        maintFlagLabel = new JLabel();
        locationLabel = new JLabel();
        tailNumberTextField = new JTextField();
        maintFlagComboBox = new JComboBox<>();
        locationComboBox = new JComboBox<>(TemporaryFunctions.getLocationArray());
        topButtonPanel = new JPanel();
        searchAircraftButton = new JButton();
        showAllButton = new JButton();
        aircraftTableScrollPane = new JScrollPane();
        aircraftTable = new JTable();
        bottomPanel = new JPanel();
        aircraftOperationsButton = new JButton();
        aircraftMaintenanceButton = new JButton();
        addAircraftButton = new JButton();
        modifyAircraftButton = new JButton();

        setLayout(new GridBagLayout());

        logoLabel.setIcon(new ImageIcon(getClass().getResource("/view/Logo.png"))); // NOI18N
        logoLabel.setName(""); // NOI18N
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(20, 10, 10, 10);
        add(logoLabel, gridBagConstraints);

        titleLabel.setFont(new Font("Arial", 1, 36)); // NOI18N
        titleLabel.setText("Aircraft Search");
        titleLabel.setToolTipText("");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(titleLabel, gridBagConstraints);

        topPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        topPanel.setLayout(new GridBagLayout());

        searchButtonGroup.add(tailNumberRadioButton);
        tailNumberRadioButton.setSelected(true);
        tailNumberRadioButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                tailNumberRadioButtonItemStateChanged(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        topPanel.add(tailNumberRadioButton, gridBagConstraints);

        searchButtonGroup.add(maintFlagRadioButton);
        maintFlagRadioButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                maintFlagRadioButtonItemStateChanged(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        topPanel.add(maintFlagRadioButton, gridBagConstraints);

        searchButtonGroup.add(locationRadioButton);
        locationRadioButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                locationRadioButtonItemStateChanged(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        topPanel.add(locationRadioButton, gridBagConstraints);

        tailNumberLabel.setText("Tail Number");
        tailNumberLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tailNumberLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        topPanel.add(tailNumberLabel, gridBagConstraints);

        maintFlagLabel.setText("Maintenance Flag");
        maintFlagLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                maintFlagLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        topPanel.add(maintFlagLabel, gridBagConstraints);

        locationLabel.setText("Location");
        locationLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                locationLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        topPanel.add(locationLabel, gridBagConstraints);

        tailNumberTextField.setColumns(10);
        tailNumberTextField.setMinimumSize(new Dimension(100, 20));
        tailNumberTextField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tailNumberTextFieldMouseClicked(evt);
            }
        });
        tailNumberTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                tailNumberTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        topPanel.add(tailNumberTextField, gridBagConstraints);

        maintFlagComboBox.setForeground(Color.lightGray);
        maintFlagComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "TRUE", "FALSE" }));
        maintFlagComboBox.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                maintFlagComboBoxMouseClicked(evt);
            }
        });
        maintFlagComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                maintFlagComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        topPanel.add(maintFlagComboBox, gridBagConstraints);

        locationComboBox.setForeground(Color.lightGray);
        locationComboBox.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                locationComboBoxMouseClicked(evt);
            }
        });
        locationComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                locationComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        topPanel.add(locationComboBox, gridBagConstraints);

        topButtonPanel.setLayout(new GridBagLayout());

        searchAircraftButton.setText("Search Aircraft");
        searchAircraftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchAircraftButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        topButtonPanel.add(searchAircraftButton, gridBagConstraints);

        showAllButton.setText("Show All");
        showAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                showAllButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        topButtonPanel.add(showAllButton, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        topPanel.add(topButtonPanel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(topPanel, gridBagConstraints);

        aircraftTable.setAutoCreateRowSorter(true);
        aircraftTable.setModel(TemporaryFunctions.getAircraftTableModel());
        //Hide ID column in table but still allow application access to it
        aircraftTable.getColumnModel().getColumn(0).setMinWidth(0);
        aircraftTable.getColumnModel().getColumn(0).setMaxWidth(0);
        aircraftTable.getColumnModel().getColumn(0).setWidth(0);
        aircraftTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        aircraftTable.getTableHeader().setReorderingAllowed(false);
        aircraftTableScrollPane.setViewportView(aircraftTable);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(aircraftTableScrollPane, gridBagConstraints);

        aircraftOperationsButton.setText("Aircraft Operations");
        aircraftOperationsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aircraftOperationsButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(aircraftOperationsButton);

        aircraftMaintenanceButton.setText("Aircraft Maintenance");
        aircraftMaintenanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aircraftMaintenanceButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(aircraftMaintenanceButton);

        addAircraftButton.setText("Add Aircraft");
        addAircraftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addAircraftButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(addAircraftButton);

        modifyAircraftButton.setText("Modify Aircraft");
        modifyAircraftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                modifyAircraftButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(modifyAircraftButton);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(10, 10, 20, 10);
        add(bottomPanel, gridBagConstraints);
    }//GEN-END:initComponents

    private void aircraftOperationsButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_aircraftOperationsButtonActionPerformed
        //Switch to operations view on card layout when aircraft operations button is pressed
        //Gaining control of CardLayout by getting mainPanel from root frame
        Component component = (Component) evt.getSource();
        MainFrame frame = (MainFrame) SwingUtilities.getRoot(component);
        MainPanel mainPanel = frame.getMainPanel();
        CardLayout layout = (CardLayout) mainPanel.getLayout();

        OperationsView operationsView = mainPanel.getOperationsView();
        try {
            //Get tail number from aircraft table and set in operationsView panel
            int selectedRow = aircraftTable.getSelectedRow();
            String tailNumber = aircraftTable.getValueAt(selectedRow, 1).toString();
            operationsView.setTailNumber(tailNumber);
            //Switch to operationsView panel
            layout.show(mainPanel, "operationsView");
        } catch (IndexOutOfBoundsException e) {
            //If no aircraft is not selected in table, show error dialog
            JOptionPane.showMessageDialog(topPanel, "Please select an aircraft", "Notice", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_aircraftOperationsButtonActionPerformed

    private void addAircraftButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_addAircraftButtonActionPerformed
        //Open add aircraft dialog window when add aircraft button is pressed

        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        AddAircraftView addAircraftView = new AddAircraftView(frame, true);
        addAircraftView.setVisible(true);
    }//GEN-LAST:event_addAircraftButtonActionPerformed

    private void modifyAircraftButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_modifyAircraftButtonActionPerformed
        //Open modify aircraft window when modify aircraft button is pressed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        try {
            int selectedRow = aircraftTable.getSelectedRow();
            String ID = aircraftTable.getValueAt(selectedRow, 0).toString();
            String tailNumber = aircraftTable.getValueAt(selectedRow, 1).toString();
            String type = aircraftTable.getValueAt(selectedRow, 2).toString();
            String location = aircraftTable.getValueAt(selectedRow, 3).toString();
            String maxSpeed = aircraftTable.getValueAt(selectedRow, 4).toString();
            String maxAltitude = aircraftTable.getValueAt(selectedRow, 5).toString();
            String currentMaintHours = aircraftTable.getValueAt(selectedRow, 8).toString();
            String maintHoursThreshold = aircraftTable.getValueAt(selectedRow, 9).toString();
            String endOfServiceDate = aircraftTable.getValueAt(selectedRow, 10).toString();
            ModifyAircraftView modifyAircraftView = new ModifyAircraftView(frame,
                    true, ID, tailNumber, type, location, maxSpeed, maxAltitude,
                    currentMaintHours, maintHoursThreshold, endOfServiceDate);

            modifyAircraftView.setVisible(true);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(topPanel, "Please select an aircraft to modify", "Notice", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_modifyAircraftButtonActionPerformed

    private void searchAircraftButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_searchAircraftButtonActionPerformed
        //Actions performed when search aircraft button is pressed

        //If searching by tail number
        if (tailNumberRadioButton.isSelected()) {
            //Input validation
            if (!util.InputValidator.isAlphaNumeric(tailNumberTextField.getText())) {
                JOptionPane.showMessageDialog(topPanel, "Please enter letters and numbers only", "Notice", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(topPanel, "Searching by Tail Number: " + tailNumberTextField.getText(), "Notice", JOptionPane.PLAIN_MESSAGE);
                System.out.println("Searching by Tail Number: " + tailNumberTextField.getText());
            }
        }

        //If searching by maintenance flag
        if (maintFlagRadioButton.isSelected()) {
            //Output for testing
            JOptionPane.showMessageDialog(topPanel, "Searching by Maintenance Flag: " + maintFlagComboBox.getSelectedItem(), "Notice", JOptionPane.PLAIN_MESSAGE);
            System.out.println("Searching by Maintenance Flag: " + maintFlagComboBox.getSelectedItem());
        }

        //If searching by location
        if (locationRadioButton.isSelected()) {
            //Output for testing
            JOptionPane.showMessageDialog(topPanel, "Searching by Location: " + locationComboBox.getSelectedItem(), "Notice", JOptionPane.PLAIN_MESSAGE);
            System.out.println("Searching by Location: " + locationComboBox.getSelectedItem());
        }
    }//GEN-LAST:event_searchAircraftButtonActionPerformed

    private void aircraftMaintenanceButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_aircraftMaintenanceButtonActionPerformed
        //Switch to maintenance view on card layout when aircraft maintenance button is pressed
        //Gaining control of CardLayout by getting mainPanel from root frame
        Component component = (Component) evt.getSource();
        MainFrame frame = (MainFrame) SwingUtilities.getRoot(component);
        MainPanel mainPanel = frame.getMainPanel();
        CardLayout layout = (CardLayout) mainPanel.getLayout();

        MaintenanceView maintenanceView = mainPanel.getMaintenanceView();
        try {
            //Get tail number from aircraft table and set in maintenance view panel
            int selectedRow = aircraftTable.getSelectedRow();
            String tailNumber = aircraftTable.getValueAt(selectedRow, 1).toString();
            maintenanceView.setTailNumber(tailNumber);
            //Switch to maintenanceView panel
            layout.show(mainPanel, "maintenanceView");
        } catch (IndexOutOfBoundsException e) {
            //If no aircraft is not selected in table, show error dialog
            JOptionPane.showMessageDialog(topPanel, "Please select an aircraft", "Notice", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_aircraftMaintenanceButtonActionPerformed

    private void tailNumberRadioButtonItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_tailNumberRadioButtonItemStateChanged
        //Change foreground to black of radio button is selected, gray if not.
        //This will help the user understand what is being searched
        if (tailNumberRadioButton.isSelected()) {
            tailNumberTextField.setForeground(Color.BLACK);
        } else {
            tailNumberTextField.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_tailNumberRadioButtonItemStateChanged

    private void maintFlagRadioButtonItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_maintFlagRadioButtonItemStateChanged
        //Change foreground to black of radio button is selected, gray if not.
        //This will help the user understand what is being searched
        if (maintFlagRadioButton.isSelected()) {
            maintFlagComboBox.setForeground(Color.BLACK);
        } else {
            maintFlagComboBox.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_maintFlagRadioButtonItemStateChanged

    private void locationRadioButtonItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_locationRadioButtonItemStateChanged
        //Change foreground to black of radio button is selected, gray if not.
        //This will help the user understand what is being searched
        if (locationRadioButton.isSelected()) {
            locationComboBox.setForeground(Color.BLACK);
        } else {
            locationComboBox.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_locationRadioButtonItemStateChanged

    private void maintFlagComboBoxActionPerformed(ActionEvent evt) {//GEN-FIRST:event_maintFlagComboBoxActionPerformed
        //Change radio button selection when user clicks on combo box
        maintFlagRadioButton.setSelected(true);
    }//GEN-LAST:event_maintFlagComboBoxActionPerformed

    private void locationComboBoxActionPerformed(ActionEvent evt) {//GEN-FIRST:event_locationComboBoxActionPerformed
        //Change radio button selection when user clicks on combo box
        locationRadioButton.setSelected(true);
    }//GEN-LAST:event_locationComboBoxActionPerformed

    private void tailNumberTextFieldMouseClicked(MouseEvent evt) {//GEN-FIRST:event_tailNumberTextFieldMouseClicked
        //Change radio button selection when user clicks on text field
        tailNumberRadioButton.setSelected(true);
    }//GEN-LAST:event_tailNumberTextFieldMouseClicked

    private void maintFlagComboBoxMouseClicked(MouseEvent evt) {//GEN-FIRST:event_maintFlagComboBoxMouseClicked
        //Change radio button selection when user clicks on maint flag combo box
        maintFlagRadioButton.setSelected(true);
    }//GEN-LAST:event_maintFlagComboBoxMouseClicked

    private void locationComboBoxMouseClicked(MouseEvent evt) {//GEN-FIRST:event_locationComboBoxMouseClicked
        //Change radio button selection when user clicks on location combo box
        locationRadioButton.setSelected(true);
    }//GEN-LAST:event_locationComboBoxMouseClicked

    private void tailNumberLabelMouseClicked(MouseEvent evt) {//GEN-FIRST:event_tailNumberLabelMouseClicked
        //Change radio button selection when user clicks on label
        tailNumberRadioButton.setSelected(true);
    }//GEN-LAST:event_tailNumberLabelMouseClicked

    private void maintFlagLabelMouseClicked(MouseEvent evt) {//GEN-FIRST:event_maintFlagLabelMouseClicked
        //Change radio button selection when user clicks on label
        maintFlagRadioButton.setSelected(true);
    }//GEN-LAST:event_maintFlagLabelMouseClicked

    private void locationLabelMouseClicked(MouseEvent evt) {//GEN-FIRST:event_locationLabelMouseClicked
        //Change radio button selection when user clicks on label
        locationRadioButton.setSelected(true);
    }//GEN-LAST:event_locationLabelMouseClicked

    private void tailNumberTextFieldActionPerformed(ActionEvent evt) {//GEN-FIRST:event_tailNumberTextFieldActionPerformed
        //Perform search when enter key is pressed in text field
        searchAircraftButton.doClick();
    }//GEN-LAST:event_tailNumberTextFieldActionPerformed

    private void showAllButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_showAllButtonActionPerformed
        //Show all aircraft records in table
        //TODO Call function to show all records in table
        //Testing output dialog box
        JOptionPane.showMessageDialog(topPanel, "Call function to show all records", "Notice", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_showAllButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton addAircraftButton;
    private JButton aircraftMaintenanceButton;
    private JButton aircraftOperationsButton;
    private JTable aircraftTable;
    private JScrollPane aircraftTableScrollPane;
    private JPanel bottomPanel;
    private JComboBox<String> locationComboBox;
    private JLabel locationLabel;
    private JRadioButton locationRadioButton;
    private JLabel logoLabel;
    private JComboBox<String> maintFlagComboBox;
    private JLabel maintFlagLabel;
    private JRadioButton maintFlagRadioButton;
    private JButton modifyAircraftButton;
    private JButton searchAircraftButton;
    private ButtonGroup searchButtonGroup;
    private JButton showAllButton;
    private JLabel tailNumberLabel;
    private JRadioButton tailNumberRadioButton;
    private JTextField tailNumberTextField;
    private JLabel titleLabel;
    private JPanel topButtonPanel;
    private JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
