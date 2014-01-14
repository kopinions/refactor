package foo;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CustomerTest {

    @Test
    public void testCustomer() {
        Customer c = new Customer("David", new CustomerType(CustomerType.REGULAR));
        assertNotNull(c);
    }

    @Test
    public void testAddRental() {
        Customer customer2 = new Customer("Sallie", new CustomerType(CustomerType.REGULAR));
        Rental rental1 = new Rental(new Movie("Gone with the Wind", Movie.REGULAR), 3); // 3 day rental

        customer2.addRental(rental1);
    }

    @Test
    public void testGetName() {
        Customer c = new Customer("David", new CustomerType(CustomerType.REGULAR));

        assertEquals("David", c.getName());
    }

    @Test
    public void testStatementForRegularMovie() {
        Customer customer2 = new Customer("Sallie", new CustomerType(CustomerType.REGULAR));
        Rental rental1 = new Rental(new Movie("Gone with the Wind", Movie.REGULAR), 3); // 3 day rental

        customer2.addRental(rental1);

        String expected = "Rental Record for Sallie\n" +
                "\tGone with the Wind\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";

        assertEquals(expected, customer2.statement());
    }

    @Test
    public void testStatementForNewReleaseMovie() {
        Customer customer2 = new Customer("Sallie", new CustomerType(CustomerType.REGULAR));

        Rental rental1 = new Rental(new Movie("Star Wars", Movie.NEW_RELEASE), 3); // 3 day rental
        customer2.addRental(rental1);

        String expected = "Rental Record for Sallie\n" +
                "\tStar Wars\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points";

        assertEquals(expected, customer2.statement());
    }

    @Test
    public void testStatementForChildrensMovie() {
        Customer customer2 = new Customer("Sallie", new CustomerType(CustomerType.REGULAR));

        Rental rental1 = new Rental(new Movie("Madagascar", Movie.CHILDRENS), 3); // 3 day rental
        customer2.addRental(rental1);

        String expected = "Rental Record for Sallie\n" +
                "\tMadagascar\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";

        assertEquals(expected, customer2.statement());
    }

    @Test
    public void testStatementForManyMoviesForRegularCustomer() {
        Customer customer1 = new Customer("David", new CustomerType(CustomerType.REGULAR));

        Rental rental1 = new Rental(new Movie("Madagascar", Movie.CHILDRENS), 6); // 6 day rental
        Rental rental2 = new Rental(new Movie("Star Wars", Movie.NEW_RELEASE), 2); // 2 day rental
        Rental rental3 = new Rental(new Movie("Gone with the Wind", Movie.REGULAR), 8); // 8 day rental

        customer1.addRental(rental1);
        customer1.addRental(rental2);
        customer1.addRental(rental3);

        String expected = "Rental Record for David\n" +
                "\tMadagascar\t6.0\n" +
                "\tStar Wars\t6.0\n" +
                "\tGone with the Wind\t11.0\n" +
                "Amount owed is 23.0\n" +
                "You earned 4 frequent renter points";

        assertEquals(expected, customer1.statement());
    }

    @Test
    public void testStatementForManyMoviesForPremiumCustomer() {
        Customer customer1 = new Customer("David", new CustomerType(CustomerType.PREMIUM));

        Rental rental1 = new Rental(new Movie("Madagascar", Movie.CHILDRENS), 6); // 6 day rental
        Rental rental2 = new Rental(new Movie("Star Wars", Movie.NEW_RELEASE), 2); // 2 day rental
        Rental rental3 = new Rental(new Movie("Gone with the Wind", Movie.REGULAR), 8); // 8 day rental

        customer1.addRental(rental1);
        customer1.addRental(rental2);
        customer1.addRental(rental3);

        String expected = "Rental Record for David\n" +
                "\tMadagascar\t6.0\n" +
                "\tStar Wars\t6.0\n" +
                "\tGone with the Wind\t11.0\n" +
                "Amount owed is 18.4\n" +
                "You earned 4 frequent renter points";

        assertEquals(expected, customer1.statement());
    }
}
