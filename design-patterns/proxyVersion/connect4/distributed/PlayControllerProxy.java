package proxyVersion.connect4.distributed;

import proxyVersion.connect4.distributed.dispatchers.FrameType;
import proxyVersion.utils.TCPIP;
import proxyVersion.connect4.controllers.PlayController;
import proxyVersion.connect4.models.session.Session;
import proxyVersion.connect4.types.Error;

public class PlayControllerProxy extends PlayController {

	private TCPIP tcpip;

	public PlayControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void undo() {
		this.tcpip.send(FrameType.UNDO.name());
	}

    @Override
    public boolean isUndoable() {
		this.tcpip.send(FrameType.UNDOABLE.name());
		return this.tcpip.receiveBoolean();
    }

    @Override
	public void redo() {
		this.tcpip.send(FrameType.REDO.name());
	}

    @Override
    public boolean isRedoable() {
		this.tcpip.send(FrameType.REDOABLE.name());
		return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean isConnect4() {
		this.tcpip.send(FrameType.CONNECT4.name());
		return this.tcpip.receiveBoolean();
    }

    @Override
    public void next() {
		//TODO: next
    }

    @Override
    public void putToken(int column) {
		//TODO: put token
    }

	@Override
	public Error getPutTokenError(int column) {
		this.tcpip.send(FrameType.ERRORS_PUT.name());
		this.tcpip.send(column);
		return this.tcpip.receiveError();
	}
}
