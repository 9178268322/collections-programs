package com.ip.collections.programs;

import com.ip.collections.model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This is shipmnet class which adds, replaces and prepares the products.
 */
public class Shipment implements Iterable<Product> {

    private static final List<Product> products = new ArrayList<>();
    private static final int PRODUCT_NOT_PRESENT = -1;
    private static final int LIGHT_VAN_MAX_WEIGHT = 20;

    private static List<Product> lightVanProducts;
    private static List<Product> heavyVanProducts;

    public void add(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product shouldn't be null");
        }
        products.add(product);
    }

    public void replace(Product oldProduct, Product newProduct) {
        if (oldProduct == null || newProduct == null) {
            throw new IllegalArgumentException("Product shouldn't be null");
        }
        final int index = products.indexOf(oldProduct);
        if (index != PRODUCT_NOT_PRESENT) {
            products.set(index, newProduct);
        }
    }

    public void prepare() {
        products.sort(Product.BY_WEIGHT);
        int splitPoint = findSplitPoint();
        lightVanProducts = products.subList(0, splitPoint);
        heavyVanProducts = products.subList(splitPoint, products.size());
    }

    private int findSplitPoint() {
        for (int i = 0; i < products.size(); i++) {
            final Product product = products.get(i);
            if (product.getWeight() > LIGHT_VAN_MAX_WEIGHT) {
                return i;
            }
        }
        return 0;
    }

    public List<Product> getLightVanProducts() {
        return lightVanProducts;
    }

    public  List<Product> getHeavyVanProducts() {
        return heavyVanProducts;
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
