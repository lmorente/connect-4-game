package passiveViewVersion.connect4.views.console;

import passiveViewVersion.connect4.views.CoordinateView;
import passiveViewVersion.connect4.views.Message;
import passiveViewVersion.utils.models.Coordinate;
import passiveViewVersion.utils.views.BoundedIntDialog;

public class ConcreteCoordinateView implements CoordinateView {

    @Override
    public int readColumn() {
        return new BoundedIntDialog(0, Coordinate.DIMENSION_COLUMN - 1).read(Message.ENTER_COLUMN_TO_PUT.name());
    }

}
