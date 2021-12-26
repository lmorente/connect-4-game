package connect4.views.console;

import connect4.types.Color;
import connect4.views.Message;
import connect4.views.PlayerView;

class ConcretePlayerView implements PlayerView {

    @Override
    public void writeWinner(Color color) {
        new MessageView().writeln(Message.PLAYER_WIN, color.name());
    }
    
}
