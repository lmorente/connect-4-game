package proxyVersion.connect4.controllers;

import proxyVersion.connect4.models.session.Session;
import proxyVersion.connect4.models.session.SessionImplementation;

public class RedoController extends Controller {

    private SessionImplementation sessionImplementation;

    public RedoController(Session session) {
        super(session);
        this.sessionImplementation = ((SessionImplementation) this.session);
    }

    public void redo() {
        this.sessionImplementation.redo();
    }

    public boolean isRedoable() {
        return this.sessionImplementation.isRedoable();
    }
}
