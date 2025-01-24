package view;

import controller.GameController;
import model.Dice;
import model.Hmac;
import utilities.Messages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            Messages.showUsageMessage();
            Messages.showExampleMessage();
            return;
        }

        List<Integer[]> predefinedDices = new ArrayList<>();
        try {
            for (String arg : args) {
                String[] values = arg.split(",");
                Integer[] dice = Arrays.stream(values).map(Integer::parseInt).toArray(Integer[]::new);
                predefinedDices.add(dice);
            }
        } catch (NumberFormatException e) {
            Messages.showInvalidDiceFormat();
            return;
        }

        Dice diceModel = new Dice();
        Hmac hmac = new Hmac();

        // Inicializar el controlador del juego
        GameController gameController = new GameController(diceModel, hmac);
        gameController.initializeGameDice(predefinedDices);

        Messages.showWelcomeMessage();
        Messages.showMessage("Available dice: " + gameController.getAvailableDice());
        Scanner scanner = new Scanner(System.in);

        try {
            Messages.showMessage("\nLet's determine who makes the first move.");
            int firstMoveRandom = (int) (Math.random() * 2); // Selección aleatoria 0 o 1
            String hmacFirstMove = gameController.getHmacSecretKey();
            Messages.showMessage("I selected a random value in the range 0..1 (HMAC=" + hmacFirstMove + ").");
            Messages.showMessage("Try to guess my selection.");

            while (true) {
                Messages.showMessage("0 - 0\n1 - 1\nX - exit\n? - help");
                System.out.print("Your selection: ");
                String selection = scanner.nextLine().trim();

                if (selection.equalsIgnoreCase("X")) {
                    Messages.showGoodbyeMessage();
                    break;
                } else if (selection.equals("?")) {
                    Messages.showHelpMessage();
                    continue;
                }

                int playerGuess;
                try {
                    playerGuess = Integer.parseInt(selection);
                } catch (NumberFormatException e) {
                    Messages.showInvalidInputMessage();
                    continue;
                }

                if (playerGuess == firstMoveRandom) {
                    Messages.showGuessResultCorrect();
                } else {
                    Messages.showGuessResultIncorrect();
                }
                break;
            }

            Messages.showDiceChoiceMessage();
            for (int i = 0; i < predefinedDices.size(); i++) {
                System.out.println(i + " - " + Arrays.toString(predefinedDices.get(i)));
            }
            Messages.showMessage("X - exit\n? - help");

            while (true) {
                System.out.print("Your selection: ");
                String diceSelection = scanner.nextLine().trim();

                if (diceSelection.equalsIgnoreCase("X")) {
                    Messages.showGoodbyeMessage();
                    break;
                } else if (diceSelection.equals("?")) {
                    Messages.showHelpMessage();
                    continue;
                }

                int playerDiceIndex;
                try {
                    playerDiceIndex = Integer.parseInt(diceSelection);
                    if (playerDiceIndex < 0 || playerDiceIndex >= predefinedDices.size()) {
                        Messages.showInvalidDiceIndex();
                        continue;
                    }
                } catch (NumberFormatException e) {
                    Messages.showInvalidInputMessage();
                    continue;
                }

                System.out.println("You chose the dice: " + Arrays.toString(predefinedDices.get(playerDiceIndex)));
                break;
            }

            Messages.showMessage("\nIt's time for your throw.");
            int diceIndex = 0;
            String result = gameController.rollDiceWithHmac(diceIndex);
            Messages.showMessage(result);

        } catch (Exception e) {
            Messages.showMessage("An error occurred during the game: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
