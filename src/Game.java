import java.util.Scanner;

public class Game {

    String modus;
    Scanner scanner;


    public void startGame() throws InterruptedException {
        System.out.println("\n                  Fantasyfight 4 \n\n"
                + "Freefight-Modus (F)         Story-Modus (S) Anm. des Autors: leider noch in Arbeit:(. Die Kampftechniken, können aber auch alle im Freefight ausprobiert werden.");

        scanner = new Scanner(System.in);

        while (true) {                                                   //wieso hört die Schleife nicht auf?

            modus = scanner.next();


            if (modus.equals("F") || modus.equals("f")) {
                Freefight freefight = new Freefight();
                freefight.startFreefight();                                             //Freefight wird gestartet ->
                break;

            } else if (modus.equals("S") || modus.equals("s")) {
                Story story = new Story();
                story.startStory();                                                     //Story wird gestartet
                break;

            } else {
                System.out.println("Bitte gib 'F' für den Freefight-Modus oder 'S' für den Story-Modus ein.");
            }
        }
    }
}
