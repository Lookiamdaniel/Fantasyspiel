package Hero;

public class Barbar extends Hero {

    private int anger;


    public Barbar(String name, int healthpoints, int luck, int strength, int anger, Weapon weapon) {
        super(name, healthpoints, luck, strength, weapon);
        this.anger = anger;

    }

    public void becomeAngry (){
        attackdamage+=anger;
    }
}
