package proxyVersion.connect4.distributed.dispatchers.actions;

import proxyVersion.connect4.distributed.dispatchers.Dispatcher;
import proxyVersion.connect4.controllers.PlayController;

public class NextDispatcher extends Dispatcher {

    public NextDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		((PlayController)this.acceptorController).next();
	}
    
}