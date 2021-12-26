package passiveViewVersion.utils.models;

public interface Coordinate {

  int DIMENSION_ROW = 6;
  int DIMENSION_COLUMN = 7;

  Coordinate NULL = NullCoordinate.getInstance();

  boolean isNull();

  Coordinate[] getInDirectionCoordinates(Direction direction, int amount);

  Coordinate getInDirectionCoordinate(Direction direction);
}
