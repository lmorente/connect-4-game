package connect4.views.console;

import connect4.views.BoardView;
import connect4.views.Message;
import utils.models.Coordinate;
import utils.views.Console;

class ConcreteBoardView extends BoardView {

    public void write() {
        new MessageView().writeln(Message.HORIZONTAL_LINE);
        for (int i = 0; i<Coordinate.DIMENSION_ROW; i++) {
            new MessageView().write(Message.VERTICAL_LINE);
            for (int j =0; j < Coordinate.DIMENSION_COLUMN; j++) {
                new ColorView().write(this.colors.get(i * Coordinate.DIMENSION_COLUMN + j));
                new MessageView().write(Message.VERTICAL_LINE);
            }
            Console.getInstance().writeln();
        }
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }
}
