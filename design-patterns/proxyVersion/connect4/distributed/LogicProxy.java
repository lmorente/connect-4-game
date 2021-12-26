package proxyVersion.connect4.distributed;


import proxyVersion.utils.TCPIP;
import proxyVersion.connect4.controllers.Logic;

import proxyVersion.connect4.models.StateValue;

public class LogicProxy extends Logic {
	
	private final TCPIP tcpip;
	
	public LogicProxy() {
		this.tcpip = TCPIP.createClientSocket();
		this.session = new SessionProxy(this.tcpip);
		this.acceptorControllers.put(StateValue.INITIAL, new StartControllerProxy(this.session,this.tcpip));
		this.acceptorControllers.put(StateValue.IN_GAME, new PlayControllerProxy(this.session,this.tcpip));
		this.acceptorControllers.put(StateValue.RESUME, new ResumeControllerProxy(this.session,this.tcpip));
		this.acceptorControllers.put(StateValue.EXIT, null);
	}

	public void close() {
		this.tcpip.close();
	}
}
