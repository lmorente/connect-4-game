import controllers.Controller;
import controllers.GameController;
import view.console.ViewConsole;

import java.util.Objects;

public class Connect4 {

    private final ViewConsole view;
    private final GameController gameController;

    public Connect4() {
        this.view = new ViewConsole();
        this.gameController = new GameController();
    }

    private void play() {
        Controller controller;
        do {
            controller = gameController.getController();

            if(Objects.nonNull(controller)){
                controller.accept(view);
            }
        } while (Objects.nonNull(controller));
    }

    public static void main(String[] args) {
        new Connect4().play();
    }
}
