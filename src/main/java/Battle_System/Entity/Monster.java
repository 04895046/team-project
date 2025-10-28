package Battle_System.Entity;

import Battle_System.GameAPI.MonsterDetail;
import Battle_System.GameAPI.SrdMonsterDetail;

import java.util.ArrayList;
import java.util.Random;
/**
 * This Monster class
 */
public class Monster {
    //1. As a user I wa nt those monsters I’ve defeated to be recorded, and to be able to view their status information.
    //2. As a user I want that when I pass through the same area again, the monsters I’ve already defeated will not reappear.
    //3. As a user I want those monsters have name, atk, hp, and damage type
    public String NAME;
    private int HP;
    private Spells[] SPELL;

    public Monster() {
        Random random = new Random();
        HP = random.nextInt(11) + 20;

        SrdMonsterDetail api = new SrdMonsterDetail();
        setSpells(api);
        setNAME(api);
    }

    // Getters and Setters
    public int getHP() {
        return HP;
    }

    public Spells[] getSpells() {
        return SPELL;
    }

    public void HPDecrease(int DMG){
        HP -= DMG;
        if (HP < 0) HP = 0;
    }

    public void setNAME(SrdMonsterDetail api) {
        Random random = new Random();
        String[] nameList = api.generateRaces();
        int size = nameList.length;
        int index = random.nextInt(size);
        NAME = nameList[index];
    }

    public void setSpells(SrdMonsterDetail api) {
        Random random = new Random();
        int size = random.nextInt(4);
        ArrayList<Spells> spell = api.generateSpells();
        int spellListSize = spell.size();
        SPELL = new Spells[size];
        for (int i = 0; i < size; i++) {
            int randomIndex = random.nextInt(spellListSize);
            SPELL[i] = spell.get(randomIndex);
        }
    }

    public Spells chooseSpell(){
        Random random = new Random();
        int size = SPELL.length;
        int index = random.nextInt(size);
        return SPELL[index];
    }

    public int attack(Spells spell) {
        return spell.getDMG();
    }

    public boolean isAlive() {
        return HP > 0;
    }
}
