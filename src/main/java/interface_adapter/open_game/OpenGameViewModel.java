package interface_adapter.open_game;

import java.util.ArrayList;
import java.util.List;

public class  OpenGameViewModel {

    private String message;

    // Listeners manually stored (no java.beans)
    private final List<Runnable> listeners = new ArrayList<>();

    public void addListener(Runnable listener) {
        listeners.add(listener);
    }

    public void firePropertyChange() {
        for (Runnable r : listeners) {
            r.run();
        }
    }

    // --- Getters ---
    public String getMessage() {
        return message;
    }


    // --- Setters ---
    public void setMessage(String message) {
        this.message = message;
    }

}
