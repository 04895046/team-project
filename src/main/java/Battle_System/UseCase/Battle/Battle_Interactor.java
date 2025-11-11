package Battle_System.UseCase.Battle;

import Battle_System.Entity.Battle;
import Battle_System.Entity.Monster;
import Battle_System.Entity.Spells;
import Battle_System.Entity.User;

public class Battle_Interactor implements Battle_InputBoundary {
    private final BattleUserDataAccessInterface userDataAccessObject;
    private final Battle_OutputBoundary battlePresenter;

    public Battle_Interactor(BattleUserDataAccessInterface userDataAccessObject, Battle_OutputBoundary battleOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.battlePresenter = battleOutputBoundary;
    }

    @Override
    public void execute(Battle_InputData inputData) {
        final User user = inputData.getUser();
        final Monster monster = inputData.getMonster();
        // TODO: finish the execute
        Battle newBattle = new Battle(monster, user);
        while (user.isAlive() && monster.isAlive()) {
            UserTurn();
            if (monster.isAlive()) {
                break;
            }
            MonsterTurn();
        }
        // 把battle里面的东西全部都copy到这边
    }
}
