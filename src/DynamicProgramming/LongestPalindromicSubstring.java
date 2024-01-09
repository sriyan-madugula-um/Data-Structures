package DynamicProgramming;

public class LongestPalindromicSubstring { // dp is used because in a palindrome, if you remove the first and last letter, you still get a palindrome (sub-problems)
    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindromicSubstring(str));
    }

    public static String longestPalindromicSubstring(String str) {
        String res = "";
        int n = str.length();

        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) { // this loop iterates backwards and the inner loop iterates forwards to ensure that each substring is checking the first and last letter to maintain a palindrome
            for (int j = i; j < n; j++) {
                dp[i][j] = str.charAt(i) == str.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]); // end and beginning char are the same, j and i are close enough to assure a palindrome (base case), check inner palindrome
                if (dp[i][j] && (j - i + 1 > res.length())) { // if dp stores true and the current substring is larger than the substring stored in res
                    res = str.substring(i, j + 1); // update res to be the palindrome from index i to j inclusive
                }
            }
        }
        return res;
    }
}
