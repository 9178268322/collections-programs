package com.ip.collections.model;

/**
 * This is a pojo class of Enquiry.
 */
public class Enquiry {

    private final Customer customer;
    private final Category category;

    public Enquiry(Customer customer, Category category) {
        this.customer = customer;
        this.category = category;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("Enquiry{customer = %s, category = %s", customer, category);
    }
}
