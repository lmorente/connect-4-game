package main.connect4.controllers;

import main.connect4.models.Game;
import main.connect4.models.Session;
import main.connect4.models.State;

public class StartController extends Controller {

    public StartController(Session session, State state) {
        super(session, state);
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
