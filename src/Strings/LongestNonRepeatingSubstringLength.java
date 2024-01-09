package Strings;

import java.util.*;

public class LongestNonRepeatingSubstringLength { // sliding window, ascii
    public static void main(String[] args) {
        String str = "abcbda";
        System.out.println(longestNonRepeatingSubstring(str));
    }

    public static int longestNonRepeatingSubstring(String str) {
        int maxLength = Integer.MIN_VALUE;

        int left = 0;
        int right = 0;
        int len = str.length();
        int[] charsIndex = new int[128]; // Stores characters at the index of their ascii value (location) with most recent string index (value)
        Arrays.fill(charsIndex, -1);

        while (right < len) {
            if (charsIndex[str.charAt(right)] >= left) // A repeat char within the window beginning from left index is found.
                left = charsIndex[str.charAt(right)] + 1; // therefore, begin new sliding window by updating left index past where most recent right index was
            charsIndex[str.charAt(right)] = right; // update new char found in array or update repeat char with more recent index
            maxLength = Math.max(maxLength, right - left + 1); // determine maximum length based on right and left index
            right++;
        }

        return maxLength;
    }
}
