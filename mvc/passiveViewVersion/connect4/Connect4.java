package passiveViewVersion.connect4;

import passiveViewVersion.connect4.controllers.PlayController;
import passiveViewVersion.connect4.controllers.ResumeController;
import passiveViewVersion.connect4.controllers.StartController;
import passiveViewVersion.connect4.models.Session;
import passiveViewVersion.connect4.views.ViewFactory;

abstract class Connect4 {

    private Session session;
    private ViewFactory viewFactory;
    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;

    protected Connect4() {
        this.session = new Session();
        this.viewFactory = this.createViewFactory();
        this.startController = new StartController(this.session, this.viewFactory);
        this.playController = new PlayController(this.session, this.viewFactory);
        this.resumeController = new ResumeController(this.session, this.viewFactory);
    }

    protected abstract ViewFactory createViewFactory();

    protected void play() {
        do {
            this.startController.control();
            this.playController.control();       
        } while (this.resumeController.control());
    }
}
