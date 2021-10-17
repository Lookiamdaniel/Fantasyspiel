package Hero;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Hero {

    private String name;
    protected float healthpoints;
    private int luck;
    private int strength;
    protected float attackdamage;
    private Weapon weapon;

    public Hero(String name, float healthpoints, int luck, int strength, @NotNull Weapon weapon) {
        this.name = name;
        this.healthpoints = healthpoints;
        this.luck = luck;
        this.strength = strength;
        this.weapon = weapon;

        Random random = new Random();
        float singleLuck;
        singleLuck = (float) (random.nextFloat() * (luck-0.5) + 0.5);


        attackdamage = strength * singleLuck * weapon.getMaterial();
    }

    public float getAttackdamage(){
        return attackdamage;
    }
    public float getHealthpoints(){ return  healthpoints;}

    /* public float calcAttackdamage (int strength, int luck) {
        attackdamage = strength * calcLuck(luck);
        return attackdamage;
    }

    public float calcLuck (int luck) {
        Random random = new Random();
        float singleLuck;
        singleLuck = (float) (random.nextFloat() * (luck-0.5) + 0.5);
        return singleLuck;
    } */
}
