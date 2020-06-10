package com.ip.collections.test;

import com.ip.collections.model.Product;
import com.ip.collections.programs.CollectionUtilites;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * This test class is used to test CollectionUtilites functions.
 */
public class CollectionUtilitesTest {

    private static CollectionUtilites collectionUtilites;

    private static final Product P1 = new Product("Wooden Door", 35);
    private static final Product P2 = new Product("Floor Panel", 25);
    private static final Product P3 = new Product("Glass Window", 10);

    @BeforeTest
    public void init() {
        collectionUtilites = new CollectionUtilites();
    }

    @Test
    public void testAddproducts() {
        Product[] products = {P1, P2, P3};
        assertThat(collectionUtilites.addProducts(products)).contains(P1, P2, P3);
    }

    @Test
    public void testAddWithOneProduct() {
        Product[] products = {P1};
        assertThatIllegalArgumentException().isThrownBy(() -> collectionUtilites.addProducts(products));
    }

    @Test
    public void testAddproductsWithNull() {
        Product[] products = null;
        assertThat(collectionUtilites.addProducts(products)).isNull();
    }

    @Test
    public void testAddproductsWithEmpty() {
        Product[] products = {};
        assertThatIllegalArgumentException().isThrownBy(() -> collectionUtilites.addProducts(products));
    }

    @Test
    public void testAddproductsWithOneNull() {
        Product[] products = {null};
        assertThatIllegalArgumentException().isThrownBy(() -> collectionUtilites.addProducts(products));
    }

    @Test
    public void testAddproductsWithMultipleNull() {
        Product[] products = {null, null, null};
        assertThatIllegalArgumentException().isThrownBy(() -> collectionUtilites.addProducts(products));
    }

    @Test
    public void testAddproductsWithWhiteSpace() {
        Product[] products = { };
        assertThatIllegalArgumentException().isThrownBy(() -> collectionUtilites.addProducts(products));
    }

    @Test
    public void testAddproductsWithWhiteTabSpace() {
        Product[] products = {  };
        assertThatIllegalArgumentException().isThrownBy(() -> collectionUtilites.addProducts(products));
    }

    @Test
    public void testMinWithOneProductByName() {
        Product[] products = {P1};
        assertThatIllegalArgumentException().isThrownBy(() -> collectionUtilites.getMinProductByName(products));
    }

    @Test
    public void testMinProductByName() {
        Product[] products = {P1, P2, P3};
        assertThat(collectionUtilites.getMinProductByName(products)).isEqualTo(P2);
    }

    @Test
    public void testMinProductWithNull() {
        Product[] products = null;
        assertThat(collectionUtilites.getMinProductByName(products)).isNull();
    }

    @Test
    public void testMinProductWithEmpty() {
        Product[] products = {};
        assertThatIllegalArgumentException().isThrownBy(() -> collectionUtilites.getMinProductByName(products));
    }

    @Test
    public void testMinProductWithOneNull() {
        Product[] products = {null};
        assertThatIllegalArgumentException().isThrownBy(() -> collectionUtilites.getMinProductByName(products));
    }

    @Test
    public void testMinProductWithMultipleNull() {
        Product[] products = {null, null, null};
        assertThatIllegalArgumentException().isThrownBy(() -> collectionUtilites.getMinProductByName(products));
    }

    @Test
    public void testMinProductWithWhiteSpace() {
        Product[] products = { };
        assertThatIllegalArgumentException().isThrownBy(() -> collectionUtilites.getMinProductByName(products));
    }

    @Test
    public void testMinProductWithTabSpace() {
        Product[] products = {  };
        assertThatIllegalArgumentException().isThrownBy(() -> collectionUtilites.getMinProductByName(products));
    }

    @Test
    public void testMaxProductByWeight() {
        Product[] products = {P1, P2, P3};
        assertThat(collectionUtilites.getMaxProductByWeight(products)).isEqualTo(P1);
    }

    @Test
    public void testMaxProductWithNull() {
        Product[] products = null;
        assertThat(collectionUtilites.getMaxProductByWeight(products)).isNull();
    }

    @Test
    public void testMaxProductWithEmpty() {
        Product[] products = {};
        assertThatIllegalArgumentException().isThrownBy(() -> collectionUtilites.getMaxProductByWeight(products));
    }

    @Test
    public void testMaxProductWithOneNull() {
        Product[] products = {null};
        assertThatIllegalArgumentException().isThrownBy(() -> collectionUtilites.getMaxProductByWeight(products));
    }

    @Test
    public void testMaxProductWithMultipleNull() {
        Product[] products = {null, null, null};
        assertThatIllegalArgumentException().isThrownBy(() -> collectionUtilites.getMaxProductByWeight(products));
    }

    @Test
    public void testMaxProductWithWhiteSpace() {
        Product[] products = { };
        assertThatIllegalArgumentException().isThrownBy(() -> collectionUtilites.getMaxProductByWeight(products));
    }

    @Test
    public void testMaxProductWithTabSpace() {
        Product[] products = {  };
        assertThatIllegalArgumentException().isThrownBy(() -> collectionUtilites.getMaxProductByWeight(products));
    }
}
