package org.nieke.esspla.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by michi on 03.08.14.
 */
public class DataHolder {

    private static volatile DataHolder instance;

    private List<DatabaseEntry> entryList;

    private DataHolder() {
        entryList = new ArrayList<DatabaseEntry>();
    }

    public static DataHolder getInstance() {
        if (instance == null) {
            synchronized (DataHolder.class) {
                if (instance == null) {
                    instance = new DataHolder();
                }
            }
        }

        return instance;
    }


    public List<DatabaseEntry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<DatabaseEntry> entryList) {
        this.entryList = entryList;
    }

    /**
     * Searches the list of HuPlaEntries for an entry matching the date and time. May be null if not available
     *
     * @param year  Year which the entry should have
     * @param month month which the entry should have
     * @param day   Day which the entry should have
     * @param time  Time which the entry should have
     * @return The entry having the specified date and time. May be null if not available
     */
    public DatabaseEntry findEntryByDate(int year, int month, int day, MealTime time) {
        DatabaseEntry huPlaEntry = null;

        synchronized (entryList) {
            for (DatabaseEntry entry : entryList) {
                if (entry.equalDates(year, month, day) && entry.getMealTime().equals(time)) {
                    return entry;
                }
            }
        }

        return huPlaEntry;
    }

    public DatabaseEntry findEntryByCalendar(Calendar calendar, MealTime mealTime) {
        return findEntryByDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), mealTime);
    }
}
