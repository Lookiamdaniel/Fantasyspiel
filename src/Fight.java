import Hero.*;
import Weapon.Weapon;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

public class Fight {

    public static void startFight(Hero hero, Weapon weapon, Monster monster) throws InterruptedException {

        System.out.println("So kämpfst du:"
        + "Wenn du bereit bist drücke 1, dann geht es in 5 Sekunden los!"); //Kämpfen noch erklären

        while (true) {
            Scanner scan = new Scanner(System.in);
            int bereit = scan.nextInt();

            if (bereit == 1) {
                fight(hero, weapon, monster);
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

        fight(hero, weapon, monster);


    }

    public static void fight(Hero hero, Weapon weapon, Monster monster) {
        System.out.println("Das Monster greift von LINKS an!");
    }
}
