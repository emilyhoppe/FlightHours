/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthours;
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
        MainFrame mainView = new MainFrame();
        mainView.setVisible(true);
        
        //Read in Test Data File (Edited by Emily)
        System.out.println("Printing Test Data from AircraftTestData.txt");
        ReadData test = new ReadData();
        test.checkDataFormat();
        test.printData();
    }
    
}
