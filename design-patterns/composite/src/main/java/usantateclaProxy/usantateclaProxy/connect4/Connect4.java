package usantateclaProxy.usantateclaProxy.connect4;

import usantateclaProxy.usantateclaProxy.connect4.controllers.AcceptorController;
import usantateclaProxy.usantateclaProxy.connect4.controllers.Logic;
import usantateclaProxy.usantateclaProxy.connect4.views.View;

abstract class Connect4 {

    private View view;
    private Logic logic;

    protected Connect4() {
        this.logic = new Logic();
        this.view = this.createView();
    }

    protected abstract View createView();

    protected void play() {
        AcceptorController controller;
        do {
            controller = logic.getController();
            if (controller != null) {
                controller.accept(this.view);
            }
        } while (controller != null);
    }

}
