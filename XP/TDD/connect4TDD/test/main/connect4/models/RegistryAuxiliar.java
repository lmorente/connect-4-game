package main.connect4.models;

import java.util.List;
import main.connect4.types.Color;

public class RegistryAuxiliar {
    private GameTestAuxiliar game;
    private Registry registry;

    public RegistryAuxiliar() {
        this.game = new GameTestAuxiliar();
        this.registry = new Registry(this.game);
    }

    public void register(int times) {
        for (int i = 0; i < times; i++) {
            this.registry.register();
        }
    }

    public void registerPutToken(int column) {
        this.game.putToken(column);
        this.game.next();
        this.registry.register();
    }

    public void makeRedo(){
        this.makeRedo(1);
    }

    public void makeUndo(){
        this.makeUndo(1);
    }

    public void register(){
        this.register(1);
    }

    public void makeRedo(int times) {
        for (int i = 0; i < times; i++) {
            assert this.registry.isRedoable();
            this.registry.redo();
        }
    }


    public void makeUndo(int times) {
        for (int i = 0; i < times; i++) {
            assert this.registry.isUndoable();
            this.registry.undo();
        }
    }

    public List<BoardMemento> getBoardMementos() {
        return this.registry.getBoardMementos();
    }

    public int getPrevious() {
        return this.registry.getPrevious();
    }

    public void reset() {
        this.registry.reset();
    }

    public Game getGame() {
        return this.game;
    }

    public Color getActiveColor() {
        return this.game.getActiveColor();
    }
}
