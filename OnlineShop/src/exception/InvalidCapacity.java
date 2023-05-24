package exception;

public class InvalidCapacity extends InvalidDiscountCode{
    public InvalidCapacity(String message) {
        super(message);
    }
    public InvalidCapacity() {
        super("InvalidCapacity");
    }
}
