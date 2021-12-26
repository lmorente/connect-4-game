package main.connect4.models;

import java.util.*;

public class Registry {

    private List<BoardMemento> boardMementos;
    private Game game;
    private int previous;

    public Registry(Game game) {
        this.game = game;
        this.boardMementos = new ArrayList<>();
    }

    public void register() {
        for(int i=0; i< this.previous; i++){
            this.boardMementos.remove(i);
        }
        this.previous = 0;
        this.boardMementos.add(this.previous, this.game.getBoardMemento());
    }

    public List<BoardMemento> getBoardMementos() {
        return this.boardMementos;
    }

    public void undo(){
        assert(isUndoable());
        this.previous++;
        this.game.setBoardMemento(this.getBoardMementos().get(this.previous));
    }

    public void redo() {
        assert(this.isRedoable());
        this.previous--;
        this.game.setBoardMemento(this.getBoardMementos().get(this.previous));
    }

    public boolean isUndoable(){
        return this.previous < boardMementos.size() - 1;
    }

    public boolean isRedoable() {
        return this.previous > 0;
    }

    public int getPrevious() {
        return this.previous;
    }

    public void reset() {
        this.boardMementos = new ArrayList<>();
        this.previous = 0;
    }
}
