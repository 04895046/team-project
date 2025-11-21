package Battle_System.Entity;

public class Item {

    private String name;
    private String description;
    private String type; // type of item from Dnd api will be sorted by interactor
    private int value;

    public Item(String name, String type) {
        this.name = name;
        this.type = type;
        int len = name.length() / 3;
        if (len > 11) { value = 11; } else { value = len; }
        this.description = name + " is a " + type + " item with a potential value of " + value + " pts.";
    }

    public String getDescription() {
        return description;
    }
    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public int getValue() {return value;}

}

/**
 *  List<String> lvl_1 = Arrays.asList("Common", "Varies");
 *         List<String> lvl_2 = Arrays.asList("Rare", "Uncommon");
 *         List<String> lvl_3 = Arrays.asList("Very Rare", "Legendary", "Artifact");
 *         List<String> Weapon = Arrays.asList("weapon", "wand", );
 */

