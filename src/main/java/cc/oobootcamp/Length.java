package cc.oobootcamp;

public class Length {

    private int value;

    public Length(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    String compare(Length targetLength) {
        int targetValue = targetLength.value;

        if (this.value > targetValue) {
            return String.format("%s is larger then %s", value, targetValue);
        } else if (this.value < targetValue) {
            return String.format("%s is shorter then %s", value, targetValue);
        } else {
            return "we are same!";
        }
    }
}
