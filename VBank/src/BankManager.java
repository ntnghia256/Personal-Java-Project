import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import entity.Account;
import entity.SavingAccount;

public class BankManager {
    private Map<String, Account> accounts = new HashMap<>();

    public void addAccount(Account acc) {
        accounts.put(acc.getAccountNumber(), acc);
    }

    public Account getAccount(String accNum) {
        return accounts.get(accNum);
    }

    // Get all balance accounts
    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts.values());
    }

    // Find the rich account
    public List<Account> getWealthyAccounts() {
        return accounts.values().stream()
            .filter(acc -> acc.getBalance() > 10_000_000)
            .collect(Collectors.toList());
    }

    // Calculate total the sum balance of the bank
    public double getTotalBankBalance() {
        return accounts.values().stream()
                    .mapToDouble(Account::getBalance)
                    .sum();
    }

    // Get all name of user with UpperCase
    public List<String> getOwnerNames() {
        return accounts.values().stream()
            .map(Account::getOwner)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    }

    // Save data to file
    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Account acc : accounts.values()) {
                String line = String.format("%s,%s,%.0f", acc.getAccountNumber(), acc.getOwner(), acc.getBalance());
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Save data successfully into " + filename);
        } catch (Exception e) {
            System.err.println("Error when saving file " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 3) {  
                    String id = data[0];
                    String name = data[1];
                    double bal = Double.parseDouble(data[2]);
                    // Create object and add to Map
                    this.addAccount(new SavingAccount(id, name, bal));
                }
            }
            System.out.println("Read data successfully from file " + filename);
        } catch (Exception e) {
            System.err.println("Error when read file or file do not exists!");
        }
    }

    // Multithreading - Calculate interest
    public void runInterestTask() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (Account acc : accounts.values()) {
            executor.execute(() -> {
                if (acc != null) {
                SavingAccount sa = (SavingAccount) acc;
                sa.deposit(sa.calculateInterest(sa.getBalance()));
                System.out.println("Calculated the interest for: " + sa.getAccountNumber() + " by " + Thread.currentThread().getName());
            }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait for threads execute done!
        }
        System.out.println("Finished calculate the interest of VBank System!");
    }
}
