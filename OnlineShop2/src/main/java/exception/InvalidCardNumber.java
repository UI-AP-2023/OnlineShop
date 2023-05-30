package exception;

public class InvalidCardNumber extends InvalidInput {
    public InvalidCardNumber(String message) {
        super(message);
    }
    public InvalidCardNumber() {
        super("InvalidCardNumber!");
    }
}
