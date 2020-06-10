package com.ip.collections.programs;

import com.ip.collections.model.Product;
import com.ip.collections.model.Supplier;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static com.ip.collections.model.Product.BY_WEIGHT;

/**
 * This TreeProductCatalogue class filtters the products by their weight.
 */
public class TreeProductCatalogue implements Iterable<Product> {

    private static final SortedSet<Product> products = new TreeSet<>(BY_WEIGHT);
    private static final int WEIGHT = 20;

    public void isSuppliedBy(Supplier supplier) {
        if (supplier == null) {
            throw new IllegalArgumentException("Supplier can't be null");
        }
        products.addAll(supplier.getProducts());
    }

    public Set<Product> lightVanProducts() {
        Product heaviestLightVanProduct = findHeaviestLightVanProduct();
        return products.headSet(heaviestLightVanProduct);
    }

    public Set<Product> heavyVanProducts() {
        Product heaviestLightVanProduct = findHeaviestLightVanProduct();
        return products.tailSet(heaviestLightVanProduct);
    }

    private Product findHeaviestLightVanProduct() {
        for (Product product : products) {
            if (product.getWeight() > WEIGHT) {
                return product;
            }
        }
        return products.last();
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
