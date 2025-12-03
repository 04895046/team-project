package interface_adapter.battle;

import entity.Monster;
import entity.User;
import use_case.battle.BattleInputBoundary;
import use_case.battle.BattleInputData;
import interface_adapter.quiz.QuizViewModel;
import interface_adapter.quiz.QuizState;

/**
 * Controller for the Battle Use Case.
 *
 */
public class BattleController {
    private final BattleInputBoundary battleUseCaseInteractor;
    private final QuizViewModel quizViewModel;


    public BattleController(BattleInputBoundary battleUseCaseInteractor, QuizViewModel quizViewModel) {
        this.battleUseCaseInteractor = battleUseCaseInteractor;
        this.quizViewModel = quizViewModel;
    }

    public void execute(User user, Monster monster, boolean resultOfQuiz){
        final BattleInputData battleInputData= new BattleInputData(user, monster, resultOfQuiz);
        battleUseCaseInteractor.execute(battleInputData);
    }

    public void switchToQuizView(User user, Monster monster){
        QuizState quizState = quizViewModel.getState();

        // store battle context in submitQuiz state
        quizState.setUser(user);
        quizState.setMonster(monster);
        quizState.setQuizId();
        quizViewModel.firePropertyChange();

        // tell the battle use case to switch to submitQuiz view
        battleUseCaseInteractor.switchToQuizView();
    }
}
