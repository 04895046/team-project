package opening_game;

import opening_game.data_access.OpenGameFileDataAccess;
import opening_game.entity.GameState;
import opening_game.interface_adapter.*;
import opening_game.use_case.*;
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

        // 4. Interactor
        OpenGameInputBoundary interactor =
                new OpenGameInteractor(presenter, dataAccess);

        // 5. Controller
        OpenGameController controller =
                new OpenGameController(interactor);

        // 6. View (Swing panel)
        OpenGameView view =
                new OpenGameView(controller, viewModel);

        // 7. Show it inside a JFrame
        JFrame frame = new JFrame("Open Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(view);
        frame.pack();
        frame.setVisible(true);
    }
}
