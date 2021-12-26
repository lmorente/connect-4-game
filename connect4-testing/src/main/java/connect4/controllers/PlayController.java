package connect4.controllers;

import connect4.controllers.menu.*;
import connect4.models.Session;
import connect4.views.ViewFactory;

import java.util.HashMap;

public class PlayController extends Controller {

    private MenuController menu;

    public PlayController(Session session, ViewFactory viewFactory) {
        super(session, viewFactory);
        this.menu = new MenuController();
        this.menu.addCommand(new ActionCommand(new ActionController(session, viewFactory)));
        this.menu.addCommand(new RedoCommand(new RedoController(session, viewFactory)));
        this.menu.addCommand(new UndoCommand(new UndoController(session, viewFactory)));
    }

    public void control() {
        do {
            this.writeBoard();
            this.menu.displayMenu(this.viewFactory.createMenuView());
            this.session.next();
        } while (!this.session.isConnect4());
    }
}
