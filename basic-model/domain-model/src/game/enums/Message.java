package game.enums;

public enum Message {

    START_GAME("####   START GAME    ####\n"),
    END_GAME("\n####   END GAME   ####\n"),
    RESULT_GAME("Game result: "),
    RESULT_WINNER("The winner is "),
    HEADER_SEPARATOR("----------------------"),
    PLAYER_TURN("Turn "),
    CHOOSE_COLUMN("Choose a column:"),
    INPUT_ERROR("ERROR! This column is complete, choose another column: ");

    private String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
