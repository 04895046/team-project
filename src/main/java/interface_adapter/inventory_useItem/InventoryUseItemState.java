package interface_adapter.inventory_useItem;

import java.util.ArrayList;
import java.util.List;

public class InventoryUseItemState {

    private List<String> itemNames;

    private boolean needsRefresh;
    private String message;

    public InventoryUseItemState() {
        this.itemNames = new ArrayList<>();
        this.message = "";
        this.needsRefresh = false;
    }

    // Getters and Setters
    public List<String> getItemNames() {
        return itemNames;
    }

    public void setItemNames(List<String> itemNames) {
        this.itemNames = itemNames;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getNeedsRefresh() {
        return needsRefresh;
    }

    public void setNeedsRefresh(boolean needsRefresh) {
        this.needsRefresh = needsRefresh;
    }
}
