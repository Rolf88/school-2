package controllerasync;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RolfMoikjær
 */
public class ControllerAsync extends Thread {

    private String msg = "Hello";
    List<DemoObserver> observers = new ArrayList();
    private boolean keepRunning = true;
    
    public void registerObserver(DemoObserver o) {
        observers.add(o);
    }

    private void notifyObservers(String msg) {
        for (DemoObserver o : observers) {
            o.dataReady(msg);
        }
    }

    @Override
    public void run() {
        int count = 0;
        while (keepRunning) {
            try {
                Thread.sleep(10000);
                notifyObservers(msg+count++);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControllerAsync.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getMsg() {
        return msg;
    }

}
