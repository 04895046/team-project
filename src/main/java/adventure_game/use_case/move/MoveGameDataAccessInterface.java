package adventure_game.use_case.move;

import adventure_game.entity.AdventureGame;

public interface MoveGameDataAccessInterface {
    AdventureGame getGame();

    void saveGame(AdventureGame game);
}
