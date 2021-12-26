package connect4.views.console;

import connect4.views.Message;
import connect4.views.StartView;

class ConcreteStartView implements StartView {

    @Override
    public void write() {
        new MessageView().writeln(Message.TITLE);
    }
}
