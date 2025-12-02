package interface_adapter.inventoryAddItem;

import entity.Item;
import interface_adapter.inventoryUseItem.InventoryUseItemState;
import interface_adapter.inventoryUseItem.InventoryUseItemViewModel;
import interface_adapter.move.MoveState;
import interface_adapter.move.MoveViewModel;
import use_case.inventoryAddItem.InventoryAddItemOutputBoundary;
import use_case.inventoryAddItem.InventoryAddItemOutputData;

import java.util.ArrayList;
import java.util.List;

public class InventoryAddItemPresenter implements InventoryAddItemOutputBoundary {
    private final InventoryAddItemViewModel viewModel;
    private final MoveViewModel moveViewModel;
    private final InventoryUseItemViewModel inventoryUseItemViewModel;  // ← ADD THIS

    public InventoryAddItemPresenter(InventoryAddItemViewModel viewModel,
                                     MoveViewModel moveViewModel,
                                     InventoryUseItemViewModel inventoryUseItemViewModel) {  // ← ADD PARAMETER
        this.viewModel = viewModel;
        this.moveViewModel = moveViewModel;
        this.inventoryUseItemViewModel = inventoryUseItemViewModel;  // ← ADD THIS
    }


    @Override
    public void present(InventoryAddItemOutputData outputData) {
        Item item = outputData.getItem();
        viewModel.getState().setAddedItem(item);

        // Update the move view model
        MoveState moveState = moveViewModel.getState();
        moveState.setNeedUpdate(true);
        moveViewModel.firePropertyChange();

        // Update the inventory view model state with the new item
        InventoryUseItemState inventoryState = inventoryUseItemViewModel.getState();
        List<String> currentItems = inventoryState.getItemNames();
        if (currentItems == null) {
            currentItems = new ArrayList<>();
        }
        List<String> updatedItems = new ArrayList<>(currentItems);
        updatedItems.add(item.getName());
        inventoryState.setItemNames(updatedItems);

        inventoryUseItemViewModel.firePropertyChange();


    }}