import java.util.*;

public class Freefight {

private Scanner scan;

private Hero hero;
private Weapon weapon;
private Monster monster;
private String hName;
private Fight fight;

    public void startFreefight () throws InterruptedException {

        setName();
        createWeapon();
        createHero();
        createMonster();

        fight = new Fight(hero, weapon, monster);
        monster.setFight(fight);
        hero.setFight(fight);
        fight.startFight();

        Game game = new Game();
        game.startGame();
    }

    public void setName(){
        System.out.println("Herzlich Willkommen, du befindest dich in dem FreeFight-Mouds.\n\n Btte erstelle deinen Helden:"
                + "\n Name:");

        scan = new Scanner(System.in);
        hName = scan.next();
    }

    public void createWeapon () {

        while (true) {
            String hWaffe;
            System.out.println("\n Waffe wählen:  \n"
                    +"Schwert: Königsmörder (1) [hat eine gute Reichweite und macht ordentlich Schaden]\n"
                    +"Dolche: FlinkeHände (2) [keine große Reichweite und machen durchschnittlichen Schaden]\n"
                    +"Bogen: Kilometerkiller (3) [verursacht am wenigsten Schaden, hat aber die maximale Reichweite (wichtig gegen Dystopius)\n"
                    +"Axt: Berserker (4) [verursacht am meisten Schaden und hat eine geringe Reichweite]\n");
            scan = new Scanner(System.in);
            hWaffe = scan.nextLine();

            if (hWaffe.equals("1")) {
                weapon = new Weapon("Königsmörder", 5, 3, 1);
                break;
            } else if (hWaffe.equals("2")) {
                weapon = new Weapon("Flinkehände", 3, 1, 1);
                break;
            } else if (hWaffe.equals("3")) {
                weapon = new Weapon("Kilometerkiller", 1, 9, 1);
                break;
            } else if (hWaffe.equals("4")) {
                weapon = new Weapon("Berserker", 7, 2, 1);
                break;
            } else {
                System.out.println("Bitte gib eine Zahl zwischen 1 und 4 ein, um deine Waffe zu wählen.");
            }
        }

    }

    public void createHero() {
        String hKlasse;

        while (true) {
            System.out.println("\n Klasse wählen: \n"
                    +"Zauberer (1) [Held von gebührendem Alter und Weisheit, wenig Kraft und Lebenspunkte mehr]\n"
                    +"      Spezialfähigkeit: heilt sich nach jeder gekämpften Runde\n\n"
                    +"Barbar (2) [ein wahrhaftiger Kämpfer mit einer starken Rüstung und einer unglaublichen Kraft]\n"
                    +"      Spezialfähigkeit: nach jeder Runde wird der Barbar wütender und erhöht somit seine Kraft um so mehr\n\n"
                    +"Elb (3) [ein anmutiger Krieger mit viel Glück und durchschnittlicher Kraft]\n"
                    +"      Spezialfähigkeit: ein bisschen Barbar und ein bisschen Zauberer, kann sich also heilen und wird immer stärker\n");
            scan = new Scanner(System.in);
            hKlasse = scan.nextLine();

            if (hKlasse.equals("1")) {
                hero = new Wizard(hName, 35, 1.2, 4, fight,5, weapon);
                break;
            } else if (hKlasse.equals("2")) {
                hero = new Barbar(hName, 50, 0.8, 10, 2, weapon, fight);
                break;
            } else if (hKlasse.equals("3")) {
                hero = new Elb(hName, 40, 1.5, 7, 2, 1, weapon, fight);
                break;
            } else{
                System.out.println("Bitte gib eine Zahl zwischen 1 und 3 ein, um deine Heldenklasse zu wählen.");
            }
        }
    }

    public void createMonster () {

        int hMonster;
        Monster aMonster[] = new Monster[4];

        while (true){
            System.out.println("\n gegnerisches Monster wählen:  \n"
                    +"Drache Dystopius (1) [das Stärkste Monster, hat die höchste Range, die meisten Lebenspunkte und kann am meisten Schaden verursachen]\n"
                    +"Lindwurm Lodan (2) [das zweitstärkste Monster mit einer gewaltigen Stärke]\n"
                    +"Medusa (3) [hat zwar nicht viele Lebenspunkte, aber am meisten Glück und kämpft am gerissensten]\n"
                    +"Ork Ohnekompromiss (4) [ein Berserker mit wenig Glück, aber einer durchschnittlichen Stärke und Lebenspunkten\n");

            scan = new Scanner(System.in);
            hMonster = scan.nextInt();

            if (hMonster == 1){
                monster = new Monster("Dystopius", 60, 1.2, 11, 8, 800, fight);
                aMonster[0] = monster;
                break;
            } else if (hMonster==2){
                monster = new Monster("Lodan", 55, 1, 13, 4, 1100, fight);
                aMonster[1]=monster;
                break;
            } else if (hMonster==3) {
                monster = new Monster("Medusa", 45, 1.5, 7, 1, 600, fight);
                aMonster[2] = monster;
                break;
            } else if (hMonster==4) {
                monster = new Monster("Ohnekompromiss", 50, 0.9, 10, 2, 800, fight);
                aMonster[3] = monster;
                break;
            } else {
                Random random = new Random();
                hMonster = random.nextInt((4-1)+1)+1;
            }
        }

    }
}
