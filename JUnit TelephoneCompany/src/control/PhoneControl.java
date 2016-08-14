package control;

import entity.PhoneCall_Calculator;
import entity.RandomCall;
import entity.Validator;

/**
 *
 * @author Simon
 */
public class PhoneControl  {

    public static final String OK = Validator.OK+Validator.OK; //using the Validator OK value to initialize variable here. That way GUI need not know Validator class at all.
    private PhoneCall_Calculator pc_Calculator;
    
    public PhoneControl(){
        pc_Calculator = new PhoneCall_Calculator();
    }

    public String validateUserInfo(String startTime, String duration){
        return Validator.checkDate(startTime) + Validator.checkDuration(duration);
    }
    
    public String getCalculatedCall(String date, String duration) throws IllegalArgumentException {
        return pc_Calculator.getCalculatedCall(date, duration);
    }
    
    public String getRandomStartTime(){
        return RandomCall.getRandomStartTime();
    }

    public String getRandomDuration(){
        return RandomCall.getRandomDuration();
    }
}
