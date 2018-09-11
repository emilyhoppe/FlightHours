/** **********
 *
 *      Class:         InputValidator.java
 *      Package:       util
 *      Date:          September, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description: This static utility class contains methods to validate
 *                  user input entered into the GUI.
 *
 *********** */
package util;

public class InputValidator {

    //Validate that a string contains only letters and numbers
    public static Boolean isAlphaNumeric(String text) {
        return text.matches("^[a-zA-Z0-9]+$");
    }

    //Validate that a string contains only numbers
    public static Boolean isPositiveNumber(String text) {
        return text.matches("^[0-9]+$");
    }

}
