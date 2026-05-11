package wordCounter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence(s) or paragraph(s): ");

        String input = sc.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("No input provided.");
        } else {
            String[] words = input.split("\\s+");
            System.out.printf("There are %d words in the text.\n", words.length);
        }

        sc.close();
    }
}