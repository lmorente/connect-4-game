package connect4.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RegistryTest {

    private RegistryBuilder registerBuilder;

    private final int COLUMN_1 = 1;
    private final int COLUMN_0 = 0;

    @BeforeEach
    public void beforeEach() {
        this.registerBuilder = new RegistryBuilder();
        this.registerBuilder.reset();
    }

    @Test
    public void givenEmptyBoard_WhenTryingUndo_ThenAssertionError() {
        assertThrows(AssertionError.class, () -> this.registerBuilder.makeUndo());
    }

    @Test
    public void givenEmptyBoard_WhenTryingRedo_ThenAssertionError(){
        assertThrows(AssertionError.class, () -> this.registerBuilder.makeRedo());
    }

    @Test
    public void givenGame_WhenPlaying_ThenUndoable() {
        this.registerBuilder.putToken(COLUMN_0);
        assertThat(this.registerBuilder.isUndoable(), is(true));
    }

    @Test
    public void givenGame_WhenUndo_ThenRedoable() {
        this.registerBuilder.putToken(COLUMN_1);
        this.registerBuilder.makeUndo();
        assertThat(this.registerBuilder.isRedoable(), is(true));
    }

    @Test
    public void givenGame_WhenUndoRedo_ThenisNotRedoable(){
        this.registerBuilder.putToken(COLUMN_1);
        this.registerBuilder.makeUndo();
        this.registerBuilder.makeRedo();
        assertThat(this.registerBuilder.isRedoable(), is(false));
    }

    @Test
    public void givenGame_WhenUndoingOnce_ThenNotUndoable() {
        this.registerBuilder.putToken(COLUMN_0);
        this.registerBuilder.makeUndo();
        assertThat(this.registerBuilder.isUndoable(), is(false));
    }

    @Test
    public void givenGame_WhenUndoingMultiple_ThenNotUndoable() {
        this.registerBuilder.putToken(COLUMN_0);
        this.registerBuilder.putToken(COLUMN_1);
        this.registerBuilder.putToken(COLUMN_0);
        this.registerBuilder.makeUndo(3);
        assertThat(this.registerBuilder.isUndoable(), is(false));
    }

    @Test
    public void givenGame_WhenUndoingMultiple_ThenRedoable() {
        this.registerBuilder.putToken(COLUMN_0);
        this.registerBuilder.putToken(COLUMN_1);
        this.registerBuilder.putToken(COLUMN_0);
        this.registerBuilder.makeUndo(3);
        this.registerBuilder.makeRedo(3);
        assertThat(this.registerBuilder.isRedoable(), is(false));
    }
}