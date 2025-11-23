package opening_game.interface_adapter.opengame;

import opening_game.use_case.openGame.OpenGameInputBoundary;
import opening_game.use_case.openGame.OpenGameInputData;

public class OpenGameController {
    private final OpenGameInputBoundary interactor;

    public OpenGameController(OpenGameInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void startNewGame(String startingLocation, String destination) {
        OpenGameInputData data =
                new OpenGameInputData(true, startingLocation, destination);
        interactor.execute(data);
    }

    public void continueGame() {
        OpenGameInputData data =
                new OpenGameInputData(false, null, null);
        interactor.execute(data);
    }
}
