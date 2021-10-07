import Hero.*;
import Weapon.Weapon;
import java.util.*;

public class Fight {

    public static void startFight(Hero hero, Weapon weapon, Monster monster) {

        System.out.println("So kämpfst du:"
        + "Wenn du bereit bist drücke 1, dann geht es in 5 Sekunden los!"); //Kämpfen noch erklären

        Scanner scan = new Scanner(System.in);
        int bereit = scan.nextInt();

        if (bereit == 1)
            fight(hero, weapon, monster);
        else {
            System.out.println("Bitte gib 1 ein, wenn du bereit bist.");
        }

    }

    public static void fight(Hero hero, Weapon weapon, Monster monster) {

    }
}
