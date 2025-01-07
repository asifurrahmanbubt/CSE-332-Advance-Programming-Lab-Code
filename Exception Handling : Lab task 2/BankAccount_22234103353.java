// 22234103353
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", Balance: " + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds! Current balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrew: " + amount + ", Balance: " + balance);
    }
}

public class BankAccount_22234103353 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        try {
            account.deposit(500);
            account.withdraw(600); // Will throw exception
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
