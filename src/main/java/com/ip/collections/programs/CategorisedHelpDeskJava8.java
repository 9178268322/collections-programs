package com.ip.collections.programs;

import com.ip.collections.model.Category;
import com.ip.collections.model.Customer;
import com.ip.collections.model.Enquiry;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Predicate;
import java.util.logging.Logger;

import static com.ip.collections.model.Category.COMPUTER;
import static com.ip.collections.model.Category.PHONE;
import static com.ip.collections.model.Category.PRINTER;

/**
 * This class contains some functions which is used by java 8.
 */
public class CategorisedHelpDeskJava8 {

    private static final Logger log = Logger.getLogger(CategorisedHelpDeskJava8.class.getName());
    private static final Queue<Enquiry> enquiries = new ArrayDeque<>();

    public boolean enquire(final Customer customer, final Category type) {
        return enquiries.offer(new Enquiry(customer, type));
    }

    public void processPrinterEnquiry() {
        processEnquiry(
                enquiry -> enquiry.getCategory() == PRINTER, "Is it out of paper?");
    }

    public void processGeneralEnquiry() {
        processEnquiry(
                enquiry -> enquiry.getCategory() != PRINTER, "Have you tried turning it off and on again?");
    }

    private void processEnquiry(final Predicate<Enquiry> enquiryCheck, final String message) {
        final Enquiry enquiry = enquiries.peek();
        if (enquiry != null && enquiryCheck.test(enquiry)) {
            enquiries.remove();
            enquiry.getCustomer().reply(message);
        } else {
            log.info("No work to do, let's have some coffee!");
        }
    }

    public static void main(String[] args) {
        Customer jack = new Customer("jack");
        Customer jill = new Customer("jill");
        Customer mary = new Customer("marry");

        CategorisedHelpDeskJava8 helpDesk = new CategorisedHelpDeskJava8();

        helpDesk.enquire(jack, PHONE);
        helpDesk.enquire(jill, PRINTER);
        helpDesk.enquire(mary, COMPUTER);

        helpDesk.processPrinterEnquiry();
        helpDesk.processGeneralEnquiry();
        helpDesk.processPrinterEnquiry();
    }
}
