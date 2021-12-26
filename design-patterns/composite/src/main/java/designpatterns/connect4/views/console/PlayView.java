package designpatterns.connect4.views.console;

import designpatterns.connect4.controllers.PlayController;
import designpatterns.connect4.views.Message;
import designpatterns.connect4.views.console.menu.PlayMenu;

class PlayView {

    void interact(PlayController playController) {
        do {
            new PlayMenu(playController).execute();
        } while (!playController.isConnect4());
        new MessageView().writeln(Message.PLAYER_WIN, playController.getActiveColor().name());
        playController.nextState();
    }

}
