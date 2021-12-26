package passiveViewVersion.connect4.controllers;

import passiveViewVersion.connect4.models.Session;
import passiveViewVersion.connect4.views.ViewFactory;

public class RedoController extends Controller {

    public RedoController(Session session, ViewFactory viewFactory) {
        super(session, viewFactory);
    }

    public void redo() {
        this.session.redo();
    }

    public boolean isRedoable() {
        return this.session.isRedoable();
    }
}
