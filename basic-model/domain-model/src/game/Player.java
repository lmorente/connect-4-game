package game;

public class Player {

    private final String name;
    private final String piece;
    private boolean isActive;

    public Player(String name, String piece) {
        this.name = name;
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public String getPiece() {
        return piece;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}