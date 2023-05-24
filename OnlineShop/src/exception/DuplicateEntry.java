package exception;

abstract public class DuplicateEntry extends Exception {
    public DuplicateEntry(String message)
    {
        super("Duplicate entry-"+message);
    }
}
