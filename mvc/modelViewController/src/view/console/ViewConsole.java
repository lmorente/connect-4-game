package view.console;

import controllers.stages.EndController;
import controllers.stages.PlayController;
import controllers.stages.RestartController;
import controllers.stages.StartController;
import view.View;
import view.console.stages.EndView;
import view.console.stages.PlayView;
import view.console.stages.RestartView;
import view.console.stages.StartView;

public class ViewConsole implements View {

    private final StartView startView;
    private final PlayView playView;
    private final EndView endView;
    private final RestartView restartView;

    public ViewConsole() {
        this.startView = new StartView();
        this.playView = new PlayView();
        this.endView = new EndView();
        this.restartView = new RestartView();
    }

    @Override
    public void visit(StartController startController) {
        this.startView.interact(startController);
    }

    @Override
    public void visit(PlayController playController) {
        this.playView.interact(playController);
    }

    @Override
    public void visit(EndController endController) {
        this.endView.interact(endController);
    }

    @Override
    public void visit(RestartController restartController) {
        this.restartView.interact(restartController);
    }
}
