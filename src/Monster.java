import java.util.Random;

public class Monster {

    private String name;
    protected int healthpoints;
    private int luck;
    private int strength;
    private float attackdamage;

    public Monster (String name, int healthpoints, int luck, int strength) {
        this.name = name;
        this.healthpoints = healthpoints;
        this.luck = luck;
        this.strength = strength;

        Random random = new Random();
        float singleLuck;
        singleLuck = (float) (random.nextFloat() * (luck-0.5) + 0.5);

        attackdamage = strength * singleLuck;
    }

    public String getName () {
        return name;
    }

    public float calcAttackdamage (int strength, int luck) {
        attackdamage = strength * calcLuck(luck);
        return attackdamage;
    }

    public float calcLuck (int luck) {
        Random random = new Random();
        float singleLuck;
        singleLuck = (float) (random.nextFloat() * (luck-0.5) + 0.5);
        return singleLuck;
    }
}
