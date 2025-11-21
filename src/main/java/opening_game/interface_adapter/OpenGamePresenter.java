package opening_game.interface_adapter;

import opening_game.use_case.OpenGameOutputBoundary;
import opening_game.use_case.OpenGameOutputData;

public class OpenGamePresenter implements OpenGameOutputBoundary {

    private final OpenGameViewModel viewModel;

    public OpenGamePresenter(OpenGameViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(OpenGameOutputData outputData) {
        viewModel.setMessage(outputData.getMessage());
        viewModel.setState(outputData.getGameState());
    }

    @Override
    public void prepareFailView(String errorMessage) {
        viewModel.setMessage(errorMessage);
        viewModel.setState(null);
    }

    public OpenGameViewModel getViewModel() {
        return viewModel;
    }
}
