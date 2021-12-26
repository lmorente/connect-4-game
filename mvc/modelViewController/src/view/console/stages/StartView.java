package view.console.stages;

import controllers.stages.StartController;
import view.console.printer.Message;


public class StartView {

    public void interact(StartController startController) {
        Message.START_GAME.print();
        startController.startGame();
        startController.nextState();
    }
}
