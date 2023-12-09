package excercises.inheritance;

public class Sofa extends Product {
    private final String fabricType;

    public Sofa(String serialNumber, String supplier, String origin, String color, String sku, String fabricType) {
        super(serialNumber, supplier, origin, color, sku);
        this.fabricType = fabricType;
    }

    @Override
    public void showInformation() {
        super.showInformation();
        System.out.println("Fabric type: " + this.fabricType);
    }
}