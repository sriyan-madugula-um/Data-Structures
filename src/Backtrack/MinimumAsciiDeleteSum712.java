package Backtrack;
import java.util.*;
public class MinimumAsciiDeleteSum712 {
    public static void main(String[] args) {
        String s1 = "delete";
        String s2 = "leet";
        System.out.println(minimumDeleteSum(s1, s2));
    }

    public static int minimumDeleteSum(String s1, String s2) {
        // dynamic programming
        // have a list of strings be added to through a void recursive method
        // will store all possible strings (largest non-consecutive matches)
        // another helper method will evaluate min ASCII from list of strings
        // original combined ascii - (ascii of string)*2 --> minimum
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> memo = new HashMap<>();
        int ascii1 = 0;
        for (int i = 0; i < s1.length(); i++) {
            ascii1 += s1.charAt(i);
        } //s1's ascii
        int ascii2 = 0;
        for (int j = 0; j < s2.length(); j++) {
            ascii2 += s2.charAt(j);
        } //s2's ascii
        rec(s1, s2, 0, 0, "", result, memo);
        System.out.println(result);
        return ascii(result, ascii1, ascii2);
    }

    public static void rec(String s1, String s2, int index1, int index2, String curr, List<String> result, HashMap<String, Integer> memo) { //adds potential values to result
        if (index1 > s1.length() - 1 && index2 > s2.length() - 1) {
            if (!result.contains(curr)) {
                result.add(curr);
            }
            return;
        }
        String key = index1 + "-" + index2;
        if (memo.containsKey(key))
            return;
        if (index1 < s1.length() && index2 < s2.length() && s1.charAt(index1) == s2.charAt(index2))
            rec(s1, s2, index1 + 1, index2 + 1, curr + s1.charAt(index1), result, memo);
        else {
            if (index1 < s1.length())
                rec(s1, s2, index1 + 1, index2, curr, result, memo);
            if (index2 < s2.length())
                rec(s1, s2, index1, index2 + 1, curr, result, memo);
        }
        memo.put(key, 1);
    }

    public static int ascii(List<String> result, int ascii1, int ascii2) { //finds minimum ascii value of deleted
        int minSum = Integer.MAX_VALUE;

        for (String entry : result) {
            int sum = 0;
            for (int j = 0; j < entry.length(); j++) {
                sum += entry.charAt(j);
            }
            minSum = Math.min(ascii1 + ascii2 - (sum * 2), minSum);
        }

        return minSum;
    }
}
