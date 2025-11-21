package adventure_game.use_case.move;

import adventure_game.entity.Direction;

public class MoveInputData {
    private Direction direction;

    public MoveInputData(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}
