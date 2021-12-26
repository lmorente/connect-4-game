package passiveViewVersion.connect4.models;

import passiveViewVersion.connect4.types.Color;
import passiveViewVersion.utils.models.ConcreteCoordinate;

public class Session {

    private Game game;
    private Registry registry;

    public Session() {
        this.game = new Game();
        this.reset();
        this.registry = new Registry(game);
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

    public void putToken(int column) {
        this.game.putToken(column);
    }

    public void undo() {
        this.registry.undo();
    }

    public void redo() {
        this.registry.redo();
    }

    public boolean isUndoable() {
        return this.registry.isUndoable();
    }

    public boolean isRedoable() {
        return this.registry.isRedoable();
    }
}
