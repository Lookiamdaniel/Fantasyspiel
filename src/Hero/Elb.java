package Hero;

public class Elb extends Hero {

    private int magic;
    private int dexterity;


    public Elb(String name, int healthpoints, int luck, int strength, int magic, int dexterity, Weapon weapon) {
        super(name, healthpoints, luck, strength, weapon);
        this.magic = magic;
        this.dexterity = dexterity;


    }
}
