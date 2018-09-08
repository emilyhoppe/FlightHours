/** **********
 *
 *      Class:         AircraftView.java
 *      Package:       view
 *      Date:          September, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description:
 *          AircraftView is the default view that opens when the user starts the application
 *          This view allows the user to search a list of aircraft by tail number, maintenance
 *          flag or location.  A table with aircraft data will be produced.
 *          The user is then allowed to switch to the aircraft operations view or the aircraft
 *          maintenance view.  Also, the user can open dialog boxes by pressing the add aircraft
 *          or modify aircraft buttons.
 *
 *********** */
package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import temporary.TemporaryFunctions;

public class AircraftView extends javax.swing.JPanel {

    public AircraftView() {
        initComponents();
        //Use search aircraft button when user hits enter key
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

        searchButtonGroup = new javax.swing.ButtonGroup();
        logoLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        topPanel = new javax.swing.JPanel();
        tailNumberRadioButton = new javax.swing.JRadioButton();
        maintFlagRadioButton = new javax.swing.JRadioButton();
        locationRadioButton = new javax.swing.JRadioButton();
        tailNumberLabel = new javax.swing.JLabel();
        maintFlagLabel = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        tailNumberTextField = new javax.swing.JTextField();
        maintFlagComboBox = new javax.swing.JComboBox<>();
        locationComboBox = new javax.swing.JComboBox<>(TemporaryFunctions.getLocationArray());
        topButtonPanel = new javax.swing.JPanel();
        searchAircraftButton = new javax.swing.JButton();
        showAllButton = new javax.swing.JButton();
        aircraftTableScrollPane = new javax.swing.JScrollPane();
        aircraftTable = new javax.swing.JTable();
        bottomPanel = new javax.swing.JPanel();
        aircraftOperationsButton = new javax.swing.JButton();
        aircraftMaintenanceButton = new javax.swing.JButton();
        addAircraftButton = new javax.swing.JButton();
        modifyAircraftButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Logo.png"))); // NOI18N
        logoLabel.setName(""); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 10, 10);
        add(logoLabel, gridBagConstraints);

        titleLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        titleLabel.setText("Aircraft Search");
        titleLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(titleLabel, gridBagConstraints);

        topPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        topPanel.setLayout(new java.awt.GridBagLayout());

        searchButtonGroup.add(tailNumberRadioButton);
        tailNumberRadioButton.setSelected(true);
        tailNumberRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tailNumberRadioButtonItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        topPanel.add(tailNumberRadioButton, gridBagConstraints);

        searchButtonGroup.add(maintFlagRadioButton);
        maintFlagRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                maintFlagRadioButtonItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        topPanel.add(maintFlagRadioButton, gridBagConstraints);

        searchButtonGroup.add(locationRadioButton);
        locationRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                locationRadioButtonItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        topPanel.add(locationRadioButton, gridBagConstraints);

        tailNumberLabel.setText("Tail Number");
        tailNumberLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tailNumberLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        topPanel.add(tailNumberLabel, gridBagConstraints);

        maintFlagLabel.setText("Maintenance Flag");
        maintFlagLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maintFlagLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        topPanel.add(maintFlagLabel, gridBagConstraints);

        locationLabel.setText("Location");
        locationLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                locationLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        topPanel.add(locationLabel, gridBagConstraints);

