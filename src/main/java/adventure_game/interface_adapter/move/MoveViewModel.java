package adventure_game.interface_adapter.move;

import adventure_game.interface_adapter.ViewModel;

public class MoveViewModel extends ViewModel<MoveState> {

    public static final String LEFT_BUTTON_LABEL = "Go Left";
    public static final String RIGHT_BUTTON_LABEL = "Go Right";

    public MoveViewModel() {
        super("move");
        setState(new MoveState());
    }
}
