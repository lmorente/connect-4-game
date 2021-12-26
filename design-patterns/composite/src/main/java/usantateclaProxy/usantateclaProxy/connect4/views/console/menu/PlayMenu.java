package usantateclaProxy.usantateclaProxy.connect4.views.console.menu;

import usantateclaProxy.usantateclaProxy.connect4.controllers.PlayController;


public class PlayMenu extends Menu {

    public PlayMenu(PlayController playController) {
        this.addCommand(new ActionCommand(playController));
        this.addCommand(new UndoCommand(playController));
        this.addCommand(new RedoCommand(playController));
    }
}
