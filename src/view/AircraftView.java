/** **********
 *
 *      Class:         AircraftView.java
 *      Package:       view
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description:  AircraftView is the default GUI view that opens when
 *          the user starts the application.  This view allows the user to search
 *          a list of aircraft by tail number, maintenance flag or station.
 *          A table with aircraft data will be produced.  The user is then allowed
 *          to switch to the aircraft operations view or the aircraft maintenance
 *          view.  Also, the user can open dialog boxes by pressing the add aircraft
 *          or modify aircraft buttons.
 *
 *
 *********** */
package view;

import controller.AircraftDAO;
import controller.StationDAO;
import model.Station;
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
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class AircraftView extends javax.swing.JPanel {

    //Instance variables
    private AircraftDAO aircraftDAO;
    SimpleDateFormat simpleDateFormat;
    private JButton addAircraftButton;
    private JButton aircraftMaintenanceButton;
    private JButton aircraftOperationsButton;
    private JTable aircraftTable;
    private JScrollPane aircraftTableScrollPane;
    private JPanel bottomPanel;
    private JLabel logoLabel;
    private JComboBox<String> maintFlagComboBox;
    private JLabel maintFlagLabel;
    private JRadioButton maintFlagRadioButton;
    private JButton modifyAircraftButton;
    private JButton searchAircraftButton;
    private ButtonGroup searchButtonGroup;
    private JButton showAllButton;
    private JComboBox stationComboBox;
    private JLabel stationLabel;
    private JRadioButton stationRadioButton;
    private JLabel tailNumberLabel;
    private JRadioButton tailNumberRadioButton;
    private JTextField tailNumberTextField;
    private JLabel titleLabel;
    private JPanel topButtonPanel;
    private JPanel topPanel;
    private JLabel noRecordsLabel;

    //Constructor
    public AircraftView() {
        this.simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        initComponents();
    }

    //Initialize all Swing components and place them in the JPanel using GridBag layout
    private void initComponents() {
        GridBagConstraints gridBagConstraints;
        searchButtonGroup = new ButtonGroup();
        logoLabel = new JLabel();
        titleLabel = new JLabel();
        topPanel = new JPanel();
        tailNumberRadioButton = new JRadioButton();
        maintFlagRadioButton = new JRadioButton();
        stationRadioButton = new JRadioButton();
        tailNumberLabel = new JLabel();
        maintFlagLabel = new JLabel();
        stationLabel = new JLabel();
        tailNumberTextField = new JTextField();
        maintFlagComboBox = new JComboBox<>();
        StationDAO stationDAO = new StationDAO();
        stationComboBox = new JComboBox<>(stationDAO.selectStationByType("AMO").toArray());
        topButtonPanel = new JPanel();
        searchAircraftButton = new JButton();
        showAllButton = new JButton();
        aircraftTableScrollPane = new JScrollPane();
        aircraftTable = new JTable();
        bottomPanel = new JPanel();
        noRecordsLabel = new JLabel();
        aircraftOperationsButton = new JButton();
        aircraftMaintenanceButton = new JButton();
        addAircraftButton = new JButton();
        modifyAircraftButton = new JButton();

        setLayout(new GridBagLayout());

        topPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        topPanel.setLayout(new GridBagLayout());

        searchButtonGroup.add(tailNumberRadioButton);
        tailNumberRadioButton.setSelected(true);
        tailNumberRadioButton.addItemListener(new ItemListener() {
            @Override
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
            @Override
            public void itemStateChanged(ItemEvent evt) {
                maintFlagRadioButtonItemStateChanged(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        topPanel.add(maintFlagRadioButton, gridBagConstraints);

        searchButtonGroup.add(stationRadioButton);
        stationRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                stationRadioButtonItemStateChanged(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        topPanel.add(stationRadioButton, gridBagConstraints);

        tailNumberLabel.setText("Tail Number");
        tailNumberLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                tailNumberLabelMouseClicked(evt);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                tailNumberLabelMouseEntered(evt);
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
            @Override
            public void mouseClicked(MouseEvent evt) {
                maintFlagLabelMouseClicked(evt);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                maintFlagLabelMouseEntered(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        topPanel.add(maintFlagLabel, gridBagConstraints);

        stationLabel.setText("AMO Station");
        stationLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                stationLabelMouseClicked(evt);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                stationLabelMouseEntered(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        topPanel.add(stationLabel, gridBagConstraints);

        tailNumberTextField.setColumns(10);
        tailNumberTextField.setMinimumSize(new Dimension(100, 20));
        tailNumberTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                tailNumberTextFieldMouseClicked(evt);
            }
        });
        tailNumberTextField.addActionListener(new ActionListener() {
            @Override
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
        maintFlagComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"TRUE", "FALSE"}));
        maintFlagComboBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                maintFlagComboBoxMouseClicked(evt);
            }
        });
        maintFlagComboBox.addActionListener(new ActionListener() {
            @Override
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

        stationComboBox.setForeground(Color.lightGray);
        stationComboBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                stationComboBoxMouseClicked(evt);
            }
        });
        stationComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                stationComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        topPanel.add(stationComboBox, gridBagConstraints);

        topButtonPanel.setLayout(new GridBagLayout());

        searchAircraftButton.setText("Search Aircraft");
        searchAircraftButton.addActionListener(new ActionListener() {
            @Override
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
            @Override
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

        //Add components to AircraftView JPanel
        logoLabel.setIcon(new ImageIcon(getClass().getResource("/view/Logo.png")));
        logoLabel.setName("");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(20, 10, 10, 10);
        add(logoLabel, gridBagConstraints);

        titleLabel.setFont(new Font("Arial", 1, 36));
        titleLabel.setText("Aircraft Search");
        titleLabel.setToolTipText("");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(titleLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(topPanel, gridBagConstraints);

        noRecordsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        noRecordsLabel.setMinimumSize(new Dimension(200, 20));
        noRecordsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(0, 10, 0, 10);
        add(noRecordsLabel, gridBagConstraints);

        aircraftTable.setAutoCreateRowSorter(true);
        aircraftDAO = new AircraftDAO();
        aircraftTable.setModel(aircraftDAO.selectAllAircraft());
        setupAircraftTable();
        aircraftTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        aircraftTable.getTableHeader().setReorderingAllowed(false);
        aircraftTableScrollPane.setViewportView(aircraftTable);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(aircraftTableScrollPane, gridBagConstraints);

        aircraftOperationsButton.setText("Aircraft Operations");
        aircraftOperationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                aircraftOperationsButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(aircraftOperationsButton);

        aircraftMaintenanceButton.setText("Aircraft Maintenance");
        aircraftMaintenanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                aircraftMaintenanceButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(aircraftMaintenanceButton);

        addAircraftButton.setText("Add Aircraft");
        addAircraftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                addAircraftButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(addAircraftButton);

        modifyAircraftButton.setText("Modify Aircraft");
        modifyAircraftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                modifyAircraftButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(modifyAircraftButton);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(10, 10, 20, 10);
        add(bottomPanel, gridBagConstraints);
    }

    //Switch to operations view on card layout when aircraft operations button is pressed
    //Gaining control of CardLayout by getting mainPanel from root frame
    private void aircraftOperationsButtonActionPerformed(ActionEvent evt) {
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
            int aircraftID = (Integer) aircraftTable.getValueAt(selectedRow, 0);
            operationsView.setAircraftID(aircraftID);
            //Switch to operationsView panel
            layout.show(mainPanel, "operationsView");
        } catch (IndexOutOfBoundsException e) {
            //If no aircraft is not selected in table, show error dialog
            JOptionPane.showMessageDialog(topPanel,
                    "Please select an aircraft", "Notice", JOptionPane.ERROR_MESSAGE);
        }

    }

    //Open  add aircraft dialog window when add aircraft button is pressed
    private void addAircraftButtonActionPerformed(ActionEvent evt) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        AddAircraftView addAircraftView = new AddAircraftView(frame, true);
        addAircraftView.setVisible(true);
        //Refresh all aircraft records in table when returning from dialog
        aircraftTable.setModel(aircraftDAO.selectAllAircraft());
        setupAircraftTable();
    }

    //Open modify aircraft window when modify aircraft button is pressed
    private void modifyAircraftButtonActionPerformed(ActionEvent evt) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        try {
            int selectedRow = aircraftTable.getSelectedRow();
            String ID = aircraftTable.getValueAt(selectedRow, 0).toString();
            String tailNumber = aircraftTable.getValueAt(selectedRow, 1).toString();
            String type = aircraftTable.getValueAt(selectedRow, 2).toString();
            String station = aircraftTable.getValueAt(selectedRow, 3).toString();
            String maxSpeed = aircraftTable.getValueAt(selectedRow, 4).toString();
            String maxAltitude = aircraftTable.getValueAt(selectedRow, 5).toString();
            String totalFlightHours = aircraftTable.getValueAt(selectedRow, 6).toString();
            //Maintenance Flag is automatically set and doesn't need to be passed to window
            String currentMaintHours = aircraftTable.getValueAt(selectedRow, 8).toString();
            String maintHoursThreshold = aircraftTable.getValueAt(selectedRow, 9).toString();
            String endOfServiceDate;
            //endOfServiceDate is sometimes null so we will use an empty string if it is
            //We also format the string correctly to MM/dd/yyyy
            try {
                endOfServiceDate = simpleDateFormat.format(aircraftTable.getValueAt(selectedRow, 10));
            } catch (NullPointerException | IllegalArgumentException expected) {
                endOfServiceDate = "";
            }
            //Create ModifyAircraftView JDialog instance and pass parameters
            ModifyAircraftView modifyAircraftView = new ModifyAircraftView(frame,
                    true, ID, tailNumber, type, station, maxSpeed, maxAltitude, totalFlightHours,
                    currentMaintHours, maintHoursThreshold, endOfServiceDate);

            modifyAircraftView.setVisible(true);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(topPanel,
                    "Please select an aircraft to modify", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        //Refresh all aircraft records in table when returning from dialog
        aircraftTable.setModel(aircraftDAO.selectAllAircraft());
        setupAircraftTable();

    }

    //Actions performed when search aircraft button is pressed
    private void searchAircraftButtonActionPerformed(ActionEvent evt) {
        aircraftDAO = new AircraftDAO();
        //If tail number radio butto is selected
        if (tailNumberRadioButton.isSelected()) {
            //Input validation
            if (!util.InputValidator.isAlphaNumeric10(tailNumberTextField.getText())) {
                JOptionPane.showMessageDialog(topPanel,
                        "Please enter letters and numbers only", "Notice", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //Search database and retrieve new table model from AircraftDAO
            aircraftTable.setModel(aircraftDAO.selectAircraftByTailnumber(
                    tailNumberTextField.getText().toUpperCase()));
            setupAircraftTable();
        }

        //If maintenance flag radio button is selected
        if (maintFlagRadioButton.isSelected()) {
            //Search database and retrieve new table model from AircraftDAO
            aircraftTable.setModel(aircraftDAO.selectAircraftByMaintFlag(
                    Boolean.parseBoolean(maintFlagComboBox.getSelectedItem().toString())));
            setupAircraftTable();
        }

        //If station radio butto is selected
        if (stationRadioButton.isSelected()) {
            //Search database and retrieve new table model from AircraftDAO
            Station station = (Station) stationComboBox.getSelectedItem();
            int stationID = station.getStationID();
            aircraftTable.setModel(aircraftDAO.selectAircraftByStation(stationID));
            setupAircraftTable();
        }
    }

    //Switch to maintenance view on card layout when aircraft maintenance button is pressed
    //Gaining control of CardLayout by getting mainPanel from root frame
    private void aircraftMaintenanceButtonActionPerformed(ActionEvent evt) {
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
            int aircraftID = (Integer) aircraftTable.getValueAt(selectedRow, 0);
            maintenanceView.setAircraftID(aircraftID);
            //Switch to maintenanceView panel
            layout.show(mainPanel, "maintenanceView");
        } catch (IndexOutOfBoundsException e) {
            //If no aircraft is not selected in table, show error dialog
            JOptionPane.showMessageDialog(topPanel, "Please select an aircraft",
                    "Notice", JOptionPane.ERROR_MESSAGE);
        }

    }

    //Change foreground to black of radio button is selected, gray if not.
    //This will help the user understand what is being searched
    private void tailNumberRadioButtonItemStateChanged(ItemEvent evt) {
        if (tailNumberRadioButton.isSelected()) {
            tailNumberTextField.setForeground(Color.BLACK);
        } else {
            tailNumberTextField.setForeground(Color.LIGHT_GRAY);
        }
    }

    //Change foreground to black of radio button is selected, gray if not.
    private void maintFlagRadioButtonItemStateChanged(ItemEvent evt) {
        //This will help the user understand what is being searched
        if (maintFlagRadioButton.isSelected()) {
            maintFlagComboBox.setForeground(Color.BLACK);
        } else {
            maintFlagComboBox.setForeground(Color.LIGHT_GRAY);
        }
    }

    //Change foreground to black of radio button is selected, gray if not.
    private void stationRadioButtonItemStateChanged(ItemEvent evt) {
        //This will help the user understand what is being searched
        if (stationRadioButton.isSelected()) {
            stationComboBox.setForeground(Color.BLACK);
        } else {
            stationComboBox.setForeground(Color.LIGHT_GRAY);
        }
    }

    //Change radio button selection when user clicks on combo box
    private void maintFlagComboBoxActionPerformed(ActionEvent evt) {
        maintFlagRadioButton.setSelected(true);
    }

    //Change radio button selection when user clicks on combo box
    private void stationComboBoxActionPerformed(ActionEvent evt) {
        stationRadioButton.setSelected(true);
    }

    //Change radio button selection when user clicks on text field
    private void tailNumberTextFieldMouseClicked(MouseEvent evt) {
        tailNumberRadioButton.setSelected(true);
    }

    //Change radio button selection when user clicks on maint flag combo box
    private void maintFlagComboBoxMouseClicked(MouseEvent evt) {
        maintFlagRadioButton.setSelected(true);
    }

    //Change radio button selection when user clicks on station combo box
    private void stationComboBoxMouseClicked(MouseEvent evt) {
        stationRadioButton.setSelected(true);
    }

    //Change radio button selection when user clicks on label
    private void tailNumberLabelMouseClicked(MouseEvent evt) {
        tailNumberRadioButton.setSelected(true);
    }

    //Change radio button selection when user clicks on label
    private void maintFlagLabelMouseClicked(MouseEvent evt) {
        maintFlagRadioButton.setSelected(true);
    }

    //Change radio button selection when user clicks on label
    private void stationLabelMouseClicked(MouseEvent evt) {
        stationRadioButton.setSelected(true);
    }

    //Perform search when enter key is pressed in text field
    private void tailNumberTextFieldActionPerformed(ActionEvent evt) {
        searchAircraftButton.doClick();
    }

    //Show all aircraft records in table
    private void showAllButtonActionPerformed(ActionEvent evt) {
        aircraftTable.setModel(aircraftDAO.selectAllAircraft());
        setupAircraftTable();
    }

    //Modifies aircraftTable to adjust columns correctly for display
    private void setupAircraftTable() {
        //Hide first column - ID
        aircraftTable.getColumnModel().getColumn(0).setMinWidth(0);
        aircraftTable.getColumnModel().getColumn(0).setMaxWidth(0);
        aircraftTable.getColumnModel().getColumn(0).setWidth(0);
        //Set 3rd column min width - Station
        aircraftTable.getColumnModel().getColumn(3).setMinWidth(130);

        //Change date format for column 10 to MM/dd/yyyy format
        TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof Date) {
                    value = simpleDateFormat.format(value);
                }
                return super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
            }
        };
        aircraftTable.getColumnModel().getColumn(10).setCellRenderer(tableCellRenderer);

        //Set noRecordsLabel if there are no records in the table
        if (aircraftTable.getModel().getRowCount() == 0) {
            noRecordsLabel.setText("No Records Found");
        } else {
            noRecordsLabel.setText("");
        }

    }

    private void tailNumberLabelMouseEntered(MouseEvent evt) {
        tailNumberLabel.setToolTipText("Select this option to search Aircraft by Tail Number");
    }

    private void maintFlagLabelMouseEntered(MouseEvent evt) {
        maintFlagLabel.setToolTipText("Select this option to search Aircraft by Maintenance Flag");
    }

    private void stationLabelMouseEntered(MouseEvent evt) {
        stationLabel.setToolTipText("Select this option to search Aircraft by Station");
    }

    //Allows refreshing table when hitting back button on other views
    public void refreshAircraftTable() {
        showAllButton.doClick();
    }

}
