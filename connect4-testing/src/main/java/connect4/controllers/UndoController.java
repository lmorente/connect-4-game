package connect4.controllers;

import connect4.models.Session;
import connect4.views.ViewFactory;

public class UndoController extends CommandController {

    public UndoController(Session session, ViewFactory viewFactory) {
        super(session, viewFactory);
    }

    public void execute() {
        this.session.undo();
    }

    public boolean isActive() {
        return this.session.isUndoable();
    }
}
