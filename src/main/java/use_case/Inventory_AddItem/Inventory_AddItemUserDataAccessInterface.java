package use_case.Inventory_AddItem;

import entity.AdventureGame;
import entity.Item;
import entity.Inventory;
import entity.User;

public interface Inventory_AddItemUserDataAccessInterface {
    User getUser();

    AdventureGame getGame();

    void saveGame(AdventureGame game);
}

