package view.console.stages;

import controllers.stages.RestartController;
import view.common.AffirmativeNegative;
import view.console.printer.Message;
import view.console.reader.Reader;

public class RestartView {

    public void interact(RestartController restartController) {
        Message.RESTART_GAME.print();

        final String response = Reader.read();
        if (AffirmativeNegative.checkAffirmative(response)) {
            restartController.reset();
        } else {
            restartController.exit();
        }
    }
}
