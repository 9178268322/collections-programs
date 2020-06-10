package com.ip.collections.programs;

import com.ip.collections.model.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * This class contains some functions of product.
 */
public class ProductCalculation {

    public List<Product> getProductsByWeight(Collection<Product> products, int weight) {
        List<Product> productList = new ArrayList<>();
        Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            if (product.getWeight() > weight) {
                productList.add(product);
            }
        }
        return productList;
    }

    public Collection<Product> removeProductByWeight(Collection<Product> products, int weight) {
        final Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            if (product.getWeight() == weight) {
                productIterator.remove();
            }
        }
        return products;
    }

    public int getProductSize(Collection<Product> products) {
        return products.size();
    }

    public boolean checkIsEmpty(Collection<Product> products) {
        return products.isEmpty();
    }

    public boolean isPresent(Collection<Product> products, Product name) {
        return products.contains(name);
    }

}
