package use_case.InventoryUseItem;


import entity.User;

public class InventoryUseItemInputData {
    private final String itemName;
    private final User user;

    /**
     * Constructor for using an item
     * @param itemName name of the item to use
     * @param user the user whose inventory to operate on
     */
    public InventoryUseItemInputData(String itemName, User user) {
        this.itemName = itemName;
        this.user = user;
    }

    /**
     * Constructor for viewing inventory (no item name needed)
     * @param user the user whose inventory to view
     */
    public InventoryUseItemInputData(User user) {
        this.itemName = null;
        this.user = user;
    }

    public String getItemName() {
        return itemName;
    }

    public User getUser() {
        return user;
    }
}

