import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        String filename = "products.csv";

        // โหลดข้อมูลเดิมจากไฟล์อัตโนมัติเมื่อเริ่มโปรแกรม (ถ้ามี)
        try {
            store.loadFromFile(filename);
        } catch (IOException e) {
            System.out.println("Could not load file: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\n---- Menu -----");
            System.out.println("1. Show All Data");
            System.out.println("2. Add Data");
            System.out.println("3. Edit Data (ex. name, price, stock)");
            System.out.println("4. Delete Data");
            System.out.println("5. Count Of Data");
            System.out.println("Q. Exit");
            System.out.println("---------------");
            System.out.print("Select menu: ");
            choice = scanner.nextLine().trim();

            switch (choice.toLowerCase()) {
                case "1":
                    System.out.println("\n--- All Products ---");
                    store.showAllProducts();
                    break;

                case "2":
                    System.out.println("\n--- Add New Product ---");
                    try {
                        System.out.print("Enter Code: ");
                        String code = scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Price: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter Stock: ");
                        int stock = Integer.parseInt(scanner.nextLine());

                        Product p = new Product(code, name, price, stock);
                        if (store.addProduct(p)) {
                            store.saveToFile(filename);
                            System.out.println("Added successfully!");
                        } else {
                            System.out.println("Error: Product code already exists!");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input data. Please try again.");
                    }
                    break;

                case "3":
                    System.out.println("\n--- Edit Data ---");
                    store.showAllProducts();
                    if (store.getProductCount() == 0) break;

                    try {
                        System.out.print("Enter row number to edit: ");
                        int index = Integer.parseInt(scanner.nextLine()) - 1;
                        Product target = store.getProductByIndex(index);

                        if (target == null) {
                            System.out.println("Invalid row number!");
                            break;
                        }

                        System.out.println("Editing: ");
                        target.showInfo();

                        System.out.print("Enter new Name (leave blank to keep current): ");
                        String newName = scanner.nextLine();
                        if (!newName.isBlank()) target.setName(newName);

                        System.out.print("Enter new Price (leave blank to keep current): ");
                        String newPriceStr = scanner.nextLine();
                        if (!newPriceStr.isBlank()) target.setPrice(Double.parseDouble(newPriceStr));

                        System.out.print("Enter new Stock (leave blank to keep current): ");
                        String newStockStr = scanner.nextLine();
                        if (!newStockStr.isBlank()) target.setStock(Integer.parseInt(newStockStr));

                        store.saveToFile(filename);
                        System.out.println("Updated successfully!");
                    } catch (Exception e) {
                        System.out.println("Error updating data: " + e.getMessage());
                    }
                    break;

                case "4":
                    System.out.println("\n--- Delete Data ---");
                    store.showAllProducts();
                    if (store.getProductCount() == 0) break;

                    try {
                        System.out.print("Enter row number to delete: ");
                        int index = Integer.parseInt(scanner.nextLine()) - 1;

                        if (store.deleteProductByIndex(index)) {
                            store.saveToFile(filename);
                            System.out.println("Deleted successfully!");
                        } else {
                            System.out.println("Invalid row number!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    } catch (IOException e) {
                        System.out.println("File error: " + e.getMessage());
                    }
                    break;

                case "5":
                    System.out.println("\nTotal rows of data: " + store.getProductCount() + " items.");
                    break;

                case "q":
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid menu choice. Please try again.");
            }
        } while (!choice.equalsIgnoreCase("q"));

        scanner.close();
    }
}