        tailNumberTextField.setColumns(10);
        tailNumberTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        tailNumberTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tailNumberTextFieldMouseClicked(evt);
            }
        });
        tailNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tailNumberTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        topPanel.add(tailNumberTextField, gridBagConstraints);

        maintFlagComboBox.setForeground(java.awt.Color.lightGray);
        maintFlagComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TRUE", "FALSE" }));
        maintFlagComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maintFlagComboBoxMouseClicked(evt);
            }
        });
        maintFlagComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maintFlagComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        topPanel.add(maintFlagComboBox, gridBagConstraints);

        locationComboBox.setForeground(java.awt.Color.lightGray);
        locationComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                locationComboBoxMouseClicked(evt);
            }
        });
        locationComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        topPanel.add(locationComboBox, gridBagConstraints);

        topButtonPanel.setLayout(new java.awt.GridBagLayout());

        searchAircraftButton.setText("Search Aircraft");
        searchAircraftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAircraftButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        topButtonPanel.add(searchAircraftButton, gridBagConstraints);

        showAllButton.setText("Show All");
        showAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        topButtonPanel.add(showAllButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        topPanel.add(topButtonPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(topPanel, gridBagConstraints);

        aircraftTable.setAutoCreateRowSorter(true);
        aircraftTable.setModel(TemporaryFunctions.getAircraftTableModel());
        aircraftTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        aircraftTable.getTableHeader().setReorderingAllowed(false);
        aircraftTableScrollPane.setViewportView(aircraftTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(aircraftTableScrollPane, gridBagConstraints);

        aircraftOperationsButton.setText("Aircraft Operations");
        aircraftOperationsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aircraftOperationsButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(aircraftOperationsButton);

        aircraftMaintenanceButton.setText("Aircraft Maintenance");
        aircraftMaintenanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aircraftMaintenanceButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(aircraftMaintenanceButton);

        addAircraftButton.setText("Add Aircraft");
        addAircraftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAircraftButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(addAircraftButton);

        modifyAircraftButton.setText("Modify Aircraft");
        modifyAircraftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyAircraftButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(modifyAircraftButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 20, 10);
        add(bottomPanel, gridBagConstraints);
    }//GEN-END:initComponents

    private void aircraftOperationsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aircraftOperationsButtonActionPerformed
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
            String tailNumber = aircraftTable.getValueAt(selectedRow, 0).toString();
            operationsView.setTailNumber(tailNumber);
            //Switch to operationsView panel
            layout.show(mainPanel, "operationsView");
        } catch (IndexOutOfBoundsException e) {
            //If no aircraft is not selected in table, show error dialog
            JOptionPane.showMessageDialog(topPanel, "Please select an aircraft", "Notice", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_aircraftOperationsButtonActionPerformed

    private void addAircraftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAircraftButtonActionPerformed
        //Open add aircraft dialog window when add aircraft button is pressed

        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        AddAircraftView addAircraftView = new AddAircraftView(frame, true);
        addAircraftView.setVisible(true);
    }//GEN-LAST:event_addAircraftButtonActionPerformed

    private void modifyAircraftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyAircraftButtonActionPerformed
        //Open modify aircraft window when modify aircraft button is pressed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        try {
            int selectedRow = aircraftTable.getSelectedRow();
            String tailNumber = aircraftTable.getValueAt(selectedRow, 0).toString();
            String type = aircraftTable.getValueAt(selectedRow, 1).toString();
            String location = aircraftTable.getValueAt(selectedRow, 2).toString();
            String mission = aircraftTable.getValueAt(selectedRow, 3).toString();
            String maxSpeed = aircraftTable.getValueAt(selectedRow, 4).toString();
            String maxAltitude = aircraftTable.getValueAt(selectedRow, 5).toString();
            String maintHoursThreshold = aircraftTable.getValueAt(selectedRow, 8).toString();
            String endOfServiceDate = aircraftTable.getValueAt(selectedRow, 9).toString();
            ModifyAircraftView modifyAircraftView = new ModifyAircraftView(frame, true, tailNumber, type, location, mission, maxSpeed, maxAltitude, maintHoursThreshold, endOfServiceDate);

            modifyAircraftView.setVisible(true);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(topPanel, "Please select an aircraft to modify", "Notice", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_modifyAircraftButtonActionPerformed

    private void searchAircraftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchAircraftButtonActionPerformed
        //Actions performed when search aircraft button is pressed

        //If searching by tail number
        if (tailNumberRadioButton.isSelected()) {
            //Output for testing
            //If textfield is empty show error popup
            if (tailNumberTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(topPanel, "Please enter text to search", "Notice", JOptionPane.ERROR_MESSAGE);
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

    private void aircraftMaintenanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aircraftMaintenanceButtonActionPerformed
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
            String tailNumber = aircraftTable.getValueAt(selectedRow, 0).toString();
            maintenanceView.setTailNumber(tailNumber);
            //Switch to maintenanceView panel
            layout.show(mainPanel, "maintenanceView");
        } catch (IndexOutOfBoundsException e) {
            //If no aircraft is not selected in table, show error dialog
            JOptionPane.showMessageDialog(topPanel, "Please select an aircraft", "Notice", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_aircraftMaintenanceButtonActionPerformed

    private void tailNumberRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tailNumberRadioButtonItemStateChanged
        //Change foreground to black of radio button is selected, gray if not.
        //This will help the user understand what is being searched
        if (tailNumberRadioButton.isSelected()) {
            tailNumberTextField.setForeground(Color.BLACK);
        } else {
            tailNumberTextField.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_tailNumberRadioButtonItemStateChanged

    private void maintFlagRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_maintFlagRadioButtonItemStateChanged
        //Change foreground to black of radio button is selected, gray if not.
        //This will help the user understand what is being searched
        if (maintFlagRadioButton.isSelected()) {
            maintFlagComboBox.setForeground(Color.BLACK);
        } else {
            maintFlagComboBox.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_maintFlagRadioButtonItemStateChanged

    private void locationRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_locationRadioButtonItemStateChanged
        //Change foreground to black of radio button is selected, gray if not.
        //This will help the user understand what is being searched
        if (locationRadioButton.isSelected()) {
            locationComboBox.setForeground(Color.BLACK);
        } else {
            locationComboBox.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_locationRadioButtonItemStateChanged

    private void maintFlagComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maintFlagComboBoxActionPerformed
        //Change radio button selection when user clicks on combo box
        maintFlagRadioButton.setSelected(true);
    }//GEN-LAST:event_maintFlagComboBoxActionPerformed

    private void locationComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationComboBoxActionPerformed
        //Change radio button selection when user clicks on combo box
        locationRadioButton.setSelected(true);
    }//GEN-LAST:event_locationComboBoxActionPerformed

    private void tailNumberTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tailNumberTextFieldMouseClicked
        //Change radio button selection when user clicks on text field
        tailNumberRadioButton.setSelected(true);
    }//GEN-LAST:event_tailNumberTextFieldMouseClicked

    private void maintFlagComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintFlagComboBoxMouseClicked
        //Change radio button selection when user clicks on maint flag combo box
        maintFlagRadioButton.setSelected(true);
    }//GEN-LAST:event_maintFlagComboBoxMouseClicked

    private void locationComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_locationComboBoxMouseClicked
        //Change radio button selection when user clicks on location combo box
        locationRadioButton.setSelected(true);
    }//GEN-LAST:event_locationComboBoxMouseClicked

    private void tailNumberLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tailNumberLabelMouseClicked
        //Change radio button selection when user clicks on label
        tailNumberRadioButton.setSelected(true);
    }//GEN-LAST:event_tailNumberLabelMouseClicked

    private void maintFlagLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintFlagLabelMouseClicked
        //Change radio button selection when user clicks on label
        maintFlagRadioButton.setSelected(true);
    }//GEN-LAST:event_maintFlagLabelMouseClicked

    private void locationLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_locationLabelMouseClicked
        //Change radio button selection when user clicks on label
        locationRadioButton.setSelected(true);
    }//GEN-LAST:event_locationLabelMouseClicked

    private void tailNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tailNumberTextFieldActionPerformed
        //Perform search when enter key is pressed in text field
        searchAircraftButton.doClick();
    }//GEN-LAST:event_tailNumberTextFieldActionPerformed

    private void showAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllButtonActionPerformed
        //Show all aircraft records in table
        //TODO Call function to show all records in table
        //Testing output dialog box
        JOptionPane.showMessageDialog(topPanel, "Call function to show all records", "Notice", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_showAllButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAircraftButton;
    private javax.swing.JButton aircraftMaintenanceButton;
    private javax.swing.JButton aircraftOperationsButton;
    private javax.swing.JTable aircraftTable;
    private javax.swing.JScrollPane aircraftTableScrollPane;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JComboBox<String> locationComboBox;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JRadioButton locationRadioButton;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JComboBox<String> maintFlagComboBox;
    private javax.swing.JLabel maintFlagLabel;
    private javax.swing.JRadioButton maintFlagRadioButton;
    private javax.swing.JButton modifyAircraftButton;
    private javax.swing.JButton searchAircraftButton;
    private javax.swing.ButtonGroup searchButtonGroup;
    private javax.swing.JButton showAllButton;
    private javax.swing.JLabel tailNumberLabel;
    private javax.swing.JRadioButton tailNumberRadioButton;
    private javax.swing.JTextField tailNumberTextField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel topButtonPanel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
