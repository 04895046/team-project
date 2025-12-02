package interface_adapter.InventoryUseItem;

import entity.User;
import use_case.InventoryUseItem.InventoryUseItemInputData;
import use_case.InventoryUseItem.InventoryUseItemInputBoundary;

public class InventoryUseItemController {

    private final InventoryUseItemInputBoundary useItemInteractor;
    private User user;

    public InventoryUseItemController(InventoryUseItemInputBoundary useItemInteractor) {
        this.useItemInteractor = useItemInteractor;
    }

    /**
     * Set the current user
     * @param user the user playing the game
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Called when user clicks "Use Item" in the dropdown
     * @param itemName name of the item to use
     */
    public void useItem(String itemName) {
        if (user == null || itemName == null) {
            return;
        }
        InventoryUseItemInputData inputData = new InventoryUseItemInputData(itemName, user);
        useItemInteractor.useItem(inputData);
    }

    /**
     * Called when user wants to view their inventory
     */
    public void viewInventory() {
        if (user == null) {
            return;
        }
        InventoryUseItemInputData inputData = new InventoryUseItemInputData(user);
        useItemInteractor.viewInventory(inputData);
    }
}
