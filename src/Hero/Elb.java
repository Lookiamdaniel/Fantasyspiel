package Hero;

public class Elb extends Hero { //extends Wizard and Barbar but not possible in Java :(

    private double magicHeal;
    private int anger;


    public Elb(String name, int healthpoints, int luck, int strength, double magicHeal, int anger, Weapon weapon) {
        super(name, healthpoints, luck, strength, weapon);
        this.magicHeal = magicHeal;
        this.anger = anger;
        attackdamage+=anger;
    }

    public void becomeAngry(){
        attackdamage+=anger;
    }

    public void heal (){
        healthpoints += magicHeal;
    }
}
