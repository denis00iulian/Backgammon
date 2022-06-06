package game;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Point> pointList;


    public Board() {
        pointList = new ArrayList<>();
        initializeBoard();
        setPiecesPosition();
    }

    private void initializeBoard() {
        for (int pointIndex = 0; pointIndex < 26; pointIndex++)
            this.pointList.add(new Point(pointIndex));
    }

    private void setPiecesPosition() {
        this.pointList.get(6).addTokens(5, TokenType.WHITE);
        this.pointList.get(8).addTokens(3, TokenType.WHITE);
        this.pointList.get(13).addTokens(5, TokenType.WHITE);
        this.pointList.get(24).addTokens(2, TokenType.WHITE);
        this.pointList.get(19).addTokens(5, TokenType.BLUE);
        this.pointList.get(17).addTokens(3, TokenType.BLUE);
        this.pointList.get(12).addTokens(5, TokenType.BLUE);
        this.pointList.get(1).addTokens(2, TokenType.BLUE);
    }

    public List<Point> getPointsList() {
        return pointList;
    }

    public void movePiece(int from, int to) {
        if (!pointList.get(from).isEmpty())
            pointList.get(to).add(pointList.get(from).popToken());
    }

}
