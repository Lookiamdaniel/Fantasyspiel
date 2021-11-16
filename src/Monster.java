import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Monster {

    private String name;
    private double healthpoints;
    private double luck;
    private int strength;
    private double attackdamage;
    private int range;
    private int speed;
    private Fight fight;


    public Monster(String name, double healthpoints, double luck, int strength, int range, int speed,Fight fight) {
        this.name = name;
        this.healthpoints = healthpoints;
        this.luck = luck;
        this.strength = strength;
        this.range = range;
        this.speed = speed;
        this.fight = fight;

    }

    public String getName(){
        return name;
    }

    public int getRange(){
        return range;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLuck(double luck) {
        this.luck = luck;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public double getLuck(){
        return luck;
    }

    public int getStrength (){
        return strength;
    }

    public int getSpeed(){
        return speed;
    }

    public double getHealthpoints(){
        return  healthpoints;
    }

    public void setHealthpoints (double subtrahend) {
        healthpoints -= subtrahend;
    }

    public double getAttackdamage(){
        Random random = new Random();
        double singleLuck;
        singleLuck = (random.nextDouble() * (luck-0.5) + 0.5);

        attackdamage = strength * singleLuck;

        return attackdamage;
    }

    //mit den folgenden Methoden werden die klassischen Monster kreiert.
    public void createOhnekompromiss(Monster monster){
        monster = new Monster("Ohnekompromiss", 50, 0.9, 10, 2, 700, fight);
    }
    public void createLodan(Monster monster){
        monster.setName("Lodan");
        monster.setSpeed(900);
        monster.setHealthpoints(55);
        monster.setLuck(1);
        monster.setStrength(13);
        monster.setRange(4);
    }
    public void createMedusa(){
        Monster monster = new Monster("Medusa", 45, 1.5, 7, 1, 300, fight);
    }
    public void createDystopius(){
        Monster monster = new Monster("Dystopius", 60, 1.2, 11, 8, 600, fight);
    }

    public void setFight(Fight fight){
        this.fight = fight;
    }

    //es folgen die Methoden für den Angriff
    public void offense(Hero hero, Weapon weapon) {
        String attackDescription;
        String musterDefense;

        if (getRange() > weapon.getRange()){ //Möglichkeit für das Monster auf Entfernung anzugreifen; wird durch den Zufall bestimmt
            int winRange = getRange() - weapon.getRange();
            Random random = new Random();
            int randRange = random.nextInt(10);

            if (randRange <= winRange){
                System.out.println("Das Monster kann auf größerer Entfernung angreifen, als du und nutzt diese. Du hast keine Chance.");
                fight.setWinnerAttack(2);
                fight.madeDamage();
            }
        }

        Random random = new Random();
        int attack = random.nextInt((3-0)+1);

        if (attack == 0){
            attackDescription = "LINKS";
            musterDefense = "a";
            attack(attackDescription, musterDefense, hero);

        } else if (attack == 1){
            attackDescription = "RECHTS";
            musterDefense = "d";
            attack(attackDescription, musterDefense, hero);

        } else if (attack == 2){
            attackDescription = "OBEN";
            musterDefense = "w";
            attack(attackDescription, musterDefense, hero);

        } else if (attack == 3){
            attackDescription = "TIEF";
            musterDefense = "s";
            attack(attackDescription, musterDefense, hero);
        }


    } //Parameter Hero und Weapon sind keine Attribute des Helden, ansonsten Kampf gegen verschiedene Monster komplexer
    //offense führt immer zu attack

    public void attack (String attackDescription, String musterDefense, Hero hero) {
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println(getName() + " greift " + attackDescription + " an!");
        Date start = new Date();
        long s = System.currentTimeMillis();
        try {
            String defense = scanner.next();
            Date stop = new Date();
            long e = System.currentTimeMillis();
            double duration = stop.getTime() - start.getTime();
            long d = e - s;
            if (d < speed && defense.equalsIgnoreCase(musterDefense)) {
                System.out.println("Gute Verteidigung! Jetzt kannst du angreifen!");
                fight.setWinnerAttack(1);
            }  else {
                System.out.println("Zu langsam. Das tut weh.");
                fight.setWinnerAttack(2);
                fight.madeDamage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } //man hat nur 1 Sekunde, um zu reagieren. Ist man zu langsam, kann das Monster eine Kombo starten
}
