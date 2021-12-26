package passiveViewVersion.connect4.controllers;

import passiveViewVersion.connect4.models.Session;
import passiveViewVersion.connect4.views.ViewFactory;

public class ActionController extends Controller {

    public ActionController(Session session, ViewFactory viewFactory) {
        super(session, viewFactory);
    }

    public void play() {
        this.session.putToken(this.getColumn());
    }

    private int getColumn() {
        return this.viewFactory.createCoordinateView().readColumn();
    }

    public boolean isConnect4() {
        return this.session.isConnect4();
    }
}
