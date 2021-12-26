package passiveViewVersion.connect4.controllers.menu;

import passiveViewVersion.connect4.controllers.PlayController;

public class UndoCommand extends Command {

    public UndoCommand(PlayController playController) {
        super(CommandType.UNDO.getValue(), playController);
    }

    public void execute() {
        this.playController.undo();
    }

    public boolean isActive() {
        return playController.isUndoable();
    }
}
