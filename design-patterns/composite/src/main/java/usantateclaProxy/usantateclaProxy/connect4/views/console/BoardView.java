package usantateclaProxy.usantateclaProxy.connect4.views.console;

import usantateclaProxy.usantateclaProxy.connect4.controllers.Controller;
import usantateclaProxy.usantateclaProxy.connect4.views.Message;
import usantateclaProxy.usantateclaProxy.connect4.models.Board;
import usantateclaProxy.usantateclaProxy.utils.models.ConcreteCoordinate;
import usantateclaProxy.usantateclaProxy.utils.views.Console;

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
