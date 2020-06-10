package com.ip.collections.test;

import com.ip.collections.model.Product;
import com.ip.collections.programs.SortProducts;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test class is used to test SortProducts functions.
 */
public class SortProductsTest {

    private static SortProducts products;

    private static final Product P1 = new Product("Wooden Door", 35);
    private static final Product P2 = new Product("Floor Panel", 25);
    private static final Product P3 = new Product("Glass Window", 10);

    @BeforeTest
    public void init() {
        products = new SortProducts();
    }

    @Test
    public void testSortedProductsByWeight() {
        List<Product> productList = new ArrayList<>();
        productList.add(P1);
        productList.add(P2);
        productList.add(P3);
        assertThat(products.getSortedProductsByWeight(productList)).contains(P3, P2, P1);
    }

    @Test
    public void testSortedProductsByWeightWithNull() {
        List<Product> productList = null;
        assertThat(products.getSortedProductsByWeight(productList)).isNull();
    }

    @Test
    public void testSortedProductsByWeightWithEmpty() {
        List<Product> productList = new ArrayList<>();
        assertThat(products.getSortedProductsByWeight(productList)).isEmpty();
    }

    @Test
    public void testSortedProductsByName() {
        List<Product> productList = new ArrayList<>();
        productList.add(P1);
        productList.add(P2);
        productList.add(P3);
        assertThat(products.getSortedProductsByWeight(productList)).contains(P2, P3, P1);
    }

    @Test
    public void testSortedProductsByNameWithNull() {
        List<Product> productList = null;
        assertThat(products.getSortedProductsByWeight(productList)).isNull();
    }

    @Test
    public void testSortedProductsByNameWithEmpty() {
        List<Product> productList = new ArrayList<>();
        assertThat(products.getSortedProductsByWeight(productList)).isEmpty();
    }
}
