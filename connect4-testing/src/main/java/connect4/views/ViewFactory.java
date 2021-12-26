package connect4.views;

public abstract class ViewFactory {

    public abstract BoardView createBoardView();
    public abstract CoordinateView createCoordinateView();
    public abstract ResumeView createResumeView();
    public abstract StartView createStartView();
    public abstract ErrorView createErrorView();
    public abstract MenuView createMenuView();
}
