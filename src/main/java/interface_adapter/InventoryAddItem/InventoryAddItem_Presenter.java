package interface_adapter.InventoryAddItem;

import entity.Item;
import interface_adapter.move.MoveState;
import interface_adapter.move.MoveViewModel;
import use_case.Inventory_AddItem.Inventory_AddItem_OutputBoundary;
import use_case.Inventory_AddItem.Inventory_AddItem_OutputData;

/**
 * Presenter for AddItem Usecase
 * updates viewModel state with added item.
 */

public class InventoryAddItem_Presenter implements Inventory_AddItem_OutputBoundary {
    private final InventoryAddItem_ViewModel viewModel;
    private final MoveViewModel moveViewModel;

    public InventoryAddItem_Presenter(InventoryAddItem_ViewModel viewModel, MoveViewModel moveViewModel) {
        this.viewModel = viewModel;
        this.moveViewModel = moveViewModel;
    }

    @Override
    public void present(Inventory_AddItem_OutputData outputData) {
        Item item = outputData.getItem();
        viewModel.getState().setAddedItem(item);

        // Also update the move view model to reflect the item has been removed from the map
        MoveState moveState = moveViewModel.getState();
        moveState.setNeedUpdate(true);
        moveViewModel.firePropertyChange();
    }
}
