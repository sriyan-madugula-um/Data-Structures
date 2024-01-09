package Sorting;

import java.util.Arrays;

public class SelectionSorting { //find minimum, place at front
    public static void main(String[] args) {
        int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int indexMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[indexMin]) {
                    indexMin = j;
                }
            }
            int temp = array[i];
            array[i] = array[indexMin];
            array[indexMin] = temp;
        }
    }
}
