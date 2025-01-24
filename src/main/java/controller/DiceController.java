package controller;

import model.Dice;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

public class DiceController {

    private final Dice dice;

    public DiceController(Dice dice) {
        this.dice = dice;
    }

    public int rollDice(int diceIndex) {
        if (diceIndex < 0 || diceIndex >= dice.getDices().size()) {
            throw new IllegalArgumentException("Invalid dice index: " + diceIndex);
        }

        Integer[] selectedDice = dice.getDices().get(diceIndex);
        SecureRandom random = new SecureRandom();
        return selectedDice[random.nextInt(selectedDice.length)];
    }

    public List<String> getAvailableDices() {
        List<Integer[]> dicesList = dice.getDices();
        return dicesList.stream()
                .map(d -> "Dice: " + List.of(d))
                .collect(Collectors.toList());
    }

    public void initializeDices(List<Integer[]> predefinedDices) {
        dice.setDices(predefinedDices);
    }
}
