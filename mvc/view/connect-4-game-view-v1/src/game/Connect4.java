package game;

public class Connect4 {

    private final Turn turn;
    private final Board board;

    public Connect4() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void initGame() {
        this.turn.makeFirstTurn();
    }

    public void playTurn(int column) {
        assert column >= 0 && column < 7;
        this.turn.putPiece(column);

        if (this.board.isConnect4()) {
            this.turn.update(board, GoalStatus.WIN);
        } else if (this.board.isCompleted()) {
            this.turn.update(board, GoalStatus.FULL_BOARD);
        } else {
            this.turn.makeNextTurn();
        }
    }

    public String getActivedPlayer() {
        return this.turn.getActivePlayer();
    }

    public GoalStatus getGoal() {
        return this.turn.getGoal();
    }

    public boolean isValidTurn(int column) {
        assert column >= 0 && column < 7;
        return !this.board.isFullColumn(column);
    }

    public boolean isInProgress() {
        return this.turn.isInProgress();
    }

    public String getSquare(int i, int j) {
        return this.board.getSquare(i, j);
    }
}
