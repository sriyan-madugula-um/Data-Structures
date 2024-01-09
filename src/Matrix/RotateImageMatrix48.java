package Matrix;

import java.util.*;

public class RotateImageMatrix48 { //rotate image 90 degrees right
    public static void main(String[] args) {
        int n = 12;
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = (int) (Math.random() * 89 + 10); //only double-digit numbers
            }
        }
        print2D(nums);
        // rotateImage(nums);
        // rotateImage2(nums);
        System.out.println();
        print2D(nums);
    }

    public static void rotateImage(int[][] nums) {
        HashMap<String, Integer> map = new HashMap<>(); //integer from array, string (two ints) of intended location
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                map.put(j + " " + (nums.length - 1 - i), nums[i][j]);
            }
        }
        for (String num : map.keySet()) {
            int row;
            int col;
            String r = "";
            String c = "";
            for (int i = 0; i < num.length(); i++) {
                if (num.substring(i, i + 1).equals(" ")) {
                    c = num.substring(i + 1);
                    break;
                } else {
                    r = r + num.substring(i, i + 1);
                }
            }
            row = Integer.parseInt(r);
            col = Integer.parseInt(c);
            nums[row][col] = map.get(num);
        }
    }

    public static void rotateImage2(int[][] nums) {
        int n = nums.length;
        // transpose the matrix
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }
        // reverse each row
        for(int i = 0; i < n; i++) {
            int left = 0;
            int right = n-1;
            while(left < right) {
                int temp = nums[i][left];
                nums[i][left] = nums[i][right];
                nums[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void print2D(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}
