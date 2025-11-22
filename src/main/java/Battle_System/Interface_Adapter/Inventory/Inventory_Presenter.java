package Battle_System.Interface_Adapter.Inventory;

import Battle_System.UseCase.Inventory.Inventory_OutputData;
import Battle_System.UseCase.Inventory.Inventory_OutputBoundary;
import Battle_System.Entity.Item;
import java.util.List;

public class Inventory_Presenter implements Inventory_OutputBoundary {

    @Override
    public void addItem(Inventory_OutputData outputData) {
        List<Item> items = outputData.getItems();
        // test lines
        System.out.print("Item added. Inventory has expanded to contain " );
        for (Item item : items) {
            System.out.println("-" + item.getName() + "(" + item.getType() + ")");
        }
    }
    @Override
    public void useItem(Inventory_OutputData outputData) {
        List<Item> items = outputData.getItems();
        int hp = outputData.getHpIncrease();
        int def = outputData.getDefIncrease();
        int dmg = outputData.getDmgIncrease();

        // test lines
        System.out.print("Item used, has enhanced " );
        if (hp > 0) { System.out.println("hp: " + hp); }
        if (def > 0) { System.out.println("def: " + def); }
        if (dmg > 0) { System.out.println("dmg: " + dmg); }

        System.out.print("Item removed. Inventory has reduced to contain " );
        for (Item item : items) {
            System.out.println("-" + item.getName() + "(" + item.getType() + ")");
        }
    }

    @Override
    public void presentInventory(Inventory_OutputData outputData) {
        List<Item> items = outputData.getItems();

        // test lines
        System.out.print("Inventory contains: " );
        for (Item item : items) {
            System.out.println("-" + item.getName() + "(" + item.getType() + ")");
        }
    }
}
