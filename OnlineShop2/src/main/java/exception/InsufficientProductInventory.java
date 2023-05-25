package exception;

public class InsufficientProductInventory extends InvalidPurchase{

    public InsufficientProductInventory(String message) {
        super(message);
    }
    public InsufficientProductInventory() {
        super("InsufficientProductInventory");
    }
}
