package proxyVersion.connect4.types;

public enum Color {

    RED,
    YELLOW,
    NULL;

    public static Color get(int ordinal) {
        assert ordinal >= 0 && ordinal < Color.NULL.ordinal();

        return Color.values()[ordinal];
    }

    public static Color get(String colorName){
        return Color.valueOf(colorName);
    }

    public boolean isNull() {
        return this == Color.NULL;
    }
    
}
