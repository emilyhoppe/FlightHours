/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthours;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author emily
 */
public class ReadData {

    private Scanner scanner;
    private Scanner line;
    private String type;
    private ArrayList<Aircraft> aircrafts = new ArrayList<>();
    //private ArrayList<Operation> operations = new ArrayList<>();
    //private ArrayList<Maintenance> maintenances = new ArrayList<>();

    public ReadData() {
        InputStream in = getClass().getResourceAsStream("AircraftTestData.txt");
        scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
    }

    public void checkDataFormat() {
        while (scanner.hasNextLine()) {
            line = new Scanner(scanner.nextLine());
            line.useDelimiter("\t");
            if (line.hasNext()) {
                type = line.next();
            }
            switch (type) {
                case "aircraft":
                    aircrafts.add(new Aircraft(line));
                /*case "maintenance":
                        maintenances.add(new Maintenance(line));
                    case "operation":
                        operations.add(new Operation(line));                    
                        break;*/
                default:
                    break;
            }
        }
    }

    public void printData() {
        for (Aircraft a : aircrafts) {
            System.out.println(a);
        }
    }

    public void addToDatabase() {

    }

}
