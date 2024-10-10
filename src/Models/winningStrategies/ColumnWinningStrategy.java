package Models.winningStrategies;

import Models.Board;
import Models.Cell;
import Models.Move;
import Models.Player;

import java.util.List;

public class ColumnWinningStrategy extends MapWinningStrategy{

    public ColumnWinningStrategy(int dimension, List<Player> players){
        super(dimension, players);
    }

    @Override
    public void updateCount(Board board, Move lastMove){
        Cell cell = lastMove.getCell();
        Player player = lastMove.getPlayer();
        int column = cell.getColumn();

        updateCountMap(column, player);
    }

    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        Cell cell = lastMove.getCell();
        Player player = lastMove.getPlayer();
        int column = cell.getColumn();

        return checkCountMapForWinner(column, player, board.getSize());
    }

    @Override
    public void handleUndo(Board board, Move lastMove){
        Player player = lastMove.getPlayer();
        Cell cell = lastMove.getCell();
        int column = cell.getColumn();

        handleMapUndo(column, player);
    }
}
