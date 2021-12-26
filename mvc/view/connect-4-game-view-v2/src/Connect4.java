import game.Game;
import view.View;

public class Connect4 {

    private final Game game;
    private final View view;

    public Connect4() {
        this.game = new Game();
        this.view = new View(this.game);
    }

    private void play() {
        this.view.initGame();

        do {
            this.view.play();
        } while (this.view.isInProgress());

        this.view.endGame();
    }

    public static void main(String[] args) {
        new Connect4().play();
    }
}
