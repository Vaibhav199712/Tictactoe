package Models.winningStrategies;

import Models.Board;
import Models.Move;

public interface WinningStrategy {
    void updateCount(Board board, Move lastMove);

    boolean checkWinner(Board board, Move lastMove);

    void handleUndo(Board board, Move lastMove);
}
