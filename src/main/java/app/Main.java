package app;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AppBuilder appBuilder = new AppBuilder();
        JFrame application = appBuilder
                .addQuizView()
                .addUseInventoryView()
                .addBattleView()
                .addMoveView()
                .addOpenGameView()
                .addResultsView()
                .addAddInventoryView()


                // Use cases
                .addOpenGameUseCase()
                .addUseInventoryUseCase()
                .addMoveUseCase()
                .addBattleUseCase()
                .addQuizUseCase()
                .addResultsUseCase()
                .addAddInventoryUseCase()
                .build();

        application.pack();
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}
