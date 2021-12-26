package connect4.controllers.menu;

import connect4.controllers.CommandController;

public abstract class Command {
    private String name;
    protected CommandController commandController;

    public Command(String name, CommandController commandController) {
        this.name = name;
        this.commandController = commandController;
    }

    public String getName() {
        return this.name;
    }

    public abstract void execute();

    public abstract boolean isActive();
}
