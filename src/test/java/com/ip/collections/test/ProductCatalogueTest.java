package com.ip.collections.test;

import com.ip.collections.model.Product;
import com.ip.collections.model.Supplier;
import com.ip.collections.programs.ProductCatalogue;
import com.ip.collections.programs.TreeProductCatalogue;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * This class is used to test ProductCatalogue's functions.
 */
public class ProductCatalogueTest {

    private static ProductCatalogue catalogue;
    private static TreeProductCatalogue treeCatalogue;

    private static final Product P1 = new Product("Wooden Door", 35);
    public static final Product P2 = new Product("Floor Panel", 25);
    public static final Product P3 = new Product("Glass Window", 10);

    public static final Supplier S1 = new Supplier("Bob's Household Supplies");
    public static final Supplier S2 = new Supplier("Kate's Home Goods");

    static {
        S1.getProducts().add(P1);
        S1.getProducts().add(P2);

        S2.getProducts().add(P2);
        S2.getProducts().add(new Product("Glass Window", 10));
    }

    @BeforeTest
    public void init() {
        catalogue = new ProductCatalogue();
        treeCatalogue = new TreeProductCatalogue();
    }

    @Test
    public void shouldOnlyHoldUniqueProducts() {
        catalogue.isSuppliedBy(S1);
        catalogue.isSuppliedBy(S2);
        assertThat(catalogue).containsExactlyInAnyOrder(P1, P2, P3);
    }

    @Test
    public void testSupplierWithNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> catalogue.isSuppliedBy(null));
    }

    @Test
    public void treeShouldOnlyHoldUniqueProducts() {
        treeCatalogue.isSuppliedBy(S1);
        treeCatalogue.isSuppliedBy(S2);
        assertThat(treeCatalogue).containsExactlyInAnyOrder(P1, P2, P3);
    }

    @Test
    public void testTreeSupplierWithNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> treeCatalogue.isSuppliedBy(null));
    }

    @Test
    public void shouldFindLightVanProducts() {
        treeCatalogue.isSuppliedBy(S1);
        treeCatalogue.isSuppliedBy(S2);
        assertThat(treeCatalogue.lightVanProducts()).containsExactlyInAnyOrder(P3);
    }

    @Test
    public void shouldFindHeavyVanProducts() {
        treeCatalogue.isSuppliedBy(S1);
        treeCatalogue.isSuppliedBy(S2);
        assertThat(treeCatalogue.heavyVanProducts()).containsExactlyInAnyOrder(P1, P2);
    }
}
