package proxyVersion.connect4.distributed.dispatchers.actions;

import proxyVersion.connect4.distributed.dispatchers.Dispatcher;
import proxyVersion.connect4.controllers.PlayController;

public class Connect4Dispatcher extends Dispatcher {

    public Connect4Dispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayController)this.acceptorController).isConnect4());
	}
    
}