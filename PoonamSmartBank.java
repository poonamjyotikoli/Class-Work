public class PoonamSmartBank {

    static double balance = 5000;

    static void checkBalance() {
        System.out.printf("Current Balance: Rs. %.2f%n", balance);
    }

    static void depositMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
        } else {
            balance += amount;
            System.out.printf("Deposited: Rs. %.2f%n", amount);
            checkBalance();
        }
    }

    static void withdrawMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Transaction failed! Insufficient balance.");
        } else {
            balance -= amount;
            System.out.printf("Withdrawn: Rs. %.2f%n", amount);
            checkBalance();
        }
    }

    public static void main(String[] args) {
        System.out.println("--------------------------------");
        System.out.println("       SWARUP SMART BANK");
        System.out.println("--------------------------------");

        checkBalance();

        System.out.println("\n--- Deposit Transaction ---");

        depositMoney(2000);

        System.out.println("\n--- Withdrawal Transaction ---");

        withdrawMoney(1500);

        System.out.println("\n--- Final Account Summary ---");

        checkBalance();

        System.out.println("\nBank with confidence, bank with us!");
        System.out.println("================================");
    }
}