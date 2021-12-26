package usantateclaProxy.usantateclaProxy.connect4.views;

public enum Message {
    
    TITLE("--- CONNECT4 ---"),
    HORIZONTAL_LINE("---------------"),
    VERTICAL_LINE(" | "),
    ENTER_COLUMN_TO_PUT("Enter a column to put a token:"),
    COORDINATE_TO_PUT("Coordinate to put"),
    COORDINATE_TO_REMOVE("Origin coordinate to move"),
    COORDINATE_TO_MOVE("Target coordinate to move"),
    PLAYER_WIN("#player player: You win!!! :-)"),
    RESUME("Do you want to continue"),
    ACTION_COMMAND("Do a action"),
    REDO_COMMAND("Redo previous action"),
    UNDO_COMMAND("Undo previous action");

    private String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
    
}
