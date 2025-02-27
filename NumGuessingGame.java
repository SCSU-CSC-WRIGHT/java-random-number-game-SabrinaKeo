import java.util.Random;
import java.util.Scanner;

public class NumGuessingGame {
    public static void main(String[] args) {

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    int guess;
    int attempts = 0;
    int min = 1;
    int max = 100;
    int randomNum = random.nextInt(min, max + 1);

    System.out.println("Welcome to the Number Guessing Game!");
    System.out.println("Guess a number between 1-100: ");

    do {
        System.out.println("Guess: ");
        guess = scanner.nextInt();
        attempts++;

        if (guess < randomNum) {
            System.out.println("Your number is too low! Try again!");
        } else if (guess > randomNum) {
            System.out.println("Your number is too high! Try again!");
        } else {
            System.out.println("Your number is correct! Congratulations! The number was " + randomNum);
            System.out.println("# of guesses: " + attempts);
        }
    }while(guess != randomNum);
}
}