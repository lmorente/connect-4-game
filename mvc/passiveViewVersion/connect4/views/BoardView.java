package passiveViewVersion.connect4.views;

import passiveViewVersion.connect4.types.Color;
import passiveViewVersion.utils.models.Coordinate;

import java.util.ArrayList;
import java.util.List;

public abstract class BoardView {

    protected List<Color> colors;

    public BoardView() {
        this.colors = new ArrayList<>();
    }

    public void set(Color color) {
        assert this.colors.size() < Coordinate.DIMENSION_COLUMN * Coordinate.DIMENSION_ROW;
        this.colors.add(color);
    }

    public abstract void write();
}
