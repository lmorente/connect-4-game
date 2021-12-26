package proxyVersion.connect4.distributed.dispatchers.undoredo;

import proxyVersion.connect4.controllers.PlayController;
import proxyVersion.connect4.distributed.dispatchers.Dispatcher;

public class RedoableDispatcher extends Dispatcher {

	public RedoableDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayController)this.acceptorController).isRedoable());
	}

}
