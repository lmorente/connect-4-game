package models.game;

public class Coordinate {

    private int[] coordinate;

    public Coordinate(int row, int column) {
        this.coordinate = new int[]{row, column};
    }

    public Coordinate create(Integer row, int column) {
        return new Coordinate(row, column);
    }
}
