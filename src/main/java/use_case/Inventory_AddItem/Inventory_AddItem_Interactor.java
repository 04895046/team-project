package use_case.Inventory_AddItem;

import entity.AdventureGame;
import entity.Item;
import entity.Location;
import entity.User;


public class Inventory_AddItem_Interactor implements Inventory_InputBoundary_AddItem{
    private final Inventory_AddItem_OutputBoundary outputBoundary;
    private final Inventory_AddItemUserDataAccessInterface addItemUserDataAccessInterface;

    public Inventory_AddItem_Interactor(Inventory_AddItem_OutputBoundary outputBoundary, Inventory_AddItemUserDataAccessInterface addItemUserDataAccessInterface) {
        this.outputBoundary = outputBoundary;
        this.addItemUserDataAccessInterface = addItemUserDataAccessInterface;
    }

    /**
     * Adds item to user's inventory and updates output
     * @param inputData input data is the information of the item to be added
     */

    @Override
    public void addItem(Inventory_InputData_AddItem inputData){
        if (inputData == null|| inputData.getItem() == null){return;}

        User user = addItemUserDataAccessInterface.getUser();
        Item item = inputData.getItem();
        user.addItem(item);

        // Remove item from the location
        AdventureGame game = addItemUserDataAccessInterface.getGame();
        Location currentLocation = game.getGameMap().getCurrentLocation();
        currentLocation.setItem(null);
        addItemUserDataAccessInterface.saveGame(game);

        Inventory_AddItem_OutputData output = new Inventory_AddItem_OutputData(user.getInventory(), item);
        outputBoundary.present(output);}

}
