package Other;

import java.math.BigInteger;
import java.util.Arrays;

public class CatalanFactorial22 {
    public static void main(String[] args) {
        int n = 3;
        BigInteger comb = catalan(n);
        System.out.println(comb);
    }

    public static BigInteger catalan(int n) {
        return (factorial(2 * n)).divide(((factorial(n + 1)).multiply(factorial(n))));
    }

    public static BigInteger factorial(int i) {
        BigInteger[] factor = new BigInteger[i + 1];
        Arrays.fill(factor, BigInteger.valueOf(1));
        for (int j = 2; j < factor.length; j++) {
            for (int k = 0; k < j; k++) {
                factor[j] = BigInteger.valueOf(j).multiply(factor[k]);
            }
        }
        return factor[i];
    }

}
