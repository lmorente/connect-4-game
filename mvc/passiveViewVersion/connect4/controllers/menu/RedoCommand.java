package passiveViewVersion.connect4.controllers.menu;

import passiveViewVersion.connect4.controllers.PlayController;

public class RedoCommand extends Command {

    public RedoCommand(PlayController playController) {
        super(CommandType.REDO.getValue(), playController);
    }

    public void execute() {
        playController.redo();
    }

    public boolean isActive() {
        return playController.isRedoable();
    }
}
