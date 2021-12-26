package proxyVersion.connect4.controllers;

import proxyVersion.connect4.models.StateValue;
import proxyVersion.connect4.models.session.Session;
import proxyVersion.connect4.types.Color;
import proxyVersion.utils.models.ConcreteCoordinate;

public abstract class Controller {

    protected Session session;

    Controller(Session session) {
        this.session = session;
    }

    public StateValue getValueState() {
        return this.session.getValueState();
    }

    public Color getColor(ConcreteCoordinate coordinate){
        return session.getColor(coordinate);
    }
}
