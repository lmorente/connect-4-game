package game;

import game.utils.Printer;

import java.util.Objects;

public class Board {

    private final static String EMPTY = " ";

    private final int columns = 7;
    private final int rows = 6;
    private final String[][] board;

    public Board() {
        this.board = initBoard();
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public Boolean isCompleted() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (EMPTY.equals(board[i][j]))
                    return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public void putPiece(String piece, int column) {
        Integer emptyRow = null;

        for (int i = 0; i < this.rows; i++) {
            if (board[i][column].equals(EMPTY)) {
                emptyRow = i;
                break;
            }
        }
        if (Objects.nonNull(emptyRow)) {
            this.board[emptyRow][column] = piece;
        }
    }

    public String showSquare(int i, int j) {
        return board[i][j];
    }

    private String[][] initBoard() {
        String[][] board = new String[rows][columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                board[i][j] = EMPTY;
            }
        }
        return board;
    }

    public void print() {
        for (int i = this.rows - 1; i >= 0; i--) {
            for (int j = 0; j < this.columns; j++) {
                Printer.print("|");
                Printer.print(this.board[i][j]);
                if (j == (this.columns - 1)) {
                    Printer.printLine("|");
                }
            }
        }
    }
}
