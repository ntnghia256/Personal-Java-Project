public class StarPattern {
    public static void printTriangle(int h) {
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= h - i; j++) System.out.print(" ");
            // In dấu sao
            for (int k = 1; k <= (2 * i - 1); k++) System.out.print("*");
            System.out.println();
        }
    }
}
