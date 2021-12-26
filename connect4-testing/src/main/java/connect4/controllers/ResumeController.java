package connect4.controllers;

import connect4.models.Session;
import connect4.views.ViewFactory;

public class ResumeController extends Controller {

    public ResumeController(Session session, ViewFactory viewFactory) {
        super(session, viewFactory);
    }

    public boolean control() {
        boolean isResumed = this.viewFactory.createResumeView().read();
        if (isResumed) {
            this.session.reset();
        }
        return isResumed;
    }
}
