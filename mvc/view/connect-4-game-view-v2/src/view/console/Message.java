package view.console;

public enum Message {

    START_GAME("####   START GAME    ####\n"),
    END_GAME("\n####   END GAME   ####\n"),
    RESULT_GAME("Game result: %s"),
    RESULT_WINNER("The winner is %s"),
    HEADER_SEPARATOR("----------------------"),
    PLAYER_TURN("Turn %s \n"),
    CHOOSE_COLUMN("Choose a column:"),
    INPUT_ERROR("ERROR! This column is complete, choose another column: ");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void print() {
        System.out.println(getValue());
    }

    public void print(String variable) {
        System.out.println(String.format(getValue(), variable));
    }
}
