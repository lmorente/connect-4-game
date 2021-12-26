package connect4.controllers;

import connect4.models.Session;
import connect4.views.ViewFactory;

public abstract class CommandController extends Controller{
    public CommandController(Session session, ViewFactory viewFactory){
        super(session, viewFactory);
    }
    public abstract void execute();
    public abstract boolean isActive();
}
