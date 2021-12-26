package proxyVersion.connect4.views.console;

import proxyVersion.connect4.types.Error;
import proxyVersion.utils.views.Console;

class ErrorView extends proxyVersion.connect4.views.ErrorView {

    @Override
    public void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.MESSAGES[error.ordinal()]);
        }
    }

}
