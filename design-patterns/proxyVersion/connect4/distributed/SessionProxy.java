package proxyVersion.connect4.distributed;


import proxyVersion.connect4.distributed.dispatchers.FrameType;
import proxyVersion.utils.TCPIP;
import proxyVersion.connect4.models.StateValue;
import proxyVersion.connect4.models.session.Session;
import proxyVersion.connect4.types.Color;
import proxyVersion.utils.models.ConcreteCoordinate;

public class SessionProxy implements Session {
	
	private final TCPIP tcpip;

	public SessionProxy(TCPIP tcpip) {
		this.tcpip = tcpip;
	}
	
	
	public StateValue getValueState() {
		this.tcpip.send(FrameType.STATE.name());
		return StateValue.values()[this.tcpip.receiveInt()];
	}

	@Override
	public Color getColor(ConcreteCoordinate coordinate) {
		this.tcpip.send(FrameType.TOKEN_CHAR.name());
		this.tcpip.send(coordinate.getRow());
		this.tcpip.send(coordinate.getColumn());
		return Color.get(this.tcpip.receiveLine());
	}
}
