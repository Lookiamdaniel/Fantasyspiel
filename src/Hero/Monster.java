package Hero;

import java.util.Random;

public class Monster {

    private String name;
    protected double healthpoints;
    private int luck;
    private int strength;
    private double attackdamage;
    private int range;

    public Monster (String name, double healthpoints, int luck, int strength, int range) {
        this.name = name;
        this.healthpoints = healthpoints;
        this.luck = luck;
        this.strength = strength;
        this.range = range;

        Random random = new Random();
        double singleLuck;
        singleLuck = (double) (random.nextDouble() * (luck-0.5) + 0.5);

        attackdamage = strength * singleLuck;
    }

    public String getName () {
        return name;
    }

    public int getRange(){
        return range;
    }

    public double getHealthpoints(){ return  healthpoints;}

    public void setHealthpoints (double subtrahend) {
        healthpoints -= subtrahend;
    }

    public double getAttackdamage(){
        return attackdamage;
    }

    /*public double calcAttackdamage (int strength, int luck) {
        attackdamage = strength * calcLuck(luck);
        return attackdamage;
    }

    public double calcLuck (int luck) {
        Random random = new Random();
        double singleLuck;
        singleLuck = (double) (random.nextdouble() * (luck-0.5) + 0.5);
        return singleLuck;
    }*/
}
