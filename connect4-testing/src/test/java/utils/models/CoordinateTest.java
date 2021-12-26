package utils.models;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CoordinateTest {

    private ConcreteCoordinate middleCoordinate;
    private ConcreteCoordinate originCoordinate;
    private ConcreteCoordinate maxCoordinate;

    @BeforeEach
    public void setUp(){
        this.middleCoordinate = new ConcreteCoordinate(Coordinate.DIMENSION_ROW/2,Coordinate.DIMENSION_COLUMN/2);
        this.originCoordinate = new ConcreteCoordinate(0,0);
        this.maxCoordinate = new ConcreteCoordinate(Coordinate.DIMENSION_ROW - 1, Coordinate.DIMENSION_COLUMN - 1);
    }

    @Test
    public void givenCoordinate_WhenAskingForHorizontalDirectionWest_ThenDirectionIsCorrect() {
        ConcreteCoordinate coord = this.middleCoordinate.getInDirectionCoordinate(Direction.WEST);
        assertThat(coord.getRow(), is(this.middleCoordinate.getRow()));
        assertThat(coord.getColumn(), is(this.middleCoordinate.getColumn() - 1));
    }

    @Test
    public void givenCoordinate_WhenAskingForHorizontalDirectionEast_ThenDirectionIsCorrect() {
        ConcreteCoordinate coord = this.middleCoordinate.getInDirectionCoordinate(Direction.EAST);
        assertThat(coord.getRow(), is(this.middleCoordinate.getRow()));
        assertThat(coord.getColumn(), is(this.middleCoordinate.getColumn() + 1));
    }

    @Test
    public void givenCoordinate_WhenAskingForHorizontalDirectionNorth_ThenDirectionIsCorrect() {
        ConcreteCoordinate coord = this.middleCoordinate.getInDirectionCoordinate(Direction.NORTH);
        assertThat(coord.getRow(), is(this.middleCoordinate.getRow() + 1));
        assertThat(coord.getColumn(), is(this.middleCoordinate.getColumn()));
    }

    @Test
    public void givenCoordinate_WhenAskingForHorizontalDirectionSouth_ThenDirectionIsCorrect() {
        ConcreteCoordinate coord = this.middleCoordinate.getInDirectionCoordinate(Direction.SOUTH);
        assertThat(coord.getRow(), is(this.middleCoordinate.getRow() - 1));
        assertThat(coord.getColumn(), is(this.middleCoordinate.getColumn()));
    }

    @Test
    public void givenCoordinate_WhenAskingForHorizontalDirectionNorthEast_ThenDirectionIsCorrect() {
        ConcreteCoordinate coord = this.middleCoordinate.getInDirectionCoordinate(Direction.NORTH_EAST);
        assertThat(coord.getRow(), is(this.middleCoordinate.getRow() + 1));
        assertThat(coord.getColumn(), is(this.middleCoordinate.getColumn() + 1));
    }

    @Test
    public void givenCoordinate_WhenAskingForHorizontalDirectionNorthWest_ThenDirectionIsCorrect() {
        ConcreteCoordinate coord = this.middleCoordinate.getInDirectionCoordinate(Direction.NORTH_WEST);
        assertThat(coord.getRow(), is(this.middleCoordinate.getRow() + 1));
        assertThat(coord.getColumn(), is(this.middleCoordinate.getColumn() - 1));
    }

    @Test
    public void givenCoordinate_WhenAskingForHorizontalDirectionSouthEast_ThenDirectionIsCorrect() {
        ConcreteCoordinate coord = this.middleCoordinate.getInDirectionCoordinate(Direction.SOUTH_EAST);
        assertThat(coord.getRow(), is(this.middleCoordinate.getRow() - 1));
        assertThat(coord.getColumn(), is(this.middleCoordinate.getColumn() + 1));
    }

    @Test
    public void givenCoordinate_WhenAskingForHorizontalDirectionSouthWest_ThenDirectionIsCorrect() {
        ConcreteCoordinate coord = this.middleCoordinate.getInDirectionCoordinate(Direction.SOUTH_WEST);
        assertThat(coord.getRow(), is(this.middleCoordinate.getRow() - 1));
        assertThat(coord.getColumn(), is(this.middleCoordinate.getColumn() - 1));
    }

    @Test
    public void givenCoordinate_WhenAskingForNegativeBoundsDirection_ThenCorrect() {
        ConcreteCoordinate coord = this.originCoordinate.getInDirectionCoordinate(Direction.SOUTH_WEST);
        assertThat(coord.getRow(), is(- 1));
        assertThat(coord.getColumn(), is(- 1));
    }

    @Test
    public void givenCoordinate_WhenAskingForOverMaxBoundsDirection_ThenCorrect() {
        ConcreteCoordinate coord = this.maxCoordinate.getInDirectionCoordinate(Direction.NORTH_EAST);
        assertThat(coord.getRow(), is(Coordinate.DIMENSION_ROW));
        assertThat(coord.getColumn(), is(Coordinate.DIMENSION_COLUMN));
    }
}