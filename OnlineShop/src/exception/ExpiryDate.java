package exception;

public class ExpiryDate extends InvalidDiscountCode{
    public ExpiryDate(String message) {
        super(message);
    }
    public ExpiryDate() {
        super("ExpiryDate");
    }
}
