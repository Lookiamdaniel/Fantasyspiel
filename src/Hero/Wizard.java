package Hero;

import Hero.Hero;

public class Wizard extends Hero {

    private int magic;


    public Wizard(String name, int healthpoints, int luck, int strength, int attackdamage, int magic) {
        super(name, healthpoints, luck, strength, attackdamage);
        this.magic = magic;


    }
}
