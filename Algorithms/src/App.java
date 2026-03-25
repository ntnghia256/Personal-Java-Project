public class App {
    public static void main(String[] args) throws Exception {
        // Check prime number
        boolean isPrime = PrimeNumber.isPrime(11);
        System.out.println(isPrime ? "Prime number" : "Not Prime number");

        // Find Nth Fibonacci
        System.out.print(Fibonacci.findNthFibonacci(10));
    
        // Check palindrome string
        System.out.println(PalindromeString.isPalindromeString("abccbad") ? "\nPalindrome string" : "\nNot Palindrome string");

        // Binary search
        int[] arr = {1, 2, 3, 4, 5, 6};
        int rs = BinarySearch.search(arr, 6);
        System.out.println("Binary search result is: " + rs);

        // Bubble sort
        int[] arr1 = {5, 1, 4, 2, 9, 7};
        System.out.println("Bubble sort result is: ");
        for (int i : BubbleSort.sort(arr1)) {
            System.out.print(i);
        }

        // Character frequency
        String charFrequency = "honguyentrongnghia";
        System.out.println("Character frequency result is: ");
        CharFrequency.count(charFrequency);

        // Factorial - Giaithua
        int factorial = 5;
        System.out.println("Ket qua " + factorial + " giai thua la: " + Factorial.factorial(factorial));

        // Reverse string
        String reverseStirng = "coffee ket rat ngon";
        System.out.println("Reverse string result is: ");
        System.out.println(ReverseString.reverse(reverseStirng));

        // Second largest in array
        int[] secondLargest = {5, 6, 8, 1, 9, 10, 21, 7, 15};
        System.out.println("Second largest result is: ");
        System.out.println(SecondLargest.find(secondLargest));

        // Star pattern
        int starPattern = 4;
        System.out.printf("Start pattern of %d is: %n", starPattern);
        StarPattern.printTriangle(starPattern);
    }
}
