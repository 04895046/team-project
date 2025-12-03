package use_case.battle;

import entity.AdventureGame;

public interface BattleUserDataAccessInterface {
    /**
     * Get the current game state
     */
    AdventureGame getGame();

    /**
     * Save the entire game state (including defeated monsters)
     */
    void saveGame(AdventureGame game);

    /**
     * Load the entire game state
     */
    void loadGameData();
}
