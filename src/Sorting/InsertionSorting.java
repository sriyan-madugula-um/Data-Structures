package Sorting;

import java.util.Arrays;

public class InsertionSorting { //store each element in temp, check if elements to the left are greater, if so --> shift those elements right and put temp into empty space
    public static void main(String[] args) {
        int[] array = {6, 1, 7, 4, 2, 9, 8, 5, 3};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int open = i; //because it might need to be placed back exactly where it came from, so open could stay same

            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > temp) {
                    open = j; //open space for temp to be placed back
                    array[j + 1] = array[j]; //element moves right
                }
            }

            array[open] = temp; //temp gets placed into open space
        }
    }
}
