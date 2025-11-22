package opening_game.interface_adapter.result;
import opening_game.use_case.ResultScreen.ResultScreenInputBoundary;
import opening_game.use_case.ResultScreen.ResultScreenInputData;

public class ResultController {
    private final ResultScreenInputBoundary interactor;

    public ResultController(ResultScreenInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void showResultScreen(boolean completed) {
        ResultScreenInputData data = new ResultScreenInputData(completed);
        interactor.execute(data);
    }
}
