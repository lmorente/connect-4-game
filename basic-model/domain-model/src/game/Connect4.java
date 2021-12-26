package game;

import game.enums.GoalStatus;
import game.enums.Message;
import game.utils.Printer;

public class Connect4 {

    private final static int PIECES_TO_WIN = 4;

    private final Turn turn;
    private final Board board;

    private Connect4() {
        this.board = new Board();
        this.turn = new Turn();
    }

    private void play() {
        this.turn.initTurn();

        do {
            playTurn();
        } while (GoalStatus.IN_PROGRESS.equals(turn.getGoal()));

        printEndGame();
    }

    private void printEndGame() {
        this.board.print();

        Printer.printLine(Message.END_GAME.getValue());
        Printer.printLine(Message.HEADER_SEPARATOR.getValue());
        Printer.printLine(Message.RESULT_GAME.getValue().concat(this.turn.getGoal().toString()));

        if (GoalStatus.WIN.equals(this.turn.getGoal())) {
            this.turn.printActivePlayer();
        }
    }

    private void playTurn() {
        this.turn.printActivePlayer();
        this.board.print();

        Printer.printLine(Message.CHOOSE_COLUMN.getValue());

        final int column = Integer.parseInt(Printer.getOrderColumn());
        this.board.putPiece(turn.getCurrentPiece(), column);
        final GoalStatus status = evaluateGame();

        if (GoalStatus.IN_PROGRESS.equals(status)) {
            this.turn.makeNextTurn();
        }
    }

    private GoalStatus evaluateGame() {
        GoalStatus status = GoalStatus.IN_PROGRESS;
        if (checkAscendingDiagonal() || checkDescendingDiagonal()
                || checkVertical() || checkHorizontal()) {
            status = GoalStatus.WIN;
        }

        if (board.isCompleted()) {
            status = GoalStatus.FULL_BOARD;
        }

        return status;
    }

    private boolean checkAscendingDiagonal() {
        for (int i = 0; i < this.board.getRows() - 1; i++) {
            for (int j = 0; j < this.board.getRows() - 1; j++) {
                int count = 0;
                for (int p = 0; p < PIECES_TO_WIN - 1; p++) {
                    if (i + p < this.board.getRows() - 1 && j + p < this.board.getColumns() &&
                            (this.board.showSquare(i + p, j + p)).equals(this.turn.getCurrentPiece())) {
                        count++;
                    } else {
                        count = 0;
                    }
                    if (count == PIECES_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private Boolean checkDescendingDiagonal() {
        for (int i = PIECES_TO_WIN - 1; i < this.board.getRows(); i++) {
            for (int j = 0; j < this.board.getRows() - PIECES_TO_WIN; j++) {
                int count = 0;
                for (int p = 0; p < PIECES_TO_WIN - 1; p++) {
                    if (i - p <= 0 && j + p < this.board.getColumns() &&
                            (this.board.showSquare(i - p, j + p)).equals(this.turn.getCurrentPiece())) {
                        count++;
                    } else {
                        count = 0;
                    }

                    if (count == PIECES_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkVertical() {
        for (int j = 0; j < this.board.getColumns() - 1; j++) {
            for (int i = 0; i < this.board.getRows() - 1; i++) {
                int count = 0;
                for (int p = 0; p < PIECES_TO_WIN - 1; p++) {
                    if ((this.board.showSquare(i + 1, j)).equals(this.turn.getCurrentPiece())) {
                        count++;
                    } else {
                        count = 0;
                    }

                    if (count == PIECES_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkHorizontal() {
        for (int j = 0; j < this.board.getColumns() - 1; j++) {
            for (int i = 0; i < this.board.getRows() - 1; i++) {
                int count = 0;
                for (int p = 0; p < PIECES_TO_WIN - 1; p++) {
                    if ((this.board.showSquare(i, +1)).equals(this.turn.getCurrentPiece())) {
                        count++;
                    } else {
                        count = 0;
                    }

                    if (count == PIECES_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Connect4().play();
    }
}
