package org.nieke.esspla.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class EssPlaDataSource {

    private SQLiteDatabase database;
    private EssPlaSQLiteHelper dbHelper;
    private String[] allColumns = {EssPlaSQLiteHelper.COLUMN_ID,
            EssPlaSQLiteHelper.COLUMN_DATE, EssPlaSQLiteHelper.COLUMN_TIME, EssPlaSQLiteHelper.COLUMN_MEAL};

    private boolean opened;

    public EssPlaDataSource(Context context) {
        dbHelper = new EssPlaSQLiteHelper(context);
        opened = false;
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
        opened = true;
    }

    public void close() {
        dbHelper.close();
        opened = false;
    }

    public DatabaseEntry createEntry(GregorianCalendar calendar, MealTime time, String meal) {
        if (!opened)
            return null;


        String dateString = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);

        ContentValues values = new ContentValues();

        values.put(EssPlaSQLiteHelper.COLUMN_DATE, dateString);
        values.put(EssPlaSQLiteHelper.COLUMN_TIME, time.toString());
        values.put(EssPlaSQLiteHelper.COLUMN_MEAL, meal);

        long insertId = database.insert(EssPlaSQLiteHelper.TABLE_ESSPLA, null, values);
        Cursor cursor = database.query(EssPlaSQLiteHelper.TABLE_ESSPLA, allColumns, EssPlaSQLiteHelper.COLUMN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        DatabaseEntry newEntry = cursorToEntry(cursor);
        cursor.close();
        return newEntry;
    }

    public boolean deleteEntry(DatabaseEntry entry) {
        if (!opened)
            return false;

        long id = entry.getDatabaseID();
        System.out.println("DataBaseEntry deleted with id: " + id);
        database.delete(EssPlaSQLiteHelper.TABLE_ESSPLA, EssPlaSQLiteHelper.COLUMN_ID
                + " = " + id, null);
        return true;
    }

    public List<DatabaseEntry> getAllEntries() {
        if (!opened)
            return null;

        List<DatabaseEntry> entries = new ArrayList<DatabaseEntry>();

        Cursor cursor = database.query(EssPlaSQLiteHelper.TABLE_ESSPLA,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            DatabaseEntry entry = cursorToEntry(cursor);
            entries.add(entry);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return entries;
    }

    private DatabaseEntry cursorToEntry(Cursor cursor) {
        long id = cursor.getLong(0);
//            Date date = dateFormat.parse(dateString);
        GregorianCalendar calendar = parseDate(cursor.getString(1));
        MealTime time = MealTime.getTimeFromString(cursor.getString(2));
        String meal = cursor.getString(3);
        DatabaseEntry entry = new DatabaseEntry(id, calendar, time, meal);
        return entry;
    }

    private GregorianCalendar parseDate(String date) {
        String[] dateSplits = date.split("-");
        if (dateSplits.length != 3) {
            return null;
        }

        try {
            int year = Integer.parseInt(dateSplits[0]);
            int month = Integer.parseInt(dateSplits[1]);
            int day = Integer.parseInt(dateSplits[2]);

            GregorianCalendar calendar = new GregorianCalendar();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, day);

            return calendar;
        } catch (NumberFormatException numFormat) {
            numFormat.printStackTrace();
        }

        return null;
    }

    public void setMealForEntry(DatabaseEntry entry, String meal, MealTime time, GregorianCalendar calendar) {
        DataHolder dataHolder = DataHolder.getInstance();

        if(entry != null && !meal.equals(entry.getMeal())) {
            deleteEntry(entry);
            dataHolder.getEntryList().remove(entry);

            if(meal != "") {
                DatabaseEntry newEntry = createEntry(entry.getDate(), entry.getMealTime(), meal);

                if(newEntry != null) {
                    dataHolder.getEntryList().add(newEntry);
                }
            }


        } else if(entry == null && meal != "") {
            DatabaseEntry newEntry = createEntry(calendar, time, meal);

            if(newEntry != null) {
                dataHolder.getEntryList().add(newEntry);
            }
        }
    }
}
