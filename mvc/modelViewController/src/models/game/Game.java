package models.game;

public class Game {

    private final Turn turn;
    private final Board board;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void startGame() {
        this.turn.makeFirstTurn();
    }

    public void restartGame() {
        this.board.reset();
        this.turn.reset(board);
    }

    public void playTurn(int column) {
        assert column >= 0 && column < 7;
        this.turn.putPiece(column);
        this.turn.update();
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

    public boolean isWinner() {
        return this.turn.isGoalWinner();
    }

}
