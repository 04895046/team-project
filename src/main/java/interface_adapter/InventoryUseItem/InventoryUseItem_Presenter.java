package interface_adapter.InventoryUseItem;

import entity.Item;
import use_case.Inventory_UseItem.Inventory_UseItem_OutputData;

import java.util.ArrayList;
import java.util.List;

public class InventoryUseItem_Presenter extends InventoryUseItem_ViewModel {
    private final InventoryUseItem_ViewModel viewModel;

    public InventoryUseItem_Presenter(InventoryUseItem_ViewModel viewModel) {
        this.viewModel = viewModel;
    }
// Inventory_UseItem_OutputData
    public void useItem(Inventory_UseItem_OutputData outputData) {
        InventoryUseItem_State state = viewModel.getState();

        state.setHpIncrease(outputData.getHpIncrease());
        state.setDefIncrease(outputData.getDefIncrease());
        state.setDmgIncrease(outputData.getDmgIncrease());

        List<String> names = new ArrayList<>();
        for (Item item : outputData.getInventory().getItems()) {
            names.add(item.getName());
        }
        state.setItemNames(names);

        state.setMessage("Item used!");

        viewModel.firePropertyChange();
    }
}