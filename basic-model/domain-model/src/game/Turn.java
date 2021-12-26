package game;

import game.enums.GoalStatus;
import game.enums.Message;
import game.utils.Printer;

import java.util.Objects;

public class Turn {

    private final static String PLAYER_1_NAME = "Player 1";
    private final static String PLAYER_2_NAME = "Player 2";
    private final static String PIECE_1 = "X";
    private final static String PIECE_2 = "O";

    private final Player player1;
    private final Player player2;
    private GoalStatus goal;

    public Turn() {
        this.player1 = new Player(PLAYER_1_NAME, PIECE_1);
        this.player2 = new Player(PLAYER_2_NAME, PIECE_2);
    }

    public GoalStatus getGoal() {
        return goal;
    }

    public void initTurn() {
        Printer.printLine(Message.START_GAME.getValue());
        this.goal = GoalStatus.IN_PROGRESS;
        this.player1.setActive(Boolean.TRUE);
    }

    public String getCurrentPiece() {
        return Objects.nonNull(getActivePlayer()) ? getActivePlayer().getPiece() : null;
    }

    public void makeNextTurn() {
        if (Objects.nonNull(getActivePlayer())) {
            updateNextPlayer();
        }
    }

    public void printActivePlayer() {
        Printer.printLine(Message.PLAYER_TURN.getValue().concat(getActivePlayer().getName()));
    }

    private Player getActivePlayer() {
        if (this.player1.isActive()) {
            return this.player1;
        } else if (this.player2.isActive()) {
            return this.player2;
        }
        return null;
    }

    private void updateNextPlayer() {
        if (this.player1.isActive()) {
            this.player1.setActive(Boolean.FALSE);
            this.player2.setActive(Boolean.TRUE);
        } else {
            this.player2.setActive(Boolean.FALSE);
            this.player1.setActive(Boolean.TRUE);
        }
    }
}
