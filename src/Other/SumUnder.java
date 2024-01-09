package Other;

public class SumUnder {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(sumOfNaturals(n));
    }

    public static int sumOfNaturals(int n) {
        if (n % 2 == 0) {
            long answer = ((long) (n + 1) * (n / 2)) % (int) ((Math.pow(10, 9) + 7));
            return (int) answer;
        } else {
            long answer = (((long) (n + 1) * (n / 2)) + ((n / 2) + 1)) % (int) ((Math.pow(10, 9) + 7));
            return (int) answer;
        }
    }
}
