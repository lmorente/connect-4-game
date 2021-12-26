package game;

import java.util.Objects;

public class Turn {

    private final static int NUMBER_OF_PLAYERS = 2;

    private final String[] players;
    private Board board;
    private GoalStatus goal;
    private int activePlayer;

    public Turn(Board board) {
        this.board = board;
        this.players = new String[]{"X", "O"};
    }

    public GoalStatus getGoal() {
        return this.goal;
    }

    public void makeFirstTurn() {
        this.goal = GoalStatus.IN_PROGRESS;
        this.activePlayer = 0;
    }

    public void update(Board board, GoalStatus status) {
        this.board = board;
        this.goal = status;
    }

    public void makeNextTurn() {
        if(Objects.nonNull(getActivePlayer())){
            updateNextPlayer();
        }
    }

    public String getActivePlayer(){
       return this.players[activePlayer];
    }

    public void putPiece(int column) {
        this.board.putPiece(getActivePlayer(), column);
    }

    private void updateNextPlayer() {
        if(activePlayer + 1 < NUMBER_OF_PLAYERS){
            this.activePlayer++;
        } else {
            this.activePlayer = 0;
        }
    }

    public boolean isInProgress() {
        return GoalStatus.IN_PROGRESS.equals(this.goal);
    }
}
