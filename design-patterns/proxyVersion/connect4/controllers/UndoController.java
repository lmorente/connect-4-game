package proxyVersion.connect4.controllers;

import proxyVersion.connect4.models.session.Session;
import proxyVersion.connect4.models.session.SessionImplementation;

public class UndoController extends Controller {

    private SessionImplementation sessionImplementation;

    public UndoController(Session session) {
        super(session);
        this.sessionImplementation = (SessionImplementation) session;
    }

    public void undo() {
        this.sessionImplementation.undo();
    }

    public boolean isUndoable() {
        return this.sessionImplementation.isUndoable();
    }
}
