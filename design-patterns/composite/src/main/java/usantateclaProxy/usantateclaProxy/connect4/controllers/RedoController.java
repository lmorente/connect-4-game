package usantateclaProxy.usantateclaProxy.connect4.controllers;

import usantateclaProxy.usantateclaProxy.connect4.models.session.Session;

public class RedoController extends Controller {

    public RedoController(Session session) {
        super(session);
    }

    public boolean isReoable() {
        return this.session.isUndoable();
    }

    public void redo() {
        this.session.redo();
    }

    public boolean isRedoable() {
        return this.session.isRedoable();
    }
}
