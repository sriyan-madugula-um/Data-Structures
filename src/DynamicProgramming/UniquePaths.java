package DynamicProgramming;

//There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
//
//Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        return path(m, n, 0, 0, dp);
    }

    public static int path(int m, int n, int down, int right, int[][] dp) {
        if (down >= m || right >= n) {
            return 0;
        }
        if (down == m - 1 && right == n - 1) {
            return 1;
        }
        if (dp[down][right] != 0) {
            return dp[down][right];
        }
        // dp[down][right] = path(m, n, down + 1, right, dp) + path(m, n, down, right + 1, dp);
        // return path(m, n, down + 1, right, dp) + path(m, n, down, right + 1, dp);
        return dp[down][right] = path(m, n, down + 1, right, dp) + path(m, n, down, right + 1, dp);
    }
}
