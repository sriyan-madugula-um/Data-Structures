package Arrays;

public class LongestConsecutiveSubArray { //length of longest consecutive subarray
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {3, 4, 5, 7}; //should return 3 (3,4,5)
        int[][] memo = new int[a.length][b.length];
        System.out.println(findLongestLength(a, b, 0, 0, memo));
    }

    public static int findLongestLength(int[] a, int[] b, int idxA, int idxB, int[][] memo) {
        if (idxA == a.length || idxB == b.length)
            return 0;
        if (memo[idxA][idxB] != 0) //checks if it is already stored in memory
            return memo[idxA][idxB];
        int length1 = findLongestLength(a, b, idxA + 1, idxB, memo);
        int length2 = findLongestLength(a, b, idxA, idxB + 1, memo);
        int length3 = 0;
        if (a[idxA] == b[idxB])
            length3 = findLongestLength(a, b, idxA + 1, idxB + 1, memo) + 1;
        memo[idxA][idxB] = max(length1, length2, length3); //add to memory
        return max(length1, length2, length3);
    }

    public static int max(int a, int b, int c) {
        if (a > b && a > c)
            return a;
        else
            return Math.max(b, c);
    }
}
