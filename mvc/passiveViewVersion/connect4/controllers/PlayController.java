package passiveViewVersion.connect4.controllers;

import passiveViewVersion.connect4.controllers.menu.MenuController;
import passiveViewVersion.connect4.controllers.menu.PlayMenuController;
import passiveViewVersion.connect4.models.Session;
import passiveViewVersion.connect4.views.ViewFactory;

public class PlayController extends Controller {

    private ActionController actionController;
    private UndoController undoController;
    private RedoController redoController;

    public PlayController(Session session, ViewFactory viewFactory) {
        super(session, viewFactory);
        this.actionController = new ActionController(session, viewFactory);
        this.undoController = new UndoController(session, viewFactory);
        this.redoController = new RedoController(session, viewFactory);
    }

    public void control() {
        MenuController menu = new PlayMenuController(this);
        do {
            this.writeBoard();
            menu.displayMenu(this.viewFactory.createMenuView());
            this.session.next();
        } while (!this.session.isConnect4());
    }

    public void actuate() {
        this.actionController.play();
    }

    public boolean isConnect4() {
        return this.actionController.isConnect4();
    }

    public void undo() {
        this.undoController.undo();
    }

    public void redo() {
        this.redoController.redo();
    }

    public boolean isUndoable() {
        return undoController.isUndoable();
    }

    public boolean isRedoable() {
        return redoController.isRedoable();
    }
}
