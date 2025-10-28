package Battle_System.Entity;


public class Spells {
    private final String spellName;
    private final int DMG;

    /**
     * This DamageType class contains the type of the damage, the description of the damage type, the 2-3 skills that
     * this monster has, and the map contains those skills and corresponding dmg
     */
    public Spells(String spellName, int DMG) {
        this.spellName = spellName;
        this.DMG = DMG;
    }

    public String getSpellName() {
        return spellName;
    }
    public int getDMG() {
        return DMG;
    }

}
