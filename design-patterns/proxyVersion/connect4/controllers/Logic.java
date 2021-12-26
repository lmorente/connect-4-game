package proxyVersion.connect4.controllers;

import proxyVersion.connect4.models.StateValue;
import proxyVersion.connect4.models.session.Session;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    protected Session session;

    protected final Map<StateValue, AcceptorController> acceptorControllers;

    public Logic() {
        this.acceptorControllers = new HashMap<>();
    }

    public AcceptorController getController() {
        return this.acceptorControllers.get(this.session.getValueState());
    }
}
