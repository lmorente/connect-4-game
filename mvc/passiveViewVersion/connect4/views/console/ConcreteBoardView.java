package passiveViewVersion.connect4.views.console;

import passiveViewVersion.connect4.views.Message;
import passiveViewVersion.utils.models.Coordinate;
import passiveViewVersion.utils.views.Console;

class ConcreteBoardView extends passiveViewVersion.connect4.views.BoardView {

    public void write() {
        new MessageView().writeln(Message.HORIZONTAL_LINE);
        for (int i = Coordinate.DIMENSION_ROW - 1; i > 0; i--) {
            new MessageView().write(Message.VERTICAL_LINE);
            for (int j = Coordinate.DIMENSION_COLUMN; j > 0 ; j--) {
                new ColorView().write(this.colors.get(i * Coordinate.DIMENSION_ROW + j));
                new MessageView().write(Message.VERTICAL_LINE);
            }
            Console.getInstance().writeln();
        }
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }

}
