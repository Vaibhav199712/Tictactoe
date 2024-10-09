package Models;

import Models.enums.GameState;
import Models.enums.PlayerType;
import Models.winningStrategies.WinningStrategy;
import execptions.BotCountException;
import execptions.DimensionException;
import execptions.DuplicateSymbolException;
import execptions.PlayerCountException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {

    private Board board ;
    private List<Player> player ;
    private List<WinningStrategy> winningStrategies;
    private Player winner ;
    private List<Move> moves ;
    private int currentPlayerIndex ;
    private static GameState gameState ;

    private Game(Builder builder){
        this.player = builder.player ;
        this.winningStrategies = builder.winningStrategies ;
        this.board = new Board(builder.dimension);

        this.gameState = GameState.In_PROGRESS;
        this.winner = null ;
        this.moves = new ArrayList<>() ;
        this.currentPlayerIndex = 0 ;
        // once all the validation is done i will get this builder of this details of Game object
    }

    public static GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public static Builder getBuilder(){
        return new Builder() ;
    }

    public static class Builder{
        private int dimension ;
        private List<Player> player ;
        private List<WinningStrategy> winningStrategies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this ;
        }

        public Builder setPlayer(List<Player> player) {
            this.player = player;
            return this ;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this ;
        }
        private void validateBotCount() throws BotCountException {
            int botCount = 0;
            for(Player p : player){
                if(p.getPlayerType() == PlayerType.BOT){
                    botCount++ ;
                }
            }
            if(botCount > 1){
                throw new BotCountException("Bot count is more than 1 and its not allowed ") ;
            }
        }
        private void validateBoardSize() throws DimensionException{
            if(dimension < 3){
                throw new DimensionException("Board should be atleast 3 ") ;
            }
        }
        private void validatePlayerCount() throws PlayerCountException{
            //no of players is n-1
            if(player.size() != dimension-1){
                throw new PlayerCountException("player count should be N-1 ") ;
            }
        }
        private void validateDuplicateSymbols() throws DuplicateSymbolException {
            HashSet<Character> symbols = new HashSet<>() ;
            for(Player p : player){
                if(symbols.contains(p.getSymbol().getaChar())){
                    throw new DuplicateSymbolException("2 players have the same symbols ") ;
                }
                symbols.add(p.getSymbol().getaChar()) ;
            }
        }

        private void validate() throws BotCountException, DimensionException, PlayerCountException, DuplicateSymbolException {
            // three things to validate dimension, player, board
            //size of board should be atleast 3
            //no of player should be N-1
            //no duplicate symbols for players
            //no of bots should be 1


            validateBotCount();
            validateBoardSize();
            validatePlayerCount();
            validateDuplicateSymbols();

        }

        public Game build() throws BotCountException,DuplicateSymbolException,PlayerCountException,DimensionException{
            //Validations
            validate();
            return new Game(this) ;
        }
    }
}
