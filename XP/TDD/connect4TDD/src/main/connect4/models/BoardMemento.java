package main.connect4.models;

import main.connect4.types.Color;

public class BoardMemento {

    private Board board;
    private Color activePlayer;
    
    public BoardMemento(Board board, Color activePlayer){
        this.board = board;
        this.activePlayer = activePlayer;
    }
    
    public Board getBoard() {
        return board;
    }

    public Color getActivePlayer() {
        return this.activePlayer;
    }
}
