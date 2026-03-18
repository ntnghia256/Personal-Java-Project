public class Stock {
    private double price;

    public Stock(double initialPrice) {
        this.price = initialPrice;
    }

    public synchronized void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    public double getPrice() {
        return price;
    }
}
