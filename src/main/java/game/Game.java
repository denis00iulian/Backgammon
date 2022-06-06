package game;

import GUI.MainFrame;
import com.sun.tools.javac.Main;

import java.util.concurrent.atomic.AtomicBoolean;

public class Game implements Runnable {

    private static Game game = null;
    private static Board board;
    private final AtomicBoolean gameOver;
    private Player firstPlayer;
    private Player secondPlayer;
    private Player playerAtTurn;

    public Game(String firstName, String secondName) {
        this.firstPlayer = new Player(firstName, TokenType.WHITE);
        this.secondPlayer = new Player(secondName, TokenType.BLUE);
        this.gameOver = new AtomicBoolean(false);
        game = this;
    }

    public static Board getBoard() {
        return board;
    }

    public static Game getInstance() {
        return game;
    }

    public void startGame() {
        while (!gameOver.get()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //MainFrame.getCanvas().repaint();
        }
    }

    @Override
    public void run() {
        this.board = new Board();
        playerAtTurn = firstPlayer;
        MainFrame.enableRollButton();
        startGame();
    }

    public void stop() {
        gameOver.set(true);
        MainFrame.displayWinner(playerAtTurn);
        game = null;
        board = null;
    }

    public Player getPlayerAtTurn() {
        return playerAtTurn;
    }

    public void changeTurn() {
        if (playerAtTurn == firstPlayer)
            playerAtTurn = secondPlayer;
        else
            playerAtTurn = firstPlayer;
    }

}
