package exception;

public class InvalidCVV2 extends InvalidInput{
    public InvalidCVV2(String message) {
        super(message);
    }
    public InvalidCVV2() {
        super("InvalidCVV2!");
    }
}
