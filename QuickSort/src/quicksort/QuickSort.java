/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

/**
 *
 * @author RolfMoikjær
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void print(int[] list){
        for (int i = 0; i < list.length; i++) {
            System.out.printf("%2d: %4d\n", i, list[i]);
            
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] list = new int[] {3, 7, 8, 5, 2, 1, 9, 5, 4};
        QuickSortImpl.sort(list);
        
        print(list);
        
    }
    
}
