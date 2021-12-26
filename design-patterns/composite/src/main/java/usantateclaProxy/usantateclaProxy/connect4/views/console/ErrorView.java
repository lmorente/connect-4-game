package usantateclaProxy.usantateclaProxy.connect4.views.console;

import usantateclaProxy.usantateclaProxy.connect4.types.Error;
import usantateclaProxy.usantateclaProxy.utils.views.Console;

class ErrorView extends usantateclaProxy.usantateclaProxy.connect4.views.ErrorView {

    @Override
    public void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.MESSAGES[error.ordinal()]);
        }
    }

}
