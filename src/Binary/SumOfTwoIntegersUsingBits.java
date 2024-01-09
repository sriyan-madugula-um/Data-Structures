package Binary;

import Other.ConvertToNewBase;

public class SumOfTwoIntegersUsingBits {
    public static void main(String[] args) {
        int a = 10;
        int b = 17;
        System.out.println(ConvertToNewBase.convertToBase(a, 2, 8));
        System.out.println(ConvertToNewBase.convertToBase(b, 2, 8));
        System.out.println(getSum(a, b));
        System.out.println(getSum2(a, b));
    }

    public static int getSum2(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getSum2(a ^ b, (a & b) << 1);
    }

    public static int getSum(int a, int b) {
        int result;
        boolean carry = false;
        String sum = "";
        for (int i = 0; i < 32; i++) {
            if (i > Math.log(a) / Math.log(2) + 1 && i > Math.log(b) / Math.log(2) + 1) {
                break;
            }
            int mask = 1 << i; //0000 0001 shifted left i times
            int bitValue1 = (a & mask) == 0 ? 0 : 1; //return 0, if not 1 b/c it will be 2^i power in decimal
            int bitValue2 = (b & mask) == 0 ? 0 : 1;
            if (!carry) {
                sum = (bitValue1 ^ bitValue2) + sum; //XOR operator mimics addition w/o carry
            } else { //carry is true
                if (bitValue1 == 0 && bitValue2 == 0) {
                    sum = 1 + sum;
                    carry = false;
                } else {
                    sum = (bitValue1 & bitValue2) + sum;
                }
            }
            if (bitValue1 == 1 && bitValue2 == 1) {
                carry = true;
            }
        }
        System.out.println(sum);
        result = convertDecimal(sum);
        return result;
    }

    private static int convertDecimal(String sum) {
        int res = 0;
        for (int i = sum.length() - 1; i >= 0; i--) {
            if (sum.substring(i, i + 1).equals("1"))
                res += (int) Math.pow(2, sum.length() - 1 - i);
        }
        if (res < 0) {
            return res + 1;
        } else {
            return res;
        }
    }
}