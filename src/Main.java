import Models.Bot;
import Models.Game;
import Models.Player;
import Models.Symbol;
import Models.enums.BotDifficultyLevel;
import Models.enums.GameState;
import Models.winningStrategies.*;
import controllers.GameController;
import execptions.BotCountException;
import execptions.DimensionException;
import execptions.DuplicateSymbolException;
import execptions.PlayerCountException;

import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) throws PlayerCountException, DuplicateSymbolException, BotCountException, DimensionException {
        GameController gameController = new GameController();

        int dimension = 3;

        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Vaibhav", new Symbol('X')));
        players.add(new Bot(2, "SastaBot", new Symbol('B'), BotDifficultyLevel.HARD));

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy(dimension, players));
        winningStrategies.add(new ColumnWinningStrategy(dimension, players));
        winningStrategies.add(new DiagonalWinningStrategy(players));
        winningStrategies.add(new CornersWinningStrategy());

        Game game = gameController.startGame(dimension, players, winningStrategies);
        System.out.println("game has been started");
        gameController.displayBoard(game);
        while(game.getGameState() == GameState.IN_PROGRESS){
            gameController.makeMove(game);
            gameController.displayBoard(game);
            gameController.checkForUndo(game);
        }

        gameController.displayBoard(game);
        if(game.getGameState() == GameState.COMPLETED){
            System.out.println("Game is completed. Winner is " + game.getWinner().getName());
        }
        if(game.getGameState() == GameState.DRAW){
            System.out.println("Game is a Draw");
        }
    }
}
