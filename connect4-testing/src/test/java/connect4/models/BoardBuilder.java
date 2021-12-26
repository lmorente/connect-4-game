package connect4.models;

import connect4.types.Color;
import utils.models.Coordinate;

import java.util.regex.Pattern;

public class BoardBuilder {

    public Board createEmptyBoard() {
        return new Board();
    }

    public Board createBoard(String... rows) {
        assert this.checkCorrectRowFormat(rows);
        Board board = new Board();
        String workingRow;
        for (int row = rows.length-1; row >= 0; row--) {
            workingRow = rows[row];
            for (int column = 0; column < workingRow.length(); column++) {
                board.putToken(column, this.getColor(workingRow.charAt(column)));
            }
        }
        return board;
    }

    private boolean checkCorrectRowFormat(String[] rows) {
        if (rows.length != Coordinate.DIMENSION_ROW)
            return false;
        String rowPattern = "[RY ]{" + Coordinate.DIMENSION_COLUMN + "}";
        for (String row : rows) {
            if (row.length() != Coordinate.DIMENSION_COLUMN
            || !Pattern.matches(rowPattern, row))
                return false;
        }
        return true;
    }

    private Color getColor(char piece) {
        for (int i = 0; i < Color.values().length - 1; i++) {
            Color workingColor = Color.values()[i];
            if (workingColor.name().charAt(0)== piece)
                return workingColor;
        }
        return Color.NULL;
    }
}
