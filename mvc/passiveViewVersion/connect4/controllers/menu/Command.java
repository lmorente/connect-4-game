package passiveViewVersion.connect4.controllers.menu;

import passiveViewVersion.connect4.controllers.PlayController;

public abstract class Command {
    private String name;
    protected PlayController playController;

    public Command(String name, PlayController playController) {
        this.name = name;
        this.playController = playController;
    }

    public String getName() {
        return this.name;
    }

    public abstract void execute();

    public abstract boolean isActive();
}
