package main.connect4.models;

import main.connect4.types.Color;
import main.utils.models.ConcreteCoordinate;
import main.connect4.types.Error;

public class Game {

    protected Board board;
    protected Turn turn;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void reset() {
        this.board.reset();
        this.turn.reset();
    }

    public void next() {
        this.turn.next();
    }

    public Color getActiveColor() {
        return this.turn.getActiveColor();
    }

    public boolean isConnect4() {
        return this.board.isConnect4();
    }

    public Color getColor(ConcreteCoordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    public void putToken(int column) {
        this.turn.putToken(column);
    }

    public Error getPutTokenError(int column) {
        return this.turn.getPutTokenError(column);
    }

    public BoardMemento getBoardMemento(){
        return new BoardMemento(this.board.clone(), this.turn.getActiveColor());
    }

    public void setBoardMemento(BoardMemento memento){
        this.turn.setActivePlayer(memento.getActivePlayer().ordinal());
        this.board = memento.getBoard();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (board == null) {
            if (other.board != null)
                return false;
        } else if (!board.equals(other.board))
            return false;
        if (turn == null) {
            return other.turn == null;
        } else return turn.equals(other.turn);
    }

}
