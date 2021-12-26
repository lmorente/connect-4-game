package proxyVersion.connect4.views.console;

import proxyVersion.connect4.controllers.StartController;
import proxyVersion.connect4.views.Message;
import proxyVersion.utils.WithConsoleView;

class StartView extends WithConsoleView {

    void interact(StartController startController) {
        startController.start();
        new MessageView().writeln(Message.TITLE);
    }
}
