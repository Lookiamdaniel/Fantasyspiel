import java.util.Scanner;

public class Story {
    private Fight fight;
    private Weapon weapon;
    private Hero hero;
    private Monster monster;


    public void startStory () {

        Freefight freefight = new Freefight();

        System.out.println("Kawumm."
                        +"\nUnter dir fühlt sich alles sehr weich an. Du liegst auf einer Wiese oder so. Du spürst das leichte Streicheln vom Wind."
                        +"\nAber wo bist du? Die Vögel hier hören sich anders an als daheim. Du öffnest die Augen, nein du probierst die Augen zu öffnen, "
                        +"\naber es geht nicht. Du bekommst einen Schreck. Heißt das ich kann nicht mehr sehen?"
                        +"\nDas ist richtig und deswegen bin ich da, als Stimme in deinem Kopf. Ich bin dein Geist und deine Augen für die Außenwelt."
                        +"\nDu bist nun auf der Lichtung des Waldes und wirst dich nach draußen kämpfen müssen. Welcher Wald das ist, dass weiß niemand so richtig "
                        +"\nund warum du hier bist ebenfalls, aber ich kann dir helfen dem zu entfliehen."
                        +"\nDies hier ist kein normaler Wald. Es ist ein Wald voller Helden und Monster. Du bist ein Held und wirst dich an den Monstern "
                        +"\nvorbei in die Freiheit kämpfen müssen."
                        +"\nWie heißt du?");

        Scanner scan = new Scanner(System.in);
        String hName = scan.nextLine();

        System.out.println("Ah hallo " + hName
                        +"\n"
                        +"\nWarte."
                        +"\nHörst du das? Das Rascheln dort. Oh je ich konnte dir noch nicht einmal alles erklären und schon musst du gegen dein erstes Monster kämpfen."
                        +"\nEgal, du siehtst stark aus, ich denke, du kannst es besiegen. Ich glaube, es ist der Lindwurm Lodan."
                        +"\nLos gehts, du schaffst das!");

        weapon = new Weapon("Hände", 1, 1, 1);
        hero = new Hero(hName, 30, 1, 5, weapon, fight);
        monster = new Monster("Lodan", 55, 1, 13, 4, 900, fight);
        monster.createLodan(monster);
        System.out.println(monster.getName()+" ");
        fight = new Fight(hero, weapon, monster);
        hero.setFight(fight);
        monster.setFight(fight);

        fight.startFight();

        System.out.println("Respekt, dass war eine starke Leistung. Es wird höchste Zeit, dass du dir eine Waffe aussuchst. "
                        +"\nWähle waise.");

        freefight.createWeapon();
        hero.setWeapon(weapon);

        System.out.println("Eine gute Wahl, wenn ich das anmerken darf. Komm wir laufen ein Stück."
                        +"\n"
                        +"\n"
                        +"\n"
                        +"\nDu siehst ihn schon auf Entfernung. Der Ork Ohnekompromiss ist dein nächster Gegner. Der sollte kein Problem für dich sein");

        monster = new Monster("Ohnekompromiss", 50, 0.9, 10, 2, 700, fight);
        fight = new Fight(hero, weapon, monster);
        fight.startFight();

        System.out.println("Erneut ein starker Kampf. Komm wir laufen ein Stück. Das Kloster auf dem Hügel ist unser Ziel."
                        +"\nDort wirst du zum richtigen Kämpfer ausgebildet. Du wirst dir aussuchen dürfen, ob du Zauberer, Barbar oder Elb sein willst.\n\n" );

        freefight.createHero();

        System.out.println("Na so lässt man sich doch gerne sehen. Mit deinen neuen Fähigkeiten sollte unser nächster Gegner kein Problem sein."
                        +"\nEs ist die Medusa. Dort drüben an der Brücke terrorisiert sie die Waldbewohner. Wir müssen an Medusa vorbei und über die Brücke, um aus dem Wald zu gelangen.");

        monster = new Monster("Medusa", 45, 1.5, 7, 1, 300, fight);
        fight = new Fight(hero, weapon, monster);
        fight.startFight();

        System.out.println("Stark gekämpft mein Freund. Ich kann die Freiheit spüren. Komm wir müssen vor Ende der Nacht am Rande des Waldes angekommen sein."
                        +"\nAnonsten erwacht der Drache Dystopius und dem wollen wir uns nicht stellen, außer du hast einen Bogen."
                        +"\n\n\n Oh je. Wir sind zu spät angekommen. Dystopius dreht schon seine Kreise und tötet jeden, der den Wald verlassen will."
                        +"\n\nEr hat uns gesehen und greift an. Du bist der beste Kämpfer des Waldes. Du kannst ihn besiegen.");

        monster = new Monster("Dystopius", 60, 1.2, 11, 8, 600, fight);
        fight = new Fight(hero, weapon, monster);
        fight.startFight();

        System.out.println("Hey du hast es geschafft. Das gibt es nicht. Du bist der Erste. Aber eigentlich müsstest du jetzt in deine Welt zurückgezogen werden."
                        +"\nWieso passiert nichts? Was ist hier los? Hier stimmt irgendwas nicht. Siehst du, wie sich die Welt um uns herum verändert."
                        +"\nOh nein. Nein, nein, nein. Ich kenne diesen Geruch. Das kann nicht sein. Er müsste eigentlich längst tot sein.");

        System.out.println("\n\n\n\n\n\n        Wenn du wissen willst, wie es weitergeht, melde dich bei Daniel Schreiber und erwerbe für ein kleines Endgeld die Premium Version von 'Fast Fantasy'!");

        Game game = new Game();
        game.startGame();

    }
}
