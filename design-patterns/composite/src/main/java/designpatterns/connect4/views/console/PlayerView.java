package designpatterns.connect4.views.console;

import designpatterns.connect4.controllers.PlayController;
import designpatterns.connect4.types.Error;
import designpatterns.connect4.views.Message;
import designpatterns.utils.views.BoundedIntDialog;

public class PlayerView {

    private PlayController playController;

    public PlayerView(PlayController playController) {
        this.playController = playController;
    }

    public void interact() {
        int column;
        Error error;
        do {
            column = new BoundedIntDialog(1,7).read(Message.ENTER_COLUMN_TO_PUT.toString());
            error = this.getPutTokenError(column);
        } while (!error.isNull());
        this.playController.putToken(column);
    }

    private Error getPutTokenError(int column) {
        assert 0 < column && column < 7;

        Error error = this.playController.getPutTokenError(column);
        new ErrorView().writeln(error);
        return error;
    }
    
}
