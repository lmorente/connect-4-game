package connect4.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import utils.models.Coordinate;
import utils.views.Console;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

import org.mockito.MockedStatic;

class ConcreteBoardViewTest {

    private BoardViewBuilder boardViewBuilder;

    @Mock
    private Console console;

    @InjectMocks
    private ConcreteBoardView boardView;

    @BeforeEach
    public void setUp(){
        openMocks(this);
        this.boardViewBuilder = new BoardViewBuilder();
    }

    @Test
    public void givenBoardView_WhenShowBoard_ThenBoardIsPrinted() {
        this.boardViewBuilder.buildBoard(
                "Y      ",
                      " Y     ",
                      "  Y    ",
                      "   Y   ",
                      "RRRRYRR",
                      "RYYYYYY");
        this.boardView = (ConcreteBoardView) this.boardViewBuilder.getBoardView();

        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            ArgumentCaptor<String> consoleCaptor = ArgumentCaptor.forClass(String.class);
            this.boardView.write();

            verify(this.console, times(2)).writeln(consoleCaptor.capture());
            verify(this.console, times(Coordinate.DIMENSION_ROW + Coordinate.DIMENSION_ROW * Coordinate.DIMENSION_COLUMN * 2))
                    .write(consoleCaptor.capture());
            assertThat(this.captorToString(reorder(consoleCaptor.getAllValues())), is(this.boardViewBuilder.getPrintableBoard()));
        }
    }

    private List<String> reorder(List<String> list) {
        list.add(list.size() - 1, list.remove(1));
        return list;
    }

    private String captorToString(List<String> capturedList) {
        String concatenated = "";
        for (int i=0; i < capturedList.size(); i++){
            concatenated += capturedList.get(i);
        }
        return concatenated;
    }
}