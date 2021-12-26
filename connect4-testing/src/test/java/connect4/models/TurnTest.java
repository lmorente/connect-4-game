package connect4.models;

import connect4.types.Color;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class TurnTest {

    private Turn turn;

    @BeforeEach
    public void beforeEach(){
        this.turn = new Turn(new BoardBuilder().createEmptyBoard());
    }

    @Test
    public void givenTurn_WhenReset_ThenActivePlayerZero() {
        this.turn.next();
        this.turn.reset();
        assertThat(turn.getActivePlayer().getColor(), is(Color.RED));
    }

    @Test
    public void givenTurn_WhenNext_ThenActivePlayerOne() {
        this.turn.next();
        assertThat(turn.getActivePlayer().getColor(), is(Color.YELLOW));
    }

    @Test
    public void givenTurn_WhenDoubleNext_ThenActivePlayerZeroAgain() {
        this.turn.next();
        this.turn.next();
        assertThat(turn.getActivePlayer().getColor(), is(Color.RED));
    }

    @Test
    public void givenTurn_WhenReset_ThenActivePlayerColorZero() {
        this.turn.next();
        this.turn.reset();
        assertThat(turn.getActiveColor(), is(Color.values()[0]));
    }

    @Test
    public void givenTurn_WhenNext_ThenActivePlayerColorOne() {
        this.turn.next();
        assertThat(turn.getActiveColor(), is(Color.values()[1]));
    }

    @Test
    public void givenTurn_WhenDoubleNext_ThenActivePlayerColorZero() {
        this.turn.next();
        this.turn.next();
        assertThat(turn.getActiveColor(), is(Color.values()[0]));
    }
}