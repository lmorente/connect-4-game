package connect4.models;

import connect4.types.Color;
import org.junit.jupiter.api.Test;
import connect4.types.Error;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PlayerTest {

    @Test
    public void givenPlayer_WhenPutTokenOnCompleteColumn_ThenError() {
        Board board = new BoardBuilder().createBoard("RYYRYYR",
                "YRRYYRR",
                "YYRYRRY",
                "RYRYRYR",
                "RRYYRRY",
                "RYRRYYR");
        Player player = new Player(Color.YELLOW, board);
        assertThat(player.getPutTokenError(1), is(Error.NOT_EMPTY));
    }

    @Test
    public void givenPlayer_WhenPutTokenOnColumn_ThenNoError() {
        Board board = new BoardBuilder().createBoard("       ",
                "YRRYYRR",
                "YYRYRRY",
                "RYRYRYR",
                "RRYYRRY",
                "RYRRYYR");
        Player player = new Player(Color.YELLOW, board);
        assertThat(player.getPutTokenError(5), is(Error.NULL));
    }

}