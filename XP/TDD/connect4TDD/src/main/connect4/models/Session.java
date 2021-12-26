package main.connect4.models;

import main.connect4.types.Color;
import main.utils.models.ConcreteCoordinate;
import main.connect4.types.Error;

public class Session {

    private Game game;
    private Registry registry;

    public Session() {
        this.game = new Game();
        this.reset();
        this.registry = new Registry(this.game);
    }

    public void reset() {
        this.game.reset();
    }

    public Color getColor(ConcreteCoordinate coordinate) {
        return this.game.getColor(coordinate);
    }

    public boolean isConnect4() {
        return this.game.isConnect4();
    }

    public void next() {
        this.game.next();
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

    public void redo() {
        this.registry.redo();
    }

    public void register() {
        this.registry.register();
    }

    public boolean isUndoable() {
        return this.registry.isUndoable();
    }

    public boolean isRedoable() {
        return this.registry.isRedoable();
    }
}
