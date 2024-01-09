package BinarySearch; //Binary Search b/c the solution is somewhere between 1 and maxSum (low and high)

public class MaximumValueGivenIndexBoundedArray1802 { //Maximum Value at a Given Index in a Bounded Array
    public static void main(String[] args) {
        System.out.println(maxValue(4, 2, 6)); // _, _, x, _ // find largest possible value of x, given that adjacent numbers are consecutive/equal and total sum doesn't exceed maxSum
    }

    public static int maxValue(int n, int index, int maxSum) {
        long l = index; //number of values to the left
        long r = n - 1 - index; //number of values to the right
        long low = 1; //smallest possible answer
        long high = maxSum; //largest possible answer
        long res = 0;

        //use binary search to find answer between low and high

        while(low <= high) {
            long mid = (low+high)/2;
            long sum = mid; //initially, the sum is just mid (the number at index)
            long ls = 0; //sum of values to the left
            long rs = 0; //sum of values to the right
            long m = mid - 1; //number right next to mid
            if(m >= r) //right sum
                rs = m*(m+1)/2 - (m-r)*(m-r+1)/2; //9+8+7+6 = (1 + ... + 9) - (1 + ... + 5)
            else //stop at 1's
                rs = m*(m+1)/2 + 1*(r-m);
            if(m >= l) //left sum
                ls = m*(m+1)/2 - (m-l)*(m-l+1)/2;
            else //stop at 1's
                ls = m*(m+1)/2 + 1*(l-m);
            sum+=ls+rs; //update sum
            if(sum <= maxSum) {
                res = mid; //largest mid so far, but could be larger
                low = mid+1; //update low to be bigger
            }
            else {
                high = mid - 1; //don't update res b/c sum exceeds maxSum -> not allowed
            }

        }
        return (int) res;
    }
}
