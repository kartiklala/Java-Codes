import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        int choice;

        do {
            System.out.println("\n1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Stock: ");
                    int stock = sc.nextInt();

                    inventory.addProduct(id, stock);
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int productId = sc.nextInt();

                    System.out.print("Enter new stock: ");
                    int newStock = sc.nextInt();

                    inventory.updateStock(productId, newStock);
                    break;

                case 3:
                    inventory.displayInventory();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
}

class Inventory {
    HashMap<Integer, Integer> products = new HashMap<>();

    void addProduct(int id, int stock) {
        products.put(id, stock);
        System.out.println("Product " + id + " added with stock " + stock);
    }

    void updateStock(int id, int stock) {
        if (products.containsKey(id)) {
            products.put(id, stock);
            System.out.println("Stock updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    void displayInventory() {
        System.out.println("Inventory:");

        Iterator<Map.Entry<Integer, Integer>> iterator =
                products.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            System.out.println("Product " + entry.getKey() +
                    " → Stock " + entry.getValue());
        }
    }
}