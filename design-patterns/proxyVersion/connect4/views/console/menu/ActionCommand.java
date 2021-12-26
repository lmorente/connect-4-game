package proxyVersion.connect4.views.console.menu;


import proxyVersion.connect4.controllers.PlayController;
import proxyVersion.connect4.views.Message;
import proxyVersion.connect4.views.console.PlayerView;


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
