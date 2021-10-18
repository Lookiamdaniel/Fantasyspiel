package Hero;

import java.util.Random;

public class Hero {

    private String name;
    protected double healthpoints;
    private int luck;
    private int strength;
    protected double attackdamage;
    private Weapon weapon;

    public Hero(String name, double healthpoints, int luck, int strength, Weapon weapon) {
        this.name = name;
        this.healthpoints = healthpoints;
        this.luck = luck;
        this.strength = strength;
        this.weapon = weapon;

        Random random = new Random();
        double singleLuck;
        singleLuck = (double) (random.nextDouble() * (luck-0.5) + 0.5);


        attackdamage = strength * singleLuck * weapon.getMaterial();
    }

    public double getAttackdamage(){
        return attackdamage;
    }
    public double getHealthpoints(){ return  healthpoints;}
    public void setHealthpoints(double subtrahend){
        healthpoints -= subtrahend;
    }

    /* public double calcAttackdamage (int strength, int luck) {
        attackdamage = strength * calcLuck(luck);
        return attackdamage;
    }

    public double calcLuck (int luck) {
        Random random = new Random();
        double singleLuck;
        singleLuck = (double) (random.nextdouble() * (luck-0.5) + 0.5);
        return singleLuck;
    } */
}
