import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import entity.Account;

public class BankManager {
    private Map<String, Account> accounts = new HashMap<>();

    public void addAccount(Account acc) {
        accounts.put(acc.getAccountNumber(), acc);
    }

    public Account getAccount(String accNum) {
        return accounts.get(accNum);
    }

    // Find the rich account
    public List<Account> getWealthyAccounts() {
        return accounts.values().stream()
            .filter(acc -> acc.getBalance() > 10_000_000)
            .collect(Collectors.toList());
    }

    // Caculate total the sum balance of the bank
    public double getTotalBankBalance() {
        return accounts.values().stream()
                    .mapToDouble(Account::getBalance)
                    .sum();
    }
}
