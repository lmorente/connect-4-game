package proxyVersion.connect4.controllers;

import proxyVersion.connect4.models.session.Session;

public abstract class AcceptorController extends Controller {

    AcceptorController(Session session) {
        super(session);
    }

    public abstract void accept(ControllersVisitor controllersVisitor);
}