package excercises.inheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static boolean isValidProductType(String productType) {
        return productType.equalsIgnoreCase("chair") ||
                productType.equalsIgnoreCase("table") ||
                productType.equalsIgnoreCase("sofa") ||
                productType.equalsIgnoreCase("lamp") ||
                productType.equalsIgnoreCase("dresser") ||
                productType.equalsIgnoreCase("exit") ||
                productType.equalsIgnoreCase("print");
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String productType;

        while (true) {
            System.out.println("Enter the product type (chair, table, sofa, lamp, dresser) or 'exit' to quit or 'print' to show all products: ");
            productType = scanner.nextLine();

            if (productType.equalsIgnoreCase("print")) {
                products.forEach(Product::showInformation);
                continue;
            } else if (productType.equalsIgnoreCase("exit")) {
                break;
            } else if (!isValidProductType(productType)) {
                System.out.println("Warning: Product type is not valid. Please enter a valid product type.");
                continue;
            }


            System.out.println("Enter the serial number: ");
            String serialNumber = scanner.nextLine();

            System.out.println("Enter the supplier: ");
            String supplier = scanner.nextLine();

            System.out.println("Enter the origin: ");
            String origin = scanner.nextLine();

            System.out.println("Enter the color: ");
            String color = scanner.nextLine();

            System.out.println("Enter the SKU: ");
            String sku = scanner.nextLine();

            switch (productType.toLowerCase()) {
                case "chair":
                    System.out.println("Enter the material: ");
                    String material = scanner.nextLine();
                    Chair chair = new Chair(serialNumber, supplier, origin, color, sku, material);
                    products.add(chair);
                    break;

                case "table":
                    System.out.println("Enter the shape: ");
                    String shape = scanner.nextLine();
                    Table table = new Table(serialNumber, supplier, origin, color, sku, shape);
                    products.add(table);
                    break;

                case "sofa":
                    System.out.println("Enter the fabric type: ");
                    String fabricType = scanner.nextLine();
                    Sofa sofa = new Sofa(serialNumber, supplier, origin, color, sku, fabricType);
                    products.add(sofa);
                    break;

                case "lamp":
                    System.out.println("Enter the light type: ");
                    String lightType = scanner.nextLine();
                    Lamp lamp = new Lamp(serialNumber, supplier, origin, color, sku, lightType);
                    products.add(lamp);
                    break;

                case "dresser":
                    System.out.println("Enter the drawer count: ");
                    int drawerCount = Integer.parseInt(scanner.nextLine());
                    Dresser dresser = new Dresser(serialNumber, supplier, origin, color, sku, drawerCount);
                    products.add(dresser);
                    break;

                default:
                    System.out.println("Invalid product type.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Program finished.");
    }
}