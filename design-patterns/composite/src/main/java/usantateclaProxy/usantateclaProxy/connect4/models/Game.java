package usantateclaProxy.usantateclaProxy.connect4.models;

import usantateclaProxy.usantateclaProxy.connect4.models.session.MementoGame;
import usantateclaProxy.usantateclaProxy.connect4.types.Color;
import usantateclaProxy.usantateclaProxy.utils.models.ConcreteCoordinate;
import usantateclaProxy.usantateclaProxy.connect4.types.Error;

public class Game {

    private Board board;
    private Turn turn;

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

    public MementoGame createMemento() {
        return new MementoGame(turn);
    }

    public void setMemento(MementoGame memento) {
        this.turn = memento.getTurn();
    }
}
