package proxyVersion.connect4.distributed.dispatchers.actions;

import proxyVersion.connect4.distributed.dispatchers.Dispatcher;
import proxyVersion.connect4.controllers.PlayController;

public class PutTokenDispatcher extends Dispatcher {
    
    public PutTokenDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
        int column = this.tcpip.receiveInt();
		((PlayController)this.acceptorController).putToken(column);
	}
}