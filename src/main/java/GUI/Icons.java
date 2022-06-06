package GUI;

import javax.swing.*;
import java.util.ArrayList;

public class Icons {

    private static Icons icons = null;

    String backgroundFileName = "E:\\projects\\Backgammon_repo\\Backgammon\\src\\main\\resources\\img\\background.png";
    String blueTokenFileName = "E:\\projects\\Backgammon_repo\\Backgammon\\src\\main\\resources\\img\\blueChip.gif";
    String whiteTokenFileName = "E:\\projects\\Backgammon_repo\\Backgammon\\src\\main\\resources\\img\\whiteChip.gif";
    String greenTokenFileName = "E:\\projects\\Backgammon_repo\\Backgammon\\src\\main\\resources\\img\\greenRing.gif";
    String rollDicesFileName = "E:\\projects\\Backgammon_repo\\Backgammon\\src\\main\\resources\\img\\dice.gif";

    ImageIcon backgroundImage = new ImageIcon(backgroundFileName);
    ImageIcon blueTokenImage = new ImageIcon(blueTokenFileName);
    ImageIcon whiteTokenImage = new ImageIcon(whiteTokenFileName);
    ImageIcon greenRingImage = new ImageIcon(greenTokenFileName);
    ImageIcon rollDicesImage = new ImageIcon(rollDicesFileName);
    ArrayList<ImageIcon> blueDices = new ArrayList<>();
    ArrayList<ImageIcon> whiteDices = new ArrayList<>();

    private Icons() {
        for (int i = 1; i <= 6; i++) {
            String diceFileName = "E:\\projects\\Backgammon_repo\\Backgammon\\src\\main\\resources\\img\\blue" + i + ".gif";
            blueDices.add(new ImageIcon(diceFileName));
            diceFileName = "E:\\projects\\Backgammon_repo\\Backgammon\\src\\main\\resources\\img\\white" + i + ".gif";
            whiteDices.add(new ImageIcon(diceFileName));
        }
    }

    public static Icons getInstance() {
        if (icons == null)
            icons = new Icons();
        return icons;
    }
}
