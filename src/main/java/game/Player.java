package game;

import GUI.MainFrame;

public class Player {

    private String playerName;
    private TokenType tokenType;
    private Board board;

    public Player(String playerName, TokenType tokenType) {
        this.playerName = playerName;
        this.tokenType = tokenType;
        this.board = Game.getBoard();
    }

    public String getPlayerName() {
        return playerName;
    }

    public TokenType getTokenType() {
        return tokenType;
    }
}
