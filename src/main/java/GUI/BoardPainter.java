package GUI;

import com.sun.tools.javac.Main;
import game.Dices;
import game.Game;
import game.TokenType;

import javax.swing.*;
import java.awt.*;

public class BoardPainter {

    private final Icons icons = Icons.getInstance();
    private JButton rollDicesButton;
    private ImageIcon firstDice;
    private ImageIcon secondDice;
    private JLayeredPane firstDiceLabel = null;
    private JLayeredPane secondDiceLabel = null;
    private Dices dices = null;

    public BoardPainter() {
    }

    public void paintTokens(Graphics g) {
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < Game.getBoard().getPointsList().get(i + 1).getBlueTokensNumber(); j++) {
                g.drawImage(icons.blueTokenImage.getImage(), Canvas.xLimit - i * Canvas.tokenSize, Canvas.yLimit - j * Canvas.tokenSize, MainFrame.getCanvas());
            }
        for (int i = 6; i < 12; i++)
            for (int j = 0; j < Game.getBoard().getPointsList().get(i + 1).getBlueTokensNumber(); j++) {
                g.drawImage(icons.blueTokenImage.getImage(), Canvas.xLimit - (i + 2) * Canvas.tokenSize, Canvas.yLimit - j * Canvas.tokenSize, MainFrame.getCanvas());
            }
        for (int i = 12; i < 18; i++)
            for (int j = 0; j < Game.getBoard().getPointsList().get(i + 1).getBlueTokensNumber(); j++) {
                g.drawImage(icons.blueTokenImage.getImage(), Canvas.xOrigin + (i - 12) * Canvas.tokenSize, Canvas.yOrigin + j * Canvas.tokenSize, MainFrame.getCanvas());
            }
        for (int i = 18; i < 24; i++)
            for (int j = 0; j < Game.getBoard().getPointsList().get(i + 1).getBlueTokensNumber(); j++) {
                g.drawImage(icons.blueTokenImage.getImage(), Canvas.xOrigin + (i - 10) * Canvas.tokenSize, Canvas.yOrigin + j * Canvas.tokenSize, MainFrame.getCanvas());
            }
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < Game.getBoard().getPointsList().get(i + 1).getWhiteTokensNumber(); j++) {
                g.drawImage(icons.whiteTokenImage.getImage(), Canvas.xLimit - i * Canvas.tokenSize, Canvas.yLimit - j * Canvas.tokenSize, MainFrame.getCanvas());
            }
        for (int i = 6; i < 12; i++)
            for (int j = 0; j < Game.getBoard().getPointsList().get(i + 1).getWhiteTokensNumber(); j++) {
                g.drawImage(icons.whiteTokenImage.getImage(), Canvas.xLimit - (i + 2) * Canvas.tokenSize, Canvas.yLimit - j * Canvas.tokenSize, MainFrame.getCanvas());
            }
        for (int i = 12; i < 18; i++)
            for (int j = 0; j < Game.getBoard().getPointsList().get(i + 1).getWhiteTokensNumber(); j++) {
                g.drawImage(icons.whiteTokenImage.getImage(), Canvas.xOrigin + (i - 12) * Canvas.tokenSize, Canvas.yOrigin + j * Canvas.tokenSize, MainFrame.getCanvas());
            }
        for (int i = 18; i < 24; i++)
            for (int j = 0; j < Game.getBoard().getPointsList().get(i + 1).getWhiteTokensNumber(); j++) {
                g.drawImage(icons.whiteTokenImage.getImage(), Canvas.xOrigin + (i - 10) * Canvas.tokenSize, Canvas.yOrigin + j * Canvas.tokenSize, MainFrame.getCanvas());
            }
    }

    public void drawDices(Graphics g) {
        if (Game.getInstance().getPlayerAtTurn().getTokenType() == TokenType.BLUE) {
            firstDice = icons.blueDices.get(dices.getFirstDice() - 1);
            secondDice = icons.blueDices.get(dices.getSecondDice() - 1);
        } else
        {
            firstDice = icons.whiteDices.get(dices.getFirstDice() - 1);
            secondDice = icons.whiteDices.get(dices.getSecondDice() - 1);
        }
        g.drawImage(firstDice.getImage(), (Canvas.xLimit + 4 * Canvas.xOrigin) / 2, (Canvas.yLimit / 2), MainFrame.getCanvas());
        g.drawImage(secondDice.getImage(), (Canvas.xLimit + 4 * Canvas.xOrigin) / 2 + secondDice.getIconWidth(), (Canvas.yLimit / 2), MainFrame.getCanvas());
    }

    public void setDices(Dices dices) {
        this.dices = dices;
    }

    public Dices getDices() {
        return dices;
    }

}
