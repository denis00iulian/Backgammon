package game;

import java.util.ArrayList;

public class Move {

    private ArrayList<Integer> possibleLanding;
    private static int moveNumber = 0;


    public Move() {
    }

    public ArrayList<Integer> getPossibleLanding() {
        return possibleLanding;
    }

    public void computeAvailableMoves(Player player, int startingPosition) {
        possibleLanding = new ArrayList<>();
        int columnIndex = startingPosition;
        if (player.getTokenType() == TokenType.WHITE) {
            Integer firstMoveIndex = columnIndex - Dices.getFirstDice();
            Integer secondMoveIndex = columnIndex - Dices.getSecondDice();
            if (Game.getBoard().getPointsList().get(firstMoveIndex).getBlueTokensNumber() == 0)
                possibleLanding.add(firstMoveIndex);
            if (Game.getBoard().getPointsList().get(secondMoveIndex).getBlueTokensNumber() == 0)
                possibleLanding.add(secondMoveIndex);
        } else {
            Integer firstMoveIndex = columnIndex + Dices.getFirstDice();
            Integer secondMoveIndex = columnIndex + Dices.getSecondDice();
            if (Game.getBoard().getPointsList().get(firstMoveIndex).getWhiteTokensNumber() == 0)
                possibleLanding.add(firstMoveIndex);
            if (Game.getBoard().getPointsList().get(secondMoveIndex).getWhiteTokensNumber() == 0)
                possibleLanding.add(secondMoveIndex);
        }
    }

    private boolean hasValidMoves() {
        return true;
    }

    public void doMove(int from, int to) {
        Game.getBoard().movePiece(from, to);
        moveNumber++;
    }

    public static int getMoveNumber() {
        return moveNumber;
    }

}
