package foo;

import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.Vector;

//From book: 'Refactoring' by Martin Fowler
//This is the original code before refactoring begins

public class Customer {

    private String _name;
    private Vector _rentals = new Vector();
    private CustomerType _type;
    private double _discountRating = 0.8;

    public Customer(String name, CustomerType type) {
        _name = name;
        _type = type;
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

        result += "Amount owed is " + formatAmount(getTotalRenterAmount()) + "\n";
        result += "You earned " + String.valueOf(getTotalRenterPoints()) + " frequent renter points";

        return result;
    }

    public String formatAmount(double amount) {
        return new DecimalFormat(".#").format(amount);
    }

    private double getTotalRenterAmount() {
        Enumeration rentals = _rentals.elements();
        double totalAmount = 0;
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            totalAmount += each.getRenterAmount();
        }

        if (_type.isPremium()) {
            totalAmount *= _discountRating;
        }
        return totalAmount;
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
