package connect4.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import connect4.types.Color;
import utils.models.ConcreteCoordinate;
import utils.models.Coordinate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardTest {

    private BoardBuilder boardBuilder;
    private Color RED;
    private Color YELLOW;
    private final int maxColumn = Coordinate.DIMENSION_COLUMN - 1;
    private final int originColumn = 0;
    private final int maxRow = Coordinate.DIMENSION_ROW - 1;
    private final int originRow = 0;

    @BeforeEach
    public void beforeEach() {
        this.boardBuilder = new BoardBuilder();
        this.RED = Color.RED;
        this.YELLOW = Color.YELLOW;
    }

    @Test
    public void givenSemiFullColumn_WhenPut_ThenIsOccupied() {
        Board board = this.boardBuilder.createBoard("       ",
                "YRRYYRR",
                "YYRYRRY",
                "RYRYRYR",
                "RRYYRRY",
                "RYRRYYR");
        board.putToken(originColumn, RED);
        board.putToken(maxColumn, YELLOW);
        assertThat(board.isOccupied(new ConcreteCoordinate(maxRow, originColumn), RED), is(true));
        assertThat(board.isOccupied(new ConcreteCoordinate(maxRow, maxColumn), YELLOW), is(true));
    }

    @Test
    public void givenEmptyColumn_WhenPut_ThenCoordinateIsOccupied() {
        Board board = this.boardBuilder.createEmptyBoard();
        board.putToken(originColumn, RED);
        board.putToken(maxColumn, YELLOW);
        assertThat(board.isOccupied(new ConcreteCoordinate(originRow, originColumn), RED), is(true));
        assertThat(board.isOccupied(new ConcreteCoordinate(originRow, maxColumn), YELLOW), is(true));
    }

    @Test
    public void givenFullColumn_WhenPut_ThenThrowsError() {
        Board board = this.boardBuilder.createBoard("RYYRYYR",
                "YRRYYRR",
                "YYRYRRY",
                "RYRYRYR",
                "RRYYRRY",
                "RYRRYYR");
        Assertions.assertThrows(AssertionError.class, () -> board.putToken(originColumn, RED));
        Assertions.assertThrows(AssertionError.class, () -> board.putToken(maxColumn, RED));
    }

    @Test
    public void givenBoard_WhenPutTokenUnderBoundaryColumn_ThenAssertionError() {
        Board board = this.boardBuilder.createEmptyBoard();
        Assertions.assertThrows(AssertionError.class, () -> board.putToken(originColumn - 1, RED));
    }

    @Test
    public void givenBoard_WhenPutTokenOverBoundaryColumn_ThenAssertionError() {
        Board board = this.boardBuilder.createEmptyBoard();
        Assertions.assertThrows(AssertionError.class, () -> board.putToken(maxColumn + 1, RED));
    }


    @Test
    public void givenEmptyBoard_WhenStart_ThenIsEmpty() {
        Board board = this.boardBuilder.createEmptyBoard();
        assertThat(boardIsEmpty(board), is(true));
    }

    @Test void givenSomeBoard_WhenReset_ThenIsEmpty(){
        Board board = this.boardBuilder.createBoard(
                        "Y R RYY",
                        "YRRYYRR",
                        "YYRYRRY",
                        "RYRYRYR",
                        "RRYYRRY",
                        "RYRRYYR");
        board.reset();
        assertThat(boardIsEmpty(board), is(true));
    }

    private boolean boardIsEmpty(Board board){
        for (int i = 0; i < Coordinate.DIMENSION_ROW; i++)
            for (int j = 0; j < Coordinate.DIMENSION_COLUMN; j++)
                if(!board.isEmpty(new ConcreteCoordinate(i, j)))
                    return false;
        return true;
    }

    @Test
    public void givenBoard_WhenPut4DiagonalLineToken_ThenDiagonalConnect4() {
        Board board = this.boardBuilder.createBoard("       ",
                "       ",
                "       ",
                "  RY   ",
                " RYY   ",
                "RYYY   ");
        board.putToken(3, RED);
        assertThat(board.isConnect4(), is(true));
    }

    @Test
    public void givenBoard_WhenPutBackwardsDiagonal4LineToken_ThenConnect4() {
        Board board = this.boardBuilder.createBoard("       ",
                "       ",
                "       ",
                "  RY   ",
                " RYRY  ",
                "RYYYRY ");
        board.putToken(2, YELLOW);
        assertThat(board.isConnect4(), is(true));
    }

    @Test
    public void givenBoard_WhenPutVertical4LineToken_ThenConnect4() {
        Board board = this.boardBuilder.createBoard("       ",
                "       ",
                "       ",
                "  RY   ",
                " RYY   ",
                "RYYY   ");
        board.putToken(3, Color.YELLOW);
        assertThat(board.isConnect4(), is(true));
    }

    @Test
    public void givenBoard_WhenPut4HorizontalLineToken_ThenConnect4() {
        Board board = this.boardBuilder.createBoard("       ",
                "       ",
                "       ",
                "  RY   ",
                " RYY   ",
                "RYYY   ");
        board.putToken(4, Color.YELLOW);
        assertThat(board.isConnect4(), is(true));
    }

    @Test
    public void givenBoard_WhenNotPut4LineToken_ThenIsNotConnect4() {
        assertThat(this.boardBuilder.createBoard("       ",
                "       ",
                "RRY    ",
                "YYR YRR",
                "RRY RRY",
                "YYR YYY"
        ).isConnect4(), is(false));
    }

    @Test
    public void givenEmptyBoard_ThenIsNotConnect4(){
        assertThat(this.boardBuilder.createEmptyBoard().isConnect4(), is(false));
    }

}
