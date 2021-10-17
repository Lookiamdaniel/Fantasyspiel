package Hero;

public class Wizard extends Hero {

    private float magicHeal;


    public Wizard(String name, int healthpoints, int luck, int strength, float magicHeal, Weapon weapon) {
        super(name, healthpoints, luck, strength, weapon);
        this.magicHeal = magicHeal;
    }

    public void heal (float magicHeal){
        healthpoints += magicHeal;
    }

}
