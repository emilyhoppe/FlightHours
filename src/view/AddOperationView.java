/** **********
 *
 *      Class:         AddOperationView.java
 *      Package:       view
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: AddOperationView is a GUI view class which extends JDialog.
 *              It provides text fields and combo boxes for the user to add a new
 *              aircraft operations to the database.  When a user clicks the Add
 *              Operation button, the inputs will be validated and inserted in
 *              the database.
 *
 *
 *********** */
package view;

import controller.MissionDAO;
import controller.OperationDAO;
import controller.StationDAO;
import model.Mission;
import model.Operation;
import model.Station;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import util.InputValidator;

public class AddOperationView extends javax.swing.JDialog {

    //Instance variables
    private final Frame parent;
    private final int aircraftID;
    private final String tailNumber;
    private final SimpleDateFormat simpleDateFormat;
    private final Date currentDate;
    private JButton addOperationButton;
    private JButton cancelButton;
    private JLabel endDateLabel;
    private JTextField endDateTextField;
    private JLabel flightHoursLabel;
    private JTextField flightHoursTextField;
    private JPanel innerBottomPanel;
    private JPanel innerMiddlePanel;
    private JComboBox missionComboBox;
    private JLabel missionLabel;
    private JLabel operationNameLabel;
    private JTextField operationNameTextField;
    private JPanel outerPanel;
    private JLabel startDateLabel;
    private JTextField startDateTextField;
    private JComboBox stationComboBox;
    private JLabel stationLabel;
    private JLabel tailNumberLabel;
    private JTextField tailNumberTextField;
    private JLabel titleLabel;

    //Constructor with parameters
    public AddOperationView(Frame parent, boolean modal, int aircraftID, String tailNumber) {
        super(parent, modal);
        this.parent = parent;
        this.aircraftID = aircraftID;
        this.tailNumber = tailNumber;
        simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        currentDate = new Date();
        initComponents();
        //Set add operation button to respond to enter key
        SwingUtilities.getRootPane(addOperationButton).setDefaultButton(addOperationButton);
    }

    //Initialize all Swing components and place them in the JDialog using GridBag layout
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        outerPanel = new JPanel();
        titleLabel = new JLabel();
        innerMiddlePanel = new JPanel();
        tailNumberLabel = new JLabel();
        operationNameLabel = new JLabel();
        stationLabel = new JLabel();
        missionLabel = new JLabel();
        startDateLabel = new JLabel();
        endDateLabel = new JLabel();
        flightHoursLabel = new JLabel();
        tailNumberTextField = new JTextField(tailNumber);
        operationNameTextField = new JTextField();
        StationDAO stationDAO = new StationDAO();
        stationComboBox = new JComboBox<>(stationDAO.selectStationByType("USBP").toArray());
        MissionDAO missionDAO = new MissionDAO();
        missionComboBox = new JComboBox<>(missionDAO.selectAllMissions().toArray());
        startDateTextField = new JTextField(simpleDateFormat.format(currentDate));
        endDateTextField = new JTextField(simpleDateFormat.format(currentDate));
        flightHoursTextField = new JTextField();
        innerBottomPanel = new JPanel();
        addOperationButton = new JButton();
        cancelButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Operation");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new GridBagLayout());

        outerPanel.setLayout(new GridBagLayout());

        titleLabel.setFont(new Font("Tahoma", 1, 18));
        titleLabel.setText("Add Operation");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        outerPanel.add(titleLabel, gridBagConstraints);

        innerMiddlePanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        innerMiddlePanel.setToolTipText("");
        innerMiddlePanel.setLayout(new GridBagLayout());

        tailNumberLabel.setText("Tail Number");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(tailNumberLabel, gridBagConstraints);

        operationNameLabel.setText("Operation Name");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(operationNameLabel, gridBagConstraints);

        stationLabel.setText("USBP Station");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(stationLabel, gridBagConstraints);

        missionLabel.setText("Mission");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(missionLabel, gridBagConstraints);

        startDateLabel.setText("Start Date");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(startDateLabel, gridBagConstraints);

        endDateLabel.setText("End Date");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(endDateLabel, gridBagConstraints);

        flightHoursLabel.setText("Flight Hours");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(flightHoursLabel, gridBagConstraints);

        tailNumberTextField.setEditable(false);
        tailNumberTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(tailNumberTextField, gridBagConstraints);

        operationNameTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(operationNameTextField, gridBagConstraints);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(stationComboBox, gridBagConstraints);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(missionComboBox, gridBagConstraints);

        startDateTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(startDateTextField, gridBagConstraints);

        endDateTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(endDateTextField, gridBagConstraints);

        flightHoursTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(flightHoursTextField, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new Insets(15, 0, 15, 0);
        outerPanel.add(innerMiddlePanel, gridBagConstraints);

        innerBottomPanel.setLayout(new GridBagLayout());

        addOperationButton.setText("Add Operation");
        addOperationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                addOperationButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerBottomPanel.add(addOperationButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerBottomPanel.add(cancelButton, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        outerPanel.add(innerBottomPanel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(30, 30, 30, 30);
        getContentPane().add(outerPanel, gridBagConstraints);

        pack();
        //Make dialog appear in canter of parent frame
        setLocationRelativeTo(parent);
    }

    //Method variables
    private void addOperationButtonActionPerformed(ActionEvent evt) {
        Operation operation;
        OperationDAO operationDAO;
        String operationName = "";
        Station station;
        int stationID;
        Mission mission;
        int missionID;
        Date startDate = null;
        Date endDate = null;
        int flightHours;

        //Validate all user input
        if (operationNameTextField.getText().length() > 20) {
            JOptionPane.showMessageDialog(outerPanel, "Operation Name must be 20 characters or less",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!util.InputValidator.isValidDate(startDateTextField.getText())) {
            JOptionPane.showMessageDialog(outerPanel,
                    "Start Date is invalid\n"
                    + "Please use format MM/DD/YYYY\n",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!util.InputValidator.isValidDate(endDateTextField.getText())) {
            JOptionPane.showMessageDialog(outerPanel,
                    "End Date is invalid\n"
                    + "Please use format MM/DD/YYYY\n",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!InputValidator.isPositiveNumber(flightHoursTextField.getText())) {
            JOptionPane.showMessageDialog(outerPanel, "Flight hours input is invalid",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Retrieve validated user input
        operationName = operationNameTextField.getText();
        station = (Station) stationComboBox.getSelectedItem();
        stationID = station.getStationID();
        mission = (Mission) missionComboBox.getSelectedItem();
        missionID = mission.getMissionID();
        //Parse user entered dates into Date objects
        try {
            startDate = simpleDateFormat.parse(startDateTextField.getText());
            endDate = simpleDateFormat.parse(endDateTextField.getText());
        } catch (ParseException ex) {
            //Dates are already validated
        }
        flightHours = Integer.parseInt(flightHoursTextField.getText());

        //Validate that start date is before end date
        if (startDate.after(endDate)) {
            JOptionPane.showMessageDialog(outerPanel,
                    "Start date must be before end date",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Create new Operation instance
        operation = new Operation(aircraftID, stationID, missionID, operationName,
                startDate, endDate, flightHours);
        //Insert maintenance instance into database by calling DAO object
        operationDAO = new OperationDAO();
        int success = operationDAO.insertNewOperation(operation);
        //Give user feedback
        if (success != 1) {
            JOptionPane.showMessageDialog(outerPanel,
                    "Failed to add operation",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Close window
        dispose();
    }

    //Cancel adding operations and close window
    private void cancelButtonActionPerformed(ActionEvent evt) {
        dispose();
    }
}
