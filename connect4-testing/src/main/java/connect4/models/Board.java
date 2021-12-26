package connect4.models;

import connect4.types.Color;
import utils.models.ConcreteCoordinate;
import utils.models.Coordinate;
import utils.models.Direction;
import utils.models.NullCoordinate;

public class Board {

    public static final int ROWS = Coordinate.DIMENSION_ROW;
    public static final int COLUMNS = Coordinate.DIMENSION_COLUMN;

    private Color[][] colors;

    Board() {
        this.colors = new Color[Board.ROWS][Board.COLUMNS];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    void putToken(int column, Color color) {
        assert column > 0 && column < COLUMNS;
        Coordinate coordinate =  this.getEmptyCoordinate(column);
        assert !coordinate.isNull();
        ConcreteCoordinate concreteCoordinate = (ConcreteCoordinate) coordinate;
        this.colors[concreteCoordinate.getRow()][concreteCoordinate.getColumn()] = color;
    }

    Coordinate getEmptyCoordinate(int column) {
        ConcreteCoordinate current = new ConcreteCoordinate(Board.ROWS-1, column);
        if (!this.isEmpty(current)) {
            return new NullCoordinate();
        }
        ConcreteCoordinate previous;
        do {
            previous = current;
            current = current.getInDirectionCoordinate(Direction.SOUTH);
        } while (isValid(current) && this.isEmpty(current));
        return previous;
    }

    private boolean isValid(ConcreteCoordinate coordinate) {
        return 0 <= coordinate.getRow() && coordinate.getRow() < Board.ROWS
                && 0 <= coordinate.getColumn() && coordinate.getColumn() < Board.COLUMNS;
    }

    boolean thereIsEmpty(int column) {
        return !this.getEmptyCoordinate(column).isNull();
    }

    boolean isEmpty(ConcreteCoordinate coordinate) {
        return this.getColor(coordinate) == Color.NULL;
    }

    Color getColor(ConcreteCoordinate coordinate) {
        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    boolean isOccupied(ConcreteCoordinate coordinate, Color color) {
        return this.getColor(coordinate) == color;
    }

    boolean isConnect4() {
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                if (this.isConnect4(new ConcreteCoordinate(i, j))) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isConnect4(ConcreteCoordinate coordinate) {
        for (Direction direction : new Direction[] { Direction.EAST, Direction.SOUTH_EAST, Direction.SOUTH, Direction.SOUTH_WEST }) {
            if (this.isConnect4(coordinate, direction)) {
                return true;
            }
        }
        return false;
    }

    boolean isConnect4(ConcreteCoordinate coordinate, Direction direction) {
        assert !direction.isNull();
        assert this.isValid(coordinate);

        ConcreteCoordinate[] coordinates = coordinate.getInDirectionCoordinates(direction, 4);
         for (int i = 0; i < coordinates.length - 1; i++) {
            if (!this.isValid(coordinates[i+1]) || this.getColor(coordinates[i]) != this.getColor(coordinates[i + 1])) {
                return false;
            }
        }
        return this.getColor(coordinates[0]) != Color.NULL;
    }

    public Board clone(){
        Board boardCloned = new Board();
        for(int i=0; i<Board.ROWS; i++){
            for(int j=0; j<Board.COLUMNS; j++){
                boardCloned.putToken(j,this.colors[i][j]);
            }
        }
        return boardCloned;
    }

}
