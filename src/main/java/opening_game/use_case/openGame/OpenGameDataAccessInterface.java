package opening_game.use_case.openGame;

import opening_game.entity.GameState;

public interface OpenGameDataAccessInterface {
    GameState loadGame();
    void saveGame(GameState state);
    boolean saveFileExists();
    void deleteSaveFile();

}
