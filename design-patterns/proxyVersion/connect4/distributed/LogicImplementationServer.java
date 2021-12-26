package proxyVersion.connect4.distributed;

import proxyVersion.connect4.distributed.dispatchers.DispatcherPrototype;
import proxyVersion.connect4.distributed.dispatchers.FrameType;
import proxyVersion.connect4.distributed.dispatchers.actions.*;
import proxyVersion.connect4.distributed.dispatchers.errors.ErrorsPutDispatcher;
import proxyVersion.connect4.distributed.dispatchers.undoredo.RedoDispatcher;
import proxyVersion.connect4.distributed.dispatchers.undoredo.RedoableDispatcher;
import proxyVersion.connect4.distributed.dispatchers.undoredo.UndoableDispatcher;
import proxyVersion.connect4.controllers.implementation.LogicImplementation;
import proxyVersion.connect4.distributed.dispatchers.undoredo.UndoDispatcher;


public class LogicImplementationServer extends LogicImplementation {

	public void createDispatchers(DispatcherPrototype dispatcherPrototype) {

		dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startControllerImplementation));
		dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.CONNECT4, new Connect4Dispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.ERRORS_PUT, new ErrorsPutDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.PUT_TOKEN, new PutTokenDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.NEXT, new NextDispatcher(this.playControllerImplementation));
	}

}
