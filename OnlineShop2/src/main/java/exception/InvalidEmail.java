package exception;

public class InvalidEmail extends InvalidInput{
    public InvalidEmail(String message) {
        super(message);
    }
    public InvalidEmail() {
        super("InvalidEmail");
    }
}
