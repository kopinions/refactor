package foo;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 1/14/14
 * Time: 2:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerType {
    public final static int REGULAR = 0;
    public final static int PREMIUM = 1;
    private int type;

    private double discountRating;
    public CustomerType(int type) {

        this.type = type;
        discountRating = type == REGULAR ? 1 : 0.8;
    }

    public boolean isPremium() {

        return type == PREMIUM;
    }

    public double getDiscountRating() {
        return discountRating;
    }

    public void setDiscountRating(double discountRating) {
        this.discountRating = discountRating;
    }
}
