package Hero;

import Hero.Hero;

public class Elb extends Hero {

    private int magic;
    private int dexterity;


    public Elb(String name, int healthpoints, int luck, int strength, int attackdamage, int magic, int dexterity) {
        super(name, healthpoints, luck, strength, attackdamage);
        this.magic = magic;
        this.dexterity = dexterity;


    }
}
