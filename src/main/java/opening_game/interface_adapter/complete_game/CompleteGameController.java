package opening_game.interface_adapter.complete_game;
import opening_game.use_case.CompleteGame.CompleteGameInputBoundary;
import opening_game.use_case.CompleteGame.CompleteGameInputData;


public class CompleteGameController {
    private final CompleteGameInputBoundary interactor;

    public CompleteGameController(CompleteGameInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void completeGame() {
        CompleteGameInputData input = new CompleteGameInputData(true);
        interactor.execute(input);
    }
}
