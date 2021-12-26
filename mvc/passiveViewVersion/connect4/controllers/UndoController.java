package passiveViewVersion.connect4.controllers;

import passiveViewVersion.connect4.models.Session;
import passiveViewVersion.connect4.views.ViewFactory;

public class UndoController extends Controller {

    public UndoController(Session session, ViewFactory viewFactory) {
        super(session, viewFactory);
    }

    public void undo() {
        this.session.undo();
    }

    public boolean isUndoable() {
        return this.session.isUndoable();
    }
}
