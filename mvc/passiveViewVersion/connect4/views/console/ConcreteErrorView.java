package passiveViewVersion.connect4.views.console;

import passiveViewVersion.connect4.types.Error;
import passiveViewVersion.connect4.views.ErrorView;
import passiveViewVersion.utils.views.Console;

class ConcreteErrorView implements ErrorView {

    @Override
    public void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ConcreteErrorView.MESSAGES[error.ordinal()]);
        }
    }
}
