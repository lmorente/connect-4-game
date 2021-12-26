package connect4.views.console;

import connect4.views.CoordinateView;
import connect4.views.Message;
import utils.models.ConcreteCoordinate;
import utils.views.Console;

public class ConcreteCoordinateView implements CoordinateView {

    @Override
    public int readColumn() {
        Console console = Console.getInstance();
        console.writeln(Message.ENTER_COLUMN_TO_PUT.name());
        return console.readInt(ConcreteCoordinate.COLUMN) - 1;
    }

}
