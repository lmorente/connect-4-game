package designpatterns.connect4.controllers;

import java.util.HashMap;
import java.util.Map;

import designpatterns.connect4.models.session.Session;
import designpatterns.connect4.models.StateValue;

public class Logic {

    private final Session session;
    private final Map<StateValue, AcceptorController> controllers;

    public Logic() {
        this.session = new Session();
        this.controllers = new HashMap<>();
        this.controllers.put(StateValue.INITIAL, new StartController(this.session));
        this.controllers.put(StateValue.IN_GAME, new PlayController(this.session));
        this.controllers.put(StateValue.RESUME, new ResumeController(this.session));
        this.controllers.put(StateValue.EXIT, null);
    }

    public AcceptorController getController() {
        return this.controllers.get(this.session.getStateValue());
    }
}
