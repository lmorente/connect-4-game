package main.connect4.models;

import static org.junit.jupiter.api.Assertions.*;

import main.connect4.types.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegistryTest {

    private RegistryAuxiliar registryAuxiliar;

    @BeforeEach
    public void setUp() {
        this.registryAuxiliar = new RegistryAuxiliar();
    }

    @Test
    public void givenEmptyRegistry_WhenRegisterOnce_ThenOne() {
        this.registryAuxiliar.register();
        assert (this.registryAuxiliar.getBoardMementos().size() == 1);
    }

    @Test
    public void givenEmptyRegistry_WhenRegisterOnce_ThenObjectIsOfTypeBoard() {
        this.registryAuxiliar.register();
        assert (this.registryAuxiliar.getBoardMementos().get(0) instanceof BoardMemento);
    }

    @Test
    public void givenEmptyRegistry_WhenRegisterTwice_ThenObject1IsOfTypeBoard() {
        this.registryAuxiliar.register(2);
        assert (this.registryAuxiliar.getBoardMementos().size() == 2);
    }

    @Test
    public void givenRegistry_WhenUndo_ThenMoveOneStateBackwards() {
        this.registryAuxiliar.register(2);
        this.registryAuxiliar.makeUndo();
        assert (this.registryAuxiliar.getPrevious() == 1);
    }

    @Test
    public void givenRegistry_WhenUndoTwice_ThenPreviousIs2() {
        this.registryAuxiliar.register(3);
        this.registryAuxiliar.makeUndo(2);
        assert (this.registryAuxiliar.getPrevious() == 2);
    }

    @Test
    public void givenUndoneRegistry_WhenRedo_ThenMoveOneForward() {
        this.registryAuxiliar.register(4);
        this.registryAuxiliar.makeUndo();
        this.registryAuxiliar.makeRedo();
        assert (this.registryAuxiliar.getPrevious() == 0);
    }

    @Test
    public void givenRegistry_WhenRedoWithoutUndoInFirstPlace_ThenAssertError() {
        this.registryAuxiliar.register(2);
        assertThrows(AssertionError.class, () -> this.registryAuxiliar.makeRedo());
    }

    @Test
    public void givenEmptyRegistry_WhenUndoWithoutRegister_ThenAssertError() {
        assertThrows(AssertionError.class, () -> this.registryAuxiliar.makeUndo());
    }

    @Test
    public void givenRegistry_WhenReset_ThenRegistryDataResets() {
        this.registryAuxiliar.register(3);
        this.registryAuxiliar.makeUndo();
        this.registryAuxiliar.makeRedo();
        this.registryAuxiliar.reset();
        assert (this.registryAuxiliar.getPrevious() == 0);
        assert (this.registryAuxiliar.getBoardMementos().size() == 0);
    }

    @Test
    public void givenGame_WhenUndoToEmptyGame_ThenGameIsEmpty() {
        this.registryAuxiliar.register();
        this.registryAuxiliar.registerPutToken(0);
        this.registryAuxiliar.makeUndo();
        assertTrue(((GameTestAuxiliar) this.registryAuxiliar.getGame()).isColumnEmpty(0));
    }

    @Test
    public void givenGame_WhenUndoToPreviousState_ThenGameRestoresState() {
        this.registryAuxiliar.register();
        this.registryAuxiliar.registerPutToken(0);
        this.registryAuxiliar.registerPutToken(1);
        this.registryAuxiliar.makeUndo();
        assertTrue(((GameTestAuxiliar) this.registryAuxiliar.getGame()).isColumnEmpty(1));
        assertFalse(((GameTestAuxiliar) this.registryAuxiliar.getGame()).isColumnEmpty(0));
    }

    @Test
    public void givenGame_WhenUndoThenRedo_ThenGameRestoreFully() {
        this.registryAuxiliar.registerPutToken(0);
        this.registryAuxiliar.registerPutToken(1);
        this.registryAuxiliar.makeUndo();
        this.registryAuxiliar.makeRedo();
        assertFalse(((GameTestAuxiliar) this.registryAuxiliar.getGame()).isColumnEmpty(1));
        assertFalse(((GameTestAuxiliar) this.registryAuxiliar.getGame()).isColumnEmpty(0));
    }

    @Test
    public void givenGame_WhenMultipleUndoAndPutToken_ThenUndoesCorrectly() {
        this.registryAuxiliar.register();
        this.registryAuxiliar.registerPutToken(0);
        this.registryAuxiliar.makeUndo();
        assertTrue(((GameTestAuxiliar) this.registryAuxiliar.getGame()).isColumnEmpty(0));
    }

    @Test
    public void givenGame_WhenPutToken_ThenTurnChanges() {
        this.registryAuxiliar.registerPutToken(0);
        assertEquals(Color.get(1), this.registryAuxiliar.getActiveColor());
    }

    @Test
    public void givenGame_WhenMultiplePutToken_ThenTurnChanges() {
        this.registryAuxiliar.registerPutToken(0);
        this.registryAuxiliar.registerPutToken(1);
        assertEquals(Color.get(0), this.registryAuxiliar.getActiveColor());
    }

    @Test
    public void givenGame_WhenUndoRedo_ThenTurnIsRetrieved(){
        this.registryAuxiliar.registerPutToken(0);
        this.registryAuxiliar.registerPutToken(0);
        this.registryAuxiliar.makeUndo();
        assertEquals(Color.get(1), this.registryAuxiliar.getActiveColor());

        this.registryAuxiliar.makeRedo();
        assertEquals(Color.get(0), this.registryAuxiliar.getActiveColor());
    }
}