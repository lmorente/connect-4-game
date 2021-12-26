package usantateclaProxy.usantateclaProxy.connect4.views.console.menu;

import usantateclaProxy.usantateclaProxy.connect4.controllers.PlayController;
import usantateclaProxy.usantateclaProxy.connect4.views.console.BoardView;

public abstract class Command extends usantateclaProxy.usantateclaProxy.utils.models.Command {

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
