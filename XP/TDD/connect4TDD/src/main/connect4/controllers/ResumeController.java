package main.connect4.controllers;

import main.connect4.models.Session;
import main.connect4.models.State;

public class ResumeController extends Controller {

    public ResumeController(Session session, State state) {
        super(session, state);
    }

    public void reset() {
        this.session.reset();
        this.state.reset();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
