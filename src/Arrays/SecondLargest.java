package Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] array = {3, 1, 7, 4};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            }
            if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        System.out.println(secondLargest);
    }
}
