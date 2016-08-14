/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsObserver;

import java.util.Observable;
import randomperson.RandomUser;

/**
 *
 * @author RolfMoikjær
 */
public class FetchRandomUserTask extends Observable implements Runnable{

    @Override
    public void run() {
        RandomUserControl ran = new RandomUserControl();
        
        RandomUser user = ran.fetchRandomUser();
        
        setChanged();
        notifyObservers(user);
    }
    
    
}
