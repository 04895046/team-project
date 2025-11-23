package Battle_System.Interface_Adapter.Inventory;

import Battle_System.UseCase.Inventory.*;

public class Inventory_Controller {

private final Inventory_Interactor interactor;

public Inventory_Controller(Inventory_Interactor inventory_interactor) {
    this.interactor = inventory_interactor; }

// when user calls to pick up item and add to inventory
public void addItem(String itemName) {
    Inventory_InputData_AddItem inputData = new Inventory_InputData_AddItem(itemName);
    interactor.addItem(inputData); }

// when user calls to use item
public void useItem(String itemName) {
    Inventory_InputData_UseItem inputData = new Inventory_InputData_UseItem(itemName);
    interactor.useItem(inputData); }

// when user calls to view inventory
public void viewInventory() {
    interactor.viewInventory(); }
}
