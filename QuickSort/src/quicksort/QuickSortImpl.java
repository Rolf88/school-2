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
public class QuickSortImpl {

    public static void sort(int[] list) {

        sort(list, 0, list.length);
    }

    private static void swap(int[] list, int i, int j) {
        int t = list[i];
        list[i] = list[j];
        list[j] = t;
    }

    private static void sort(int[] list, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        if (end - start == 2) {
            if (list[end -1] < list[start]) {
                swap(list, start, end -1);
            }
            return;
        }
        int pivot = split(list, start, end);
        sort(list, start, pivot);
        sort(list, pivot + 1, end);

    }

    private static int split(int[] list, int start, int end) {
        int pivot = end - 1;
        int value = list[pivot];

        while(start < pivot){
            while (list[start] < value) {
                start++;
            }
            if(start == pivot){
                return pivot;
            }
            list[pivot] = list[start];
            list[start] = list[pivot-1];
            list[pivot-1] = value;
            pivot--;
        }
        return pivot;
    }
}
