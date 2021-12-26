package proxyVersion.connect4;

import proxyVersion.connect4.controllers.AcceptorController;
import proxyVersion.connect4.controllers.Logic;
import proxyVersion.connect4.views.View;

public abstract class Connect4 {

    private View view;
    private Logic logic;

    protected Connect4() {
        this.logic = createLogic();
        this.view = createView();
    }

    protected abstract Logic createLogic();

    protected abstract View createView();

    protected void play() {
        AcceptorController acceptorController;
        do {
            acceptorController = this.logic.getController();
            if (acceptorController != null) {
                this.view.interact(acceptorController);
            }
        } while (acceptorController != null);
    }
}

