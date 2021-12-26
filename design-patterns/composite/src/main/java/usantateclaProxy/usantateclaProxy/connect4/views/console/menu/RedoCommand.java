package usantateclaProxy.usantateclaProxy.connect4.views.console.menu;

import usantateclaProxy.usantateclaProxy.connect4.controllers.PlayController;
import usantateclaProxy.usantateclaProxy.connect4.views.Message;

public class RedoCommand extends Command {

    public RedoCommand(PlayController playController) {
        super(Message.REDO_COMMAND.toString(), playController);
    }

    @Override
    public void execute() {
        this.playController.redo();
        super.execute();
    }

    @Override
    public boolean isActive() {
        return this.playController.isRedoable();
    }
}
