package adventure_game.interface_adapter.move;

import adventure_game.interface_adapter.ViewModel;

public class MoveViewModel extends ViewModel<MoveState> {

    public MoveViewModel() {
        super("move");
        setState(new MoveState());
    }
}
