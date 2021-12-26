package designpatterns.connect4.controllers;

import designpatterns.connect4.models.session.Session;
import designpatterns.connect4.types.Color;
import designpatterns.utils.models.ConcreteCoordinate;

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
