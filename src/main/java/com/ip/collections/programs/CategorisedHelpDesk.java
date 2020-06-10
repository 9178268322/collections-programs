package com.ip.collections.programs;

import com.ip.collections.model.Category;
import com.ip.collections.model.Customer;
import com.ip.collections.model.Enquiry;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.logging.Logger;

import static com.ip.collections.model.Category.COMPUTER;
import static com.ip.collections.model.Category.PHONE;
import static com.ip.collections.model.Category.PRINTER;

/**
 * This class contains enquire, processPrinterEnquiry,
 * processGeneralEnquiry.
 */
public class CategorisedHelpDesk {

    private static final Logger log = Logger.getLogger(CategorisedHelpDesk.class.getName());
    private static Queue<Enquiry> enquiries = new ArrayDeque<>();

    public boolean enquire(final Customer customer, final Category type) {
        return enquiries.offer(new Enquiry(customer, type));
    }

    public void processPrinterEnquiry() {
      final Enquiry enquiry = enquiries.peek();
      if (enquiry != null && enquiry.getCategory() == PRINTER) {
          enquiries.remove();
          enquiry.getCustomer().reply("Is it out of paper");
      } else {
          log.info("No work to do, let's have some tea");
      }
    }

    public void processGeneralEnquiry() {
        final Enquiry enquiry = enquiries.peek();
        if (enquiry != null && enquiry.getCategory() != PRINTER) {
            enquiries.remove();
            enquiry.getCustomer().reply("Have you tried turning it off and on again");
        } else {
            log.info("No work to do, let's have some tea");
        }
    }

    public static void main(String[] args) {

        Customer jack = new Customer("jack");
        Customer jill = new Customer("jill");
        Customer mary = new Customer("marry");

        CategorisedHelpDesk helpDesk = new CategorisedHelpDesk();
        helpDesk.enquire(jack, PHONE);
        helpDesk.enquire(jill, PRINTER);
        helpDesk.enquire(mary, COMPUTER);

        helpDesk.processPrinterEnquiry();
        helpDesk.processGeneralEnquiry();
        helpDesk.processPrinterEnquiry();
    }
}
