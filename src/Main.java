import Models.Game;
import Models.Player;
import Models.Symbol;
import Models.enums.GameState;
import Models.winningStrategies.ColumnWinningStrategy;
import Models.winningStrategies.RowWinningStrategy;
import Models.winningStrategies.WinningStrategy;
import controllers.GameController;
import execptions.BotCountException;
import execptions.DimensionException;
import execptions.DuplicateSymbolException;
import execptions.PlayerCountException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws BotCountException, DimensionException, PlayerCountException, DuplicateSymbolException {
        GameController gameController = new GameController() ;
        int dimension = 3 ;

        List<Player> players = new ArrayList<>();
        players.add(new Player(1,"Vaibhav",new Symbol('X'))) ;
        players.add(new Player(1,"Tushar", new Symbol('O'))) ;

        List<WinningStrategy> winningStrategies = new ArrayList<>() ;
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategy()) ;

        Game game = Game.getBuilder().setDimension(dimension).setPlayer(players).setWinningStrategies(winningStrategies).build() ;
        System.out.println("Game has been started ");
//        Game game = gameController.startGame(3,players,winningStrategies);
        //it will first validate the condition and then give me a game object with validations



        while(Game.getGameState() == GameState.In_PROGRESS){
            gameController.displayBoard(game);
            gameController.makeMove(game);

            if(Game.getGameState() == GameState.COMPLETED) {
                System.out.println("Game is completed, Winner is " + game.getWinner().getName());
                break;
            }
            if(game.getGameState() == GameState.DRAW){
                System.out.println("Game is Draw");
                break;
            }
        }
    }
}
