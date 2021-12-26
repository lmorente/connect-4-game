package proxyVersion.connect4.distributed;

import proxyVersion.connect4.distributed.dispatchers.FrameType;
import proxyVersion.utils.TCPIP;
import proxyVersion.connect4.controllers.StartController;
import proxyVersion.connect4.models.session.Session;


public class StartControllerProxy extends StartController {
	
	private final TCPIP tcpip;

	public StartControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void start() {
		this.tcpip.send(FrameType.START.name());
	}

	@Override
	public void createPlayers(int numberOfUsers) {
		this.tcpip.send(numberOfUsers);
	}
}
