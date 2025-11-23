package opening_game;

import opening_game.data_access.OpenGameFileDataAccess;
import opening_game.interface_adapter.opengame.OpenGameController;
import opening_game.interface_adapter.opengame.OpenGamePresenter;
import opening_game.interface_adapter.opengame.OpenGameViewModel;
import opening_game.use_case.openGame.OpenGameDataAccessInterface;
import opening_game.use_case.openGame.OpenGameInputBoundary;
import opening_game.use_case.openGame.OpenGameInteractor;
import opening_game.use_case.openGame.ScreenSwitchBoundary;
import opening_game.view.OpenGameView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        // 1. ViewModel
        OpenGameViewModel viewModel = new OpenGameViewModel();

        // 2. Presenter
        OpenGamePresenter presenter = new OpenGamePresenter(viewModel);

        // 3. Data Access (JSON file)
        OpenGameDataAccessInterface dataAccess =
                new OpenGameFileDataAccess("savegame.json");

        // 4. Screen Switcher (TEMP version)
        ScreenSwitchBoundary switcher = new ScreenSwitchBoundary() {
            @Override
            public void switchToResultScreen() {
                System.out.println("Switching to Result Screen...");
            }
        };

        // 5. Interactor
        OpenGameInputBoundary interactor =
                new OpenGameInteractor(presenter, dataAccess, switcher);

        // 6. Controller
        OpenGameController controller = new OpenGameController(interactor);

        // 7. View
        OpenGameView view = new OpenGameView(controller, viewModel);

        // 8. Bring up JFrame
        JFrame frame = new JFrame("Open Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(view);
        frame.pack();
        frame.setVisible(true);
    }
}
