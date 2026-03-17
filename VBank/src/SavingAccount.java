import entity.Account;
import global.exceptions.InsufficientBalanceException;
import global.exceptions.InvalidAmountException;

public class SavingAccount extends Account {
    private static final double WITHDRAW_FEE = 5000;
    private static double interestRate = 0.05;

    public SavingAccount(String accountNumber, String owner, double balance) {
        super(accountNumber, owner, balance);
    }

    public double calculateInterest(double balance) {
        return balance * interestRate;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) throw new InvalidAmountException("The money need to more than 0");

        double totalRequired =  amount + WITHDRAW_FEE;
        if (totalRequired > balance) {
            throw new InsufficientBalanceException("The balance do not enough to deposit " + amount + " - Fee: " + WITHDRAW_FEE);
        }

        balance -= totalRequired;
        System.out.println("Deposit successfully " + amount + " - Fee: " + WITHDRAW_FEE);
    }
    
}
