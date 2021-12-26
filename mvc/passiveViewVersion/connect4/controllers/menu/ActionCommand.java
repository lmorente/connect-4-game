package passiveViewVersion.connect4.controllers.menu;


import passiveViewVersion.connect4.controllers.PlayController;

public class ActionCommand extends Command {
    public ActionCommand(PlayController playController) {
        super(CommandType.PLAY.getValue(), playController);
    }

    public void execute() {
        this.playController.actuate();
    }

    public boolean isActive() {
        return true;
    }
}
