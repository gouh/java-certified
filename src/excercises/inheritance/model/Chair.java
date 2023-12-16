package excercises.inheritance.model;

public class Chair extends Product {
    private final String material;

    public Chair(String serialNumber, String supplier, String origin, String color, String sku, String material) {
        super(serialNumber, supplier, origin, color, sku);
        this.material = material;
    }

    @Override
    public void showInformation() {
        super.showInformation();
        System.out.println("Material: " + this.material);
    }
}