package proxyVersion.connect4.controllers.implementation;

import proxyVersion.connect4.controllers.ActionController;
import proxyVersion.connect4.controllers.RedoController;
import proxyVersion.connect4.controllers.UndoController;
import proxyVersion.connect4.models.session.Session;
import proxyVersion.connect4.controllers.PlayController;
import proxyVersion.connect4.types.Error;

public class PlayControllerImplementation extends PlayController {

	private ActionController actionController;

	private UndoController undoController;

	private RedoController redoController;

	public PlayControllerImplementation(Session session) {
		super(session);
		this.actionController = new ActionController(this.session);
		this.undoController = new UndoController(this.session);
		this.redoController = new RedoController(this.session);
	}

	@Override
	public void undo() {
		this.undoController.undo();
	}

	@Override
	public void redo() {
		this.redoController.redo();
	}

	@Override
	public boolean isUndoable() {
		return this.undoController.isUndoable();
	}

	@Override
	public boolean isRedoable() {
		return this.redoController.isRedoable();
	}

	public boolean isConnect4() {
		return this.actionController.isConnect4();
	}

	public void next() {
		this.actionController.next();
	}

	public void putToken(int column) {
		this.actionController.putToken(column);
	}

	public Error getPutTokenError(int column) {
		return this.actionController.getPutTokenError(column);
	}
}
