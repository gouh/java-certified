package excercises.inheritance;

public class Table extends Product {
    private final String shape;

    public Table(String serialNumber, String supplier, String origin, String color, String sku, String shape) {
        super(serialNumber, supplier, origin, color, sku);
        this.shape = shape;
    }

    @Override
    public void showInformation() {
        super.showInformation();
        System.out.println("Shape: " + this.shape);
    }
}