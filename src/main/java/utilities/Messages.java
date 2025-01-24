package utilities;

public class Messages {

    public static final String USAGE_MESSAGE = "Usage: java -jar game.jar <dice1> <dice2> ...";
    public static final String EXAMPLE_MESSAGE = "Example: java -jar game.jar 2,2,4,4,9,9 6,8,1,1,8,6 7,5,3,7,5,3";
    public static final String INVALID_DICE_FORMAT = "Error: Invalid dice format. Ensure dice values are integers separated by commas.";
    public static final String WELCOME_MESSAGE = "Welcome to the Dice Game!";
    public static final String HELP_MESSAGE = "Help: Enter 0 or 1 to guess the computer's selection. X to exit.";
    public static final String INVALID_INPUT_MESSAGE = "Invalid input. Please enter 0, 1, or X.";
    public static final String INVALID_DICE_INDEX = "Invalid index. Please select a valid dice index.";
    public static final String GOODBYE_MESSAGE = "Exiting the game. Goodbye!";
    public static final String GUESS_RESULT_CORRECT = "You guessed correctly! You make the first move.";
    public static final String GUESS_RESULT_INCORRECT = "I make the first move.";
    public static final String DICE_CHOICE_MESSAGE = "Choose your dice:";

    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static void showUsageMessage() {
        showMessage(USAGE_MESSAGE);
    }

    public static void showExampleMessage() {
        showMessage(EXAMPLE_MESSAGE);
    }

    public static void showInvalidDiceFormat() {
        showMessage(INVALID_DICE_FORMAT);
    }

    public static void showWelcomeMessage() {
        showMessage(WELCOME_MESSAGE);
    }

    public static void showHelpMessage() {
        showMessage(HELP_MESSAGE);
    }

    public static void showInvalidInputMessage() {
        showMessage(INVALID_INPUT_MESSAGE);
    }

    public static void showInvalidDiceIndex() {
        showMessage(INVALID_DICE_INDEX);
    }

    public static void showGoodbyeMessage() {
        showMessage(GOODBYE_MESSAGE);
    }

    public static void showGuessResultCorrect() {
        showMessage(GUESS_RESULT_CORRECT);
    }

    public static void showGuessResultIncorrect() {
        showMessage(GUESS_RESULT_INCORRECT);
    }

    public static void showDiceChoiceMessage() {
        showMessage(DICE_CHOICE_MESSAGE);
    }
}
