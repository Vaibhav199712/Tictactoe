package Models.botPlayingStrategy;

import Models.Board;
import Models.Move;

public interface BotPlayingStrategy {
    Move makeBotMove(Board board);
}
