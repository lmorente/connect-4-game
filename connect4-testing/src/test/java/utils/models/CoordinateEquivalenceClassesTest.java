package utils.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CoordinateEquivalenceClassesTest {

    private ConcreteCoordinate coordinate;
    private final int ROW = Coordinate.DIMENSION_ROW/2;
    private final int COLUMN = Coordinate.DIMENSION_COLUMN/2;

    private final int MAX_AMOUNT = (int) Math.sqrt(Math.pow(Coordinate.DIMENSION_ROW, 2) + Math.pow(Coordinate.DIMENSION_COLUMN, 2));
    private final int MIN_AMOUNT = 1;
    private final int NO_AMOUNT = 0;

    @BeforeEach
    public void setUp(){
        this.coordinate = new ConcreteCoordinate(ROW,COLUMN);
    }

    private void assertDirectionCoords(Direction direction, int amount){
        int distance = amount - 1;
        ConcreteCoordinate[] coords = this.coordinate.getInDirectionCoordinates(direction, amount);
        assertThat(coords[0].equals(this.coordinate), is(true));
        assertThat(coords[coords.length - 1].equals(
                new ConcreteCoordinate(ROW + direction.getRow() * distance, COLUMN + direction.getColumn() * distance)),
                is(true));
    }

    private void assertErrorWhenNO_AMOUNT(Direction direction){
        Assertions.assertThrows(AssertionError.class, () -> this.coordinate.getInDirectionCoordinates(direction, NO_AMOUNT));
    }

    @Test
    public void givenCoordinate_WhenWestDirection_ThenIsCorrect(){
        this.assertDirectionCoords(Direction.WEST, MAX_AMOUNT);
        this.assertDirectionCoords(Direction.WEST, MIN_AMOUNT);
        this.assertErrorWhenNO_AMOUNT(Direction.WEST);
    }

    @Test
    public void givenCoordinate_WhenEastDirection_ThenIsCorrect(){
        this.assertDirectionCoords(Direction.EAST, MAX_AMOUNT);
        this.assertDirectionCoords(Direction.EAST, MIN_AMOUNT);
        this.assertErrorWhenNO_AMOUNT(Direction.EAST);
    }

    @Test
    public void givenCoordinate_WhenNorthDirection_ThenIsCorrect(){
        this.assertDirectionCoords(Direction.NORTH, MAX_AMOUNT);
        this.assertDirectionCoords(Direction.NORTH, MIN_AMOUNT);
        this.assertErrorWhenNO_AMOUNT(Direction.NORTH);
    }

    @Test
    public void givenCoordinate_WhenSouthDirection_ThenIsCorrect(){
        this.assertDirectionCoords(Direction.SOUTH, MAX_AMOUNT);
        this.assertDirectionCoords(Direction.SOUTH, MIN_AMOUNT);
        this.assertErrorWhenNO_AMOUNT(Direction.SOUTH);
    }

    @Test
    public void givenCoordinate_WhenNorthEastDirection_ThenIsCorrect(){
        this.assertDirectionCoords(Direction.NORTH, MAX_AMOUNT);
        this.assertDirectionCoords(Direction.NORTH, MIN_AMOUNT);
        this.assertErrorWhenNO_AMOUNT(Direction.NORTH);
    }

    @Test
    public void givenCoordinate_WhenNorthWestDirection_ThenIsCorrect(){
        this.assertDirectionCoords(Direction.NORTH_WEST, MAX_AMOUNT);
        this.assertDirectionCoords(Direction.NORTH_WEST, MIN_AMOUNT);
        this.assertErrorWhenNO_AMOUNT(Direction.NORTH_WEST);
    }

    @Test
    public void givenCoordinate_WhenSouthWestDirection_ThenIsCorrect(){
        this.assertDirectionCoords(Direction.SOUTH_WEST, MAX_AMOUNT);
        this.assertDirectionCoords(Direction.SOUTH_WEST, MIN_AMOUNT);
        this.assertErrorWhenNO_AMOUNT(Direction.SOUTH_WEST);
    }

    @Test
    public void givenCoordinate_WhenSouthEastDirection_ThenIsCorrect(){
        this.assertDirectionCoords(Direction.SOUTH_EAST, MAX_AMOUNT);
        this.assertDirectionCoords(Direction.SOUTH_EAST, MIN_AMOUNT);
        this.assertErrorWhenNO_AMOUNT(Direction.SOUTH_EAST);
    }
}