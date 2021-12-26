package connect4.models;

import connect4.types.Color;
import connect4.types.Error;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import utils.models.ConcreteCoordinate;
import utils.models.Coordinate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.openMocks;

class GameTest {

    @Mock
    private Board board;
    @Mock
    private Turn turn;
    @InjectMocks
    private Game game;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        verifyNoInteractions(this.board);
        verifyNoInteractions(this.turn);
    }

    @AfterEach
    public void afterEach() {
        verifyNoMoreInteractions(this.board);
        verifyNoMoreInteractions(this.turn);
    }

    @Test
    public void givenGame_WhenReset_ThenBoardTurnReset() {
        this.game.reset();
        verify(this.board).reset();
        verify(this.turn).reset();
    }

    @Test
    public void givenGame_WhenGetActiveColor_ThenIsTurnActiveColor() {
        when(this.turn.getActiveColor()).thenReturn(Color.YELLOW);
        assertThat(this.game.getActiveColor(), is(Color.YELLOW));
        verify(this.turn).getActiveColor();
        verifyNoInteractions(this.board);
    }

    @Test
    public void givenGame_WhenIsConnect4_ThenBoardIsConnect4() {
        when(this.board.isConnect4()).thenReturn(true);
        assertTrue(this.game.isConnect4());
        //Objeto de debate: Lourdes quiere separarlo en dos casos de prueba y Luis no. Creo que se van a pegar. >>:((
        when(this.board.isConnect4()).thenReturn(false);
        assertFalse(this.game.isConnect4());
        verify(this.board, times(2)).isConnect4();
        verifyNoInteractions(this.turn);
    }

    @Test
    public void givenGame_WhenGetColor_ThenBoardGetColor() {
        when(this.board.getColor(any())).thenReturn(Color.YELLOW);
        assertThat(this.game.getColor(new ConcreteCoordinate(0, 0)), is(Color.YELLOW));
        verify(this.board).getColor(new ConcreteCoordinate(0, 0));
        verifyNoInteractions(this.turn);
    }

    @Test
    public void givenGame_WhenPutToken_ThenTurnPutToken() {
        this.game.putToken(Coordinate.DIMENSION_COLUMN - 1);
        verify(this.turn).putToken(Coordinate.DIMENSION_COLUMN - 1);
        verifyNoInteractions(this.board);
    }

    @Test
    public void givenGame_WhenPutTokenError_ThenIsTurnPutTokenError() {
        when(this.turn.getPutTokenError(anyInt())).thenReturn(Error.NOT_EMPTY);
        assertThat(this.game.getPutTokenError(Coordinate.DIMENSION_COLUMN - 1), is(Error.NOT_EMPTY));
        verify(this.turn).getPutTokenError(Coordinate.DIMENSION_COLUMN - 1);
        verifyNoInteractions(this.board);
    }

    @Test
    public void givenGame_WhenCreateMemento_ThenCreatesMemento() {
        when(this.turn.getActiveColor()).thenReturn(Color.RED);
        this.game.createBoardMemento();
        verify(this.board).clone();
        verify(this.turn).getActiveColor();
    }

    @Test
    public void givenGame_WhenSetMemento_ThenAssignMementoData() {
        BoardMemento memento = mock(BoardMemento.class);
        when(memento.getActivePlayer()).thenReturn(Color.YELLOW.ordinal());
        this.game.setMemento(memento);
        verify(memento).getBoard();
        verify(memento).getActivePlayer();
        verify(this.turn).setActivePlayer(Color.YELLOW.ordinal());
    }
}