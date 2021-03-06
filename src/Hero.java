import java.util.Random;
import java.util.Scanner;

public class Hero {

    private String name;
    protected double healthpoints;
    private double luck;
    private int strength;
    protected double attackdamage;
    private Weapon weapon;
    private Fight fight;

    public Hero(String name, double healthpoints, double luck, int strength, Weapon weapon, Fight fight) {
        this.name = name;
        this.healthpoints = healthpoints;
        this.luck = luck;
        this.strength = strength;
        this.weapon = weapon;
        this.fight = fight;
    }

    public double getAttackdamage(){
        Random random = new Random();
        double singleLuck;
        singleLuck = (random.nextDouble() * (luck-0.5) + 0.5);

        attackdamage = strength * singleLuck + weapon.getMaterial();

        return attackdamage;
    }

    public String getName(){
        return name;
    }

    public double getHealthpoints(){
        return  healthpoints;
    }

    public double getLuck(){
        return luck;
    }

    public int getStrength (){
        return strength;
    }

    public void setHealthpoints(double subtrahend){
        healthpoints -= subtrahend;
    }

    public void setFight(Fight fight){
        this.fight = fight;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    //mit den folgenden Methoden werden die klassischen Helden kreiert.
    public void createElb(String hName){
        Hero hero = new Elb(hName, 40, 1.5, 7, 2, 1, weapon, fight);
    }
    public void createWizard(String hName){
        Hero hero = new Wizard(hName, 35, 1.2, 4, fight,5, weapon);
    }
    public void createBarbar(String hName){
        Hero hero = new Barbar(hName, 50, 0.8, 10, 2, weapon, fight);
    }

    public void offense(Monster monster) {

         // gibt Helden die Chance auf einen Fernangriff
        distanceAttack(monster);

        //Nahkampfangriff, nur wenn noch kein Fernangriff
        if (fight.getWinnerAttack() < 2) {
            melee(monster);
        }

    }

    public void attack(String attackDescription, String musterDefense, Monster monster) {
        Random random = new Random();
        int randomDefense = random.nextInt(3);

        if (randomDefense == 1) {
            System.out.println("Das Monster konnte den Angriff abwehren. Geh in Deckung!");
            fight.setWinnerAttack(2);

        } else {
            fight.setWinnerAttack(1);
            fight.madeDamage();
        }
    }

    public void distanceAttack(Monster monster){
        if (monster.getRange() < weapon.getRange()) {
            int rangeProbabilty = (weapon.getRange() - monster.getRange()) * 10;
            System.out.println("Du hast mit deiner Waffe eine gr????ere Reichweite, als das Monster. \n"
                    + "Wenn du sie nutzt, hat das Monster keine Chance.\n "
                    + "Allerdings kann dich das Monster beim Vorbereiten auf den Angriff auf Entfernung "
                    + "mit einer Wahrscheinlichkeit von " + (100-rangeProbabilty) + "% unterbrechen"
                    + " und dir Schaden zuf??gen.\n"
                    + "\n Wenn du deine Reichweite nutzen willst, dr??cke '1', andernfalls irgendein anderes Zeichen!");

            Scanner scan = new Scanner(System.in);
            String tryRange = scan.next();

            if (tryRange.equals("1")) {
                Random random = new Random();
                int saveRandom = random.nextInt(99);
                if (saveRandom <= rangeProbabilty) {
                    fight.setWinnerAttack(3);
                    fight.madeDamage();
                } else {
                    fight.setWinnerAttack(4);
                    System.out.println("Leider hat dich das Monster unterbrochen und greift jetzt an!");
                }
            }
        }
    }

    public void melee(Monster monster){
        String attackDescription;
        String musterDefense;

        System.out.println("Von wo willst du angreifen? \na = LINKS\n"
                + "d = RECHTS\n"
                + "w = OBEN\n"
                + "s = TIEF");

        while (true) {

            Scanner scanAttack = new Scanner(System.in);
            attackDescription = scanAttack.next();

            if (attackDescription.equals("a")) {
                attackDescription = "LINKS";
                musterDefense = "a";
                attack(attackDescription, musterDefense, monster);
                break;

            } else if (attackDescription.equals("d")) {
                attackDescription = "RECHTS";
                musterDefense = "d";
                attack(attackDescription, musterDefense, monster);
                break;

            } else if (attackDescription.equals("w")) {
                attackDescription = "OBEN";
                musterDefense = "w";
                attack(attackDescription, musterDefense, monster);
                break;

            } else if (attackDescription.equals("s")) {
                attackDescription = "TIEF";
                musterDefense = "s";
                attack(attackDescription, musterDefense, monster);
                break;
            } else {
                System.out.println("Gib a, d, w oder s ein.");
            }
        }
    }

















    /* public double calcAttackdamage (int strength, int luck) {
        attackdamage = strength * calcLuck(luck);
        return attackdamage;
    }

    public double calcLuck (int luck) {
        Random random = new Random();
        double singleLuck;
        singleLuck = (double) (random.nextdouble() * (luck-0.5) + 0.5);
        return singleLuck;
    } */
}
