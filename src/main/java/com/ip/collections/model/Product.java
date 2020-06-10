package com.ip.collections.model;

import java.util.Comparator;
import java.util.Objects;

/**
 * This is a pojo class.
 */
public class Product {

    public static final Comparator<Product> BY_WEIGHT = (p1, p2) -> Integer.compare(p1.weight, p2.weight);
    public static final Comparator<Product> BY_NAME = (p1, p2) -> p1.name.compareTo(p2.name);

    private transient String name;
    private transient int weight;

    public Product() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

    public Product(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("Product{ name= '%s', weight= %s}", name, weight);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof Product) {
            final Product p1 = (Product) obj;
            return (this.name.equals(p1.name) && this.weight == p1.weight);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }
}
