package passiveViewVersion.connect4.controllers.menu;

public enum CommandType {

    PLAY("play"),
    UNDO("undo"),
    REDO("redu");

    private String value;

    CommandType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
