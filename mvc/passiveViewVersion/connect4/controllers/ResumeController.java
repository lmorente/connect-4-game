package passiveViewVersion.connect4.controllers;

import passiveViewVersion.connect4.models.Session;
import passiveViewVersion.connect4.views.ViewFactory;

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
