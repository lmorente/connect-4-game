package usantateclaProxy.usantateclaProxy.connect4.controllers;

import usantateclaProxy.usantateclaProxy.connect4.models.session.Session;

public class ResumeController extends Controller implements AcceptorController {

    public ResumeController(Session session) {
        super(session);
    }

    public void reset() {
        this.session.reset();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
