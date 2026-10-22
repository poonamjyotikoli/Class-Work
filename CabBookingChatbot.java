
import java.util.Random;
import java.util.Scanner;

public class CabBookingChatbot {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    static int getChoice(String message, int min, int max) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            try {
                int choice = Integer.parseInt(input);
                if (choice >= min && choice <= max) {
                    return choice;
                }
            } catch (NumberFormatException e) {
                // Handle invalid input
            }

            System.out.println("Invalid choice! Please try again.");
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== CAB BOOKING CHATBOT =====");
            System.out.println("1. Book Ride");
            System.out.println("2. Exit");

            int menu = getChoice("Enter your choice: ", 1, 2);

            if (menu == 2) {
                System.out.println("Thank you for using Cab Booking Chatbot!");
                break;
            }

            System.out.println("\nChoose Cab Type:");
            System.out.println("1. Auto - Rs.12/km");
            System.out.println("2. Sedan - Rs.18/km");
            System.out.println("3. SUV - Rs.25/km");

            int cab = getChoice("Enter cab choice: ", 1, 3);

            String cabType;
            int rate;

            if (cab == 1) {
                cabType = "Auto";
                rate = 12;
            } else if (cab == 2) {
                cabType = "Sedan";
                rate = 18;
            } else {
                cabType = "SUV";
                rate = 25;
            }

            System.out.println("\nChoose Route:");
            System.out.println("1. Pune Station -> Shivajinagar (5 km)");
            System.out.println("2. Swargate -> Kothrud (8 km)");
            System.out.println("3. Hinjawadi -> Wakad (10 km)");

            int route = getChoice("Enter route choice: ", 1, 3);

            String source;
            String destination;
            int distance;

            if (route == 1) {
                source = "Pune Station";
                destination = "Shivajinagar";
                distance = 5;
            } else if (route == 2) {
                source = "Swargate";
                destination = "Kothrud";
                distance = 8;
            } else {
                source = "Hinjawadi";
                destination = "Wakad";
                distance = 10;
            }

            int fare = distance * rate;

            System.out.println("\n===== RIDE DETAILS =====");
            System.out.println("Source      : " + source);
            System.out.println("Destination : " + destination);
            System.out.println("Cab Type    : " + cabType);
            System.out.println("Distance    : " + distance + " km");
            System.out.println("Rate        : Rs." + rate + "/km");
            System.out.println("Total Fare  : Rs." + fare);

            System.out.println("\n1. Confirm & Share OTP");
            System.out.println("2. Cancel Ride");

            int confirm = getChoice("Enter your choice: ", 1, 2);

            if (confirm == 2) {
                System.out.println("Ride cancelled before OTP sharing.");
                System.out.println("Returning to main menu...");
                continue;
            }

            int otp = 1000 + random.nextInt(9000);

            System.out.println("\n===== RIDE CONFIRMED =====");
            System.out.println("Your OTP is: " + otp);
            System.out.println("OTP shared successfully!");
            System.out.println("Cancellation is not allowed after OTP sharing.");
            System.out.println("Returning to main menu...");
        }

        sc.close();
    }
}
