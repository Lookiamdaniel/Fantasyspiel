import java.util.Date;
import java.util.Random;
import java.util.Scanner;

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
                System.out.println("Das Monster hat eine kann auf größerer Entfernung angreifen, als du und nutzt diese. Du hast keine Chance.");

                hero.setHealthpoints(getAttackdamage()); //Schaden am Helden wird ausgeführt

                System.out.println("Du hast noch " + hero.getHealthpoints() + "Leben.");
                System.out.println("Achtung, es greift nochmal an!"); //jetzt folgt Nahkampfangriff
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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Das Monster greift " + attackDescription + " an!");
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
                hero.setHealthpoints(getAttackdamage());
                System.out.println("Du hast noch " + hero.getHealthpoints() + " Leben.");
                System.out.println("Achtung, es greift nochmal an!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } //man hat nur 1 Sekunde, um zu reagieren. Ist man zu langsam, kann das Monster eine Kombo starten
}
