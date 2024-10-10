package Models.factories;

import Models.Bot;
import Models.botPlayingStrategy.BotPlayingStrategy;
import Models.botPlayingStrategy.EasyBotPlayingStrategy;
import Models.botPlayingStrategy.HardBotPlayingStrategy;
import Models.botPlayingStrategy.MediumBotPlayingStrategy;
import Models.enums.BotDifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyByDifficultyLevel(Bot bot){
        BotDifficultyLevel difficultyLevel = bot.getDifficultyLevel();
        if(difficultyLevel == BotDifficultyLevel.EASY){
            return new EasyBotPlayingStrategy(bot);
        } else if(difficultyLevel == BotDifficultyLevel.MEDIUM){
            return new MediumBotPlayingStrategy(bot);
        } else if(difficultyLevel == BotDifficultyLevel.HARD){
            return new HardBotPlayingStrategy(bot);
        }
        return null;
    }
}
