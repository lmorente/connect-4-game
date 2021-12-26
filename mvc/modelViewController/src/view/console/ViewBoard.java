package view.console;

import controllers.Controller;
import view.common.BoardDimension;
import view.console.printer.BoardElement;

public class ViewBoard {

    public static void print(Controller controller) {
        printHeaderBoard();
        for (int i = BoardDimension.ROW.getValue() - 1; i >= 0; i--) {
            for (int j = 0; j < BoardDimension.COLUMN.getValue(); j++) {
                BoardElement.EDGE_SEPARATOR.print();
                BoardElement.SQUARE.print(controller.getSquare(i, j));
                if (j == (BoardDimension.COLUMN.getValue() - 1)) {
                    BoardElement.FINAL_EDGE_SEPARATOR.print();
                }
            }
        }
        BoardElement.LINE_SEPARATOR.print();
    }

    private static void printHeaderBoard() {
        String headerColumn = " ";
        for (int i = 0; i < BoardDimension.COLUMN.getValue(); i++) {
            headerColumn = headerColumn.concat(i + " ");
        }
        BoardElement.COLUMN_HEADER.print(headerColumn);
        BoardElement.LINE_SEPARATOR.print();
    }
}
