import Hero.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Fight {

    private static int angriff;

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
                monsterPreAttack(hero, weapon, monster);
            break;
            } else {
                System.out.println("Bitte gib 1 ein, wenn du bereit bist.");
            }
        }
        System.out.println("Der Kampf startet in...");
        for (int i = 1; i <= 5; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(6-i);
        }




    }

    public static void monsterPreAttack(Hero hero, Weapon weapon, Monster monster) {
        String sattack;
        String musterDefense;

        Random random = new Random();
        int attack = random.nextInt((3-0)+1)+1;
        
        if (attack == 0){
            sattack = "LINKS";
            musterDefense = "a";
            monsterAttack(sattack, musterDefense);

        } else if (attack == 1){
            sattack = "RECHTS";
            musterDefense = "d";
            monsterAttack(sattack, musterDefense);

        } else if (attack == 2){
            sattack = "OBEN";
            musterDefense = "w";
            monsterAttack(sattack, musterDefense);

        } else if (attack == 3){
            sattack = "TIEF";
            musterDefense = "s";
            monsterAttack(sattack, musterDefense);
        }

        
    }

    public static void monsterAttack (String sattack, String musterDefense) {
        Scanner scanner;
        String heroDefense;

        System.out.println("Das Monster greift " + sattack + " an!");

        scanner = new Scanner(System.in);
        heroDefense = scanner.next();

        if (heroDefense.equalsIgnoreCase(musterDefense)) {
            System.out.println("Gute Verteidigung!");
            //Leben abziehen

        } else {
            System.out.println("Zu langsam. Das tut weh.");
        }
    }
}
