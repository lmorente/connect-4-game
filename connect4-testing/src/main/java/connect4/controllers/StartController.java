package connect4.controllers;

import connect4.models.Session;
import connect4.views.ViewFactory;

public class StartController extends Controller {

    public StartController(Session session, ViewFactory viewFactory) {
        super(session, viewFactory);
    }

    public void control() {
        this.viewFactory.createStartView().write();
    }
}
