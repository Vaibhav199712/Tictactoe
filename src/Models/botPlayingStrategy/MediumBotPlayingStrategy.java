package Models.botPlayingStrategy;

import Models.Board;
import Models.Bot;
import Models.Cell;
import Models.Move;
import Models.enums.CellState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MediumBotPlayingStrategy implements BotPlayingStrategy{
    Bot bot;

    public MediumBotPlayingStrategy(Bot bot){
        this.bot = bot;
    }

    @Override
    public Move makeBotMove(Board board) {
        System.out.println("It's " + bot.getName() + "'s turn. Thinking...\n");
        List<Cell> emptyCellsList = getEmptyCells(board);

        Random random = new Random();
        int randomIndex = random.nextInt(emptyCellsList.size());
        Cell randomlyChosenCell = emptyCellsList.get(randomIndex);

        randomlyChosenCell.setPlayer(bot);
        randomlyChosenCell.setCellState(CellState.OCCUPIED);
        return new Move(randomlyChosenCell, bot);
    }

    private List<Cell> getEmptyCells(Board board){
        int sizeOfBoard = board.getSize();
        List<Cell> emptyCells = new ArrayList<>();
        for(int i = 0; i < sizeOfBoard; i++){
            for(int j = 0; j < sizeOfBoard; j++){
                Cell currentCell = board.getBoard().get(i).get(j);
                if(currentCell.getCellState() == CellState.EMPTY){
                    emptyCells.add(currentCell);
                }
            }
        }
        return emptyCells;
    }
}

