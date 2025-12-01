package app.opening_game;

import data_access.OpenGameFileDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.opengame.OpenGameController;
import interface_adapter.opengame.OpenGamePresenter;
import interface_adapter.opengame.OpenGameViewModel;
import use_case.openGame.OpenGameDataAccessInterface;
import use_case.openGame.OpenGameInputBoundary;
import use_case.openGame.OpenGameInteractor;
import view.OpenGameView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        // 1. View Manager (controls which screen is shown)
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        // 2. ViewModel
        OpenGameViewModel viewModel = new OpenGameViewModel();

        // 3. Presenter (implements OpenGameOutputBoundary)
        OpenGamePresenter presenter =
                new OpenGamePresenter(viewModel, viewManagerModel);

        // 4. Data Access (JSON file or save file)
        OpenGameDataAccessInterface dataAccess =
                new OpenGameFileDataAccess("savegame.json");

     // Interactor (NO ScreenSwitchBoundary anymore)
        OpenGameInputBoundary interactor =
                new OpenGameInteractor(presenter, dataAccess);

        // 6. Controller
        OpenGameController controller =
                new OpenGameController(interactor);

        // 7. View
        OpenGameView view =
                new OpenGameView(controller, viewModel);

        // 8. Swing frame setup
        JFrame frame = new JFrame("Open Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(view);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
