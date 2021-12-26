package proxyVersion.utils.models;

public interface Coordinate {
  
  Coordinate NULL = NullCoordinate.getInstance();
  boolean isNull();
  Coordinate[] getInDirectionCoordinates(Direction direction, int amount);
  Coordinate getInDirectionCoordinate(Direction direction);
}
