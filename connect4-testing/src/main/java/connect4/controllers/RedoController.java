package connect4.controllers;

import connect4.models.Session;
import connect4.views.ViewFactory;

public class RedoController extends CommandController {

    public RedoController(Session session, ViewFactory viewFactory) {
        super(session, viewFactory);
    }

    public void execute() {
        this.session.redo();
    }

    public boolean isActive() {
        return this.session.isRedoable();
    }
}
