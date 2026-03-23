public class Fibonacci {
    public static int findNthFibonacci(int n) {
        if (n <= 1) return 1;
        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.print("The " + n + "th Fibonacci is: ");
        return b;
    }
}
