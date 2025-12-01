package interface_adapter.InventoryAddItem;

import entity.Item;
import use_case.InventoryAddItem.InventoryAddItemOutputBoundary;
import use_case.InventoryAddItem.InventoryAddItemOutputData;

/**
 * Presenter for AddItem Usecase
 * updates viewModel state with added item.
 */

public class InventoryAddItem_Presenter implements InventoryAddItemOutputBoundary {
    private final InventoryAddItem_ViewModel viewModel;

    public InventoryAddItem_Presenter(InventoryAddItem_ViewModel viewModel) {
        this.viewModel = viewModel; }

    @Override
    public void present(InventoryAddItemOutputData outputData) {
        Item item = outputData.getItem();
        viewModel.getState().setAddedItem(item);


    }
}
