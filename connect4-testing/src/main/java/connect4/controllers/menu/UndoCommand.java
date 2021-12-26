package connect4.controllers.menu;

import connect4.controllers.CommandController;

public class UndoCommand extends Command {

    public UndoCommand(CommandController commandController) {
        super(CommandType.UNDO.getValue(), commandController);
    }

    public void execute() {
        this.commandController.execute();
    }

    public boolean isActive() {
        return commandController.isActive();
    }
}
