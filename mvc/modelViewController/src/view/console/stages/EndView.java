package view.console.stages;

import controllers.stages.EndController;
import view.console.ViewBoard;
import view.console.printer.Message;

public class EndView {

    public void interact(EndController endController) {
        ViewBoard.print(endController);

        Message.END_GAME.print();
        Message.HEADER_SEPARATOR.print();
        Message.RESULT_GAME.print(endController.getGoal());

        if (endController.isWinner()) {
            Message.RESULT_WINNER.print(endController.getActivePlayer());
        }

        endController.nextState();
    }
}
