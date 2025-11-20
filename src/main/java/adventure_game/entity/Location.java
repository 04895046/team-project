package adventure_game.entity;

import Battle_System.User.Monster;
import org.json.JSONObject;

public class Location {

    private final String name;
    private final double latitude;
    private final double longitude;

    private Monster monster;
//    private Item item;

    public Location(String name, double latitude, double longitude, Monster monster) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
//        assert (monster == null && item != null) || (monster != null && item == null);
        this.monster = monster;
//        this.item = item;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

//    public Item getItem() {
//        return item;
//    }
//
//    public void setItem(Item item) {
//        this.item = item;
//    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("latitude", latitude);
        json.put("longitude", longitude);
        return json;
    }

    public static Location fromJSON(JSONObject json) {
        String name = json.getString("name");
        double latitude = json.getDouble("latitude");
        double longitude = json.getDouble("longitude");
        // Monster is currently initialized to null as it's not persisted
        return new Location(name, latitude, longitude, null);
    }

}