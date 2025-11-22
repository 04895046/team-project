package opening_game;

import opening_game.data_access.OpenGameFileDataAccess;
import opening_game.interface_adapter.opengame.OpenGameController;
import opening_game.interface_adapter.opengame.OpenGamePresenter;
import opening_game.interface_adapter.opengame.OpenGameViewModel;
import opening_game.use_case.openGame.OpenGameDataAccessInterface;
import opening_game.use_case.openGame.OpenGameInputBoundary;
import opening_game.use_case.openGame.OpenGameInteractor;
import opening_game.use_case.openGame.OpenGameOutputBoundary;
import opening_game.use_case.openGame.ScreenSwitchBoundary;
import opening_game.view.OpenGameView;

public class OpenGameUseCaseFactory {

    public static OpenGameView create(ScreenSwitchBoundary switcher) {

        // 1. Create ViewModel
        OpenGameViewModel viewModel = new OpenGameViewModel();

        // 2. Create Presenter
        OpenGameOutputBoundary presenter = new OpenGamePresenter(viewModel);

        // 3. Create Data Access
        OpenGameDataAccessInterface dataAccess =
                new OpenGameFileDataAccess("game_save.json");

        // 4. Create Interactor (UPDATED)
        OpenGameInputBoundary interactor =
                new OpenGameInteractor(presenter, dataAccess, switcher);

        // 5. Create Controller
        OpenGameController controller = new OpenGameController(interactor);

        // 6. Create View (Swing UI)
        return new OpenGameView(controller, viewModel);
    }
}
