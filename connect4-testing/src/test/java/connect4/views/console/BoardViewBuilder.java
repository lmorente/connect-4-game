package connect4.views.console;

import connect4.types.Color;
import connect4.views.BoardView;
import connect4.views.Message;
import utils.models.Coordinate;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class BoardViewBuilder {

    private String boardString;
    private BoardView boardView;
    private Map<Character, Color> colors;

    public BoardViewBuilder(){
        this.boardView = new ConcreteBoardView();
        this.boardString = "";
        this.colors = new HashMap<Character, Color>();
        this.colors.put('R', Color.RED);
        this.colors.put('Y', Color.YELLOW);
        this.colors.put(' ', Color.NULL);
    }

    public void buildBoard(String... rows) {
        assert this.checkCorrectRowFormat(rows);
        this.boardString = "";
        this.boardString += Message.HORIZONTAL_LINE.toString();
        for (int i = 0; i < Coordinate.DIMENSION_ROW; i++) {
            this.boardString += Message.VERTICAL_LINE;
            for (int j = 0; j < Coordinate.DIMENSION_COLUMN ; j++) {
                this.boardView.set(this.colors.get(rows[i].charAt(j)));
                this.boardString += rows[i].charAt(j);
                this.boardString += Message.VERTICAL_LINE;
            }
        }
        this.boardString += Message.HORIZONTAL_LINE.toString();
    }

    public String getPrintableBoard() {
        return this.boardString;
    }

    public BoardView getBoardView() {
        return this.boardView;
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
}
