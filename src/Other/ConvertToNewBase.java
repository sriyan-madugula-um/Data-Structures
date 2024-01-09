package Other;

public class ConvertToNewBase { //convert base 10 number to base n number
    public static void main(String[] args) {
        int num = 10;
        int base = 2;
        System.out.println(num + " converted to base " + base + " is " + convertToBase(num, base, 8));
    }

    public static StringBuilder convertToBase(int num, int base, int min) {
        int orig = num;
        StringBuilder result = new StringBuilder(); //can also just use string and concatenation (+)
        while (orig > 0) {
            result.insert(0, (orig % base));
            orig /= base;
        }
        for (int i = result.length(); i < min; i++) {
            result.insert(0, 0);
        }
        return result;
    }
}
