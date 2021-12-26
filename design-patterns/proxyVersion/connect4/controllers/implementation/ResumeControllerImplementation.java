package proxyVersion.connect4.controllers.implementation;

import proxyVersion.connect4.models.session.Session;
import proxyVersion.connect4.models.session.SessionImplementation;
import proxyVersion.connect4.controllers.ResumeController;

public class ResumeControllerImplementation extends ResumeController {
    private SessionImplementation sessionImplementation;

    public ResumeControllerImplementation(Session session){
        super(session);
        this.sessionImplementation = (SessionImplementation) session;
    }

    public void resume(boolean isResume){
        if(isResume){
            this.sessionImplementation.reset();
        }
        else{
            this.sessionImplementation.nextState();
        }
    }
}
