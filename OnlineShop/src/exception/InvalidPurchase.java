package exception;

public class InvalidPurchase extends Exception{
    public InvalidPurchase(String message)
    {
        super("Invalid purchase-"+message);
    }
}
