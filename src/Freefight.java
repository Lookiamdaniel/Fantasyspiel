import Hero.*;


import java.util.*;

public class Freefight {

private Scanner scan;

private Hero hero;
private Weapon weapon;
private Monster monster;

    public void startFreefight () throws InterruptedException {

        createHero();
        createWeapon();
        createMonster();

        Fight.startFight(hero, weapon, monster);
    }
    public void createWeapon () {

        String hWaffe;
        System.out.println("\n Waffe wählen:  Schwert: Hero.Weapon.Königsmörder (1), Dolche: FlinkeHände (2), Hero.Weapon.Bogen: Kilometerkiller (3), Hero.Weapon.Axt: Berserker (4)");
        scan = new Scanner(System.in);
        hWaffe = scan.nextLine();


        while (true) {
            if (hWaffe.equals("1")) {
                weapon = new Weapon("Königsmörder", 10, 10, 10);
                break;
            } else if (hWaffe.equals("1")) {
                weapon = new Weapon("Flinkehände", 10, 10, 10);
                break;
            } else if (hWaffe.equals("2")) {
                weapon = new Weapon("Kilometerkiller", 10, 10, 10);
                break;
            } else if (hWaffe.equals("3")) {
                weapon = new Weapon("Berserker", 10, 10, 10);
                break;
            } else {
                System.out.println("Bitte gib eine Zahl zwischen 1 und 4 ein, um deine Waffe zu wählen.");
            }
        }

    }

    public void createHero() {
        String hKlasse;

        System.out.println("Herzlich Willkommen, du befindest dich in dem FreeFight-Mouds.\n\n Btte erstelle deinen Helden:"
                + "\n Name:");

        scan = new Scanner(System.in);
        String hName = scan.next();


        System.out.println("\n Klasse wählen: Hero.Wizard (1), Hero.Hero.Barbar (2), Hero.Elb (3)");
        scan = new Scanner(System.in);
        hKlasse = scan.nextLine();

        while (true) {
            if (hKlasse.equals("1")) {
                hero = new Wizard(hName, 10, 10, 10, 10, weapon);
                break;
            } else if (hKlasse.equals("2")) {
                hero = new Barbar(hName, 10, 10, 10, 10, 10, weapon);
                break;
            } else if (hKlasse.equals("3")) {
                hero = new Elb(hName, 10, 10, 10, 10, 10, weapon);
                break;
            } else{
                System.out.println("Bitte gib eine Zahl zwischen 1 und 3 ein, um deine Heldenklasse zu wählen.");
            }

            }
        }



    public void createMonster () {

        int hMonster;
        Monster aMonster[] = new Monster[4];

        System.out.println("\n gegnerisches Monster wählen:  Drache Dystopius (1), Lindwurm Lodan (2), Medusa (3), Ork OhneKompromiss (4) oder ein zufälliges Monster (5)");
        scan = new Scanner(System.in);
        hMonster = scan.nextInt();

        while (true){
            if (hMonster == 1){
                monster = new Monster("Dystopius", 10, 10, 10);
                aMonster[0] = monster;
                break;
            } else if (hMonster==2){
                monster = new Monster("Lodan", 10, 10, 10);
                aMonster[1]=monster;
                break;
            } else if (hMonster==3) {
                monster = new Monster("Lodan", 10, 10, 10);
                aMonster[2] = monster;
                break;
            } else if (hMonster==4) {
                monster = new Monster("Lodan", 10, 10, 10);
                aMonster[3] = monster;
                break;
            } else {
                Random random = new Random();
                hMonster = random.nextInt((4-1)+1)+1;
            }
        }

    }
}
