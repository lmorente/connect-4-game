package passiveViewVersion.connect4.controllers;

import passiveViewVersion.connect4.models.Session;
import passiveViewVersion.connect4.views.BoardView;
import passiveViewVersion.connect4.views.ViewFactory;
import passiveViewVersion.utils.models.ConcreteCoordinate;
import passiveViewVersion.utils.models.Coordinate;

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
