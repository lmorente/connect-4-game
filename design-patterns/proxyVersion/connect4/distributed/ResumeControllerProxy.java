package proxyVersion.connect4.distributed;

import proxyVersion.connect4.distributed.dispatchers.FrameType;
import proxyVersion.utils.TCPIP;
import proxyVersion.connect4.controllers.ResumeController;
import proxyVersion.connect4.models.session.Session;

public class ResumeControllerProxy extends ResumeController {

	private TCPIP tcpip;

	public ResumeControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void resume(boolean newGame) {
		this.tcpip.send(FrameType.NEW_GAME.name());
		this.tcpip.send(newGame);	
	}
}
