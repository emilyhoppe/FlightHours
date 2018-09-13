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

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InputValidator {

    //Validate that a string contains only letters and numbers
    public static Boolean isAlphaNumeric(String text) {
        return text.matches("^[a-zA-Z0-9]+$");
    }

    //Validate that a string contains only numbers and is <+ 9 digits
    public static Boolean isPositiveNumber(String text) {
        return text.matches("^[0-9]+$") && text.length() <= 9;
    }

    //Validate that a string is valid as a date in MM/DD/YYYY format
    public static Boolean isValidDate(String text) {
        //First validate string to make sure user entered a 4 digit year
        //SimpleDateFormat will parse a 2 digit year 12 as 0012
        if (text.matches("^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}$")) {
            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            //This causes dates with more than 12 months to fail instead of rollover
            df.setLenient(false);
            try {
                df.parse(text);
                return true;
            } catch (ParseException expected) {
                return false;
            }
        } else {
            return false;
        }
    }

}
