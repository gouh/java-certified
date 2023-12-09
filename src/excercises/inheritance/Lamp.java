package excercises.inheritance;

public class Lamp extends Product {
    private final String lightType;

    public Lamp(String serialNumber, String supplier, String origin, String color, String sku, String lightType) {
        super(serialNumber, supplier, origin, color, sku);
        this.lightType = lightType;
    }

    @Override
    public void showInformation() {
        super.showInformation();
        System.out.println("Light type: " + this.lightType);
    }
}