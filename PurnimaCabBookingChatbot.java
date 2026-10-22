
import java.util.Random;
import java.util.Scanner;

public class PurnimaCabBookingChatbot {

    static Scanner input = new Scanner(System.in);
    static Random random = new Random();

    static String[] cabNames = { "Auto", "Sedan", "SUV" };
    static int[] rates = { 12, 18, 25 };

    static String[] sources = {
            "Pune Station", "Swargate", "Hinjawadi"
    };

    static String[] destinations = {
            "Shivajinagar", "Kothrud", "Wakad"
    };

    static int[] distances = { 5, 8, 10 };

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("     PURNIMA'S CAB BOOKING");
        System.out.println("==================================");

        boolean running = true;

        while (running) {
            System.out.println("\n------ MAIN MENU ------");
            System.out.println("1. Book Ride");
            System.out.println("2. Exit");

            int menuChoice = readChoice("Enter your choice: ", 1, 2);

            if (menuChoice == 1) {
                bookRide();
            } else {
                System.out.println("Thank you for using Purnima's Cab Booking!");
                running = false;
            }
        }

        input.close();
    }

    static void bookRide() {

        System.out.println("\n------ SELECT CAB ------");
        for (int i = 0; i < cabNames.length; i++) {
            System.out.println((i + 1) + ". " + cabNames[i]
                    + " - Rs." + rates[i] + "/km");
        }

        int cabChoice = readChoice("Choose cab type: ", 1, 3);
        int cabIndex = cabChoice - 1;

        System.out.println("\n------ AVAILABLE ROUTES ------");

        for (int i = 0; i < sources.length; i++) {
            System.out.println((i + 1) + ". " + sources[i]
                    + " to " + destinations[i]
                    + " (" + distances[i] + " km)");
        }

        int routeChoice = readChoice("Choose route: ", 1, 3);
        int routeIndex = routeChoice - 1;

        int distance = distances[routeIndex];
        int rate = rates[cabIndex];
        int fare = distance * rate;

        System.out.println("\n------ RIDE DETAILS ------");
        System.out.println("Cab Type   : " + cabNames[cabIndex]);
        System.out.println("Source     : " + sources[routeIndex]);
        System.out.println("Destination: " + destinations[routeIndex]);
        System.out.println("Distance   : " + distance + " km");
        System.out.println("Rate       : Rs." + rate + "/km");
        System.out.println("Total Fare : Rs." + fare);

        System.out.println("\n------ CONFIRMATION ------");
        System.out.println("1. Confirm and Share OTP");
        System.out.println("2. Cancel Ride");

        int confirmChoice = readChoice("Enter your choice: ", 1, 2);

        if (confirmChoice == 2) {
            System.out.println("Ride cancelled before OTP sharing.");
            System.out.println("Returning to main menu...");
            return;
        }

        int otp = 1000 + random.nextInt(9000);

        System.out.println("\n------ BOOKING CONFIRMED ------");
        System.out.println("Your ride has been booked successfully.");
        System.out.println("Your 4-digit OTP is: " + otp);
        System.out.println("Please share this OTP with your driver.");
        System.out.println("Cancellation is not allowed after OTP sharing.");
        System.out.println("Returning to main menu...");
    }

    static int readChoice(String message, int min, int max) {

        while (true) {
            System.out.print(message);
            String value = input.nextLine();

            try {
                int choice = Integer.parseInt(value.trim());

                if (choice >= min && choice <= max) {
                    return choice;
                }
            } catch (NumberFormatException e) {
                // Handle non-numeric input
            }

            System.out.println("Invalid choice! Please enter "
                    + min + " to " + max + ".");
        }
    }
}
