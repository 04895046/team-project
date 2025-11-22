package Battle_System.Entity;

import java.util.List;

public class Inventory {
    private List<Item> INVENTORY;


    public Inventory(List<Item> INVENTORY) {
        this.INVENTORY = INVENTORY; }

    //Edits to inventory
    public void addItem(Item item) {
        INVENTORY.add(item); }
    public void removeItem(Item item) {
        INVENTORY.remove(item); }

    public Item getItemByName (String name){
        for(Item item : INVENTORY){
            if (item.getName().equals(name)){
                return item;
            }
        }
    return null;
    }
    public List<Item> getItems(){
        return List.copyOf(INVENTORY);
    }

    public boolean isEmpty() {
        return INVENTORY.isEmpty();
    }
}

