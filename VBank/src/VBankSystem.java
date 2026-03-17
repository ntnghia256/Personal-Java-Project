import entity.Account;
import global.exceptions.InsufficientBalanceException;
import global.exceptions.InvalidAmountException;

public class VBankSystem {
    public static void main(String[] args) throws Exception {
        BankManager manager = new BankManager();

        // Init data
        manager.addAccount(new SavingAccount("V001", "Nguyen Van A", 50000000));
        manager.addAccount(new SavingAccount("V002", "Tran Thi B", 2000000));
        manager.addAccount(new SavingAccount("V003", "Le Van C", 15000000));

        System.out.println("--- DANH SACH TAI KHOAN GIAU CO ---");
        manager.getWealthyAccounts().forEach(System.out::println);

        // Thu nghiem Exception
        Account accA = manager.getAccount("V001");
        try {
            System.out.println("\nThuc hien rut tien cho Nguyen Van A...");
            accA.withdraw(60000000); // Se gay loi
        } catch (InsufficientBalanceException e) {
            System.err.println("LOI: " + e.getMessage());
        }

        try {
            System.out.println("\nThuc hien gui tien am...");
            accA.deposit(-100); // Se gay loi Runtime
        } catch (InvalidAmountException e) {
            System.err.println("LOI HE THONG: " + e.getMessage());
        }

        System.out.println("\nTong tai san tai VBank: " + String.format("%,.0f", manager.getTotalBankBalance()) + " VND");
    }
}
