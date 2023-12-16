package excercises.inheritance.ui;

import excercises.inheritance.factory.ProductFactory;
import excercises.inheritance.model.*;
import excercises.inheritance.service.ProductService;

import java.util.Map;
import java.util.Scanner;

import static java.util.Map.entry;

public class ProductConsole {

    private final Scanner scanner;

    private final Map<String, String> extraParams;

    private final ProductService productService;

    public ProductConsole() {
        this.extraParams = Map.ofEntries(
                entry("chair", "- Enter the material: "),
                entry("table", "- Enter the shape: "),
                entry("sofa", "- Enter the fabric type: "),
                entry("lamp", "- Enter the light type: "),
                entry("dresser", "- Enter the drawer count: ")
        );
        this.scanner = new Scanner(System.in);
        this.productService = new ProductService();
    }

    private boolean isInvalidValidProductType(String productType) {
        return !(this.extraParams.containsKey(productType));
    }

    private Product readProductData(String oldSerialNumber) {
        System.out.print("Enter the product type (chair, table, sofa, lamp, dresser): ");
        String productType = scanner.next();
        scanner.nextLine();

        if (this.isInvalidValidProductType(productType)) {
            System.out.println("Warning: Product type is not valid. Please enter a valid product type.");
            return this.readProductData(oldSerialNumber);
        }

        String serialNumber = oldSerialNumber;
        if (oldSerialNumber.isEmpty()) {
            System.out.print("- Enter the serial number: ");
            serialNumber = scanner.next();
            scanner.nextLine();
        }

        System.out.print("- Enter the supplier: ");
        String supplier = scanner.next();
        scanner.nextLine();

        System.out.print("- Enter the origin: ");
        String origin = scanner.next();
        scanner.nextLine();

        System.out.print("- Enter the color: ");
        String color = scanner.next();
        scanner.nextLine();

        System.out.print("- Enter the SKU: ");
        String sku = scanner.next();
        scanner.nextLine();

        System.out.print(extraParams.get(productType));
        String extraAttr = scanner.nextLine();

        return ProductFactory.getProduct(productType,
                serialNumber,
                supplier,
                origin,
                color,
                sku,
                extraAttr
        );
    }

    private void add() {
        System.out.println("* Registering a new product.");
        Product product = this.readProductData("");
        if (this.productService.create(product)) {
            System.out.printf("Product %s saved successfully. \n", product.getSerialNumber());
        } else {
            System.out.printf("Product %s don't saved. \n", product.getSerialNumber());
        }
        System.out.println();
    }

    private void update() throws Exception {
        System.out.println("* Updating product.");
        System.out.print("Enter serial number of product: ");
        String serialNumber = scanner.next();
        scanner.nextLine();

        int productIndex = this.productService.getProductIndex(serialNumber);
        Product product = this.readProductData(serialNumber);
        Product oldProduct = this.productService.update(productIndex, product);

        System.out.printf("Product %s updated successfully. \n", oldProduct.getSerialNumber());
        System.out.println();
    }

    private void remove() throws Exception {
        System.out.println("* Deleting product.");
        System.out.print("Enter serial number of product: ");
        String serialNumber = scanner.next();
        scanner.nextLine();

        if (this.productService.remove(serialNumber)) {
            System.out.printf("Product %s removed. \n", serialNumber);
        } else {
            System.out.printf("Product %s don't removed. \n", serialNumber);
        }

        System.out.println();
    }

    private void showList() {
        System.out.println("* showing product list.");
        if (this.productService.getAll().isEmpty()) {
            System.out.println("The product list is empty.");
        } else {
            System.out.println("============================================");
            this.productService.getAll().forEach(product -> {
                product.showInformation();
                System.out.println("============================================");
            });
        }
    }

    public void showMainPromptMessage() {
        System.out.println("Hi and welcome to catalog of products");

        System.out.println("1) Add new product.");
        System.out.println("2) Update product.");
        System.out.println("3) Remove product.");
        System.out.println("4) Show list products.");
        System.out.println("5) Exit.");

        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        try {
            switch (option) {
                case 1:
                    add();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    showList();
                    break;
                case 5:
                    System.out.println("Program finished.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        showMainPromptMessage();
    }
}
