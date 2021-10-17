package Hero;

import java.util.Random;

public class Monster {

    private String name;
    protected float healthpoints;
    private int luck;
    private int strength;
    private float attackdamage;
    private int range;

    public Monster (String name, float healthpoints, int luck, int strength, int range) {
        this.name = name;
        this.healthpoints = healthpoints;
        this.luck = luck;
        this.strength = strength;
        this.range = range;

        Random random = new Random();
        float singleLuck;
        singleLuck = (float) (random.nextFloat() * (luck-0.5) + 0.5);

        attackdamage = strength * singleLuck;
    }

    public String getName () {
        return name;
    }

    public int getRange(){
        return range;
    }

    public float getHealthpoints(){ return  healthpoints;}

    public void setHealthpoints (float newHealthpoints) {
        healthpoints = newHealthpoints;
    }

    /*public float calcAttackdamage (int strength, int luck) {
        attackdamage = strength * calcLuck(luck);
        return attackdamage;
    }

    public float calcLuck (int luck) {
        Random random = new Random();
        float singleLuck;
        singleLuck = (float) (random.nextFloat() * (luck-0.5) + 0.5);
        return singleLuck;
    }*/
}
