package Sorting;

import java.util.Arrays;

public class BubbleSorting { //compare each number to one after, and so on
    public static void main(String[] args) {
        int[] array = {1, 8, 9, 2, 7, 3, 6, 4, 5};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));

    }

    public static void bubbleSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        boolean sorted = true;
        for (int i = 0; i < array.length - 1; i++) { //this for loop can also be iterated n number of times, which would get rid of recursion
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                sorted = false; //a swap was made, so we'll need to check at least one more time to see if it's sorted
            }
            if (i == array.length - 2 && sorted) { //i reaches last index and no swaps were made
                return;
            }
        }
        bubbleSort(array);
    } //Code 1

    /*private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

    }*/ //Code 2

//Recursion itself does not inherently increase execution time. It is possible for a recursive implementation to be more efficient than an iterative one in certain scenarios.
//The choice between recursion and iteration depends on the specific problem and how it can be efficiently solved using either approach.

//In the case of Code 1 and Code 2, both have the same worst-case time complexity of O(n^2) for bubble sort.
//However, Code 2 (iterative implementation) typically has lower constant factors and is more straightforward in terms of execution.
//It does not involve the overhead of recursive function calls and stack operations.

//While Code 1 (recursive implementation) includes an optimization to terminate early if the array is already sorted, this improvement may not significantly impact the overall execution time in practice.
//The worst-case scenario still dominates the time complexity analysis, where both implementations have the same complexity.

//Therefore, if we consider the typical or worst-case scenarios, Code 2 is often preferred due to its simpler implementation and potentially better performance in terms of execution time.
//However, if you have specific knowledge about the input data and expect many partially sorted arrays, Code 1 could provide some performance benefits.
//It ultimately depends on the specific requirements and characteristics of the problem you are trying to solve.
}
