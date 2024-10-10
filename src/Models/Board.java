package Models;

import Models.enums.CellState;

import java.util.ArrayList;
import java.util.List;


public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int dimension){
        this.size = dimension;
        initialiseBoard();
    }

    public void initialiseBoard(){
        this.board = new ArrayList<>();
        for(int i = 0; i < size; i++){
            List<Cell> rowsOfCells = new ArrayList<>();
            for(int j = 0; j < size; j++){
                rowsOfCells.add(new Cell(i, j));
            }
            board.add(rowsOfCells);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void displayBoard() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = board.get(i).get(j);
                if (cell.getCellState() == CellState.EMPTY) {
                    System.out.print("   ");
                } else {
                    Player player = cell.getPlayer();
                    if (player != null) {
                        System.out.print(" " + player.getSymbol().getaChar() + " ");
                    } else {
                        System.out.print("   "); // Handle case where player is null
                    }
                }

                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < size - 1) { // Corrected from j < size-1 to i < size-1
                for (int j = 0; j < size; j++) {
                    System.out.print("----");
                }
                System.out.println();
            }
        }
    }
}
