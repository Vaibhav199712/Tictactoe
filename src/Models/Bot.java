package Models;

import Models.enums.BotDifficultyLevel;
import Models.enums.PlayerType;

public class Bot extends Player{
    private BotDifficultyLevel difficultyLevel ;

    public Bot(int id, String name, Symbol symbol,PlayerType playerType) {
        super(id, name, symbol);
        this.setPlayerType(PlayerType.BOT);

        @Override
        public void makeMove(Board board){
            //do some bot thing
        }
    }
}
