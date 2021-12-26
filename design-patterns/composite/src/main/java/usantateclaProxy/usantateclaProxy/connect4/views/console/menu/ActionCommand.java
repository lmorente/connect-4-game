package usantateclaProxy.usantateclaProxy.connect4.views.console.menu;

import usantateclaProxy.usantateclaProxy.connect4.controllers.PlayController;
import usantateclaProxy.usantateclaProxy.connect4.views.Message;
import usantateclaProxy.usantateclaProxy.connect4.views.console.PlayerView;

public class ActionCommand extends Command {

    public ActionCommand(PlayController playController) {
        super(Message.ACTION_COMMAND.toString(), playController);
    }

    @Override
    public void execute() {
        new PlayerView(this.playController).interact();
        this.playController.next();
        super.execute();
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
