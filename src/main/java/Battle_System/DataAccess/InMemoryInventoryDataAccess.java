package Battle_System.DataAccess;

import Battle_System.Entity.Item;
import Battle_System.Entity.User;
import Battle_System.UseCase.Inventory.InventoryUserDataAccessInterface;
import Battle_System.UseCase.Item.ItemUserDataAccessInterface;

import java.util.List;


public class InMemoryInventoryDataAccess implements InventoryUserDataAccessInterface{
    private  User user;
    private ItemUserDataAccessInterface itemUserDataAccess;
    public InMemoryInventoryDataAccess(User user, ItemUserDataAccessInterface itemUserDataAccess) {
        this.user = user;
        this.itemUserDataAccess = itemUserDataAccess;
        }


    @Override
    public List<Item> getInventory() {
        return user.getInventory().getItems();    }

    @Override
    public void addItem(Item item) {
        user.getInventory().addItem(item);}

    @Override
    public void removeItem(String name) {
        Item remove_item = itemUserDataAccess.getItemByName(name);
        if (remove_item != null) {
            user.getInventory().removeItem(remove_item);
        }

    }
}
