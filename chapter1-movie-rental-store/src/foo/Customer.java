package foo;

import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.Vector;

//From book: 'Refactoring' by Martin Fowler
//This is the original code before refactoring begins

public class Customer {

    private String _name;
    private Vector _rentals = new Vector();

    public static final int REGULAR = 0;
    public static final int PREMIUM = 1;

    private int customerType;
    private double discountRating;

    public Customer(String name, int customerType, double discountRating) {
        _name = name;
        this.customerType = customerType;
        this.discountRating = discountRating;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";

        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getRenterAmount()) + "\n";
        }
        if (customerType == Customer.REGULAR) {
            result += "Amount owed is " + formatAmount(getTotalRenterAmount()) + "\n";

        } else {
            result += "Amount owed is " + formatAmount(getDiscountAmount(getTotalRenterAmount())) + "\n";
        }

        result += "You earned " + String.valueOf(getTotalRenterPoints()) + " frequent renter points";

        if (customerType == Customer.REGULAR) {
            result += "\nYou can register to premium to save money";
        } else {
            result += "\nYou have saved " + formatAmount(getTotalRenterAmount() - getDiscountAmount(getTotalRenterAmount()));
        }

        return result;
    }

    private String formatAmount(double amount) {
        return new DecimalFormat(".#").format(amount);
    }

    private double getTotalRenterAmount() {
        Enumeration rentals = _rentals.elements();
        double totalAmount = 0;
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            totalAmount += each.getRenterAmount();
        }
        return totalAmount;
    }

    private double getDiscountAmount(double totalAmount) {
        double discountAmount = totalAmount;
        if (customerType == Customer.PREMIUM) {
            discountAmount *= discountRating;
        }

        return discountAmount;
    }

    private int getTotalRenterPoints() {
        Enumeration rentals = _rentals.elements();
        int frequentRenterPoints = 0;

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints += each.getFrequentPoint();
        }

        return frequentRenterPoints;
    }
}
