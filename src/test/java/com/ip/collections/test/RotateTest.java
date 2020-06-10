package com.ip.collections.test;

import com.ip.collections.model.Product;
import com.ip.collections.programs.Rotate;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test class is used to test Rotate class.
 */
public class RotateTest {

    private static  Rotate rotate;

    private static final Product P1 = new Product("Wooden Door", 35);
    private static final Product P2 = new Product("Floor Panel", 25);
    private static final Product P3 = new Product("Glass Window", 10);

    @BeforeTest
    public void init() {
        rotate = new Rotate();
    }

    @Test
    public void testRotateProducts() {
        List<Product> products = new ArrayList<>();
        products.add(P1);
        products.add(P2);
        products.add(P3);
        int distance = 1;
        assertThat(rotate.getRotateElements(products, distance)).contains(P3, P1, P2);
    }

    @Test
    public void testRotateProductsWithNull() {
        List<Product> products = null;
        int distance = 1;
        assertThat(rotate.getRotateElements(products, distance)).isNull();
    }

    @Test
    public void testRotateProductsWithEmpty() {
        List<Product> products = new ArrayList<>();
        int distance = 1;
        assertThat(rotate.getRotateElements(products, distance)).isEmpty();
    }

    @Test
    public void testRotateProductsWithZeroDistance() {
        List<Product> products = new ArrayList<>();
        products.add(P1);
        products.add(P2);
        products.add(P3);
        int distance = 0;
        assertThat(rotate.getRotateElements(products, distance)).contains(P1, P2, P3);
    }
}
