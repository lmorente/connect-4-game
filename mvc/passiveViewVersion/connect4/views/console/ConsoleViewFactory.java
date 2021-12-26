package passiveViewVersion.connect4.views.console;

import passiveViewVersion.connect4.views.BoardView;
import passiveViewVersion.connect4.views.CoordinateView;
import passiveViewVersion.connect4.views.ErrorView;
import passiveViewVersion.connect4.views.MenuView;
import passiveViewVersion.connect4.views.ResumeView;
import passiveViewVersion.connect4.views.StartView;
import passiveViewVersion.connect4.views.ViewFactory;

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
