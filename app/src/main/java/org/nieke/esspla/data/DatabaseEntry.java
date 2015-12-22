package org.nieke.esspla.data;

import java.util.GregorianCalendar;

/**
 * Created by michi on 04.08.14.
 */
public class DatabaseEntry {

    private String mealString;
    private MealTime mealTime;
    private long databaseID;
    private GregorianCalendar date;


    protected DatabaseEntry(long databaseID, GregorianCalendar date, MealTime mealTime, String mealString) {
        this.date = date;
        this.mealString = mealString;
        this.mealTime = mealTime;
        this.databaseID = databaseID;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        if (date != null)
            this.date = date;
    }

    public String getMeal() {
        return mealString;
    }

    public void setMeal(String mealString) {
        if (mealString != null)
            this.mealString = mealString;
    }

    public MealTime getMealTime() {
        return mealTime;
    }

    public void setMealTime(MealTime mealTime) {
        if (mealTime != null)
            this.mealTime = mealTime;
    }

    public long getDatabaseID() {
        return databaseID;
    }

    public void setDatabaseID(long databaseID) {
        this.databaseID = databaseID;
    }

    public boolean equalDates(int year, int month, int day) {
        if (date == null) {
            return false;
        }

        if (year == this.date.get(GregorianCalendar.YEAR) && day == this.date.get(GregorianCalendar.DAY_OF_MONTH) && month == this.date.get(GregorianCalendar.MONTH)) {
            return true;
        }

        return false;
    }
}
