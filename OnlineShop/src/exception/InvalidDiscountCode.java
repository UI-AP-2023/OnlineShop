package exception;

public class InvalidDiscountCode extends Exception {
    public InvalidDiscountCode(String message)
    {
        super("Invalid discount code-"+message);
    }

}
