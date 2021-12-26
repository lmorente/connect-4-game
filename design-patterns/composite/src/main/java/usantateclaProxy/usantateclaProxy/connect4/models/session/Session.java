package usantateclaProxy.usantateclaProxy.connect4.models.session;

import usantateclaProxy.usantateclaProxy.connect4.models.Game;
import usantateclaProxy.usantateclaProxy.connect4.models.State;
import usantateclaProxy.usantateclaProxy.connect4.models.StateValue;
import usantateclaProxy.usantateclaProxy.connect4.types.Color;
import usantateclaProxy.usantateclaProxy.connect4.types.Error;
import usantateclaProxy.usantateclaProxy.utils.models.ConcreteCoordinate;

public class Session {

    private final State state;
    private final Game game;
    private final Registry registry;

    public Session() {
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(game);
    }

    public StateValue getStateValue() {
        return this.state.getStateValue();
    }

    public void nextState() {
        this.state.next();
    }

    public Color getColor(ConcreteCoordinate coordinate) {
        return this.game.getColor(coordinate);
    }

    public boolean isConnect4() {
        return this.game.isConnect4();
    }

    public void next() {
        this.game.next();
        this.registry.register();
    }

    public Color getActiveColor() {
        return this.game.getActiveColor();
    }

    public void putToken(int column) {
        this.game.putToken(column);
    }

    public Error getPutTokenError(int column) {
        return this.game.getPutTokenError(column);
    }

    public void undo() {
        this.registry.undo();
    }

    public boolean isUndoable() {
        return this.registry.isUndoable();
    }

    public boolean isRedoable() {
        return this.registry.isRedoable();
    }

    public void redo() {
        this.registry.redo();
    }

    public void reset() {
        this.game.reset();
        this.state.reset();
        this.registry.reset();
    }
}
