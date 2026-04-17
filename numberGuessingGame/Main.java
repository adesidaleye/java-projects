package numberGuessingGame;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Guess the random number between 1 and 100: ");
        
        Random random = new Random();
        int randomNum = random.nextInt(1, 100);

        int userGuess = scanner.nextInt();
        int attempts = 15;

        while (true) {
            if (userGuess == randomNum || attempts == 0) {
                String msg = attempts == 0 ? "You are out of attempts, Sorry!" : "You guessed correctly!";
                System.out.println(msg + " The number is " + randomNum);
                break;
            }

            String suffix = attempts > 1 ? "s" : "";
            System.out.printf("You have %d attempt%s remaining%n", attempts, suffix);

            int diff = Math.abs(userGuess - randomNum);

            if (diff <= 10)         System.out.println("Very close");
            else if (diff <= 20)    System.out.println("Close");
            else if (diff <= 50)    System.out.println("Far");
            else                    System.out.println("Very far");

            System.out.print("Guess again: ");
            userGuess = scanner.nextInt();
            attempts--;
        }

        scanner.close();
    }
}