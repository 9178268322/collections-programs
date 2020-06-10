package com.ip.maps.model;

import java.util.Objects;

/**
 * This pojo class contains three  data members like id, name, weight of product.
 */
public class Product {

    private transient int id;
    private transient String name;
    private transient int weight;

    public Product() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

    public Product(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("Product{id = %s, name = '%s', weight = %s", id, name, weight);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof Product) {
            final Product p1 = (Product) obj;
            return (this.id == p1.id && this.name.equals(p1.name) && this.weight == p1.weight);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight);
    }
}
