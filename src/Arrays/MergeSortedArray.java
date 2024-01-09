package Arrays;

import java.util.*;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {2,3,7,11,0,0,0};
        int m = 4;
        int[] nums2 = {1,6,9};
        int n = 3;
        mergeArray(nums1, nums2, m, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void mergeArray(int[] nums1, int[] nums2, int m, int n) {
        int i = m - 1; //final index of nums1 without 0's
        int j = n - 1; //final index nums2
        int k = m + n - 1; //final index of altered nums1

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        /*
        if(j != -1) {
            for(int o = 0; o <= j; o++) {
                nums1[o] = nums2[o];
            }
        }
        */
        while(j >= 0) {
            nums1[j] = nums2[j];
            j--;
        }
    }

    public static void mergeArray2(int[] nums1, int[] nums2, int m, int n) {
        int one = n;
        int two = 0;
        while (one < m + n && two < n) { // O(n)
            nums1[one] = nums2[two];
            one++;
            two++;
        }

        Arrays.sort(nums1); // O((m+n) log(m+n))
    }
}
