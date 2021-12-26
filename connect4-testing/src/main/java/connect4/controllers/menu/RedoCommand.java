package connect4.controllers.menu;

import connect4.controllers.CommandController;

public class RedoCommand extends Command {

    public RedoCommand(CommandController commandController) {
        super(CommandType.REDO.getValue(), commandController);
    }

    public void execute() {
        commandController.execute();
    }

    public boolean isActive() {
        return commandController.isActive();
    }
}
