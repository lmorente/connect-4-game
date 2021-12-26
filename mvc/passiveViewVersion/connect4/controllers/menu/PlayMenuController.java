package passiveViewVersion.connect4.controllers.menu;

import passiveViewVersion.connect4.controllers.PlayController;

public class PlayMenuController extends MenuController {

    public PlayMenuController(PlayController playController) {
        super.addCommand(new ActionCommand(playController));
        super.addCommand(new RedoCommand(playController));
        super.addCommand(new UndoCommand(playController));
    }
}
