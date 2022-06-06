package game;

import java.util.ArrayList;
import java.util.List;

public class Point {

    /**
     * index = 0 -> home
     * index = 25 -> startAgain
     */
    private int index;
    private List<Token> tokenListHere = new ArrayList<>();

    public Point(int index) {
        this.index = index;
    }

    public void addTokens(int nrOfTokens, TokenType tokenType) {
        for (int i = 0; i < nrOfTokens; i++)
            tokenListHere.add(new Token(tokenType));
    }

    public void add(Token token) {
        tokenListHere.add(token);
    }

    public int getWhiteTokensNumber() {
        if (!tokenListHere.isEmpty() && tokenListHere.get(0).isBlue())
            return 0;
        else
            return tokenListHere.size();
    }

    public int getBlueTokensNumber() {
        if (!tokenListHere.isEmpty() && tokenListHere.get(0).isWhite())
            return 0;
        else
            return tokenListHere.size();
    }

    public boolean isEmpty() {
        return tokenListHere.isEmpty();
    }

    public Token popToken() {
        Token temp = tokenListHere.get(tokenListHere.size() - 1);
        tokenListHere.remove(temp);
        return temp;
    }

    public TokenType getTokenType() {
        if(tokenListHere.isEmpty())
            return null;
        if (tokenListHere.get(0).isBlue())
            return TokenType.BLUE;
        else
            return TokenType.WHITE;
    }

}
