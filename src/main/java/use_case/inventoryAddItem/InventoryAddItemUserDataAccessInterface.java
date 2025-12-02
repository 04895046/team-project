package use_case.inventoryAddItem;

import entity.AdventureGame;
import entity.User;

public interface InventoryAddItemUserDataAccessInterface {

    AdventureGame getGame();

    void saveGame(AdventureGame game);

    User getUser();
}

