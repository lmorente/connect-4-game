package usantateclaProxy.usantateclaProxy.connect4.controllers;

import usantateclaProxy.usantateclaProxy.connect4.models.session.Session;

public class StartController extends Controller implements AcceptorController {

    public StartController(Session session) {
        super(session);
    }

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
