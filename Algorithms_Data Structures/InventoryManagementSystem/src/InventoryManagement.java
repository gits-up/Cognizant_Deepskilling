import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int id, String name, int qty, double price) {
        this.productId = id;
        this.productName = name;
        this.quantity = qty;
        this.price = price;
    }

    public String toString() {
        return productId + " - " + productName + " - Qty: " + quantity + " - Price: Rs. " + price;
    }
}

public class InventoryManagement {
    static HashMap<Integer, Product> inventory = new HashMap<>();

    public static void addProduct(Product p) {
        inventory.put(p.productId, p);
    }

    public static void updateProduct(int id, int qty, double price) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = qty;
            p.price = price;
        }
    }

    public static void deleteProduct(int id) {
        inventory.remove(id);
    }

    public static void displayInventory() {
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        addProduct(new Product(1, "Laptop", 10, 55000));
        addProduct(new Product(2, "Mouse", 25, 500));
        updateProduct(1, 8, 53000);
        deleteProduct(2);
        displayInventory();
    }
}
