package proxyVersion.connect4.distributed.dispatchers.actions;


import proxyVersion.connect4.controllers.StartController;
import proxyVersion.connect4.distributed.dispatchers.Dispatcher;

public class StartDispatcher extends Dispatcher {

	public StartDispatcher(StartController startController) {
		super(startController);
	}

	@Override
	public void dispatch() {
		((StartController) this.acceptorController).start();
	}

}
