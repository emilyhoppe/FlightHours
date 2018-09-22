/** **********
 *
 *      Class:         AddMaintenanceView.java
 *      Package:       view
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: AddMaintenanceView is a GUI view class which extends JDialog.
 *              It provides text fields and combo boxes for the user to add a new
 *              maintenance event into the database.  When a user clicks the Add
 *              Maintenance button, the inputs will be validated and inserted in
 *              the database.
 *
 *
 *********** */
package view;

import controller.MaintenanceDAO;
import flighthours.Maintenance;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class AddMaintenanceView extends javax.swing.JDialog {

    //Instance variables
    private final Frame parent;
    private final String tailNumber;
    private final int aircraftID;
    private JButton addMaintenanceButton;
    private JButton cancelButton;
    private JLabel descriptionLabel;
    private JScrollPane descriptionScrollPane;
    private JTextArea descriptionTextArea;
    private JLabel endDateLabel;
    private JTextField endDateTextField;
    private JPanel innerBottomPanel;
    private JPanel innerMiddlePanel;
    private JPanel outerPanel;
    private JLabel startDateLabel;
    private JTextField startDateTextField;
    private JLabel tailNumberLabel;
    private JTextField tailNumberTextField;
    private JLabel titleLabel;

    //Constructor with parameters
    public AddMaintenanceView(Frame parent, boolean modal, int aircraftID, String tailNumber) {
        super(parent, modal);
        this.parent = parent;
        this.tailNumber = tailNumber;
        this.aircraftID = aircraftID;
        initComponents();
        //Set add maintenance button to respond to enter key
        SwingUtilities.getRootPane(addMaintenanceButton).setDefaultButton(addMaintenanceButton);
    }

    //Initialize all Swing components and place them in the JDialog using GridBag layout
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        outerPanel = new JPanel();
        titleLabel = new JLabel();
        innerMiddlePanel = new JPanel();
        tailNumberLabel = new JLabel();
        startDateLabel = new JLabel();
        endDateLabel = new JLabel();
        descriptionLabel = new JLabel();
        tailNumberTextField = new JTextField(tailNumber);
        startDateTextField = new JTextField();
        endDateTextField = new JTextField();
        descriptionScrollPane = new JScrollPane();
        descriptionTextArea = new JTextArea();
        innerBottomPanel = new JPanel();
        addMaintenanceButton = new JButton();
        cancelButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Maintenance");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new GridBagLayout());

        outerPanel.setLayout(new GridBagLayout());

        titleLabel.setFont(new Font("Tahoma", 1, 18));
        titleLabel.setText("Add Maintenance");
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

        startDateLabel.setText("Start Date");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(startDateLabel, gridBagConstraints);

        endDateLabel.setText("End Date");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(endDateLabel, gridBagConstraints);

        descriptionLabel.setText("Description");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(descriptionLabel, gridBagConstraints);

        tailNumberTextField.setEditable(false);
        tailNumberTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(tailNumberTextField, gridBagConstraints);

        startDateTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(startDateTextField, gridBagConstraints);

        endDateTextField.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(endDateTextField, gridBagConstraints);

        descriptionTextArea.setColumns(30);
        descriptionTextArea.setRows(5);
        descriptionTextArea.setTabSize(4);
        descriptionScrollPane.setViewportView(descriptionTextArea);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(descriptionScrollPane, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new Insets(15, 0, 15, 0);
        outerPanel.add(innerMiddlePanel, gridBagConstraints);

        innerBottomPanel.setLayout(new GridBagLayout());

        addMaintenanceButton.setText("Add Maintenance");
        addMaintenanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                addMaintenanceButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerBottomPanel.add(addMaintenanceButton, gridBagConstraints);

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

    private void addMaintenanceButtonActionPerformed(ActionEvent evt) {
        //Method variables
        Maintenance maintenance;
        MaintenanceDAO maintenanceDAO;
        SimpleDateFormat simpleDateFormat;
        Date startDate = null;
        Date endDate = null;
        String description = "";

        //Validate all user input
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

        if (descriptionTextArea.getText()
                .length() > 100) {
            JOptionPane.showMessageDialog(outerPanel,
                    "Description is too long \n It must be less than 100 characters",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Retrieve validated user input
        //Parse user entered dates into Date objects
        simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            startDate = simpleDateFormat.parse(startDateTextField.getText());
            endDate = simpleDateFormat.parse(endDateTextField.getText());
        } catch (ParseException ex) {
            //Dates are already validated
        }
        description = descriptionTextArea.getText();

        //Create new Maintenance instance
        maintenance = new Maintenance(aircraftID, startDate, endDate, description);

        //Insert maintenance instance into database by calling DAO object
        maintenanceDAO = new MaintenanceDAO();
        int success = maintenanceDAO.insertNewMaintenance(maintenance);
        //Give user feedback
        if (success != 1) {
            JOptionPane.showMessageDialog(outerPanel,
                    "Failed to add maintenance",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Close window
        dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        //Cancel adding maintenance record and close window
        dispose();
    }
}
