package Sorting;

import java.util.Arrays;

public class QuickSorting { //pivot
    public static void main(String[] args) {
        int[] array = {2, 8, 4, 7, 1, 3, 9, 6, 5};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int start, int end) {

        if (end <= start) {
            return;
        }
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    public static int partition(int[] array, int start, int end) {

        //int pivot = end; //index of pivot

        int i = start - 1;
        int j = start;
        while (j < end) {
            if (array[j] < array[end]) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            j++;
        }
        i++;
        int temp = array[i];
        array[i] = array[end]; //can replace pivot with end because pivot starts at end
        array[end] = temp;

        return i;
    }

}
