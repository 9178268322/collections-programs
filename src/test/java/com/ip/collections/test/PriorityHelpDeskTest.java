package com.ip.collections.test;

import com.ip.collections.model.Category;
import com.ip.collections.model.Customer;
import com.ip.collections.programs.PriorityHelpDesk;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class is used to test PriorityHelpDesk's functions.
 */
public class PriorityHelpDeskTest {

    private static PriorityHelpDesk helpDesk;

    private static final Customer JACK = new Customer("jack");
    private static final Customer JILL = new Customer("jill");
    private static final Customer MARY = new Customer("marry");

    private static final Category PHONE = Category.PHONE;
    private static final Category PRINTER = Category.PRINTER;
    private static final Category COMPUTER = Category.COMPUTER;

    @BeforeTest
    public void init() {
        helpDesk = new PriorityHelpDesk();
    }

    @Test
    public void testEnquiry() {
        assertThat(helpDesk.enquire(JACK, PHONE)).isTrue();
        assertThat(helpDesk.enquire(JILL, PRINTER)).isTrue();
        assertThat(helpDesk.enquire(MARY, COMPUTER)).isTrue();
    }

}
