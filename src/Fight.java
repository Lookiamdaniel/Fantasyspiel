import java.util.*;
import java.util.concurrent.TimeUnit;

public class Fight {

    private int angriff;
    private int winnerAttack;
    private Hero hero;
    private Weapon weapon;
    private Monster monster;

    public Fight(Hero hero, Weapon weapon, Monster monster){
        this.hero = hero;
        this.weapon = weapon;
        this.monster = monster;
    }

    public void startFight() {

        System.out.println("So kämpfst du: \n Lege deine Finger der linken Hand auf die Tasten 'W,A,S,D' \n"
                + "und einen Finger der rechten Hand auf die Eingabe-Taste.\n"//Erklärung des Spielprinzips
                + "Das Monster wird jede Runde einen zufälligen Angriff durchführen, für den du nur eine Sekunde Zeit hast ihn abzuwehren\n\n"
                + "Wenn das Monster LINKS angreift, drücke 'A' und anschließend 'Enter'. \n"
                + "Wenn das Monster RECHTS angreift, drücke 'D' und anschließend 'Enter'. \n"
                + "Wenn das Monster OBEN angreift, drücke 'W' und anschließend 'Enter'. \n"
                + "Wenn das Monster TIEF angreift, drücke 'S' und anschließend 'Enter'. \n\n"
                + "Du kämpfst nun gegen " + monster.getName() + ". Hier musst du schnell sein, du hast nur 0." + monster.getSpeed() / 100 + " Sekunden Zeit, um zu reagieren.\n\n"
                + "Wenn du bereit bist drücke 1!");

        while (true) {
            Scanner scan = new Scanner(System.in);
            int bereit = scan.nextInt();

            if (bereit == 1) {
                System.out.println("Der Kampf startet in...");
                for (int i = 1; i <= 3; i++) {

                    System.out.println(4 - i);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                winnerAttack = 2;
                break;
            } else {
                System.out.println("Bitte gib 1 ein, wenn du bereit bist.");
            }
        } // wartet darauf, dass der Spieler die Erklärung verstanden hat und bereit ist

        while (monster.getHealthpoints() > 0 || hero.getHealthpoints() > 0){ //keine Ahnung, wieso das nicht funktoniert

            if (monster.getHealthpoints() <= 0 || hero.getHealthpoints() <= 0 ) {
                break;
            }

            //Spezialfähigkeiten der Helden werden aktiviert. (Der Barbar wird Runde für Runde wütender.)
            if (hero instanceof Healable) {
                Healable x = (Healable) hero;
                x.heal();
            }
            if (hero instanceof Anger) {
                Anger x = (Anger) hero;
                x.becomeAngry();
            }

            if (winnerAttack == 2 || winnerAttack == 4){
                monster.offense(hero, weapon);
            } else {
                hero.offense(monster);
            }

        } // hier spielt sich der eigentliche Kampf ab

        if (monster.getHealthpoints()<=0) { //Meldung, wenn der Held den Kampf gewonnen hat, anschließend ist der Freefight vorbei
            System.out.println("Jawoll, du hast das Monster besiegt und selber noch " + hero.getHealthpoints() + " Leben.");
        }
        else if (hero.getHealthpoints()<=0){ //Meldung, wenn das Monster den Kampf gewonnen hat, anschließend ist der Freefight vorbei
            System.out.println("Du hast den Kampf leider verloren und bist gestorben. Das Monster hatte noch "+monster.getHealthpoints()+" Leben.");
            Game game = new Game();
            game.startGame();
        }
    }

    public void madeDamage(){ //1,3=hero, 2,4=monster
        if (winnerAttack == 1 || winnerAttack == 3) {
            monster.setHealthpoints(hero.getAttackdamage());
            if (monster.getHealthpoints() >= 0){
                System.out.println(monster.getName()+" hat noch " + monster.getHealthpoints() + " Leben.");
                System.out.println("Du kannst nochmal angreifen!");
            }
            winnerAttack = 1;
        } else {
            hero.setHealthpoints(monster.getAttackdamage());
            if (hero.getHealthpoints() >= 0){
                System.out.println("Du hast noch " + hero.getHealthpoints() + " Leben.");
                System.out.println(monster.getName()+" greift an!");
            }
            winnerAttack = 2;
        }
    }

    public void setWinnerAttack(int winnerAttack){
        this.winnerAttack = winnerAttack;
    }

    public int getWinnerAttack(){
        return winnerAttack;
    }

    public void test (){
        System.out.println("Test");

        Scanner test = new Scanner(System.in);
        String a = test.next();
    }
}
