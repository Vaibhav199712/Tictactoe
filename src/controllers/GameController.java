package controllers;

import Models.Game;
import Models.Player;
import Models.winningStrategies.WinningStrategy;
import execptions.BotCountException;
import execptions.DimensionException;
import execptions.DuplicateSymbolException;
import execptions.PlayerCountException;

import java.util.List;

public class GameController {
    //stateless Class
//    Game game ;
    //State Class
    //if a class have an attribute than it is State Class, if not then it is Stateless Class

    public Game startGame(int dimension, List<Player> player, List<WinningStrategy> winningStrategies) throws PlayerCountException, DuplicateSymbolException, BotCountException, DimensionException {
        return Game.getBuilder().
                setDimension(dimension).
                setPlayer(player).
                setWinningStrategies(winningStrategies).
                build();

    }

    public void displayBoard(Game game){
        game.getBoard().displayBoard() ;
    }

    public void makeMove(Game game) {
        int currentPlayerIndex = game.getCurrentPlayerIndex() ;
        Player currentPlayer = game.getPlayer().get(currentPlayerIndex) ;

        currentPlayer.makeMove(game.getBoard());
        // update the game's list of moves
        // check if there is a winner or not!

        int nextPlayerIndex = currentPlayerIndex + 1 ;
        game. setCurrentPlayerIndex(nextPlayerIndex);
    }

    public void checkWinner(Game game){

    }

    public void undo(Game game) {

    }

    public void checkForUndo(Game game){
        game.checkForUndo();
    }

}
