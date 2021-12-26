package connect4.views.console;

import connect4.types.Error;
import connect4.views.ErrorView;
import utils.views.Console;

class ConcreteErrorView implements ErrorView {

    @Override
    public void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ConcreteErrorView.MESSAGES[error.ordinal()]);
        }
    }
}
