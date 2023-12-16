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
        switch (productType.toLowerCase()) {
            case "chair":
                return new Chair(serialNumber, supplier, origin, color, sku, extraAttr);
            case "table":
                return new Table(serialNumber, supplier, origin, color, sku, extraAttr);
            case "sofa":
                return new Sofa(serialNumber, supplier, origin, color, sku, extraAttr);
            case "lamp":
                return new Lamp(serialNumber, supplier, origin, color, sku, extraAttr);
            case "dresser":
                return new Dresser(serialNumber, supplier, origin, color, sku, Integer.parseInt(extraAttr));
            default:
                return null;
        }
    }
}
