package main.connect4.views.console;

import main.connect4.controllers.PlayController;
import main.connect4.controllers.ResumeController;
import main.connect4.controllers.StartController;
import main.connect4.views.View;

public class ConsoleView implements View {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public ConsoleView() {
        this.startView = new StartView();
        this.playView = new PlayView();
        this.resumeView = new ResumeView();
    }

    public void visit(StartController startController) {
        this.startView.interact(startController);
    }

    public void visit(PlayController playController) {
        this.playView.interact(playController);
    }

    public boolean visit(ResumeController resumeController) {
        return this.resumeView.interact(resumeController);
    }

}
