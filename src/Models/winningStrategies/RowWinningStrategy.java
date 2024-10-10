package Models.winningStrategies;

import Models.Board;
import Models.Cell;
import Models.Move;
import Models.Player;

import java.util.List;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RowWinningStrategy extends MapWinningStrategy{

    public RowWinningStrategy(int dimension, List<Player> players){
        super(dimension, players);
    }


    @Override
    public void updateCount(Board board, Move lastMove){
        Cell cell = lastMove.getCell(); // 2, 1
        Player player = lastMove.getPlayer();
        int row = cell.getRow();    // 2

        updateCountMap(row, player);
    }

    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        Cell cell = lastMove.getCell();
        Player player = lastMove.getPlayer();
        int row = cell.getRow();

        return checkCountMapForWinner(row, player, board.getSize());
    }

    @Override
    public void handleUndo(Board board, Move lastMove){
        Player player = lastMove.getPlayer();
        Cell cell = lastMove.getCell();
        int row = cell.getRow();

        handleMapUndo(row, player);
    }
}

