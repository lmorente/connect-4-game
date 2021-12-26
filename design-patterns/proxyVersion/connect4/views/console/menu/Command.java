package proxyVersion.connect4.views.console.menu;

import proxyVersion.connect4.controllers.PlayController;
import proxyVersion.connect4.views.console.BoardView;

public abstract class Command extends proxyVersion.utils.models.Command {

    protected PlayController playController;

    protected Command(String title, PlayController playController) {
        super(title);
        this.playController = playController;
    }

    @Override
    public void execute() {
        new BoardView().write(this.playController);
    }
}
