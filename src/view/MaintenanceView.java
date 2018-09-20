/** **********
 *
 *      Class:         MaintenanceView.java
 *      Package:       view
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: MaintenanceView is a GUI view class which extends JPanel.
 *          A table with aircraft maintenance events will be provided, showing all
 *          maintenance events related to the previously selected aircraft.  The
 *          user can select a maintenance event from the table and click Add Maintenance
 *          or Modify Maintenance to open input dialog boxes.  A Back button is provided
 *          which will switch the card layout back to the Aircraft Search view.
 *
 *
 *********** */
package view;

import controller.MaintenanceDAO;
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

public class MaintenanceView extends javax.swing.JPanel {

    //Instance variables
    MaintenanceDAO maintenanceDAO = new MaintenanceDAO();
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
        maintenanceTable.setModel(maintenanceDAO.selectMaintenanceByAircraft(aircraftID));
        setupMaintenanceTable();
    }

    //Constructor
    public MaintenanceView() {
        this.simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        initComponents();
    }

    //Initialize all Swing components and place them in the JPanel using GridBag layout
    private void initComponents() {//GEN-BEGIN:initComponents
        GridBagConstraints gridBagConstraints;

        logoLabel = new JLabel();
        titleLabel = new JLabel();
        topPanel = new JPanel();
        tailNumberLabel = new JLabel();
        tailNumberTextField = new JTextField(tailNumber);
        maintenanceTableScrollPane = new JScrollPane();
        maintenanceTable = new JTable();
        bottomPanel = new JPanel();
        backButton = new JButton();
        addMaintenanceButton = new JButton();
        modifyMaintenanceButton = new JButton();

        setLayout(new GridBagLayout());

        logoLabel.setIcon(new ImageIcon(getClass().getResource("/view/Logo.png"))); // NOI18N
        logoLabel.setName(""); // NOI18N
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(20, 10, 10, 10);
        add(logoLabel, gridBagConstraints);

        titleLabel.setFont(new Font("Arial", 1, 36)); // NOI18N
        titleLabel.setText("Aircraft Maintenance");
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

        maintenanceTable.setAutoCreateRowSorter(true);
        maintenanceTable.setModel(maintenanceDAO.selectMaintenanceByAircraft(aircraftID));
        setupMaintenanceTable();
        maintenanceTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        maintenanceTableScrollPane.setViewportView(maintenanceTable);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(maintenanceTableScrollPane, gridBagConstraints);

        backButton.setText("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(backButton);

        addMaintenanceButton.setText("Add Maintenance");
        addMaintenanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addMaintenanceButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(addMaintenanceButton);

        modifyMaintenanceButton.setText("Modify Maintenance");
        modifyMaintenanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                modifyMaintenanceButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(modifyMaintenanceButton);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(10, 10, 20, 10);
        add(bottomPanel, gridBagConstraints);
    }//GEN-END:initComponents

    private void backButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        //Switch to aircraft view on card layout when aircraft back button is pressed
        //Gaining control of CardLayout by getting mainPanel from root frame
        Component component = (Component) evt.getSource();
        MainFrame frame = (MainFrame) SwingUtilities.getRoot(component);
        MainPanel mainPanel = frame.getMainPanel();
        CardLayout layout = (CardLayout) mainPanel.getLayout();
        layout.show(mainPanel, "aircraftView");
    }//GEN-LAST:event_backButtonActionPerformed

    private void addMaintenanceButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_addMaintenanceButtonActionPerformed
        // TODO add your handling code here:
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        AddMaintenanceView addMaintenanceView = new AddMaintenanceView(frame, true, tailNumber);
        addMaintenanceView.setVisible(true);
        //Refresh all maintenance records in table when returning from dialog
        maintenanceTable.setModel(maintenanceDAO.selectMaintenanceByAircraft(aircraftID));
        setupMaintenanceTable();
    }//GEN-LAST:event_addMaintenanceButtonActionPerformed

    private void modifyMaintenanceButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_modifyMaintenanceButtonActionPerformed
        //Open modify maintenance window when modify maintenance button is pressed
        //Retrieve selected table row and pass all data to new window
        //Dates will be formatted to MM/dd/yyyy
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        try {
            int selectedRow = maintenanceTable.getSelectedRow();
            String maintenanceID = maintenanceTable.getValueAt(selectedRow, 0).toString();
            String startDate = simpleDateFormat.format(maintenanceTable.getValueAt(selectedRow, 2));
            String endDate = simpleDateFormat.format(maintenanceTable.getValueAt(selectedRow, 3));
            String description = maintenanceTable.getValueAt(selectedRow, 4).toString();
            ModifyMaintenanceView modifyMaintenanceView = new ModifyMaintenanceView(frame,
                    true, tailNumber, maintenanceID, startDate, endDate, description);

            modifyMaintenanceView.setVisible(true);
            //Refresh all maintenance records in table when returning from dialog
            maintenanceTable.setModel(maintenanceDAO.selectMaintenanceByAircraft(aircraftID));
            setupMaintenanceTable();
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(topPanel, "Please select a maintenance event to modify", "Notice", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_modifyMaintenanceButtonActionPerformed

    //Modifies maintenanceTable to adjust columns correctly for display
    private void setupMaintenanceTable() {
        //Hide ID column in table but still allow application access to it
        maintenanceTable.getColumnModel().getColumn(0).setMinWidth(0);
        maintenanceTable.getColumnModel().getColumn(0).setMaxWidth(0);
        maintenanceTable.getColumnModel().getColumn(0).setWidth(0);
        maintenanceTable.getColumnModel().getColumn(1).setMinWidth(0);
        maintenanceTable.getColumnModel().getColumn(1).setMaxWidth(0);
        maintenanceTable.getColumnModel().getColumn(1).setWidth(0);
        //Adjust date colums smaller so description column can be wide
        maintenanceTable.getColumnModel().getColumn(2).setMaxWidth(100);
        maintenanceTable.getColumnModel().getColumn(3).setMaxWidth(100);

        //Change date format for columns 2 and 3 to MM/dd/yyyy format
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
        maintenanceTable.getColumnModel().getColumn(2).setCellRenderer(tableCellRenderer);
        maintenanceTable.getColumnModel().getColumn(3).setCellRenderer(tableCellRenderer);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton addMaintenanceButton;
    private JButton backButton;
    private JPanel bottomPanel;
    private JLabel logoLabel;
    private JTable maintenanceTable;
    private JScrollPane maintenanceTableScrollPane;
    private JButton modifyMaintenanceButton;
    private JLabel tailNumberLabel;
    private JTextField tailNumberTextField;
    private JLabel titleLabel;
    private JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
