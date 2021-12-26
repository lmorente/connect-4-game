package controllers.stages;

import controllers.Controller;
import controllers.ControllersVisitor;
import models.game.Game;
import models.state.State;

public class RestartController extends Controller {

    public RestartController(Game game, State state) {
        super(game, state);
    }

    public void reset() {
        this.game.restartGame();
        this.state.reset();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

    public void exit() {
        this.state.exit();
    }
}
