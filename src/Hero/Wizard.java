package Hero;

public class Wizard extends Hero {

    private int magic;


    public Wizard(String name, int healthpoints, int luck, int strength, int magic, Weapon weapon) {
        super(name, healthpoints, luck, strength, weapon);
        this.magic = magic;


    }
}
