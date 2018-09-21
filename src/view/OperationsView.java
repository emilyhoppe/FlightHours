/** **********
 *
 *      Class:         OperationsView.java
 *      Package:       view
 *      Date:          October 14, 2018
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

import controller.OperationDAO;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class OperationsView extends javax.swing.JPanel {

    //Instance variables
    OperationDAO operationDAO = new OperationDAO();
    private String tailNumber;
    private int aircraftID;
    SimpleDateFormat simpleDateFormat;

    //Set tail number public method
    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
        tailNumberTextField.setText(tailNumber);
    }

    //Set aircraft ID public method
    public void setAircraftID(int aircraftID) {
        this.aircraftID = aircraftID;
        operationsTable.setModel(operationDAO.selectOperationsByAircraft(aircraftID));
        setupOperationsTable();
    }

    //Constructor
    public OperationsView() {
        this.simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        initComponents();
    }

    //Initialize all Swing components and place them in the JDialog using GridBag layout
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        logoLabel = new JLabel();
        titleLabel = new JLabel();
        topPanel = new JPanel();
        tailNumberLabel = new JLabel();
        tailNumberTextField = new JTextField();
        operationsTableScrollPane = new JScrollPane();
        operationsTable = new JTable();
        bottomPanel = new JPanel();
        backButton = new JButton();
        addOperationButton = new JButton();
        modifyOperationButton = new JButton();

        setLayout(new GridBagLayout());

        logoLabel.setIcon(new ImageIcon(getClass().getResource("/view/Logo.png"))); 
        logoLabel.setName(""); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(20, 10, 10, 10);
        add(logoLabel, gridBagConstraints);

        titleLabel.setFont(new Font("Arial", 1, 36)); 
        titleLabel.setText("Aircraft Operations");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(titleLabel, gridBagConstraints);

        topPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        topPanel.setLayout(new GridBagLayout());

        tailNumberLabel.setText("Tail Number");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        topPanel.add(tailNumberLabel, gridBagConstraints);

        tailNumberTextField.setEditable(false);
        tailNumberTextField.setColumns(10);
        tailNumberTextField.setMinimumSize(new Dimension(70, 20));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        topPanel.add(tailNumberTextField, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(topPanel, gridBagConstraints);

        operationsTable.setAutoCreateRowSorter(true);
        operationsTable.setModel(operationDAO.selectOperationsByAircraft(aircraftID));
        //Hide ID column in table but still allow application access to it
        operationsTable.getColumnModel().getColumn(0).setMinWidth(0);
        operationsTable.getColumnModel().getColumn(0).setMaxWidth(0);
        operationsTable.getColumnModel().getColumn(0).setWidth(0);
        operationsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        operationsTableScrollPane.setViewportView(operationsTable);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(operationsTableScrollPane, gridBagConstraints);

        backButton.setText("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(backButton);

        addOperationButton.setText("Add Operation");
        addOperationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addOperationButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(addOperationButton);

        modifyOperationButton.setText("Modify Operation");
        modifyOperationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                modifyOperationButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(modifyOperationButton);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(10, 10, 20, 10);
        add(bottomPanel, gridBagConstraints);
    }

    private void backButtonActionPerformed(ActionEvent evt) {
        //Switch to aircraft view on card layout when aircraft back button is pressed
        //Gaining control of CardLayout by getting mainPanel from root frame
        Component component = (Component) evt.getSource();
        MainFrame frame = (MainFrame) SwingUtilities.getRoot(component);
        MainPanel mainPanel = frame.getMainPanel();
        CardLayout layout = (CardLayout) mainPanel.getLayout();
        layout.show(mainPanel, "aircraftView");

    }

    private void addOperationButtonActionPerformed(ActionEvent evt) {
        //Open add operation window when add operaiton button is pressed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        AddOperationView addOperationView = new AddOperationView(frame, true, aircraftID,tailNumber);
        addOperationView.setVisible(true);
        //Refresh all operations records in table when returning from dialog
        operationsTable.setModel(operationDAO.selectOperationsByAircraft(aircraftID));
        setupOperationsTable();
    }

    private void modifyOperationButtonActionPerformed(ActionEvent evt) {
        //Open modify operation window when modify operation button is pressed
        //Retrieve selected table row and pass all data to new window
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        try {
            int selectedRow = operationsTable.getSelectedRow();
            int operationID = Integer.parseInt(operationsTable.getValueAt(selectedRow, 0).toString());
            int stationID = Integer.parseInt(operationsTable.getValueAt(selectedRow, 2).toString());
            int missionID = Integer.parseInt(operationsTable.getValueAt(selectedRow, 3).toString());
            String name = operationsTable.getValueAt(selectedRow, 4).toString();
            String station = operationsTable.getValueAt(selectedRow, 5).toString();
            String mission = operationsTable.getValueAt(selectedRow, 6).toString();
            String startDate = simpleDateFormat.format(operationsTable.getValueAt(selectedRow, 7));
            String endDate = simpleDateFormat.format(operationsTable.getValueAt(selectedRow, 8));
            String flightHours = operationsTable.getValueAt(selectedRow, 9).toString();
            ModifyOperationView modifyOperationView = new ModifyOperationView(frame,
                    true, aircraftID, tailNumber, operationID, stationID, missionID, name, station, mission, startDate,
                    endDate, flightHours);

            modifyOperationView.setVisible(true);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(topPanel, "Please select an operation to modify", "Notice", JOptionPane.ERROR_MESSAGE);
        }
        //Refresh all operations records in table when returning from dialog
        operationsTable.setModel(operationDAO.selectOperationsByAircraft(aircraftID));
        setupOperationsTable();
    }

    //Modifies maintenanceTable to adjust columns correctly for display
    private void setupOperationsTable() {
        //Hide ID columns in table but still allow application access to them
        operationsTable.getColumnModel().getColumn(0).setMinWidth(0);
        operationsTable.getColumnModel().getColumn(0).setMaxWidth(0);
        operationsTable.getColumnModel().getColumn(0).setWidth(0);
        operationsTable.getColumnModel().getColumn(1).setMinWidth(0);
        operationsTable.getColumnModel().getColumn(1).setMaxWidth(0);
        operationsTable.getColumnModel().getColumn(1).setWidth(0);
        operationsTable.getColumnModel().getColumn(2).setMinWidth(0);
        operationsTable.getColumnModel().getColumn(2).setMaxWidth(0);
        operationsTable.getColumnModel().getColumn(2).setWidth(0);
        operationsTable.getColumnModel().getColumn(3).setMinWidth(0);
        operationsTable.getColumnModel().getColumn(3).setMaxWidth(0);
        operationsTable.getColumnModel().getColumn(3).setWidth(0);

        //Change date format for columns 7 and 8 to MM/dd/yyyy format
        TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof Date) {
                    value = simpleDateFormat.format(value);
                }
                return super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
            }
        };
        operationsTable.getColumnModel().getColumn(7).setCellRenderer(tableCellRenderer);
        operationsTable.getColumnModel().getColumn(8).setCellRenderer(tableCellRenderer);
    }

    // Variables declaration - do not modify
    private JButton addOperationButton;
    private JButton backButton;
    private JPanel bottomPanel;
    private JLabel logoLabel;
    private JButton modifyOperationButton;
    private JTable operationsTable;
    private JScrollPane operationsTableScrollPane;
    private JLabel tailNumberLabel;
    private JTextField tailNumberTextField;
    private JLabel titleLabel;
    private JPanel topPanel;
    // End of variables declaration
}
