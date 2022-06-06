package game;

public class Token {

    private TokenType tokenType;

    public Token(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public boolean isWhite() {
        return tokenType == TokenType.WHITE;
    }

    public boolean isBlue() {
        return tokenType == TokenType.BLUE;
    }

}
