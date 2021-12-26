package proxyVersion.connect4.controllers;

import proxyVersion.connect4.models.session.Session;
import proxyVersion.connect4.types.Error;

public abstract class PlayController extends AcceptorController {

    public PlayController(Session session) {
        super(session);
    }

    public abstract void undo();

    public abstract boolean isUndoable();

    public abstract void redo();

    public abstract boolean isRedoable();

    public abstract boolean isConnect4();

    public abstract void next();

    public abstract void putToken(int column);

    public abstract Error getPutTokenError(int column);

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
