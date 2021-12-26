package main.connect4;

import main.connect4.controllers.Controller;
import main.connect4.controllers.Logic;
import main.connect4.views.View;

abstract class Connect4 {

    private View view;
    private Logic logic;

    protected Connect4() {
        this.logic = new Logic();
        this.view = this.createView();
    }

    protected abstract View createView();

    protected void play() {
        Controller controller;
        do {
            controller = logic.getController();
            if (controller != null)
                controller.accept(this.view);
        } while (controller != null);
    }

}
