package com.ip.collections.programs;

import com.ip.collections.model.Product;
import com.ip.collections.model.Supplier;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * This class contains supplied function.
 */
public class ProductCatalogue implements Iterable<Product> {

    private static final Set<Product> products = new HashSet<>();

    public void isSuppliedBy(Supplier supplier) {
        if (supplier == null) {
            throw new IllegalArgumentException("Supplier can't be null");
        }
        products.addAll(supplier.getProducts());
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
