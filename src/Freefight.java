import java.util.*;

public class Freefight {

private Scanner scan;

private Hero hero;
private Weapon weapon;
private Monster monster;
private String hName;
private Fight fight;

    public void startFreefight () {

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
                weapon.createKönigsmörder();
                break;
            } else if (hWaffe.equals("2")) {
                weapon.createFlinkehände();
                break;
            } else if (hWaffe.equals("3")) {
                weapon.createKilometerkiller();
                break;
            } else if (hWaffe.equals("4")) {
                weapon.createBerserker();
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
                hero.createWizard(hName);
                break;
            } else if (hKlasse.equals("2")) {
                hero.createBarbar(hName);
                break;
            } else if (hKlasse.equals("3")) {
                hero.createElb(hName);
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
                monster.createDystopius();
                aMonster[0] = monster;
                break;
            } else if (hMonster==2){
                monster.createLodan(monster);
                aMonster[1]=monster;
                break;
            } else if (hMonster==3) {
                monster.createMedusa();
                aMonster[2] = monster;
                break;
            } else if (hMonster==4) {
                monster.createOhnekompromiss(monster);
                aMonster[3] = monster;
                break;
            } else {
                Random random = new Random();
                hMonster = random.nextInt((4-1)+1)+1;
            }
        }

    }
}
