import Hero.*;

import java.awt.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Fight {

    private static int angriff;
    private static int winnerAttack;

    public static void startFight(Hero hero, Weapon weapon, Monster monster) throws InterruptedException {

        System.out.println("So kämpfst du: \n Lege deine Finger auf die Tasten 'W,A,S,D'. \n"
                + "Wenn das Monster LINKS angreift, drücke 'A'. \n"
                + "Wenn das Monster RECHTS angreift, drücke 'D'. \n"
                + "Wenn das Monster OBEN angreift, drücke 'W'. \n"
                + "Wenn das Monster TIEF angreift, drücke 'S'. \n\n"
                + "Wenn du bereit bist drücke 1, dann geht es in 5 Sekunden los!");

        while (true) {
            Scanner scan = new Scanner(System.in);
            int bereit = scan.nextInt();

            if (bereit == 1) {
                System.out.println("Der Kampf startet in...");
                for (int i = 1; i <= 5; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(6 - i);
                }
                winnerAttack = 2;
                fightCircle(hero, weapon, monster);
            break;
            } else {
                System.out.println("Bitte gib 1 ein, wenn du bereit bist.");
            }
        }
    }

    public static void fightCircle(Hero hero, Weapon weapon, Monster monster){

        while (monster.getHealthpoints() > 0 || hero.getHealthpoints() > 0){

            if (winnerAttack == 2){
                monsterAttack(hero, weapon, monster);
            } else {
                heroAttack(hero, weapon, monster);
            }
            hero.elb.heal();
            hero.wizard.heal();
        }

        if (monster.getHealthpoints()<0){
            System.out.println("Jawoll, du hast das Monster besiegt und selber noch"+hero.getHealthpoints()+"Leben.");
        } else if (hero.getHealthpoints()<0){
            System.out.println("Du hast den Kampf leider verloren und bist gestorben. Das Monster hatte noch"+monster.getHealthpoints()+"Leben.");
        }
    }

    public static void monsterAttack(Hero hero, Weapon weapon, Monster monster) {
        String sattack;
        String musterDefense;

        if (monster.getRange() > weapon.getRange()){
            Random random = new Random();
            int randRange = random.nextInt(((11-monster.getRange())-0)+1)+1;

            if (randRange == 0){
                System.out.println("Das Monster hat eine kann auf größerer Entfernung angreifen, als du und nutzt dies. Du hast keine Chance.");
                winnerAttack = 2;
                madeDamage(hero, monster);
            }
        }

        Random random = new Random();
        int attack = random.nextInt((3-0)+1)+1;
        
        if (attack == 0){
            sattack = "LINKS";
            musterDefense = "a";
            monsterExcAttack(sattack, musterDefense, hero, monster);

        } else if (attack == 1){
            sattack = "RECHTS";
            musterDefense = "d";
            monsterExcAttack(sattack, musterDefense, hero, monster);

        } else if (attack == 2){
            sattack = "OBEN";
            musterDefense = "w";
            monsterExcAttack(sattack, musterDefense, hero, monster);

        } else if (attack == 3){
            sattack = "TIEF";
            musterDefense = "s";
            monsterExcAttack(sattack, musterDefense, hero, monster);
        }

        
    }

    public static void monsterExcAttack (String sattack, String musterDefense, Hero hero, Monster monster) {
        Scanner scanner;
        String heroDefense;

        System.out.println("Das Hero.Monster greift " + sattack + " an!");

        scanner = new Scanner(System.in);
        heroDefense = scanner.next();

        if (heroDefense.equalsIgnoreCase(musterDefense)) {
            System.out.println("Gute Verteidigung! Jetzt kannst du angreifen!");
            winnerAttack = 1;
        } else {
            System.out.println("Zu langsam. Das tut weh.");
            winnerAttack = 2;
            madeDamage(hero, monster);
        }
    }

    public static void heroAttack(Hero hero, Weapon weapon, Monster monster) {
        String sattack;
        String musterDefense;

        if (monster.getRange() < weapon.getRange()){
            int rangeProbabilty = weapon.getRange()/ monster.getRange() * 100;
            System.out.println("Du hast mit deiner Waffe eine größere Reichweite, als das Monster. \n"
                    +"Wenn du sie nutzt, hat das Monster keine Chance.\n "
                    +"Allerdings kann dich das Monster beim Vorbereiten auf den Angriff auf Entfernung"
                    +"mit einer Wahrscheinlichkeit von"+rangeProbabilty+"% unterbrechen"
                    +" und dir Schaden zufügen.\n"
                    +"\n Wenn du deine Reichweite nutzen willst, drücke '1', andernfalls irgendein anderes Zeichen!");

            Scanner scan = new Scanner(System.in);
            String tryRange = scan.next();

            if (tryRange.equals("1")){
                Random random = new Random();
                int saveRandom = random.nextInt((100-rangeProbabilty-0)+1);
                if (saveRandom == 1){
                    winnerAttack = 1;
                } else {
                    winnerAttack = 2;
                }
                madeDamage(hero, monster);
            }
        }

        System.out.println("Von wo willst du angreifen? \na = LINKS\n"
        +"d = RECHTS\n"
        +"w = OBEN\n"
        +"s = TIEF");

        Scanner scanAttack = new Scanner(System.in);
        sattack = scanAttack.next();

        if (sattack.equals("a")){
            sattack = "LINKS";
            musterDefense = "a";
            heroExcAttack(sattack, musterDefense, hero, monster);

        } else if (sattack.equals("d")){
            sattack = "RECHTS";
            musterDefense = "d";
            heroExcAttack(sattack, musterDefense, hero, monster);

        } else if (sattack.equals("w")){
            sattack = "OBEN";
            musterDefense = "w";
            heroExcAttack(sattack, musterDefense, hero, monster);

        } else if (sattack.equals("s")){
            sattack = "TIEF";
            musterDefense = "s";
            heroExcAttack(sattack, musterDefense, hero, monster);
        }


    }

    public static void heroExcAttack (String sattack, String musterDefense, Hero hero, Monster monster) {
        Random random = new Random();
        int randomDefense = random.nextInt((3-0)+1);

        if (randomDefense == 1) {
            System.out.println("Das Monster konnte den Angriff abwehren. Geh in Deckung!");
            winnerAttack = 2;

        } else {
            System.out.println("Du hast das Monster getroffen! Probiere deine Combo fortzusetzen!");
            winnerAttack = 1;
            madeDamage(hero, monster);
        }
    }

    public static void madeDamage (Hero hero, Monster monster){ //1=hero, 2=monster
        if (winnerAttack == 1) {
            monster.setHealthpoints(hero.getAttackdamage());
            System.out.println("Das Monster hat noch" + monster.getHealthpoints() + " Leben.");
            System.out.println("Du kannst nochmal angreifen!");
            winnerAttack = 1;
        } else {
            hero.setHealthpoints(monster.getAttackdamage());
            System.out.println("Du hast noch" + hero.getHealthpoints() + "Leben.");
            System.out.println("Achtung, es greift nochmal an!");
            winnerAttack = 2;
        }
    }
}
