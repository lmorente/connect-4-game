package usantateclaProxy.usantateclaProxy.connect4.controllers;

import usantateclaProxy.usantateclaProxy.connect4.models.session.Session;
import usantateclaProxy.usantateclaProxy.connect4.types.Color;
import usantateclaProxy.usantateclaProxy.connect4.types.Error;

public class ActionController extends Controller {

    public ActionController(Session session) {
        super(session);
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
}
