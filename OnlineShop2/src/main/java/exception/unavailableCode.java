package exception;

public class unavailableCode extends InvalidDiscountCode {
    public unavailableCode(String message) {
        super(message);
    }

    public unavailableCode() {
        super("unavailableCode");
    }
}
