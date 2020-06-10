package com.ip.collections.programs;

import com.ip.collections.model.Product;

import java.util.List;

import static com.ip.collections.model.Product.BY_NAME;
import static com.ip.collections.model.Product.BY_WEIGHT;

/**
 * This class is contains some sorting functions.
 */
public class SortProducts {

    public List<Product> getSortedProductsByWeight(List<Product> products) {
        if (products == null) {
            return null;
        }
        products.sort(BY_WEIGHT);
        return products;
    }

    public List<Product> getSortedProductsByName(List<Product> products) {
        if (products == null) {
            return null;
        }
        products.sort(BY_NAME);
        return products;
    }
}
