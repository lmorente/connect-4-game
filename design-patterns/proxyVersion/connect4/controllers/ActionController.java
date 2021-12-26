package proxyVersion.connect4.controllers;

import proxyVersion.connect4.models.session.Session;
import proxyVersion.connect4.models.session.SessionImplementation;
import proxyVersion.connect4.types.Color;
import proxyVersion.connect4.types.Error;
import proxyVersion.utils.models.ConcreteCoordinate;

public class ActionController extends Controller {

    private SessionImplementation sessionImplementation;

    public ActionController(Session session) {
        super(session);
        this.sessionImplementation = (SessionImplementation) session;
    }

    public boolean isConnect4() {
        return this.sessionImplementation.isConnect4();
    }

    public void next() {
        this.sessionImplementation.next();
    }

    public Color getActiveColor() {
        return this.sessionImplementation.getActiveColor();
    }

    public void putToken(int column) {
        this.sessionImplementation.putToken(column);
    }

    public Error getPutTokenError(int column) {
        return this.sessionImplementation.getPutTokenError(column);
    }

    @Override
    public Color getColor(ConcreteCoordinate coordinate) {
        return this.session.getColor(coordinate);
    }
}
