package DynamicProgramming;

import java.math.*;

public class DynamicProgrammingFibonacci { //currently O(N), can use matrices to get this to O(logn), Binet's formula derived from matrices also O(logn) b/c of exponentiation
    public static void main(String[] args) {
        int n = 5;
        System.out.println(findFibonacci(n));
        double result;
        result = (1 / Math.sqrt(5) * Math.pow(((1 + Math.sqrt(5)) / 2), n)) - (1 / Math.sqrt(5) * Math.pow(((1 - Math.sqrt(5)) / 2), n)); //binet's formula
        System.out.println(Math.round(result));
    }

    public static BigInteger findFibonacci(int n) {
        if (n == 0) {
            return BigInteger.valueOf(0);
        }
        BigInteger[] temp = new BigInteger[n + 1];
        temp[0] = BigInteger.valueOf(0);
        temp[1] = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            temp[i] = temp[i - 1].add(temp[i - 2]);
        }
        return temp[n];
    }
}
