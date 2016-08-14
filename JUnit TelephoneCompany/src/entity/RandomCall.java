
package entity;

import java.util.Random;

/**
 *
 * @author pelo
 */
public class RandomCall {

    
    public static String getRandomStartTime(){
        Random gen = new Random();
        int hour = gen.nextInt(24);
        int minut = gen.nextInt(61);
        return Integer.toString(hour) + Integer.toString(minut);
    }
    
    public static String getRandomDuration(){
        Random gen = new Random();
        int dur = gen.nextInt(1440);
        return Integer.toString(dur);
    }
    
    
}
