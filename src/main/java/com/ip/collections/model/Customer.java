package com.ip.collections.model;

import java.util.logging.Logger;

/**
 * This is a pojo class of customer.
 */
public class Customer {

    private static final Logger log = Logger.getLogger(Customer.class.getName());
    private transient String name;

    public Customer() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

    public Customer(String name) {
        this.name = name;
    }

    public void reply(String message) {
        log.info(name + ":" + message);
    }
}
