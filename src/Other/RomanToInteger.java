package Other;

public class RomanToInteger {
    public static void main(String[] args) {
        String roman = "MMMDCCXXIV";
        System.out.println(convert(roman));
    }

    public static int convert(String roman) {
        int result = 0;
        for (int i = 0; i < roman.length(); i++) {
            if (i != roman.length() - 1) {
                if (roman.charAt(i) == 'I' && roman.charAt(i + 1) == 'V') {
                    result += 4;
                    i++;
                    continue;
                }
                if (roman.charAt(i) == 'I' && roman.charAt(i + 1) == 'X') {
                    result += 9;
                    i++;
                    continue;
                } else if (roman.charAt(i) == 'I') {
                    result += 1;
                }
                if (roman.charAt(i) == 'X' && roman.charAt(i + 1) == 'L') {
                    result += 40;
                    i++;
                    continue;
                }
                if (roman.charAt(i) == 'X' && roman.charAt(i + 1) == 'C') {
                    result += 90;
                    i++;
                    continue;
                } else if (roman.charAt(i) == 'X') {
                    result += 10;
                }
                if (roman.charAt(i) == 'C' && roman.charAt(i + 1) == 'D') {
                    result += 400;
                    i++;
                    continue;
                }
                if (roman.charAt(i) == 'C' && roman.charAt(i + 1) == 'M') {
                    result += 900;
                    i++;
                    continue;
                } else if (roman.charAt(i) == 'C') {
                    result += 100;
                }
                if (roman.charAt(i) == 'V') {
                    result += 5;
                }
                if (roman.charAt(i) == 'L') {
                    result += 50;
                }
                if (roman.charAt(i) == 'D') {
                    result += 500;
                }
                if (roman.charAt(i) == 'M') {
                    result += 1000;
                }
            } else {
                if (roman.charAt(i) == 'I') {
                    result += 1;
                }
                if (roman.charAt(i) == 'V') {
                    result += 5;
                }
                if (roman.charAt(i) == 'X') {
                    result += 10;
                }
                if (roman.charAt(i) == 'L') {
                    result += 50;
                }
                if (roman.charAt(i) == 'C') {
                    result += 100;
                }
                if (roman.charAt(i) == 'D') {
                    result += 500;
                }
                if (roman.charAt(i) == 'M') {
                    result += 1000;
                }
            }
        }

        return result;
    }
}
