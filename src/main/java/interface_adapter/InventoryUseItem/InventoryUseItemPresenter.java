package interface_adapter.InventoryUseItem;

import use_case.InventoryUseItem.InventoryUseItemOutputData;
import use_case.InventoryUseItem.InventoryUseItemOutputBoundary;
import entity.Inventory;
import entity.Item;
import use_case.InventoryUseItem.InventoryUseItemOutputData;

import java.util.ArrayList;
import java.util.List;

public class InventoryUseItemPresenter implements InventoryUseItemOutputBoundary {
    private final InventoryUseItemViewModel viewModel;

    public InventoryUseItemPresenter(InventoryUseItemViewModel viewModel) {
        this.viewModel = viewModel;
    }
// Inventory_UseItem_OutputData
    public void useItem(InventoryUseItemOutputData outputData) {
        InventoryUseItemState state = viewModel.getState();

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

    @Override
    public void viewInventory(InventoryUseItemOutputData outputData) {

    }
}
