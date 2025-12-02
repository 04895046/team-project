package use_case.inventoryAddItem;

/**
 * Input boundary for Add Item use case
 */

public interface InventoryAddItemInputBoundary {

    /**
     * To be used by Inventory_AddItem_Interactor;
     * @param inputData item to be added to inventory
     */
    void addItem(InventoryAddItemInputData inputData);
}
