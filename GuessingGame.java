import java.util.*;

public class GuessingGame {
    private static final ArrayList<Integer> scoreBoard = new ArrayList<>();

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        game.displayMenu();
    }

    private void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n***************************************************");
            System.out.println("            Welcome to the Number Guessing Game");
            System.out.println("***************************************************");
            System.out.println("1. Play the Game");
            System.out.println("2. View Scoreboard");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    playGame(scanner);
                    break;
                case 2:
                    displayScoreBoard();
                    break;
                case 3:
                    System.out.println("Thank you for playing!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private void playGame(Scanner scanner) {
        System.out.print("Enter the number range (e.g., 100): ");
        int numberRange = scanner.nextInt();

        int randomNumber = generateRandomNumber(numberRange);
        int attempts = guessNumber(randomNumber, scanner);

        scoreBoard.add(attempts);
        System.out.println("Your score has been recorded.");
    }

    private int generateRandomNumber(int numberRange) {
        Random random = new Random();
        return random.nextInt(numberRange) + 1;
    }

    private int guessNumber(int randomNumber, Scanner scanner) {
        int userGuess;
        int attempts = 0;

        do {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess > randomNumber) {
                System.out.println("Your guess is too high. Try again.");
            } else if (userGuess < randomNumber) {
                System.out.println("Your guess is too low. Try again.");
            }
        } while (randomNumber != userGuess);

        if (attempts == 1) {
            System.out.println("Congratulations! You guessed the number correctly in " + attempts + " try.");
        } else {
            System.out.println("Congratulations! You guessed the number correctly in " + attempts + " tries.");
        }

        return attempts;
    }

    private void displayScoreBoard() {
        System.out.println("\n----- Scoreboard -----");
        if (scoreBoard.isEmpty()) {
            System.out.println("No scores recorded yet.");
        } else {
            Collections.sort(scoreBoard);
            System.out.println("Your fastest games today (in ascending order of attempts):");
            for (int score : scoreBoard) {
                System.out.println("Finished the game in " + score + " attempts");
            }
        }
    }
}