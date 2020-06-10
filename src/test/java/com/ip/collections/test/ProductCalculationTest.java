package com.ip.collections.test;

import com.ip.collections.model.Product;
import com.ip.collections.programs.ProductCalculation;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class is used to test ProductCalculation's functions.
 */
public class ProductCalculationTest {

    private static ProductCalculation calculation;

    private static final Product P1 = new Product("Wooden Door", 35);
    private static final Product P2 = new Product("Floor Panel", 25);
    private static final Product P3 = new Product("Glass Window", 10);

    @BeforeTest
    public void init() {
        calculation = new ProductCalculation();
    }

    @Test
    public void testProductByWeight() {
        List<Product> products = Arrays.asList(P1, P2, P3);
        assertThat(calculation.getProductsByWeight(products, 20)).containsExactly(P1, P2);
    }

    @Test
    public void testProductRemoveByWeight() {
        List<Product> products = new LinkedList<>(Arrays.asList(P1, P2, P3));
        assertThat(calculation.removeProductByWeight(products, 10)).containsExactly(P1, P2);
    }

    @Test
    public void testProductSize() {
        List<Product> products = Arrays.asList(P1, P2, P3);
        assertThat(calculation.getProductSize(products)).isEqualTo(3);
    }

    @Test
    public void testProductInfo() {
        List<Product> products = Arrays.asList(P1, P2, P3);
        assertThat(calculation.checkIsEmpty(products)).isFalse();
    }

    @Test
    public void testProductPresent() {
        List<Product> products = Arrays.asList(P1, P2, P3);
        assertThat(calculation.isPresent(products, P3)).isTrue();
    }
}
