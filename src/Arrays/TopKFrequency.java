package Arrays;

import java.util.*;

public class TopKFrequency {
    public static void main(String[] args) {

        int[] nums = {5, 6, 7, 2, 5, 6};
        int k = 2;

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        Integer[] keyArray = new Integer[map.size()];
        Integer[] valueArray = new Integer[map.size()];
        int s = 0;

        for (int key : map.keySet()) {
            keyArray[s] = key;
            valueArray[s] = map.get(key);
            s++;
        }

        int length = keyArray.length;

        for (int i = 0; i < length; i++) { //sort values and put the keys in the same index as the values (frequencies)
            for (int j = i + 1; j < length; j++) {
                int tempKey = 0;
                int tempValue = 0;
                if (valueArray[i] > valueArray[j]) {

                    tempKey = keyArray[i];
                    keyArray[i] = keyArray[j];
                    keyArray[j] = tempKey;

                    tempValue = valueArray[i];
                    valueArray[i] = valueArray[j];
                    valueArray[j] = tempValue;
                }
            }
        }
        System.out.println(Arrays.toString(keyArray));
        System.out.println(Arrays.toString(valueArray));
        for (int i = length - 1, j = 0; j < k; i--, j++) {
            result[j] = keyArray[i];
        }

        System.out.println(Arrays.toString(result));
    }
}