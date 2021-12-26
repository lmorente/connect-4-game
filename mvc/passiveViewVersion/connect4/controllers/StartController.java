package passiveViewVersion.connect4.controllers;

import passiveViewVersion.connect4.models.Session;
import passiveViewVersion.connect4.views.ViewFactory;

public class StartController extends Controller {

    public StartController(Session session, ViewFactory viewFactory) {
        super(session, viewFactory);
    }

    public void control() {
        this.viewFactory.createStartView().write();
        this.writeBoard();
    }
}
