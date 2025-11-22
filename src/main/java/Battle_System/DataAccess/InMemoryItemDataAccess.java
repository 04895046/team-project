package Battle_System.DataAccess;

import Battle_System.Entity.Item;
import Battle_System.UseCase.Item.ItemUserDataAccessInterface;
import java.util.ArrayList;
import java.util.List;

public class InMemoryItemDataAccess implements ItemUserDataAccessInterface {
    private final List<Item> items;

    public InMemoryItemDataAccess() {
        this.items = new ArrayList<>(); }
@Override
    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
    return null;
    }
}
