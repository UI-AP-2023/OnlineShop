package exception;

public class InvalidPasswordCard extends InvalidInput{
    public InvalidPasswordCard(String message) {
        super(message);
    }
    public InvalidPasswordCard() {
        super("InvalidPasswordCard!");
    }
}
