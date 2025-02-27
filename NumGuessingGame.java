import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumGuessingGame {

    private int level;
    private int max;
    private int guess;
    private int attempts;
    private int randomNum;
    private Random rand;
    private Scanner sc;
    private String playAgain;

    // Constructor
    public NumGuessingGame() {
        rand = new Random();
        sc = new Scanner(System.in);
        attempts = 0;
    }

    public void startGame() {
        System.out.println("Welcome to Guessing Game! \n\nPlease select a difficulty level... \n1 = Easy \n2 = Medium \n3 = Hard \n\nLevel: ");
        level = sc.nextInt();

        // Set the level
        setMax();

        //Random number generator
        randomNum = rand.nextInt(max) + 1;


        System.out.println("Guess a number between 1 and " + max + " : ");
        do {

            int maxAttempts = 10;

            System.out.println("Guess: ");

            try {
                guess = sc.nextInt();
                attempts++;

                if (guess < randomNum) {
                    System.out.println("Your number is too low! Try again!");
                } else if (guess > randomNum) {
                    System.out.println("Your number is too high! Try again!");
                } else {
                    System.out.println("Your number is correct! Congratulations! The number was " + randomNum);
                    System.out.println("# of guesses: " + attempts);
                    break;
                }
                if (attempts >= maxAttempts) {
                    System.out.println("Sorry! You have reached the maximum number of attempts. The number was " + randomNum + "! Try again next time.");
                    break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Your input is invalid! Please enter a number between 1 and " + max + " : ");
                sc.nextLine();
            }
        } while (guess != randomNum);
    }

    // Method for level
    private void setMax() {
        if (level == 1) {
            max = 50;
        } else if (level == 2) {
            max = 100;
        } else if (level == 3) {
            max = 500;
        }
    }

    public static void main(String[] args) {
        NumGuessingGame game = new NumGuessingGame();
        game.startGame();
    }
}
