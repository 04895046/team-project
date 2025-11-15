package Adventure_Game.interface_adapter.move;

import Adventure_Game.entity.Direction;
import Adventure_Game.use_case.move.MoveInputBoundary;
import Adventure_Game.use_case.move.MoveInputData;

public class MoveController {
    private final MoveInputBoundary moveUseCaseInteractor;

    public MoveController(MoveInputBoundary moveUseCaseInteractor) {
        this.moveUseCaseInteractor = moveUseCaseInteractor;
    }

    public void execute(Direction direction) {
        final MoveInputData moveInputData = new MoveInputData(direction);
        moveUseCaseInteractor.execute(moveInputData);
    }
}
