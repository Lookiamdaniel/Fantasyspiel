import java.util.Scanner;

public class Story {

    public void startStory () {



        Game game = new Game();
        try {
            game.startGame();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
