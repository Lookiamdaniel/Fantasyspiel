public class Wizard extends Hero implements Healable {

    private double magicHeal;


    public Wizard(String name, int healthpoints, double luck, int strength, Fight fight, double magicHeal, Weapon weapon) {
        super(name, healthpoints, luck, strength, weapon, fight);
        this.magicHeal = magicHeal;
    }

    public void heal (){
        healthpoints += magicHeal;
    }

    public double getMagicHeal(){
        return magicHeal;
    }
}
