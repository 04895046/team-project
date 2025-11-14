package Battle_System.User;

import Battle_System.Item;
import java.util.ArrayList;

public class User {

    //1. As a user I want to have an initial ATK and HP value when the game starts.
    //2. As a user I want to be able to initiate a battle so that I can attack my opponent/monster or choose flee to aviod the fight.
    //3. As a user I want to be able to access my inventory so that I can equip or use items.

    private String name;
    private double hp;
    private double dmg;
    private double def;
    private ArrayList<Item> inventory;

    public User(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
}
