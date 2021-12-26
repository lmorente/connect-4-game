package controllers.stages;

import controllers.Controller;
import controllers.ControllersVisitor;
import models.game.Game;
import models.state.State;

public class EndController extends Controller {

    public EndController(Game game, State state) {
        super(game, state);
    }

    public String getGoal() {
        return this.game.getGoal().toString();
    }

    public boolean isWinner() {
        return game.isWinner();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
