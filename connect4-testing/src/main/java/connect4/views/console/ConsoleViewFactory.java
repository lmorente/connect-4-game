package connect4.views.console;

import connect4.views.BoardView;
import connect4.views.CoordinateView;
import connect4.views.ErrorView;
import connect4.views.MenuView;
import connect4.views.ResumeView;
import connect4.views.StartView;
import connect4.views.ViewFactory;

public class ConsoleViewFactory extends ViewFactory {

    public BoardView createBoardView() {
        return new ConcreteBoardView();
    }

    public CoordinateView createCoordinateView() {
        return new ConcreteCoordinateView();
    }

    public ResumeView createResumeView() {
        return new ConcreteResumeView();
    }

    public StartView createStartView() {
        return new ConcreteStartView();
    }

    public ErrorView createErrorView() {
        return new ConcreteErrorView();
    }

    public MenuView createMenuView(){
        return new ConcreteMenuView();
    }
}
