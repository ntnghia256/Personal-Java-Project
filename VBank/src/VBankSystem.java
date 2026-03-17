public class VBankSystem {
    public static void main(String[] args) throws Exception {
        BankManager manager = new BankManager();

        // Init data
        manager.addAccount(new SavingAccount("V001", "Nguyen Van A", 50000000));
        manager.addAccount(new SavingAccount("V002", "Tran Thi B", 2000000));
        manager.addAccount(new SavingAccount("V003", "Le Van C", 15000000));
    }
}
