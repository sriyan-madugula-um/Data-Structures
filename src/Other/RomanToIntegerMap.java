package Other;

import java.util.HashMap;

public class RomanToIntegerMap {
    public static void main(String[] args) {
        String roman = "MCMXLIV";
        int result = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        for (int i = 0; i < roman.length(); i++) {
            if (i != roman.length() - 1) {
                if (map.containsKey(roman.substring(i, i + 2))) {
                    String key = roman.substring(i, i + 2);
                    result += map.get(key);
                    i++;
                    continue;
                }
            }
            if (map.containsKey(roman.substring(i, i + 1))) {
                String key = roman.substring(i, i + 1);
                result += map.get(key);
            } else {
                result = -1;
                break;
            }
        }
        System.out.println(result);
    }
}
