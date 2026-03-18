import entity.Product;
import entity.Warehouse;

public class App {
    public static void main(String[] args) throws Exception {
        Warehouse<Product> myWarehouse = new Warehouse<>();
        myWarehouse.addItem(new Product("001", "Laptop", 1500, 10));
        myWarehouse.addItem(new Product("002", "Mouse", 20, 50));
        myWarehouse.addItem(new Product("003", "Keyboard", 50, 30));

        double totalValue = myWarehouse.getAll().stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();
        System.out.println("Tong gia tri kho: " + totalValue + " USD");

        // Xoa sp thap hon 30
        myWarehouse.removeItems(p -> p.getPrice() < 30);
        System.out.println("Kho sau khi loc: " + myWarehouse.getAll());
    }
}
