package controllers.stages;

import controllers.Controller;
import controllers.ControllersVisitor;
import models.game.Game;
import models.state.State;

public class PlayController extends Controller {

    public PlayController(Game game, State state) {
        super(game, state);
    }

    public boolean isInProgress() {
        return this.game.isInProgress();
    }

    public boolean isValidTurn(String input) {
        final int column = Integer.parseInt(input);
        return this.game.isValidTurn(column);
    }

    public void playTurn(String input) {
        final int column = Integer.parseInt(input);
        this.game.playTurn(column);
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
