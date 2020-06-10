package com.ip.collections.programs;

import com.ip.collections.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.ip.collections.model.Product.BY_NAME;
import static com.ip.collections.model.Product.BY_WEIGHT;

/**
 * This class is contained some utilites functions.
 */
public class CollectionUtilites {

    private static final int LENGTH = 3;

    public List<Product> addProducts(Product... products) {
        if (products == null) {
            return null;
        }
        if (products.length != LENGTH) {
            throw new IllegalArgumentException("There should be exactly 3 args provided");
        }
        for (Product product : products) {
            if (product == null) {
                throw new IllegalArgumentException("Product can't be null");
            }
        }
        List<Product> productList = new ArrayList<>();
        Collections.addAll(productList, products[0], products[1], products[2]);
        return productList;
    }

    public Product getMinProductByName(Product... products) {
        if (products == null) {
            return null;
        }
        if (products.length != LENGTH) {
            throw new IllegalArgumentException("There should be exactly 3 args provided");
        }
        for (Product product : products) {
            if (product == null) {
                throw new IllegalArgumentException("Product can't be null");
            }
        }
        List<Product> productList = new ArrayList<>();
        Collections.addAll(productList, products[0], products[1], products[2]);
        return Collections.min(productList, BY_NAME);
    }

    public Product getMaxProductByWeight(Product... products) {
        if (products == null) {
            return null;
        }
        if (products.length != LENGTH) {
            throw new IllegalArgumentException("There should be exactly 3 args provided");
        }
        for (Product product : products) {
            if (product == null) {
                throw new IllegalArgumentException("Product can't be null");
            }
        }
        List<Product> productList = new ArrayList<>();
        Collections.addAll(productList, products[0], products[1], products[2]);
        return Collections.max(productList, BY_WEIGHT);
    }
}
