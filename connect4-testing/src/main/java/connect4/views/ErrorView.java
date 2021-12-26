package connect4.views;

import connect4.types.Error;

public interface ErrorView {

    public static final String[] MESSAGES = {
            "The square is not empty",
            "There is not a token of yours",
            "The origin and target squares are the same",
            "The coordinates are wrong"
    };

    void writeln(Error error);
}
