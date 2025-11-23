package opening_game.use_case.CompleteGame;

public interface CompleteGameOutputBoundary {
    void prepareSuccessView(CompleteGameOutputData outputData);
    void prepareFailView(String errorMessage);
}
