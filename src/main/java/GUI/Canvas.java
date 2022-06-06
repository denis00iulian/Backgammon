package GUI;

import game.Dices;
import game.Game;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {

    private final Icons icons = Icons.getInstance();
    static final int xOrigin = 95;
    static final int yOrigin = 23;
    static final int xLimit = 720;
    static final int yLimit = 585;
    static final int tokenSize = 48;
    static BoardPainter boardPainter;


    public Canvas() {
        boardPainter = new BoardPainter();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(icons.backgroundImage.getImage(), 0, 0, this);
        if (Game.getInstance() != null) {
            boardPainter.paintTokens(g);
            BoardMouseListener.points.forEach(rectangle -> g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height));
            if (Dices.getFirstDice() != null && Dices.getSecondDice() != null)
                boardPainter.drawDices(g);
        }
    }

    public void showDices(Dices dices) {
        boardPainter.setDices(dices);
    }

}
