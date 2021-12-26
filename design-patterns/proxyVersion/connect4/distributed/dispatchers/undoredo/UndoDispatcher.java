package proxyVersion.connect4.distributed.dispatchers.undoredo;


import proxyVersion.connect4.controllers.PlayController;
import proxyVersion.connect4.distributed.dispatchers.Dispatcher;

public class UndoDispatcher extends Dispatcher {

	public UndoDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		((PlayController)this.acceptorController).undo();
	}

}
