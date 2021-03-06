package proxyVersion.connect4.views.console;

import proxyVersion.connect4.controllers.AcceptorController;
import proxyVersion.connect4.controllers.PlayController;
import proxyVersion.connect4.controllers.ResumeController;
import proxyVersion.connect4.controllers.StartController;
import proxyVersion.connect4.views.View;

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

    public void visit(ResumeController resumeController) {
        this.resumeView.interact(resumeController);
    }

    @Override
    public void interact(AcceptorController acceptorController) {
        acceptorController.accept(this);
    }
}
