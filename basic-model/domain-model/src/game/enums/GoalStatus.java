package game.enums;

public enum GoalStatus {

    IN_PROGRESS("Game in progress"), WIN("win the game"), FULL_BOARD("The board is full, game over");

    private final String message;

    GoalStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}