public class Elb extends Hero implements Healable, Anger {

    private double magicHeal;
    private int anger;


    public Elb(String name, int healthpoints, double luck, int strength, double magicHeal, int anger, Weapon weapon, Fight fight) {
        super(name, healthpoints, luck, strength, weapon, fight);
        this.magicHeal = magicHeal;
        this.anger = anger;
    }

    public void becomeAngry(){
        attackdamage+=anger;
    }

    public void heal (){
        healthpoints += magicHeal;
    }

    public double getMagicHeal(){
        return magicHeal;
    }

    public int getAnger(){
        return anger;
    }

}
