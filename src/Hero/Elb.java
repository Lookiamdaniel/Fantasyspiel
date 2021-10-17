package Hero;

public class Elb extends Hero {

    private float magicHeal;
    private int anger;


    public Elb(String name, int healthpoints, int luck, int strength, float magicHeal, int anger, Weapon weapon) {
        super(name, healthpoints, luck, strength, weapon);
        this.magicHeal = magicHeal;
        this.anger = anger;
    }

    public void becomeAngry(){
        attackdamage+=anger;
    }

    public void heal (float magicHeal){
        healthpoints += magicHeal;
    }
}
