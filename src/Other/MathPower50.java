package Other;

public class MathPower50 {
    public static void main(String[] args) {
        double x = 0.5;
        int n = 1000;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        if (x == 1 || n == 0) {
            return 1;
        }
        if (n < 0) {
            if (n == -2147483648) {
                n = 2147483646;
            } else {
                n = Math.abs(n);
            }
            x = 1 / x;
        }
        if (n % 2 == 0) //this is the time saver
        {
            return myPow(x * x, n / 2); //x^8 = (x^2)^4
        } else {
            return x * myPow(x * x, (n - 1) / 2);
        }
    }
}
