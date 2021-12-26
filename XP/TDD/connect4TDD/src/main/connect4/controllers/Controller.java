package main.connect4.controllers;

import main.connect4.models.Game;
import main.connect4.models.Session;
import main.connect4.models.State;
import main.connect4.types.Color;
import main.utils.models.ConcreteCoordinate;

public abstract class Controller {

    protected Session session;
    protected State state;

    Controller(Session session, State state) {
        this.session = session;
        this.state = state;
    }

    public void nextState() {
        this.state.next();
    }

    public Color getColor(ConcreteCoordinate coordinate) {
        return this.session.getColor(coordinate);
    }

    public abstract void accept(ControllersVisitor controllersVisitor);

}
