package com.ip.collections.test;

import com.ip.collections.model.Product;
import com.ip.collections.programs.Shipment;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * This class is used to test Shipment's functions.
 */
public class ShipmentTest {

    private static Shipment shipment;

    private static final Product P1 = new Product("Wooden Door", 35);
    private static final Product P2 = new Product("Floor Panel", 25);
    private static final Product P3 = new Product("Glass Window", 10);

    @BeforeTest
    public void init() {
        shipment = new Shipment();
    }

    @Test
    public void shouldAddItems() {
        shipment.add(P1);
        shipment.add(P2);
        assertThat(shipment).contains(P1, P2);
    }

    @Test
    public void testWithOneNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> shipment.add(null));
    }

    @Test
    public void shouldReplaceItems() {
        shipment.add(P1);
        shipment.add(P2);
        shipment.replace(P1, P3);
        assertThat(shipment).contains(P3, P2);
    }

    @Test
    public void testReplaceItemsWithNull() {
        shipment.add(P1);
        shipment.add(P2);
        assertThatIllegalArgumentException().isThrownBy(() -> shipment.replace(P1, null));
    }

    @Test
    public void testWithNullReplaceItem() {
        shipment.add(P1);
        shipment.add(P2);
        assertThatIllegalArgumentException().isThrownBy(() -> shipment.replace(null, P3));
    }

    @Test
    public void testNullReplaceItemsWithNull() {
        shipment.add(P1);
        shipment.add(P2);
        assertThatIllegalArgumentException().isThrownBy(() -> shipment.replace(null, null));
    }

    @Test
    public void shouldNotReplaceMissingItems() {
        shipment.add(P1);
        shipment.replace(P2, P3);
        assertThat(shipment).contains(P1);
    }

    @Test
    public void shouldIdentifyVanRequirments() {
        shipment.add(P1);
        shipment.add(P2);
        shipment.add(P3);
        shipment.prepare();
        assertThat(shipment.getLightVanProducts()).containsExactly(P3);
        assertThat(shipment.getHeavyVanProducts()).contains(P1, P2);
    }
}
