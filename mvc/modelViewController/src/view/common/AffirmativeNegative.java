package view.common;

public enum AffirmativeNegative {

    YES("yes"),
    NO("no");

    private final String value;

    AffirmativeNegative(String value) {
        this.value = value;
    }

    public static boolean checkAffirmative(String response) {
        return  (AffirmativeNegative.YES.value).equals(response);
    }
}
