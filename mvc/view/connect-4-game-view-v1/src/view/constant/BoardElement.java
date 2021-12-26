package view.constant;

public enum BoardElement {

    EDGE_SEPARATOR("|"),
    LINE_SEPARATOR("_______________");

    private final String value;

    BoardElement(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
