package main.connect4.views.console;

import main.connect4.controllers.StartController;
import main.connect4.views.Message;

class StartView{

    void interact(StartController startController) {
        new MessageView().writeln(Message.TITLE);
        new BoardView().write(startController);
        startController.nextState();
    }

}
