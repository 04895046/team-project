package adventure_game.entity;

import Battle_System.User.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdventureGame {

    private final User user;
    private final GameMap gameMap;
    private List<Location> pathHistory;

    // NOTE: could add static data related variables like startTime

    // New Game
    public AdventureGame(User user, GameMap gameMap) {
        this.user = user;
        this.gameMap = gameMap;
        this.pathHistory = new LinkedList<>();
        this.pathHistory.add(gameMap.getCurrentLocation());
    }

    // Old Game
    public AdventureGame(User user, GameMap gameMap,  List<Location> pathHistory) {
        this.user = user;
        this.gameMap = gameMap;
        this.pathHistory = pathHistory;
    }

    public User getUser() {
        return user;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public List<Location> getPathHistory() {
        return pathHistory;
    }

    public boolean canMove(Direction direction) {
        return this.gameMap.canMove(direction);
    }

    public boolean move(Direction direction) {
        boolean success = this.gameMap.move(direction);
        if (success) {
            this.pathHistory.add(this.gameMap.getCurrentLocation());
        }
        return success;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        // Wrap user in JSONObject (assumes User follows Java Bean conventions)
        json.put("user", new JSONObject(this.user));
        json.put("gameMap", this.gameMap.toJSON());

        JSONArray pathArray = new JSONArray();
        for (Location loc : pathHistory) {
            pathArray.put(loc.toJSON());
        }
        json.put("pathHistory", pathArray);

        return json;
    }

    public static AdventureGame fromJSON(JSONObject json) {
        // Deserialize User using reflection since we can't modify the User class
        JSONObject userJson = json.getJSONObject("user");
        User user = new User();

        for (String key : userJson.keySet()) {
            try {
                Field field = User.class.getDeclaredField(key);
                field.setAccessible(true);
                Object value = userJson.get(key);
                // Basic type conversion if needed (e.g. Integer to Double/Long)
                if (value instanceof Integer && (field.getType() == double.class || field.getType() == Double.class)) {
                    field.set(user, ((Integer) value).doubleValue());
                } else {
                    field.set(user, value);
                }
            } catch (Exception e) {
                // Skip fields that can't be set
            }
        }

        GameMap map = GameMap.fromJSON(json.getJSONObject("gameMap"));

        List<Location> path = new LinkedList<>();
        if (json.has("pathHistory")) {
            JSONArray pathArray = json.getJSONArray("pathHistory");
            for (int i = 0; i < pathArray.length(); i++) {
                path.add(Location.fromJSON(pathArray.getJSONObject(i)));
            }
        } else {
            path.add(map.getCurrentLocation());
        }

        return new AdventureGame(user, map, path);
    }

}