package controller;

import model.Dice;
import model.Hmac;
import model.Game;

import java.util.List;

public class GameController {

    private final DiceController diceController;
    private final HmacController hmacController;
    private final Game game;

    public GameController(Dice dice, Hmac hmac) {
        this.game = new Game(dice, hmac);
        this.diceController = new DiceController(dice);
        this.hmacController = new HmacController();
    }

    public String rollDiceWithHmac(int diceIndex) throws Exception {
        int rollResult = diceController.rollDice(diceIndex);
        String hmac = hmacController.generateHmac(String.valueOf(rollResult));
        return "Roll result: " + rollResult + ", HMAC: " + hmac;
    }

    public List<String> getAvailableDice() {
        return diceController.getAvailableDices();
    }

    public void initializeGameDice(List<Integer[]> predefinedDices) {
        diceController.initializeDices(predefinedDices);
    }

    public String getHmacSecretKey() {
        return hmacController.getSecretKeyBase64();
    }
}
