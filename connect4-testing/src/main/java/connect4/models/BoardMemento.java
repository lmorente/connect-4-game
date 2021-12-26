package connect4.models;

public class BoardMemento {
    private Board board;
    private int activePlayer;

    public BoardMemento(Board board, Turn turn) {
        this.board = board.clone();
        this.activePlayer = turn.getActiveColor().ordinal();
    }

    public Board getBoard() {
        return board;
    }

    public int getActivePlayer() {
        return activePlayer;
    }
}
