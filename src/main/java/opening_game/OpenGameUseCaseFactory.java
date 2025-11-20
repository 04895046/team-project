package opening_game;

import opening_game.data_access.OpenGameFileDataAccess;
import opening_game.interface_adapter.OpenGameController;
import opening_game.interface_adapter.OpenGamePresenter;
import opening_game.interface_adapter.OpenGameViewModel;
import opening_game.use_case.OpenGameDataAccessInterface;
import opening_game.use_case.OpenGameInputBoundary;
import opening_game.use_case.OpenGameInteractor;
import opening_game.use_case.OpenGameOutputBoundary;
import opening_game.view.OpenGameView;

    public class OpenGameUseCaseFactory {

        public static OpenGameView create() {

            // 1. Create ViewModel
            OpenGameViewModel viewModel = new OpenGameViewModel();

            // 2. Create Presenter
            OpenGameOutputBoundary presenter = new OpenGamePresenter(viewModel);

            // 3. Create Data Access
            OpenGameDataAccessInterface dataAccess =
                    new OpenGameFileDataAccess("game_save.json");

            // 4. Create Interactor
            OpenGameInputBoundary interactor =
                    new OpenGameInteractor(presenter, dataAccess);

            // 5. Create Controller
            OpenGameController controller = new OpenGameController(interactor);

            // 6. Create View (Swing UI)
            return new OpenGameView(controller, viewModel);
        }
    }
