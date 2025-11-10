package data.models;

public enum Offense {
    ONE_WAY(2000),
    DRUNK_DRIVING(50000),
    NO_SEAT_BELT(5000),
    OVER_SPEEDING(10000),
    ;

    private int fineAmount;

    Offense(int fineAmount) {
        this.fineAmount = fineAmount;
    }


    public int getFineAmount() {
        return fineAmount;
    }

    public String getName() {
        String lower = name().toLowerCase().replace("_", " ");
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }

}
