package usantateclaProxy.usantateclaProxy.connect4.controllers;

import usantateclaProxy.usantateclaProxy.connect4.models.session.Session;
import usantateclaProxy.usantateclaProxy.connect4.types.Color;
import usantateclaProxy.usantateclaProxy.utils.models.ConcreteCoordinate;

public abstract class Controller {

    protected Session session;

    public Controller(Session session) {
        this.session = session;
    }

    public void nextState() {
        this.session.nextState();
    }

    public Color getColor(ConcreteCoordinate coordinate) {
        return this.session.getColor(coordinate);
    }

}
