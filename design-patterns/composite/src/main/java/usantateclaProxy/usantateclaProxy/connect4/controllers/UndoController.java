package usantateclaProxy.usantateclaProxy.connect4.controllers;

import usantateclaProxy.usantateclaProxy.connect4.models.session.Session;

public class UndoController extends Controller {

    public UndoController(Session session) {
        super(session);
    }

    public void undo() {
        this.session.undo();
    }

    public boolean isUndoable() {
        return this.session.isUndoable();
    }
}
