package main.connect4.controllers;

import main.connect4.models.Session;
import main.connect4.models.State;
import main.connect4.types.Color;
import main.connect4.types.Error;

public class PlayController extends Controller {

    public PlayController(Session session, State state) {
        super(session, state);
    }

    public boolean isConnect4() {
        return this.session.isConnect4();
    }

    public void next() {
        this.session.next();
    }

    public Color getActiveColor() {
        return this.session.getActiveColor();
    }

    public void putToken(int column) {
        this.session.putToken(column);
    }

    public Error getPutTokenError(int column) {
        return this.session.getPutTokenError(column);
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
