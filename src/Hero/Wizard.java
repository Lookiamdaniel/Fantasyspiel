package Hero;

import Hero.Hero;
import Weapon.Weapon;

public class Wizard extends Hero {

    private int magic;


    public Wizard(String name, int healthpoints, int luck, int strength, int attackdamage, int magic, Weapon weapon) {
        super(name, healthpoints, luck, strength, attackdamage, weapon);
        this.magic = magic;


    }
}
