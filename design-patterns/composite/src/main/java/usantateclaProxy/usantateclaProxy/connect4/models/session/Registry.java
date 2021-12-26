package usantateclaProxy.usantateclaProxy.connect4.models.session;


import usantateclaProxy.usantateclaProxy.connect4.models.Game;

import java.util.ArrayList;
import java.util.List;

public class Registry {

    private List<MementoGame> mementos;
    private final Game game;
    private int previousIndex;

    public Registry(Game game) {
        this.game = game;
        this.reset();
    }

    public void reset() {
        this.previousIndex = 0;
        this.mementos = new ArrayList<>();
        this.mementos.add(this.previousIndex, this.game.createMemento());
    }

    public void register() {
        this.previousIndex = 0;
        this.mementos.add(this.previousIndex, this.game.createMemento());
    }

    public void undo() {
        assert this.isUndoable();

        this.previousIndex++;
        setMemento();
    }

    public void redo() {
        assert this.isRedoable();

        this.previousIndex--;
        setMemento();
    }

    private void setMemento() {
        this.game.setMemento(this.mementos.get(previousIndex));
    }

    public boolean isUndoable() {
        return this.previousIndex < this.mementos.size() - 1;
    }

    public boolean isRedoable() {
        return this.previousIndex >= 1;
    }
}
