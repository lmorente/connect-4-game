package controllers.stages;

import controllers.Controller;
import controllers.ControllersVisitor;
import models.game.Game;
import models.state.State;

public class StartController extends Controller {

    public StartController(Game game, State state) {
        super(game, state);
    }

    public void startGame() {
        this.game.startGame();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
