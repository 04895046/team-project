package interface_adapter.inventoryAddItem;

import interface_adapter.ViewModel;

public class InventoryAddItemViewModel extends ViewModel<InventoryAddItemState> {
    public InventoryAddItemViewModel() {
        super("InventoryAddItem");
        setState(new InventoryAddItemState());
    }

}
