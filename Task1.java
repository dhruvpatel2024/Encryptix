import java.util.Scanner;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        boolean playAgain;

        int totalRounds = 0;
        int totalScore = 0;

        do {
            totalRounds++;
            int attempts = playGame(rand, sc);
            totalScore += attempts > 0 ? 10 - attempts : 0; 
            System.out.print("Do you want to play again? (yes/no): ");
            String response = sc.nextLine().trim();
            playAgain = response.equalsIgnoreCase("yes");
        } while (playAgain);

        sc.close();
        System.out.println("\n**************************************************");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Total score: " + totalScore);
    }

    public static int playGame(Random rand, Scanner sc) {
        int numberToGuess = rand.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 10;
        boolean guessedCorrectly = false;

        System.out.println("\n------------------------------------------------------------------");
        System.out.println("I have generated a number between 1 and 100. Can you guess it?");
        
        while (attempts < maxAttempts && !guessedCorrectly) {
            System.out.print("Enter your guess: ");
            if (sc.hasNextInt()) {
                int userGuess = sc.nextInt();
                sc.nextLine();  // consume the newline character
                attempts++;
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    guessedCorrectly = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            } else {
                sc.nextLine();  // consume invalid input
                System.out.println("Invalid input. Please enter an integer.");
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess);
        }

        return guessedCorrectly ? attempts : 0;
    }
}
