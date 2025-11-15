package Adventure_Game.interface_adapter.move;

import Adventure_Game.use_case.move.MoveOutputBoundary;
import Adventure_Game.use_case.move.MoveOutputData;

public class MovePresenter implements MoveOutputBoundary {

    private final MoveViewModel moveViewModel;

    public MovePresenter(MoveViewModel moveViewModel) {
        this.moveViewModel = moveViewModel;
    }

    @Override
    public void present(MoveOutputData moveOutputData) {
        MoveState moveState = moveViewModel.getState();

        moveState.setLeftButtonEnabled(moveOutputData.isCanMoveLeft());
        moveState.setRightButtonEnabled(moveOutputData.isCanMoveRight());
        moveState.setCurrentLocationName(moveOutputData.getCurrentLocationName());
        moveState.setMonster(moveOutputData.getMonster());
//        state.setItem(outputData.getItem());
        String linearMap = formatLinearMap(
                moveOutputData.getCurrentIndex(),
                moveOutputData.getMapSize()
        );
        moveState.setLinearMap(linearMap);
        moveViewModel.firePropertyChange();
    }

    private String formatLinearMap(int currentIndex, int mapSize) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mapSize; i++) {
            if (i == currentIndex) {
                sb.append("P"); // 'P' 代表玩家
            } else {
                sb.append("_");
            }

            if (i < mapSize - 1) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }
}
