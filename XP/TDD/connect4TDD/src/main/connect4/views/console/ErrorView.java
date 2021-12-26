package main.connect4.views.console;

import main.connect4.types.Error;
import main.utils.views.Console;

class ErrorView extends main.connect4.views.ErrorView {

    @Override
    public void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.MESSAGES[error.ordinal()]);
        }
    }

}
