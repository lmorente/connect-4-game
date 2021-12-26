package connect4.controllers;

import connect4.models.Session;
import connect4.views.BoardView;
import connect4.views.ViewFactory;
import utils.models.ConcreteCoordinate;
import utils.models.Coordinate;

public abstract class Controller {

    protected Session session;
    protected ViewFactory viewFactory;

    Controller(Session session, ViewFactory viewFactory) {
        this.session = session;
        this.viewFactory = viewFactory;
    }

    void writeBoard() {
        final BoardView boardView = this.viewFactory.createBoardView();
        for (int i = 0; i < Coordinate.DIMENSION_ROW; i++) {
            for (int j = 0; j < Coordinate.DIMENSION_COLUMN; j++) {
                boardView.set(this.session.getColor(new ConcreteCoordinate(i, j)));
            }
        }
        boardView.write();
    }
}
