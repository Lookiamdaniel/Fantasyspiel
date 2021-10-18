package Hero;

public class Wizard extends Hero {

    private double magicHeal;


    public Wizard(String name, int healthpoints, int luck, int strength, double magicHeal, Weapon weapon) {
        super(name, healthpoints, luck, strength, weapon);
        this.magicHeal = magicHeal;
    }

    public void heal (){
        healthpoints += magicHeal;
    }

}
