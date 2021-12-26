package designpatterns.connect4.views.console.menu;

import designpatterns.connect4.controllers.PlayController;
import designpatterns.connect4.views.console.BoardView;

public abstract class Command extends designpatterns.utils.models.Command {

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
