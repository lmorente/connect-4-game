package proxyVersion.connect4.controllers;

import proxyVersion.connect4.models.session.Session;

public abstract class ResumeController extends  AcceptorController {

    public ResumeController(Session session) {
        super(session);
    }

    public abstract void resume(boolean isResume);

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
