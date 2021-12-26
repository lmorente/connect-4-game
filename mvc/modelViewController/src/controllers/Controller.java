package controllers;

import models.game.Game;
import models.state.State;

public abstract class Controller {

    protected Game game;
    protected State state;

    public Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    public void nextState() {
        state.nextState();
    }

    public String getSquare(int i, int j) {
        return this.game.getSquare(i, j);
    }

    public String getActivePlayer() {
        return this.game.getActivedPlayer();
    }

    public abstract void accept(ControllersVisitor controllersVisitor);
}
