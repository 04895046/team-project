package data_access;

import use_case.Battle.BattleUserDataAccessInterface;
import use_case.move.MoveGameDataAccessInterface;
import use_case.openGame.OpenGameDataAccessInterface;
import use_case.quiz.QuizDataAccessInterface;
import use_case.show_results.ShowResultsGameDataAccessInterface;

/**
 * Factory interface for creating game data access objects.
 * This follows the Abstract Factory pattern and supports Dependency Inversion Principle
 * by allowing different implementations for production, testing, and other environments.
 */
public interface GameDataAccessFactory {
    /**
     * Creates and returns a data access object that implements all required interfaces
     * for the game system.
     *
     * @return A data access object implementing all game data access interfaces
     */
    MoveGameDataAccessInterface createGameDataAccess();

    /**
     * Creates and returns a data access object for battle operations.
     * By default, returns the same object as createGameDataAccess() since
     * FileGameDataAccessObject implements all interfaces.
     *
     * @return A data access object for battle operations
     */
    default BattleUserDataAccessInterface createBattleDataAccess() {
        return (BattleUserDataAccessInterface) createGameDataAccess();
    }

    /**
     * Creates and returns a data access object for quiz operations.
     *
     * @return A data access object for quiz operations
     */
    default QuizDataAccessInterface createQuizDataAccess() {
        return (QuizDataAccessInterface) createGameDataAccess();
    }

    /**
     * Creates and returns a data access object for results display operations.
     *
     * @return A data access object for results operations
     */
    default ShowResultsGameDataAccessInterface createResultsDataAccess() {
        return (ShowResultsGameDataAccessInterface) createGameDataAccess();
    }

    /**
     * Creates and returns a data access object for open game operations.
     *
     * @return A data access object for open game operations
     */
    default OpenGameDataAccessInterface createOpenGameDataAccess() {
        return (OpenGameDataAccessInterface) createGameDataAccess();
    }
}
