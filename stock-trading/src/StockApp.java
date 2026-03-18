import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StockApp {
    public static void main(String[] args) {
        Stock techStock = new Stock(150.0);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Update price each 2 seconds
        executor.execute(() -> {
            Random random = new Random();
            while (true) {
                double change = (random.nextDouble() - 0.5) * 10;
                techStock.updatePrice(techStock.getPrice() + change);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        // Observer and print
        executor.execute(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.printf("Current price: %.2f\n", techStock.getPrice());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
            executor.shutdownNow();
        });
    }
}
