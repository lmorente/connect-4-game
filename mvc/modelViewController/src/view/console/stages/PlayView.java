package view.console.stages;

import controllers.stages.PlayController;
import view.console.ViewBoard;
import view.console.printer.Message;
import view.console.reader.Reader;


public class PlayView {

    public void interact(PlayController playController) {

        do {
            Message.PLAYER_TURN.print(playController.getActivePlayer());
            ViewBoard.print(playController);
            Message.CHOOSE_COLUMN.print();
            String input = Reader.read();

            while (!playController.isValidTurn(input)) {
                Message.INPUT_ERROR.print();
                input = Reader.read();
            }

            playController.playTurn(input);

        } while (playController.isInProgress());

        playController.nextState();
    }
}
