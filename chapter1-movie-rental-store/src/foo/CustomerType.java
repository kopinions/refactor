package foo;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 1/14/14
 * Time: 11:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerType {
    public static final int REGULAR = 0;
    public static final int PREMIUM = 1;

    private int customerType;
    private double discountRating;

    public CustomerType(int customerType) {
        this.customerType = customerType;
        discountRating = customerType==PREMIUM ? 0.8 : 1;
    }

    public boolean isRegularCustomer() {
        return getCustomerType() == CustomerType.REGULAR;
    }

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }


    public double getDiscountRating() {
        return discountRating;
    }

    public void setDiscountRating(double discountRating) {
        this.discountRating = discountRating;
    }
}
