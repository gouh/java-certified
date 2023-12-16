package excercises.inheritance.model;

public class Dresser extends Product {
    private final int drawerCount;

    public Dresser(String serialNumber, String supplier, String origin, String color, String sku, int drawerCount){
        super(serialNumber, supplier, origin, color, sku);
        this.drawerCount = drawerCount;
    }

    @Override
    public void showInformation() {
        super.showInformation();
        System.out.println("Drawer count: " + this.drawerCount);
    }
}