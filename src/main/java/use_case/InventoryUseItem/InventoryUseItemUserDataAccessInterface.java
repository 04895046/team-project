package use_case.InventoryUseItem;

import entity.Item;
import entity.User;
import entity.Inventory;

public interface InventoryUseItemUserDataAccessInterface {
    /**
     * Returns inventory of user
     * @param user the user
     * @return the user's inventory
     */
    Inventory getInventory(User user);

    /**
     * Remove an item from user's inventory
     * @param user the user
     * @param item item to be removed from inventory
     */
    void removeItem(User user, Item item);

    /**
     * Get an item by name from user's inventory
     * @param user user of game
     * @param name name of item to be looked up
     * @return item looked up, or null if not found
     */
    Item getItemByName(User user, String name);
}
