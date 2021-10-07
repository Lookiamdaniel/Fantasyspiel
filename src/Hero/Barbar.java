package Hero;

import Weapon.Weapon;

public class Barbar extends Hero {

    private int endurance;
    private int anger;


    public Barbar(String name, int healthpoints, int luck, int strength, int attackdamage, int endurance, int anger, Weapon weapon) {
        super(name, healthpoints, luck, strength, attackdamage, weapon);
        this.endurance = endurance;
        this.endurance = anger;


    }
}
