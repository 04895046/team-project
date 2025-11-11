package Battle_System.Interface_Adapter.Battle;

import Battle_System.Entity.Monster;
import Battle_System.Entity.User;

public class Battle_State {
    private User user;
    private Monster monster;

    public Monster getMonster() {
        return monster;
    }
    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
