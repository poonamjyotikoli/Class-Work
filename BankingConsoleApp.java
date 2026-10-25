
import java.util.Scanner;

public class BankingConsoleApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double balance = 10000.00;
        boolean running = true;

        System.out.println("================================");
        System.out.println("     WELCOME TO SIMPLE BANK");
        System.out.println("================================");

        while (running) {
            System.out.println("\n------ BANKING MENU ------");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.printf("Current Balance: Rs. %.2f%n",
                            balance);
                    break;

                case "2":
                    System.out.print("Enter deposit amount: ");
                    try {
                        double amount = Double.parseDouble(
                                sc.nextLine().trim());

                        if (Double.isFinite(amount) && amount > 0) {
                            balance += amount;
                            System.out.println("Deposit successful!");
                            System.out.printf(
                                    "Updated Balance: Rs. %.2f%n",
                                    balance);
                        } else {
                            System.out.println(
                                    "Invalid amount! Enter an amount greater than 0.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Invalid input! Please enter a valid amount.");
                    }
                    break;

                case "3":
                    System.out.print("Enter withdrawal amount: ");
                    try {
                        double amount = Double.parseDouble(
                                sc.nextLine().trim());

                        if (!Double.isFinite(amount) || amount <= 0) {
                            System.out.println(
                                    "Invalid amount! Enter an amount greater than 0.");
                        } else if (amount > balance) {
                            System.out.println(
                                    "Insufficient balance!");
                        } else {
                            balance -= amount;
                            System.out.println("Withdrawal successful!");
                            System.out.printf(
                                    "Remaining Balance: Rs. %.2f%n",
                                    balance);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Invalid input! Please enter a valid amount.");
                    }
                    break;

                case "4":
                    System.out.println(
                            "Thank you for using Simple Bank. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println(
                            "Invalid choice! Please select 1, 2, 3, or 4.");
            }
        }

        sc.close();
    }
}
