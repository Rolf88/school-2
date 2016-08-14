package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pelo
 */
public class Validator
{

    public static final String OK = "OK"; // Used for the validation of user information
    
    /**
     * Checking to see if it is a valid date
     * @param date String must be in format of HHmm
     * @return OK if its a valid data, error message otherwise
     */
    public static String checkDate(String date) 
    {
        String res = OK;
        
        //Attempting to parse the HHmm to a Date format:
        SimpleDateFormat format = new SimpleDateFormat("HHmm");
        try { format.parse(date);  } 
        catch (ParseException e) 
        {      res = "Not a start time. Must be in HHmm format\n";  }
        
        return res;
    }

    /**
     * Checks to see if input is a valid call duration.
     * @param duration mm must be a positive integer greate than 0.
     * @return OK value or error message otherwise.
     */
    public static String checkDuration(String duration) 
    {
        String res = OK;
        int intDur = 0;
        //Case empty string:
        if (duration.isEmpty()) 
        {    res = "Duration cannot be empty\n";      }
        //Easter egg:
        if (duration.equals("TM")) 
        {   res = "Darth Exception said.. I am your Rootfolder! Programmer: NOOOO\n";   }
        //Case not number:
        try {  intDur = Integer.parseInt(duration);            } 
        catch (NumberFormatException e) 
        { res = "Only numbers are accepted\n";        }
        //Case negative call duration:
        if ( intDur <= 0 ) 
        {   res = "Durations must be positive and over 0\n";   }
        
       return res;
    }

}
