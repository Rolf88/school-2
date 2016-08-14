package entity;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The class works through its primary method getCalculatedCall().
 * This method sets all the variables it needs in order to perform the 
 * actual price caculation, then it calculates the price and finally 
 * returns the toString() method string. 
 * 
 * This string can be retrieved later on until another call to getCalculatedCall()
 * is made.
 * @author Simon
 */
public class PhoneCall_Calculator
{
    /* Constants and Variables: 
       The constants are used to calculate the price.
       The variables are set with each call of the public method calculatePrice(...).       
       They are used by the various calculate methods and the toString() method.
       The toString() method can be used for re-access to the information
       until a new call to getCalculatedCall() is made.
    */    
    //CONSTANTS:
    private final float taxPercentage = 1.04f;  //The tax
    private final float pricePrMinute = 0.4f;   //The price per minute
    private final float durationDiscount = 0.85f; //The discoutn 15% on long call above 60 minutes.
    private final int durationDiscountTime = 60;  //The time until a call gets a discount.
    private final int fullDiscountStartTime = 18; //The time were day and night is separated: Evening 
    private final int zeroDiscountStartTime = 8;  //The time were day and night is separated: Morning 
    private final int discount = 2;  //The discount is 50% or ½
    
    //Variables:
    private boolean isDurationDiscountTrue = false; //set true if the call gets a discount
    private Date time;  //Repressents the acutal time of day
    private int duration; //The dureation of the call in minutes
    private float netCost;  //The net cost after tax and rebates have been applied
    private float grossCost;  //The cost before any discounts or tax is applied
    private boolean isDay;  //String containing day or night
    private String long_short; //String containing long call, 15% discount, or short call.

    
    
    public String getCalculatedCall( String inTime, String inDuration ) 
    {
        /* Setting variables/instances needed for price calculations 
           1: The Date time:  */
        SimpleDateFormat format = new SimpleDateFormat("HHmm");
        try   { this.time = format.parse( inTime );  } 
        catch ( ParseException e      ) 
              { e.printStackTrace();  }
        
        // 2) The duration:
        try  {  this.duration = Integer.parseInt(inDuration); }
        catch(  NumberFormatException e) 
             {  e.printStackTrace();   }
        
        /*Now calculating the price and returning it  */
        initiatingVariables();
        calculatePrice();
        return toString();
    }

    /* The method start up and sets variables used for the calculation.  */
    private void initiatingVariables()
    {
       isDurationDiscountTrue = duration >= durationDiscountTime;  //wether or not its a long call that gets a durations discount
       if   ( isDurationDiscountTrue ) 
            { long_short = "Short";  }
       else { long_short = "Long"; }
       //Setting day or night:
       if   ( time.getHours() >= fullDiscountStartTime || time.getHours() < zeroDiscountStartTime) 
            { isDay = true;  }
       else { isDay = false; }   
       //Calculating the gross cost of the call, which is simply the duration times pricePerMinute
       grossCost = duration * pricePrMinute;
    }
        
    /* The actual calculation of the price. All variables must be set before calling this method!   */
    private void calculatePrice()
    {
        /* There are 4 different ways (Equivalent classes) of calculating the price:
           1) Day, short
           2) Day, long
           3) Night, short
           4) Night, long
        */
        if ( isDay ) 
        {           
            if   ( isDurationDiscountTrue ) 
                 { netCost = ((duration * pricePrMinute) / discount) * durationDiscount ; } //1)              
            else { netCost =   duration * pricePrMinute / discount  ;                     } //2)
        } 
        else 
        {            
            if   ( isDurationDiscountTrue) 
                 { netCost = (duration * pricePrMinute) * durationDiscount ; } //3)
            else { netCost =  duration * pricePrMinute  ;                    } //4)
        }
        
        //Finally adding tax:
        netCost = netCost * taxPercentage;
    }
    
    @Override
    public String toString()
    {
        //Creating string for day/night depending on isDay value:
        String dayString = isDay ? "Day" : "Night";
        //Rounding of with 2 decimals after comma:
        DecimalFormat decFormat = new DecimalFormat("#,00");
        float netCost_round = new Float(decFormat.format(netCost)).floatValue();
        float grossCost_round = new Float(decFormat.format(grossCost)).floatValue();

        //Putting beutiful string to gether for the user to marvel at:
        return    "Net cost: \t"     + netCost_round   + " $\n"
                + "Gross cost: \t "  + grossCost_round + " $\n"
                + "\n"                
                + "Day/Night call: \t" + dayString    + " \n"
                + "Discount,15%: \t" + isDurationDiscountTrue ;
    }

    public int getDuration()
    {
        return duration;
    }

    public float getNetCost()
    {
        return netCost;
    }

    public float getGrossCost()
    {
        return grossCost;
    }

    public void setTime(Date time)
    {
        this.time = time;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

}
