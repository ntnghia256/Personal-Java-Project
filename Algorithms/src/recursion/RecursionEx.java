package recursion;

public class RecursionEx {
    public static long factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static int power(int n, int pwr) {
        if (pwr == 0) return 1;
        return n * power(n, pwr - 1);
    }

    public static void main(String[] args) {
        // Calculate power
        System.out.println("Power value: " + power(10, 2));
    }
}
