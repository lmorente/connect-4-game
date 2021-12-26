package connect4.controllers;

import connect4.models.Session;
import connect4.views.ViewFactory;

public class ActionController extends CommandController {

    public ActionController(Session session, ViewFactory viewFactory) {
        super(session, viewFactory);
    }

    public void execute() {
        this.session.putToken(this.getColumn());
        this.session.register();
    }

    public boolean isActive(){
        return true;
    }

    private int getColumn() {
        return this.viewFactory.createCoordinateView().readColumn();
    }

}
