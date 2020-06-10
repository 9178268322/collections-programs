package com.ip.maps.programs;

import com.ip.maps.model.Product;

import java.util.Map;

/**
 * This class contains some functions to do some operations,
 * w.r.t products.
 */
public class Java8Enhancements {

    public Product getDefaultProduct(Map<Integer, Product> idToProduct, int id, Product defaultProduct) {
        if (idToProduct == null) {
            return null;
        }
        return idToProduct.getOrDefault(id, defaultProduct);
    }

    public Product getProductIfAbsent(Map<Integer, Product> idToProduct, int id, String productName, int weight) {
        if (idToProduct == null) {
            return null;
        }
        return idToProduct.computeIfAbsent(id, (pid) -> new Product(pid, productName, weight));
    }

    public Product replaceProduct(Map<Integer, Product> idToProduct, int id, Product newProduct) {
        if (idToProduct == null) {
            return null;
        }
        return idToProduct.replace(id, newProduct);
    }

    public Map<Integer, Product> replaceAllProducts(Map<Integer, Product> idToProduct, int weight) {
        if (idToProduct == null) {
            return null;
        }
        idToProduct.replaceAll((key, oldProduct) ->
                new Product(oldProduct.getId(), oldProduct.getName(), oldProduct.getWeight() + weight));
        return idToProduct;
    }
}
