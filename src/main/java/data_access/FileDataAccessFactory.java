package data_access;

import use_case.move.MoveGameDataAccessInterface;

/**
 * Production implementation of GameDataAccessFactory that uses file-based storage.
 * This factory creates FileGameDataAccessObject instances for all data access needs.
 */
public class FileDataAccessFactory implements GameDataAccessFactory {
    private FileGameDataAccessObject gameDataAccess;

    @Override
    public MoveGameDataAccessInterface createGameDataAccess() {
        // Use singleton pattern to ensure all use cases share the same DAO instance
        if (gameDataAccess == null) {
            gameDataAccess = new FileGameDataAccessObject();
        }
        return gameDataAccess;
    }
}
