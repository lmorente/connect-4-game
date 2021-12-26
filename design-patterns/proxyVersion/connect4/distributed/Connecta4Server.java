package proxyVersion.connect4.distributed;

import proxyVersion.connect4.distributed.dispatchers.DispatcherPrototype;

public class Connecta4Server {

	private final DispatcherPrototype dispatcherPrototype;

	private final LogicImplementationServer logic;

	private Connecta4Server() {
		this.dispatcherPrototype = new DispatcherPrototype();
		this.logic = new LogicImplementationServer();
		this.logic.createDispatchers(this.dispatcherPrototype);
	}

	private void serve() {
		this.dispatcherPrototype.serve();
	}

	public static void main(String[] args) {
		new Connecta4Server().serve();
	}

}
