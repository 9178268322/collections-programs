package com.ip.collections.programs;

import com.ip.collections.model.Product;

import java.util.Collections;
import java.util.List;

/**
 * This class is used to shuffle the products.
 */
public class Rotate {

    public List<Product> getRotateElements(List<Product> products, int distance) {
        if (products == null) {
            return null;
        }
        Collections.rotate(products, distance);
        return products;
    }
}
