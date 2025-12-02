package entity;
import java.util.ArrayList;
import java.util.List;
public class GameState {
    private String currentLocation;
    private final String finalDestination;
    private final List<String> inventory;
    private boolean isCompleted;

    // Constructor for NEW GAME
    public GameState(String startingLocation, String finalDestination) {
        this.currentLocation = startingLocation;
        this.finalDestination = finalDestination;
        this.inventory = new ArrayList<>();
        this.isCompleted = false;
    }

}
