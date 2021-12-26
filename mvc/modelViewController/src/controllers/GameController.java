package controllers;

import controllers.stages.EndController;
import controllers.stages.PlayController;
import controllers.stages.RestartController;
import controllers.stages.StartController;
import models.game.Game;
import models.state.State;
import models.state.StateGame;

import java.util.HashMap;
import java.util.Map;

public class GameController {

    private Game game;
    private State state;
    private Map<StateGame, Controller> controllers;

    public GameController() {
        this.state = new State();
        this.game = new Game();

        this.controllers = new HashMap<>();
        this.controllers.put(StateGame.START, new StartController(this.game, this.state));
        this.controllers.put(StateGame.IN_PROGRESS, new PlayController(this.game, this.state));
        this.controllers.put(StateGame.END, new EndController(this.game, this.state));
        this.controllers.put(StateGame.RESTART, new RestartController(this.game, this.state));
        this.controllers.put(StateGame.EXIT, null);
    }

    public Controller getController() {
        return this.controllers.get(this.state.getStateGame());
    }
}
