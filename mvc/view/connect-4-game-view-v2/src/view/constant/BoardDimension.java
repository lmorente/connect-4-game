package view.constant;

public enum BoardDimension {

    COLUMN(7),
    ROW(6);

    private final int value;

    BoardDimension(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
