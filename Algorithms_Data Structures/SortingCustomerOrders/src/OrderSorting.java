class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return orderId + " - " + customerName + " - Rs. " + totalPrice;
    }
}

public class OrderSorting {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if (orders[j].totalPrice > orders[j+1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j+1];
                    orders[j+1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(201, "Ram", 1500.50),
            new Order(202, "Rahul", 720.00),
            new Order(203, "Rohan", 2950.75),
            new Order(204, "Mohan", 1100.25)
        };

        System.out.println("Original Orders:");
        printOrders(orders);

        System.out.println("\nSorted using Bubble Sort:");
        bubbleSort(orders);
        printOrders(orders);

        orders = new Order[] {
            new Order(201, "Ram", 1500.50),
            new Order(202, "Rahul", 720.00),
            new Order(203, "Rohan", 2950.75),
            new Order(204, "Mohan", 1100.25)
        };

        System.out.println("\nSorted using Quick Sort:");
        quickSort(orders, 0, orders.length - 1);
        printOrders(orders);
    }
}