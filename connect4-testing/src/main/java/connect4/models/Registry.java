package connect4.models;

import java.util.ArrayList;
import java.util.List;

public class Registry {
    private Game game;
    private List<BoardMemento> boardMementos;
    private int firstPrevious;

    public Registry(Game game) {
        this.game = game;
        this.reset();
    }

    public void reset(){
        this.firstPrevious = 0;
        this.boardMementos = new ArrayList<>();
        this.boardMementos.add(this.firstPrevious, this.game.createBoardMemento());
    }

    public void register(){
        for(int i=0; i<firstPrevious; i++){
            this.boardMementos.remove(i);
        }
        this.firstPrevious = 0;
        this.boardMementos.add(this.firstPrevious, this.game.createBoardMemento());
    }

    public boolean isRedoable(){
        return firstPrevious > 0;
    }

    public boolean isUndoable(){
        return this.firstPrevious < (boardMementos.size() - 1);
    }

    public void undo(){
        assert(this.isUndoable());

        this.firstPrevious++;
        this.game.setMemento(boardMementos.get(this.firstPrevious));
    }

    public void redo(){
        assert(this.isRedoable());

        this.firstPrevious--;
        this.game.setMemento(boardMementos.get(this.firstPrevious));
    }
}
