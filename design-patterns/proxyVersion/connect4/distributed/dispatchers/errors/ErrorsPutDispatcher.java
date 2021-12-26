package proxyVersion.connect4.distributed.dispatchers.errors;

import proxyVersion.connect4.controllers.PlayController;
import proxyVersion.connect4.distributed.dispatchers.Dispatcher;

public class ErrorsPutDispatcher extends Dispatcher {

	public ErrorsPutDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		int column = this.tcpip.receiveInt();
		this.tcpip.send(
				((PlayController) this.acceptorController).getPutTokenError(column));
	}
}