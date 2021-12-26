package proxyVersion.connect4.views.console;

import proxyVersion.connect4.controllers.Controller;
import proxyVersion.connect4.models.Board;
import proxyVersion.connect4.views.Message;
import proxyVersion.utils.models.ConcreteCoordinate;
import proxyVersion.utils.views.Console;

public class BoardView {

    public void write(Controller controller) {
        new MessageView().writeln(Message.HORIZONTAL_LINE);
        for (int i = Board.ROWS-1; i >= 0; i--) {
            new MessageView().write(Message.VERTICAL_LINE);
            for (int j = 0 ; j < Board.COLUMNS; j++) {
                new ColorView().write(controller.getColor(new ConcreteCoordinate(i, j)));
                new MessageView().write(Message.VERTICAL_LINE);
            }
            Console.getInstance().writeln();
        }
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }

}
