package utils.models;

public class NullCoordinate implements Coordinate {

    private static NullCoordinate instance;

    static Coordinate getInstance() {
        if (NullCoordinate.instance == null) {
            NullCoordinate.instance = new NullCoordinate();
        }
        return NullCoordinate.instance;
    }

    public NullCoordinate() {
    }

    @Override
    public boolean isNull() {
        return true;
    }


    @Override
    public String toString() {
        return "Coordinate (NULL)";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public Coordinate[] getInDirectionCoordinates(Direction direction, int amount) {
        return null;
    }

    @Override
    public Coordinate getInDirectionCoordinate(Direction direction) {
        return null;
    }
}
