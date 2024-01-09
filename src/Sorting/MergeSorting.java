package Sorting;

import java.util.Arrays;

public class MergeSorting { //divide and sort and merge
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array) { //divide into halves (left and right)
        int length = array.length;
        if (length <= 1) {
            return;
        }
        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0;
        int j = 0;

        while (i < length) {
            if (i < middle) {
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
            i++;
        }

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    public static void merge(int[] leftArray, int[] rightArray, int[] array) { //sort the halves (left and right) back into original

        int length = array.length;

        int leftLength = leftArray.length;
        int rightLength = rightArray.length;

        int i = 0; //array index
        int l = 0; //leftArray index
        int r = 0; //rightArray index

        while (l < leftLength && r < rightLength) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }


        while (i < length) //leftArray or rightArray has been merged completely into array, but the other hasn't, so array still hasn't been sorted completely
        {
            if (r > l) //rightArray merged completely, left hasn't
            {
                array[i] = leftArray[l];
                l++;
                i++;
            } else { //leftArray merged completely, right hasn't
                array[i] = rightArray[r];
                r++;
                i++;
            }
        }

    }
}
