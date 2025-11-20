package opening_game.use_case;
import opening_game.entity.GameState;

public class OpenGameInteractor implements OpenGameInputBoundary {

    private final OpenGameOutputBoundary presenter;
    private final OpenGameDataAccessInterface dataAccess;

    public OpenGameInteractor(OpenGameOutputBoundary presenter,
                              OpenGameDataAccessInterface dataAccess) {
        this.presenter = presenter;
        this.dataAccess = dataAccess;
    }

    @Override
    public void execute(OpenGameInputData inputData) {

        if (inputData.isNewGame()) {
            // --- NEW GAME LOGIC ---
            GameState newState = new GameState(
                    inputData.getStartingLocation(),
                    inputData.getDestination()
            );

            // Save the newly created game
            dataAccess.saveGame(newState);

            // Prepare output
            OpenGameOutputData output = new OpenGameOutputData(
                    "New game started!",
                    newState,
                    true
            );

            presenter.prepareSuccessView(output);

        } else {
            // --- CONTINUE GAME LOGIC ---
            GameState saved = dataAccess.loadGame();

            if (saved == null) {
                presenter.prepareFailView("No saved game found!");
                return;
            }

            OpenGameOutputData output = new OpenGameOutputData(
                    "Game loaded!",
                    saved,
                    false
            );

            presenter.prepareSuccessView(output);
        }
    }
}
