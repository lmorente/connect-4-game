package main.connect4.controllers;

import java.util.HashMap;
import java.util.Map;

import main.connect4.models.Game;
import main.connect4.models.Session;
import main.connect4.models.State;
import main.connect4.models.StateValue;

public class Logic {

    private Session session;
    private State state;
    private Map<StateValue, Controller> controllers;

    public Logic() {
        this.state = new State();
        this.session = new Session();
        this.controllers = new HashMap<>();
        this.controllers.put(StateValue.INITIAL, new StartController(this.session, this.state));
        this.controllers.put(StateValue.IN_GAME, new PlayController(this.session, this.state));
        this.controllers.put(StateValue.RESUME, new ResumeController(this.session, this.state));
        this.controllers.put(StateValue.EXIT, null);
    }

    public Controller getController() {
        return this.controllers.get(this.state.getValueState());
    }

}
