package connect4.controllers.menu;


import connect4.controllers.CommandController;

public class ActionCommand extends Command {
    public ActionCommand(CommandController commandController) {
        super(CommandType.PLAY.getValue(), commandController);
    }

    public void execute() {
        this.commandController.execute();
    }

    public boolean isActive() {
        return this.commandController.isActive();
    }
}
