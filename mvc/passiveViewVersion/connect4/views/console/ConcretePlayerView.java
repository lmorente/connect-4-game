package passiveViewVersion.connect4.views.console;

import passiveViewVersion.connect4.types.Color;
import passiveViewVersion.connect4.views.Message;
import passiveViewVersion.connect4.views.PlayerView;

class ConcretePlayerView implements PlayerView {

    @Override
    public void writeWinner(Color color) {
        new MessageView().writeln(Message.PLAYER_WIN, color.name());
    }
    
}
