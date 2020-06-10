package com.ip.collections.programs;

import com.ip.collections.model.Category;
import com.ip.collections.model.Customer;
import com.ip.collections.model.Enquiry;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * This class contains enquire and processAllEnquires functions.
 */
public class HelpDesk {

    private static final Queue<Enquiry> enquiries = new ArrayDeque<>();

    public void enquire(final Customer customer, final Category category) {
        enquiries.offer(new Enquiry(customer, category));
    }

    public void processAllEnquires() {
        while (!enquiries.isEmpty()) {
            final Enquiry enquiry = enquiries.poll();
            enquiry.getCustomer().reply("Have you tried it off and on again?");
        }
    }

    public static void main(String[] args) {
        Customer jack = new Customer("jack");
        Customer jill = new Customer("jill");
        Customer mary = new Customer("marry");

        HelpDesk helpDesk = new HelpDesk();

        helpDesk.enquire(jack, Category.PHONE);
        helpDesk.enquire(jill, Category.PRINTER);
        helpDesk.enquire(mary, Category.COMPUTER);

        helpDesk.processAllEnquires();
    }
}
