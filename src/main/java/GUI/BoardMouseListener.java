package GUI;

import com.sun.tools.javac.Main;
import game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class BoardMouseListener implements MouseListener, MouseMotionListener {

    private Icons icons = Icons.getInstance();
    private ImageIcon icon;
    private Point startingPosition;
    private Point releasePosition;
    private Point position;
    private Point boardOrigin;
    static List<Rectangle> points;
    static Dimension pointWindow;
    Move move;

    public BoardMouseListener() {
        boardOrigin = new Point(Canvas.xOrigin, Canvas.yOrigin);
        points = new ArrayList<>();
        pointWindow = new Dimension(48, 270);
        MainFrame.getCanvas().addMouseListener(this);
        MainFrame.getCanvas().addMouseMotionListener(this);
        calculatePointsArea();
    }

    private void calculatePointsArea() {
        int yTemp = MainFrame.getCanvas().getHeight() - 2 * Canvas.yOrigin - pointWindow.height;

        for (int i = 0; i < 24; i++) {
            points.add(new Rectangle(boardOrigin, pointWindow));
            points.get(i).translate((i) % 12 * 48, 0);
            if (i % 12 >= 6)
                points.get(i).translate(97, 0);
            if (i >= 12) {
                points.get(i).y = yTemp;
            }
        }
        points.add(new Rectangle((MainFrame.getCanvas().getWidth() - 97) / 2, Canvas.yOrigin, 97, MainFrame.getCanvas().getHeight() - 3 * Canvas.yOrigin));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Player currentPlayer = Game.getInstance().getPlayerAtTurn();
        this.startingPosition = e.getPoint();
        int columnIndex = getColumnIndex(startingPosition);
        if (!Game.getBoard().getPointsList().isEmpty() && Dices.getFirstDice() != null && Dices.getSecondDice() != null) {
            if (Game.getBoard().getPointsList().get(columnIndex).getTokenType() == currentPlayer.getTokenType()) {
                move = new Move();
                move.computeAvailableMoves(currentPlayer, getColumnIndex(startingPosition));
                move.getPossibleLanding().forEach(landing -> System.out.println("You can go on " + landing));
            } else
                System.out.println("Nu prea se poate");
        }
        System.out.println(columnIndex);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (Dices.getFirstDice() != null && Dices.getSecondDice() != null && move != null) {
            if (move.getPossibleLanding().size() == 0) {
                MainFrame.enableRollButton();
                MainFrame.getCanvas().repaint();
                Dices.setFirstDice(null);
                Dices.setSecondDice(null);
                Game.getInstance().changeTurn();
            } else {
                move.getPossibleLanding().forEach(landing -> {
                            if (getColumnIndex(e.getPoint()) == landing) {
                                move.doMove(getColumnIndex(startingPosition), getColumnIndex(e.getPoint()));
                                MainFrame.getCanvas().repaint();
                            }
                        }
                );
                if(Move.getMoveNumber() % 2 == 0) {
                    Game.getInstance().changeTurn();
                    MainFrame.enableRollButton();
                    Dices.setFirstDice(null);
                    Dices.setSecondDice(null);
                }
            }
        }
        move = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    private int getColumnIndex(Point point) {
        int temp = -1;
        for (int i = 0; i < points.size(); ++i) {
            if (points.get(i).contains(point)) {
                temp = i;

            }
        }
        if (temp != -1)
            if (temp >= 12 && temp <= 23)
                temp = 35 - temp;
        return BoardOrientation.dependingOnOrientation(temp + 1);
    }

}
