package main.connect4.models;

public class GameTestAuxiliar extends Game {
    
    public GameTestAuxiliar() {
        this.board = new BoardTestAuxiliar();
        this.turn = new Turn(this.board);
    }
    
    public boolean isColumnEmpty(int column) {
        return ((BoardTestAuxiliar)this.board).isColumnEmpty(column);
    }
}
