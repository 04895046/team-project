package opening_game.interface_adapter.complete_game;
import opening_game.use_case.CompleteGame.CompleteGameOutputBoundary;
import opening_game.use_case.CompleteGame.CompleteGameOutputData;

public class CompleteGamePresenter implements CompleteGameOutputBoundary {
    private final CompleteGameViewModel viewModel;

    public CompleteGamePresenter(CompleteGameViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(CompleteGameOutputData outputData) {
        viewModel.setMessage(outputData.getMessage());
    }

    @Override
    public void prepareFailView(String errorMessage) {
        viewModel.setMessage(errorMessage);
    }
}
