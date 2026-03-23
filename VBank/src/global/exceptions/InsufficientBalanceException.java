package global.exceptions;

// Unchecked exception - Occur when has an invalid balance
public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}