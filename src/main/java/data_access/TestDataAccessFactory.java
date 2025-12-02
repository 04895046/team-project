package data_access;

import use_case.Battle.BattleUserDataAccessInterface;
import use_case.move.MoveGameDataAccessInterface;
import use_case.openGame.OpenGameDataAccessInterface;
import use_case.quiz.QuizDataAccessInterface;
import use_case.show_results.ShowResultsGameDataAccessInterface;

/**
 * Test implementation of GameDataAccessFactory for testing environments.
 * This factory can use in-memory DAOs or mock implementations to avoid
 * file I/O during testing.
 */
public class TestDataAccessFactory implements GameDataAccessFactory {
    private FileGameDataAccessObject gameDataAccess;
    private QuizDataAccessInterface quizDataAccess;

    @Override
    public MoveGameDataAccessInterface createGameDataAccess() {
        // For testing, you might want to use in-memory or mock implementations
        if (gameDataAccess == null) {
            gameDataAccess = new FileGameDataAccessObject();
        }
        return gameDataAccess;
    }

    @Override
    public QuizDataAccessInterface createQuizDataAccess() {
        // Use in-memory quiz DAO for testing (as seen in MoveTestApp)
        if (quizDataAccess == null) {
            quizDataAccess = new InMemoryQuizDataAccessObject();
        }
        return quizDataAccess;
    }

    @Override
    public BattleUserDataAccessInterface createBattleDataAccess() {
        return (BattleUserDataAccessInterface) createGameDataAccess();
    }

    @Override
    public ShowResultsGameDataAccessInterface createResultsDataAccess() {
        return (ShowResultsGameDataAccessInterface) createGameDataAccess();
    }

    @Override
    public OpenGameDataAccessInterface createOpenGameDataAccess() {
        return (OpenGameDataAccessInterface) createGameDataAccess();
    }
}
