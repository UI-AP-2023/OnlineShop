package exception;

public class DuplicateEmail extends DuplicateEntry{
    public DuplicateEmail(String message) {
        super(message);
    }
    public DuplicateEmail() {
        super("DuplicateEmail");
    }
}
