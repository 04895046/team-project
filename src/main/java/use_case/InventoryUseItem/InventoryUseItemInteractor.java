package use_case.InventoryUseItem;

import entity.Item;
import entity.User;

public class InventoryUseItemInteractor implements InventoryUseItemInputBoundary {
    private final InventoryUseItemOutputBoundary outputBoundary;
    private final InventoryUseItemUserDataAccessInterface userDAO;

    public InventoryUseItemInteractor(InventoryUseItemOutputBoundary outputBoundary,
                                      InventoryUseItemUserDataAccessInterface userDAO) {
        this.outputBoundary = outputBoundary;
        this.userDAO = userDAO;
    }

    /**
     * Helper method: map item type to category
     */
    private String mapTypeToCategory(String type) {
        if (type == null) return "heal";
        switch (type.toLowerCase()) {
            case "weapon":
            case "rod":
            case "wand":
            case "staff":
                return "weapon";
            case "armor":
            case "shield":
            case "ring":
                return "armour";
            default:
                return "heal";
        }
    }

    @Override
    public void useItem(InventoryUseItemInputData inputData) {
        if (inputData == null) {
            return;
        }

        User user = inputData.getUser();
        if (user == null) {
            return;
        }

        Item item = userDAO.getItemByName(user, inputData.getItemName());
        if (item == null) {
            return;
        }

        int hp = 0, def = 0, dmg = 0;

        String category = mapTypeToCategory(item.getType());
        switch (category) {
            case "heal":
                hp = Math.max(1, item.getValue());
                user.addBonusHP(hp);
                break;
            case "armour":
                def = Math.max(1, Math.min(4, Math.abs(item.getValue()) - 4));
                user.addDEF(def);
                break;
            case "weapon":
                dmg = (item.getValue() % 2 == 0) ? 2 : 1;
                user.addDMG(dmg);
                break;
        }

        userDAO.removeItem(user, item);

        InventoryUseItemOutputData output = new InventoryUseItemOutputData(
                userDAO.getInventory(user), hp, def, dmg);
        outputBoundary.useItem(output);
    }

    @Override
    public void viewInventory(InventoryUseItemInputData inputData) {
        if (inputData == null || inputData.getUser() == null) {
            return;
        }

        User user = inputData.getUser();
        InventoryUseItemOutputData output = new InventoryUseItemOutputData(
                userDAO.getInventory(user), 0, 0, 0);
        outputBoundary.viewInventory(output);
    }
}
