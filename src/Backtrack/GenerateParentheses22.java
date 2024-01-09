package Backtrack;

import java.util.*;

public class GenerateParentheses22 { //with memoization: O(n^2), w/o memoization: O(2^n)
    public static void main(String[] args) {
        int n = 3;
        List<String> result = new ArrayList<>();
        HashMap<String, List<String>> memo = new HashMap<>();
        recurse(n, 0, 0, "", result, memo);
        //System.out.println(result.size());
        System.out.println(result);
        //System.out.println(CatalanFactorial22.catalan(n));
    }

    public static void recurse(int n, int open, int close, String current, List<String> result, HashMap<String, List<String>> memo) {
        if (open == n && close == n) {
            result.add(current);
            return;
        }
        if (memo.containsKey(current)) {
            List<String> cachedResults = memo.get(current); //already cached
            result.addAll(cachedResults);
            return;
        }

        if (open < n) {
            recurse(n, open + 1, close, current + "(", result, memo);
        }
        if (close < open) {
            recurse(n, open, close + 1, current + ")", result, memo);
        }

        memo.put(current, result);
    }
}
