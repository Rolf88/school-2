/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ka.collectionsandalgorithms;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author RolfMoikjær
 */
public class Problem2 {
    
    public static void frec(int[] arr){
    Map<Integer, Integer> map = new HashMap();
    
        for (int number : arr) {
            Integer numberOfTimesInArr = 1;
            
            if(map.containsKey(number)){
                numberOfTimesInArr += map.get(number);
            }
            
            map.put(number, numberOfTimesInArr);
        }
        
        map.entrySet().stream().sorted((x, x1) -> Integer.compare(x.getKey(), x1.getKey()))
                .forEach(x -> System.out.printf("%2d | %2d\n", x.getKey(), x.getValue()));
        
        
    }
}
