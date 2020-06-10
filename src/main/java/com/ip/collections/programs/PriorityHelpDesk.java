package com.ip.collections.programs;

import com.ip.collections.model.Category;
import com.ip.collections.model.Customer;
import com.ip.collections.model.Enquiry;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static com.ip.collections.model.Category.COMPUTER;
import static com.ip.collections.model.Category.PHONE;
import static com.ip.collections.model.Category.PRINTER;

/**
 * This class contains enquire and processAllEnquires in priority order.
 */
public class PriorityHelpDesk {

    private static final Comparator<Enquiry> BY_CATEGORY = (enq1, enq2) -> enq1.getCategory().compareTo(enq2.getCategory());

    private static final Queue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY);

    public boolean enquire(final Customer customer, final Category category) {
        return enquiries.offer(new Enquiry(customer, category));
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

        PriorityHelpDesk helpDesk = new PriorityHelpDesk();

        helpDesk.enquire(jack, PHONE);
        helpDesk.enquire(jill, PRINTER);
        helpDesk.enquire(mary, COMPUTER);

        helpDesk.processAllEnquires();
    }
}
