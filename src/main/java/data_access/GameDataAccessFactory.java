package data_access;

import use_case.move.MoveGameDataAccessInterface;

/**
 * Factory interface for creating game data access objects.
 * Follows Abstract Factory pattern and Dependency Inversion Principle.
 */
public interface GameDataAccessFactory {
    /**
     * Creates and returns a data access object implementing all game data interfaces.
     *
     * @return A data access object for the game system
     */
    MoveGameDataAccessInterface createGameDataAccess();
}
