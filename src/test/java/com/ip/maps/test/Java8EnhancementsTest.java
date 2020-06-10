package com.ip.maps.test;

import com.ip.maps.model.Product;
import com.ip.maps.programs.Java8Enhancements;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test class is used to test Java8Enhancements functions.
 */
public class Java8EnhancementsTest {

    private static Java8Enhancements enhancements;

    private static final Product DOOR = new Product(1, "Wooden Door", 35);
    private static final Product FLOOR_PANEL = new Product(2, "Floor Panel", 25);
    private static final Product WINDOW = new Product(3, "Glass Window", 10);

    private static final Product DEFAULT_PRODUCT = new Product(-1, "Whatever the customer wants", 100);
    private static final Product NEW_PRODUCT = new Product(5, "Big Door", 50);

    private static final String CUSTOM_PRODUCT_NAME = "Custom Product";

    @BeforeTest
    public void init() {
        enhancements = new Java8Enhancements();
    }

    @Test
    public void testDefaultProduct() {
        Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, DOOR);
        idToProduct.put(2, FLOOR_PANEL);
        idToProduct.put(3, WINDOW);
        assertThat(enhancements.getDefaultProduct(idToProduct, 10, DEFAULT_PRODUCT)).isEqualTo(DEFAULT_PRODUCT);
    }

    @Test
    public void testDefaultProductWithNull() {
        Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, DOOR);
        idToProduct.put(2, FLOOR_PANEL);
        idToProduct.put(3, WINDOW);
        assertThat(enhancements.getDefaultProduct(idToProduct, 10, null)).isNull();
    }

    @Test
    public void testDefaultProductWithProductsNull() {
        Map<Integer, Product> idToProduct = null;
        assertThat(enhancements.getDefaultProduct(idToProduct, 10, DEFAULT_PRODUCT)).isNull();
    }

    @Test
    public void testDefaultProductWithProductsEmpty() {
        Map<Integer, Product> idToProduct = new HashMap<>();
        assertThat(enhancements.getDefaultProduct(idToProduct, 10, DEFAULT_PRODUCT)).isEqualTo(DEFAULT_PRODUCT);
    }

    @Test
    public void testDefaultProductWithExisting() {
        Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, DOOR);
        idToProduct.put(2, FLOOR_PANEL);
        idToProduct.put(3, WINDOW);
        assertThat(enhancements.getDefaultProduct(idToProduct, 1, DEFAULT_PRODUCT)).isEqualTo(DOOR);
    }

    @Test
    public void testAbsentProduct() {
        Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, DOOR);
        idToProduct.put(2, FLOOR_PANEL);
        idToProduct.put(3, WINDOW);
        int weight = 10;
        assertThat(enhancements.getProductIfAbsent(idToProduct, 5, CUSTOM_PRODUCT_NAME, weight)).
                isEqualTo(new Product(5, CUSTOM_PRODUCT_NAME, weight));
    }

    @Test
    public void testAbsentProductWithNull() {
        Map<Integer, Product> idToProduct = null;
        int weight = 10;
        assertThat(enhancements.getProductIfAbsent(idToProduct, 5, CUSTOM_PRODUCT_NAME, weight)).isNull();
    }

    @Test
    public void testAbsentProductWithEmpty() {
        Map<Integer, Product> idToProduct = new HashMap<>();
        int weight = 10;
        assertThat(enhancements.getProductIfAbsent(idToProduct, 5, CUSTOM_PRODUCT_NAME, weight)).
                isEqualTo(new Product(5, CUSTOM_PRODUCT_NAME, weight));
    }

    @Test
    public void testAbsentProductWithExisting() {
        Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, DOOR);
        idToProduct.put(2, FLOOR_PANEL);
        idToProduct.put(3, WINDOW);
        int weight = 10;
        assertThat(enhancements.getProductIfAbsent(idToProduct, 2, CUSTOM_PRODUCT_NAME, weight)).
                isEqualTo(FLOOR_PANEL);
    }

    @Test
    public void testReplaceProduct() {
        Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, DOOR);
        idToProduct.put(2, FLOOR_PANEL);
        idToProduct.put(3, WINDOW);
        assertThat(enhancements.replaceProduct(idToProduct, 1, NEW_PRODUCT)).isEqualTo(DOOR);
    }

    @Test
    public void testReplaceProductWithNoExisting() {
        Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, DOOR);
        idToProduct.put(2, FLOOR_PANEL);
        idToProduct.put(3, WINDOW);
        assertThat(enhancements.replaceProduct(idToProduct, 5, NEW_PRODUCT)).isNull();
    }

    @Test
    public void testReplaceProductWithNull() {
        Map<Integer, Product> idToProduct = null;
        assertThat(enhancements.replaceProduct(idToProduct, 1, NEW_PRODUCT)).isNull();
    }

    @Test
    public void testReplaceProductWithEmpty() {
        Map<Integer, Product> idToProduct = new HashMap<>();
        assertThat(enhancements.replaceProduct(idToProduct, 1, NEW_PRODUCT)).isNull();
    }

    @Test
    public void testReplaceAllProducts() {
        Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, DOOR);
        idToProduct.put(2, FLOOR_PANEL);
        idToProduct.put(3, WINDOW);
        int weight = 10;
        Product p1 = new Product(1, "Wooden Door", 45);
        Product p2 = new Product(2, "Floor Panel", 35);
        Product p3 = new Product(3, "Glass Window", 20);
        assertThat(enhancements.replaceAllProducts(idToProduct, weight)).
                containsEntry(1, p1).containsEntry(2, p2).containsEntry(3, p3);
    }

    @Test
    public void testReplaceAllProductsWithNull() {
        Map<Integer, Product> idToProduct = null;
        int weight = 10;
        assertThat(enhancements.replaceAllProducts(idToProduct, weight)).isNull();
    }

    @Test
    public void testReplaceAllProductsWithEmpty() {
        Map<Integer, Product> idToProduct = new HashMap<>();
        int weight = 10;
        assertThat(enhancements.replaceAllProducts(idToProduct, weight)).isEmpty();
    }
}
