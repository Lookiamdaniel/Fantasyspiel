package Hero;

public class Hero {

    private String name;
    protected int healthpoints;
    private int luck;
    private int strength;
    private int attackdamage;

    public Hero(String name, int healthpoints, int luck, int strength, int attackdamage) {
        this.name = name;
        this.healthpoints = healthpoints;
        this.luck = luck;
        this.strength = strength;
        this.attackdamage = attackdamage;
    }

}
