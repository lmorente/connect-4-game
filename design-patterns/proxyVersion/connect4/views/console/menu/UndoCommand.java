package proxyVersion.connect4.views.console.menu;

import proxyVersion.connect4.controllers.PlayController;
import proxyVersion.connect4.views.Message;

public class UndoCommand extends Command {

    public UndoCommand(PlayController playController) {
        super(Message.UNDO_COMMAND.toString(), playController);
    }

    @Override
    public void execute() {
        this.playController.undo();
        super.execute();
    }

    @Override
    public boolean isActive() {
        return this.playController.isUndoable();
    }
}
