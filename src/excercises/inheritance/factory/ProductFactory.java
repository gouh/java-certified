package excercises.inheritance.factory;

import excercises.inheritance.model.*;

public class ProductFactory {

    public static Product getProduct(String productType,
                                     String serialNumber,
                                     String supplier,
                                     String origin,
                                     String color,
                                     String sku,
                                     String extraAttr) {

        return switch (productType.toLowerCase()) {
            case "chair" -> new Chair(serialNumber, supplier, origin, color, sku, extraAttr);
            case "table" -> new Table(serialNumber, supplier, origin, color, sku, extraAttr);
            case "sofa" -> new Sofa(serialNumber, supplier, origin, color, sku, extraAttr);
            case "lamp" -> new Lamp(serialNumber, supplier, origin, color, sku, extraAttr);
            case "dresser" -> new Dresser(serialNumber, supplier, origin, color, sku, Integer.parseInt(extraAttr));
            default -> null;
        };
    }
}
