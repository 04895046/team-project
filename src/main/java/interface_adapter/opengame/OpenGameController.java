package interface_adapter.opengame;

import view.OpenGameView;
import use_case.openGame.OpenGameInputBoundary;
import use_case.openGame.OpenGameInputData;

public class OpenGameController {
    private final OpenGameInputBoundary interactor;
    public final String name = "";

    public OpenGameController(OpenGameInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void startNewGame() {
        OpenGameInputData data =
                new OpenGameInputData(true);
        interactor.execute(data);
    }
    public void switchToMoveScreen() {
        interactor.switchToMoveScreen();
    }

    public void continueGame() {
        OpenGameInputData data =
                new OpenGameInputData(false);
        interactor.execute(data);
    }

}
