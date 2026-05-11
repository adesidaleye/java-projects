package wordCounter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence(s) or paragraph(s): ");

        int counter = 0;
        String word = sc.nextLine();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') continue;
            counter++;
        }

        System.out.printf("There are %d words in the text.\n", counter);
        sc.close();
    }
}