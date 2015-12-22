package org.nieke.esspla.data;

/**
 * Created by Michael on 22.12.2015.
 */
public enum MealTime {

    BREAKFAST, LUNCH, DINNER;

    @Override
    public String toString() {
        switch (this) {
            case BREAKFAST:
                return "breakfast";
            case LUNCH:
                return "lunch";
            case DINNER:
                return "dinner";
            default:
                return "";
        }
    }

    public static MealTime getTimeFromString(String s) {
        if (s.equals(BREAKFAST.toString())) {
            return BREAKFAST;
        } else if (s.equals(LUNCH.toString())) {
            return LUNCH;
        } else if (s.equals(DINNER.toString())) {
            return DINNER;
        } else {
            return null;
        }
    }

}
