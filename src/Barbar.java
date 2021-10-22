public class Barbar extends Hero implements Anger {

    private int anger;


    public Barbar(String name, int healthpoints, double luck, int strength, int anger, Weapon weapon, Fight fight) {
        super(name, healthpoints, luck, strength, weapon, fight);
        this.anger = anger;

    }

    public void becomeAngry (){
        attackdamage+=anger;
    }

    public int getAnger(){
        return anger;
    }
}
