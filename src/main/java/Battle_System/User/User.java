package Battle_System.User;

import Battle_System.Item;
import java.util.ArrayList;

public class User {

    //1. As a user I want to have an initial ATK and HP value when the game starts.
    //2. As a user I want to be able to initiate a battle so that I can attack my opponent/monster or choose flee to aviod the fight.
    //3. As a user I want to be able to access my inventory so that I can equip or use items.

    private double hp;
    private double dmg;
    private double def;
    private ArrayList<Item> inventory;

    public User() {
        this.inventory = new ArrayList<>();
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getDmg() {
        return dmg;
    }

    public void setDmg(double dmg) {
        this.dmg = dmg;
    }

    public double getDef() {
        return def;
    }

    public void setDef(double def) {
        this.def = def;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
}
