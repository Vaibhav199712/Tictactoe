package Models;

import Models.botPlayingStrategy.BotPlayingStrategy;
import Models.enums.BotDifficultyLevel;
import Models.enums.PlayerType;
import Models.factories.BotPlayingStrategyFactory;

public class Bot extends Player{

    private BotDifficultyLevel difficultyLevel;

    public Bot(int id, String name, Symbol symbol, BotDifficultyLevel difficultyLevel) {
        super(id, name, symbol);
        this.difficultyLevel = difficultyLevel;
        this.setPlayerType(PlayerType.BOT);
    }

    public BotDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Move makeMove(Board board){
        BotPlayingStrategy playingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyByDifficultyLevel(this);
        return playingStrategy.makeBotMove(board);
    }
}

