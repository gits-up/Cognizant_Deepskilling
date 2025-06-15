import java.util.Arrays;

class Product {
    int productId;
    String productName;
    String category;

    Product(int id, String name, String cat) {
        this.productId = id;
        this.productName = name;
        this.category = cat;
    }

    public String toString() {
        return productId + " - " + productName + " (" + category + ")";
    }
}

public class EcommerceSearch {
    static Product[] products = {
        new Product(101, "Laptop", "Electronics"),
        new Product(102, "Mobile", "Electronics"),
        new Product(103, "Chair", "Furniture"),
        new Product(104, "Shoes", "Apparel"),
        new Product(105, "Watch", "Accessories")
    };

    public static Product linearSearch(String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(String name) {
        Arrays.sort(products, (a, b) -> a.productName.compareToIgnoreCase(b.productName));

        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = name.compareToIgnoreCase(products[mid].productName);
            if (cmp == 0) return products[mid];
            else if (cmp < 0) right = mid - 1;
            else left = mid + 1;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Linear Search for 'Shoes':");
        Product result1 = linearSearch("Shoes");
        System.out.println(result1 != null ? result1 : "Not Found");

        System.out.println("\nBinary Search for 'Chair':");
        Product result2 = binarySearch("Chair");
        System.out.println(result2 != null ? result2 : "Not Found");
    }
}
