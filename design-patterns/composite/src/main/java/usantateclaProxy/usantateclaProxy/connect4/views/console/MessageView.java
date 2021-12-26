package usantateclaProxy.usantateclaProxy.connect4.views.console;

import usantateclaProxy.usantateclaProxy.connect4.views.Message;
import usantateclaProxy.usantateclaProxy.utils.views.Console;

class MessageView {

    void write(Message message) {
        Console.getInstance().write(message.toString());
    }

    void writeln(Message message) {
        Console.getInstance().writeln(message.toString());
    }

    void writeln(Message message, String player) {
        assert message == Message.PLAYER_WIN;

        Console.getInstance().writeln(message.toString().replaceAll("#player", "" + player));
    }
    
}
