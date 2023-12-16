package excercises.inheritance.service;

import excercises.inheritance.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductService {
    private final List<Product> products;

    private final String productNotFoundMessage = "Product not found";

    public ProductService() {
        this.products = new ArrayList<>();
    }

    public int getProductIndex(String serialNumber) throws Exception {
        for (int i = 0; i < this.products.size(); i++) {
            if (this.products.get(i).getSerialNumber().equals(serialNumber)) {
                return i;
            }
        }

        throw new Exception(productNotFoundMessage);
    }

    public List<Product> getAll() {
        return this.products;
    }

    public boolean create(Product product) throws Exception {
        boolean existProduct = this.products.stream()
                .anyMatch(item -> Objects.equals(item.getSerialNumber(), product.getSerialNumber()));

        if (existProduct) {
            throw new Exception("Serial Number is previously used");
        }

        return this.products.add(product);
    }

    public Product update(int productIndex, Product product) {
        return this.products.set(productIndex, product);
    }

    public boolean remove(String serialNumber) throws Exception {
        if (this.products.removeIf(product -> product.getSerialNumber().equals(serialNumber))) {
            return true;
        }
        throw new Exception(productNotFoundMessage);
    }
}
