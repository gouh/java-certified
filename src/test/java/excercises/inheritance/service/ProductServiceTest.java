package excercises.inheritance.service;

import static org.junit.jupiter.api.Assertions.*;

import excercises.inheritance.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductServiceTest {
    private ProductService productService;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() throws Exception {
        productService = new ProductService();
        product1 = new Product("12345", "Supplier1", "Origin1", "Red", "SKU1");
        product2 = new Product("67890", "Supplier2", "Origin2", "Blue", "SKU2");
        productService.create(product1);
        productService.create(product2);
    }

    @Test
    void getProductIndex_ShouldReturnCorrectIndex() throws Exception {
        int index = productService.getProductIndex("12345");
        assertEquals(0, index);
    }

    @Test
    void getProductIndex_ShouldThrowExceptionForInvalidSerialNumber() {
        Exception exception = assertThrows(Exception.class, () -> productService.getProductIndex("invalidSerial"));
        assertEquals("Product not found", exception.getMessage());
    }

    @Test
    void getAll_ShouldReturnAllProducts() {
        List<Product> products = productService.getAll();
        assertEquals(2, products.size());
        assertTrue(products.contains(product1));
        assertTrue(products.contains(product2));
    }

    @Test
    void create_ShouldAddProduct() throws Exception {
        Product product3 = new Product("101112", "Supplier3", "Origin3", "Green", "SKU3");
        assertTrue(productService.create(product3));
        assertEquals(3, productService.getAll().size());
        assertTrue(productService.getAll().contains(product3));
    }

    @Test
    void create_ShouldThrowExceptionForRepeatedSerialNumber() {
        Product product3 = new Product("12345", "Supplier3", "Origin3", "Green", "SKU3");
        Exception exception = assertThrows(Exception.class, () -> productService.create(product3));
        assertEquals("Serial Number is previously used", exception.getMessage());
    }

    @Test
    void update_ShouldUpdateProduct() {
        Product updatedProduct = new Product("12345", "Supplier1-Updated", "Origin1", "Red", "SKU1");
        Product oldProduct = productService.update(0, updatedProduct);
        assertEquals(updatedProduct, productService.getAll().get(0));
        assertNotEquals(oldProduct, updatedProduct);
    }

    @Test
    void remove_ShouldRemoveProduct() throws Exception {
        productService.remove("12345");
        assertEquals(1, productService.getAll().size());
        assertFalse(productService.getAll().contains(product1));
    }

    @Test
    void remove_ShouldThrowExceptionForInvalidSerialNumber() {
        Exception exception = assertThrows(Exception.class, () -> productService.remove("invalidSerial"));
        assertEquals("Product not found", exception.getMessage());
    }
}
