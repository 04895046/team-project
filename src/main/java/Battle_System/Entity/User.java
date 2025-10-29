package Battle_System.Entity;

import Battle_System.GameAPI.SrdMonsterDetail;

import java.util.Random;

public class User {
    //1. As a user I want to have an initial ATK and HP value when the game starts.
    //2. As a user I want to be able to initiate a battle so that I can attack my opponent/monster or choose flee to aviod the fight.
    //3. As a user I want to be able to access my inventory so that I can equip or use items.
    public String NAME;
    private double HP;
    private double DMG = 8;
    private double DEF = 0;

    public User() {
        Random random = new Random();
        HP = random.nextInt(11) + 20;
    }

    // Getters and Setters
    public double getHP() {
        return HP;
    }

    public double getDMG() {
        return DMG;
    }

    public boolean isAlive() {
        return HP > 0;
    }

    public void HPDecrease(double DMG){
        HP -= DMG * (1 - 0.2 * this.getDEF());
        if (HP < 0) HP = 0;
    }

    public void addDMG(double dmg){
        DMG += dmg;
    }

    public void decreaseDMG(double dmg){
        DMG -= dmg;
    }

    public double getDEF() {
        return DEF;
    }

    public void addDEF(double def){
        DEF += def;
    }

    public void decreaseDEF(double def){
        DEF -= def;
    }

    public Boolean SuccessAttack(){
        return null;
        // TODO : answer the quiz correctly then return true in this method
    }

    public double attack(){
        if(SuccessAttack()){
            return getDMG();
        }
        else{
            return 0;
        }
    }
}
