package excercises.inheritance;

public class Product {
    private final String serialNumber;
    private final String supplier;
    private final String origin;
    private final String color;
    private final String sku;

    public Product(String serialNumber, String supplier, String origin, String color, String sku) {
        this.serialNumber = serialNumber;
        this.supplier = supplier;
        this.origin = origin;
        this.color = color;
        this.sku = sku;
    }

    public void showInformation() {
        System.out.println("============================================");
        System.out.println("Serial Number: " + this.serialNumber);
        System.out.println("Supplier: " + this.supplier);
        System.out.println("Origin: " + this.origin);
        System.out.println("Color: " + this.color);
        System.out.println("SKU: " + this.sku);
    }
}