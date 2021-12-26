package proxyVersion.connect4.distributed.dispatchers.undoredo;

import proxyVersion.connect4.controllers.PlayController;
import proxyVersion.connect4.distributed.dispatchers.Dispatcher;

public class RedoDispatcher extends Dispatcher {

	public RedoDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		((PlayController)this.acceptorController).redo();
	}

}
