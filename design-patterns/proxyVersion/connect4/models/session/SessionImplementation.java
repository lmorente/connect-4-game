package proxyVersion.connect4.models.session;

import proxyVersion.connect4.models.Game;
import proxyVersion.connect4.models.State;
import proxyVersion.connect4.models.StateValue;
import proxyVersion.connect4.types.Color;
import proxyVersion.connect4.types.Error;
import proxyVersion.utils.models.ConcreteCoordinate;

public class SessionImplementation implements Session {

    private final State state;
    private final Game game;
    private final Registry registry;

    public SessionImplementation() {
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(game);
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

    public void createPlayers(int numbOfUsers){
        this.game.createPlayers(numbOfUsers);
        this.registry.register();
    }

    public void nextState(){
        this.state.next();
    }

    @Override
    public StateValue getValueState() {
        return this.state.getStateValue();
    }

    @Override
    public Color getColor(ConcreteCoordinate coordinate) {
        return this.game.getColor(coordinate);
    }
}
