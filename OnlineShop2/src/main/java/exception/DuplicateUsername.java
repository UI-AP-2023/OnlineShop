package exception;

public class DuplicateUsername extends DuplicateEntry {
    public DuplicateUsername(String message) {
        super(message);
    }

    public DuplicateUsername() {
        super("DuplicateUsername");
    }
}
