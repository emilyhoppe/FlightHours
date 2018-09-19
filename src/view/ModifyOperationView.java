/** **********
 *
 *      Class:         ModifyOperationView.java
 *      Package:       view
 *      Date:          October 14, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: ModifyOperationView is a GUI view class which extends JDialog.
 *              It provides text fields and combo boxes for the user to modify
 *              existing operations in the database.  When a user clicks the Modify 
 *              Operation button, the inputs will be validated and updated in 
 *              the database.
 *
 *
 *********** */
package view;

import controller.MissionDAO;
import controller.StationDAO;
import flighthours.Mission;
import flighthours.Station;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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

public class ModifyOperationView extends javax.swing.JDialog {

    //Instance variables
    private String tailNumber;
    private String operationID;
    private String name;
    private String station;
    private String mission;
    private String startDate;
    private String endDate;
    private String flightHours;

    //Constructor with parameters
    public ModifyOperationView(java.awt.Frame parent, boolean modal,
            String tailNumber, String operationID, String name,
            String station, String mission, String startDate,
            String endDate, String flightHours) {
        super(parent, modal);
        this.tailNumber = tailNumber;
        this.operationID = operationID;
        this.name = name;
        this.station = station;
        this.mission = mission;
        this.startDate = startDate;
        this.endDate = endDate;
        this.flightHours = flightHours;
        initComponents();
        //Make dialog appear in canter of parent frame
        setLocationRelativeTo(parent);
        //Set modify operation button to respond to enter key
        SwingUtilities.getRootPane(modifyOperationButton).setDefaultButton(modifyOperationButton);
    }
    
    //Initialize all Swing components and place them in the JDialog using GridBag layout
    private void initComponents() {//GEN-BEGIN:initComponents
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
        operationNameTextField = new JTextField(name);
        int stationComboBoxIndex = -1;
        StationDAO stationDAO = new StationDAO();
        List<Station> stationArrayList = new ArrayList<>(stationDAO.selectStationByType("USBP"));
        //Find selected index to use for station combo box
        stationComboBoxIndex = -1;
        for(Station currentStation : stationArrayList){
            stationComboBoxIndex++;
            if(currentStation.getStationName().equals(station)){
                break;
            }
        }
        Station[] stationArray = stationArrayList.toArray(new Station[0]);
        stationComboBox = new JComboBox<>(stationArray);
        int missionComboBoxIndex;
        MissionDAO missionDAO = new MissionDAO();
        List<Mission> missionArrayList = new ArrayList<>(missionDAO.selectAllMissions());
        //Find selected index to use for station combo box
        missionComboBoxIndex = -1;
        for(Mission currentMission : missionArrayList){
            missionComboBoxIndex++;
            if(currentMission.getMissionName().equals(mission)){
                break;
            }
        }
        Mission[] missionArray = missionArrayList.toArray(new Mission[0]);
        missionComboBox = new JComboBox<>(missionArray);
        startDateTextField = new JTextField(startDate);
        endDateTextField = new JTextField(endDate);
        flightHoursTextField = new JTextField(flightHours);
        innerBottomPanel = new JPanel();
        modifyOperationButton = new JButton();
        cancelButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modify Operation");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new GridBagLayout());

        outerPanel.setLayout(new GridBagLayout());

        titleLabel.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        titleLabel.setText("Modify Operation");
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

        stationLabel.setText("Station");
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

        stationComboBox.setSelectedIndex(stationComboBoxIndex);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerMiddlePanel.add(stationComboBox, gridBagConstraints);

        missionComboBox.setSelectedIndex(missionComboBoxIndex);
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

        modifyOperationButton.setText("Modify Operation");
        modifyOperationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                modifyOperationButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        innerBottomPanel.add(modifyOperationButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new ActionListener() {
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
        setLocationRelativeTo(null);
    }//GEN-END:initComponents

    private void modifyOperationButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_modifyOperationButtonActionPerformed
        //TODO Call SQL function
        //Temporarily show message box with values
        JOptionPane.showMessageDialog(outerPanel,
                "Modifying Operations Database record for aircraft tail number: " + tailNumberTextField.getText() + "\n"
                + "Operation ID: " + operationID + "\n"
                + "Operation Name: " + operationNameTextField.getText() + "\n"
                + "Station: " + stationComboBox.getSelectedItem() + "\n"
                + "Mission: " + missionComboBox.getSelectedItem()+ "\n"
                + "Start Date: " + startDateTextField.getText() + "\n"
                + "End Date: " + endDateTextField.getText() + "\n"
                + "Flight Hours: " + flightHoursTextField.getText(),
                "Notice", JOptionPane.PLAIN_MESSAGE);
        dispose();
    }//GEN-LAST:event_modifyOperationButtonActionPerformed

    private void cancelButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        //Cancel modifying operaiton and close window
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton cancelButton;
    private JLabel endDateLabel;
    private JTextField endDateTextField;
    private JLabel flightHoursLabel;
    private JTextField flightHoursTextField;
    private JPanel innerBottomPanel;
    private JPanel innerMiddlePanel;
    /*TODO REMOVE THIS LINE
    private javax.swing.JComboBox<String> missionComboBox;
    */
    private JComboBox missionComboBox;
    private JLabel missionLabel;
    private JButton modifyOperationButton;
    private JLabel operationNameLabel;
    private JTextField operationNameTextField;
    private JPanel outerPanel;
    private JLabel startDateLabel;
    private JTextField startDateTextField;
    /*TODO REMOVE THIS LINE
    private javax.swing.JComboBox<String> stationComboBox;
    */
    private JComboBox stationComboBox;
    private JLabel stationLabel;
    private JLabel tailNumberLabel;
    private JTextField tailNumberTextField;
    private JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
