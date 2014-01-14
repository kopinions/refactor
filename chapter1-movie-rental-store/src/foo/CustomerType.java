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

    public CustomerType(int type) {

        this.type = type;
    }

    public boolean isPremium() {

        return type == PREMIUM;
    }
}
