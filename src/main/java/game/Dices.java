package game;

import java.util.Random;

public class Dices {

    private static Integer firstDice;
    private static Integer secondDice;

    public Dices() {
        rollDices();
    }

    public void rollDices() {
        Random random = new Random();
        firstDice = random.nextInt(6) + 1;
        secondDice = random.nextInt(6) + 1;
    }

    public static Integer getFirstDice() {
        return firstDice;
    }

    public static Integer getSecondDice() {
        return secondDice;
    }

    public static void setFirstDice(Integer firstDice) {
        Dices.firstDice = firstDice;
    }

    public static void setSecondDice(Integer secondDice) {
        Dices.secondDice = secondDice;
    }

}
