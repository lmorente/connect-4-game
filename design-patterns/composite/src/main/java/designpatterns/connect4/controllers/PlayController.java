package designpatterns.connect4.controllers;

import designpatterns.connect4.models.session.Session;
import designpatterns.connect4.types.Color;
import designpatterns.connect4.types.Error;

public class PlayController extends Controller implements AcceptorController {

    private ActionController actionController;
    private UndoController undoController;
    private RedoController redoController;

    public PlayController(Session session) {
        super(session);
        this.actionController = new ActionController(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);
    }

    public void undo() {
        this.undoController.undo();
    }

    public boolean isUndoable() {
        return this.undoController.isUndoable();
    }

    public void redo() {
        this.redoController.redo();
    }

    public boolean isRedoable() {
        return this.redoController.isRedoable();
    }


    public boolean isConnect4() {
        return this.actionController.isConnect4();
    }

    public void next() {
        this.actionController.next();
    }

    public Color getActiveColor() {
        return this.actionController.getActiveColor();
    }

    public void putToken(int column) {
        this.actionController.putToken(column);
    }

    public Error getPutTokenError(int column) {
        return this.actionController.getPutTokenError(column);
    }

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
