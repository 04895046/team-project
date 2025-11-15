package Adventure_Game.interface_adapter.move;

import Adventure_Game.interface_adapter.ViewModel;

public class MoveViewModel extends ViewModel<MoveState> {
    public MoveViewModel(String viewName) {
        super(viewName);
        setState(new MoveState());
    }
}
