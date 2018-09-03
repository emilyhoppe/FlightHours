/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthours;

import javax.swing.SwingUtilities;
import view.MainFrame;

/**
 *
 * @author jgrimard
 */
public class FlightHours {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here, etc, etc
        System.out.println("Hello Team!");
        System.out.println("Welcome to CMSC495 FlightHours on GitHub!");

        //Start GUI, this is needed to avoid unresponsive GUI on slow tasks
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });

        //Read in Test Data File (Edited by Emily)
        System.out.println("Printing Test Data from AircraftTestData.txt");
        ReadData test = new ReadData();
        test.checkDataFormat();
        test.printData();
    }

    //Create applicaiton frame and set it to visible
    private static void createAndShowGUI() {
        MainFrame mainView = new MainFrame();
        mainView.setVisible(true);
    }

}
