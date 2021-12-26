package connect4.models;

import connect4.types.Color;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import utils.models.ConcreteCoordinate;
import utils.models.Coordinate;
import connect4.types.Error;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.MockitoAnnotations.openMocks;

class SessionTest {

    @Mock
    private Game game;

    @Mock
    private Registry registry;

    @InjectMocks
    private Session session;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        verifyNoInteractions(this.game);
        verifyNoInteractions(this.registry);
    }

    @AfterEach
    public void afterEach() {
        verifyNoMoreInteractions(this.game);
        verifyNoMoreInteractions(this.registry);
    }

    @Test
    public void givenSession_WhenReset_ThenGameReset() {
        this.session.reset();
        verify(this.game).reset();
        verifyNoInteractions(this.registry);
    }

    @Test
    public void givenSession_WhenGetColor_ThenIsGameColor() {
        when(this.game.getColor(any())).thenReturn(Color.YELLOW);
        assertThat(this.session.getColor(new ConcreteCoordinate(0, 0)), is(Color.YELLOW));
        verify(this.game).getColor(new ConcreteCoordinate(0, 0));
        verifyNoInteractions(this.registry);
    }

    @Test
    public void givenSession_WhenIsConnect4_ThenGameIsConnect4() {
        when(this.game.isConnect4()).thenReturn(true);
        assertTrue(this.session.isConnect4());
        verify(this.game).isConnect4();
        verifyNoInteractions(this.registry);
    }

    @Test
    public void givenSession_WhenNext_ThenGameNext() {
        this.session.next();
        verify(this.game).next();
        verifyNoInteractions(this.registry);
    }

    @Test
    public void givenSession_WhenGetActiveColor_ThenIsGameActiveColor() {
        when(this.game.getActiveColor()).thenReturn(Color.YELLOW);
        assertThat(this.session.getActiveColor(), is(Color.YELLOW));
        verify(this.game).getActiveColor();
        verifyNoInteractions(this.registry);
    }

    @Test
    public void givenSession_WhenPutToken_ThenGamePutToken() {
        this.session.putToken(Coordinate.DIMENSION_COLUMN - 1);
        verify(this.game).putToken(Coordinate.DIMENSION_COLUMN - 1);
        verifyNoInteractions(this.registry);
    }

    @Test
    public void givenSession_WhenPutTokenError_ThenIsGamePutTokenError() {
        when(this.game.getPutTokenError(anyInt())).thenReturn(Error.NOT_EMPTY);
        assertThat(this.session.getPutTokenError(Coordinate.DIMENSION_COLUMN - 1), is(Error.NOT_EMPTY));
        verify(this.game).getPutTokenError(Coordinate.DIMENSION_COLUMN - 1);
        verifyNoInteractions(this.registry);
    }

    @Test
    public void givenSession_WhenUndo_ThenRegistryUndo() {
        this.session.undo();
        verify(this.registry).undo();
        verifyNoInteractions(this.game);
    }

    @Test
    public void testGivenSession_WhenRedo_ThenRegistryRedo() {
        this.session.redo();
        verify(this.registry).redo();
        verifyNoInteractions(this.game);
    }

    @Test
    public void testGivenSession_WhenRegister_ThenRegistryRegister() {
        this.session.register();
        verify(this.registry).register();
        verifyNoInteractions(this.game);
    }

    @Test
    public void GivenSession_WhenIsUndoable_ThenRegistryIsUndoable() {
        when(this.registry.isUndoable()).thenReturn(true);
        assertTrue(this.session.isUndoable());
        when(this.registry.isUndoable()).thenReturn(false);
        assertFalse(this.session.isUndoable());
        verify(this.registry, times(2)).isUndoable();
        verifyNoInteractions(this.game);
    }

    @Test
    public void GivenSession_WhenIsRedoable_ThenRegistryIsRedoable() {
        when(this.registry.isRedoable()).thenReturn(true);
        assertTrue(this.session.isRedoable());
        when(this.registry.isRedoable()).thenReturn(false);
        assertFalse(this.session.isRedoable());
        verify(this.registry, times(2)).isRedoable();
        verifyNoInteractions(this.game);
    }
}