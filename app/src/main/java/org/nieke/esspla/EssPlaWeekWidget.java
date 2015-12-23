package org.nieke.esspla;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.graphics.Color;
import android.widget.RemoteViews;

import org.nieke.esspla.data.DataHolder;
import org.nieke.esspla.data.DatabaseEntry;
import org.nieke.esspla.data.EssPlaDataSource;
import org.nieke.esspla.data.MealTime;
import org.nieke.esspla.R;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Implementation of App Widget functionality.
 */
public class EssPlaWeekWidget extends AppWidgetProvider {


    private static final String MEAL_MISSING = "Meal missing!";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.ess_pla_week_widget);

//        GregorianCalendar startDate = new GregorianCalendar();
//        startDate.setFirstDayOfWeek(GregorianCalendar.MONDAY);
//        startDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//        GregorianCalendar endDate = new GregorianCalendar();
//        endDate.setFirstDayOfWeek(GregorianCalendar.MONDAY);
//        endDate.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
//
//        DataHolder dataHolder = DataHolder.getInstance();
//        EssPlaDataSource dataSource = new EssPlaDataSource(context);
//        dataSource.open();
//        dataHolder.setEntryList(dataSource.getAllEntries());
//
//        views.setTextViewText(R.id.text_view_week_widget_date, "Essensplan for: " + startDate.get(Calendar.DAY_OF_MONTH) + "." + (startDate.get(Calendar.MONTH) + 1) + "." + startDate.get(Calendar.YEAR) + " - " + endDate.get(Calendar.DAY_OF_MONTH) + "." + (endDate.get(Calendar.MONTH) + 1) + "." + endDate.get(Calendar.YEAR));
//
//        // Entries for monday
//        DatabaseEntry mondayBreakfastEntry = dataHolder.findEntryByCalendar(startDate, MealTime.BREAKFAST);
//        DatabaseEntry mondayLunchEntry = dataHolder.findEntryByCalendar(startDate, MealTime.LUNCH);
//        DatabaseEntry mondayDinnerEntry = dataHolder.findEntryByCalendar(startDate, MealTime.DINNER);
//
//        // Entries for tuesday
//        startDate.add(Calendar.DAY_OF_MONTH, 1);
//        DatabaseEntry tuesdayBreakfastEntry = dataHolder.findEntryByCalendar(startDate, MealTime.BREAKFAST);
//        DatabaseEntry tuesdayLunchEntry = dataHolder.findEntryByCalendar(startDate, MealTime.LUNCH);
//        DatabaseEntry tuesdayDinnerEntry = dataHolder.findEntryByCalendar(startDate, MealTime.DINNER);
//
//        // Entries for wednesday
//        startDate.add(Calendar.DAY_OF_MONTH, 1);
//        DatabaseEntry wednesdayBreakfastEntry = dataHolder.findEntryByCalendar(startDate, MealTime.BREAKFAST);
//        DatabaseEntry wednesdayLunchEntry = dataHolder.findEntryByCalendar(startDate, MealTime.LUNCH);
//        DatabaseEntry wednesdayDinnerEntry = dataHolder.findEntryByCalendar(startDate, MealTime.DINNER);
//
//        // Entries for thursday
//        startDate.add(Calendar.DAY_OF_MONTH, 1);
//        DatabaseEntry thursdayBreakfastEntry = dataHolder.findEntryByCalendar(startDate, MealTime.BREAKFAST);
//        DatabaseEntry thursdayLunchEntry = dataHolder.findEntryByCalendar(startDate, MealTime.LUNCH);
//        DatabaseEntry thursdayDinnerEntry = dataHolder.findEntryByCalendar(startDate, MealTime.DINNER);
//
//        // Entries for friday
//        startDate.add(Calendar.DAY_OF_MONTH, 1);
//        DatabaseEntry fridayBreakfastEntry = dataHolder.findEntryByCalendar(startDate, MealTime.BREAKFAST);
//        DatabaseEntry fridayLunchEntry = dataHolder.findEntryByCalendar(startDate, MealTime.LUNCH);
//        DatabaseEntry fridayDinnerEntry = dataHolder.findEntryByCalendar(startDate, MealTime.DINNER);
//
//        // Entries for saturday
//        startDate.add(Calendar.DAY_OF_MONTH, 1);
//        DatabaseEntry saturdayBreakfastEntry = dataHolder.findEntryByCalendar(startDate, MealTime.BREAKFAST);
//        DatabaseEntry saturdayLunchEntry = dataHolder.findEntryByCalendar(startDate, MealTime.LUNCH);
//        DatabaseEntry saturdayDinnerEntry = dataHolder.findEntryByCalendar(startDate, MealTime.DINNER);
//
//        // Entries for sunday
//        startDate.add(Calendar.DAY_OF_MONTH, 1);
//        DatabaseEntry sundayBreakfastEntry = dataHolder.findEntryByCalendar(startDate, MealTime.BREAKFAST);
//        DatabaseEntry sundayLunchEntry = dataHolder.findEntryByCalendar(startDate, MealTime.LUNCH);
//        DatabaseEntry sundayDinnerEntry = dataHolder.findEntryByCalendar(startDate, MealTime.DINNER);

        // Set meals

        // Images for monday
//        setMealFromDatabaseEntry(views, mondayBreakfastEntry, R.id.text_view_week_widget_monday_breakfast);
//        setMealFromDatabaseEntry(views, mondayBreakfastEntry, R.id.image_view_week_widget_monday_morning);
//        setMealFromDatabaseEntry(views, mondayLunchEntry, R.id.image_view_week_widget_monday_noon);
//        setMealFromDatabaseEntry(views, mondayDinnerEntry, R.id.image_view_week_widget_monday_evening);
//
//        // Images for tuesday
//        setMealFromDatabaseEntry(views, tuesdayBreakfastEntry, R.id.image_view_week_widget_tuesday_morning);
//        setMealFromDatabaseEntry(views, tuesdayLunchEntry, R.id.image_view_week_widget_tuesday_noon);
//        setMealFromDatabaseEntry(views, tuesdayDinnerEntry, R.id.image_view_week_widget_tuesday_evening);
//
//        // Images for wednesday
//        setMealFromDatabaseEntry(views, wednesdayBreakfastEntry, R.id.image_view_week_widget_wednesday_morning);
//        setMealFromDatabaseEntry(views, wednesdayLunchEntry, R.id.image_view_week_widget_wednesday_noon);
//        setMealFromDatabaseEntry(views, wednesdayDinnerEntry, R.id.image_view_week_widget_wednesday_evening);
//
//        // Images for thursday
//        setMealFromDatabaseEntry(views, thursdayBreakfastEntry, R.id.image_view_week_widget_thursday_morning);
//        setMealFromDatabaseEntry(views, thursdayLunchEntry, R.id.image_view_week_widget_thursday_noon);
//        setMealFromDatabaseEntry(views, thursdayDinnerEntry, R.id.image_view_week_widget_thursday_evening);
//
//        // Images for friday
//        setMealFromDatabaseEntry(views, fridayBreakfastEntry, R.id.image_view_week_widget_friday_morning);
//        setMealFromDatabaseEntry(views, fridayLunchEntry, R.id.image_view_week_widget_friday_noon);
//        setMealFromDatabaseEntry(views, fridayDinnerEntry, R.id.image_view_week_widget_friday_evening);
//
//        // Images for saturday
//        setMealFromDatabaseEntry(views, saturdayBreakfastEntry, R.id.image_view_week_widget_saturday_morning);
//        setMealFromDatabaseEntry(views, saturdayLunchEntry, R.id.image_view_week_widget_saturday_noon);
//        setMealFromDatabaseEntry(views, saturdayDinnerEntry, R.id.image_view_week_widget_saturday_evening);
//
//        // Images for sunday
//        setMealFromDatabaseEntry(views, sundayBreakfastEntry, R.id.image_view_week_widget_sunday_morning);
//        setMealFromDatabaseEntry(views, sundayLunchEntry, R.id.image_view_week_widget_sunday_noon);
//        setMealFromDatabaseEntry(views, sundayDinnerEntry, R.id.image_view_week_widget_sunday_evening);



        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        final int N = appWidgetIds.length;
        for (int i=0; i<N; i++) {
            updateAppWidget(context, appWidgetManager, appWidgetIds[i]);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    private static void setMealFromDatabaseEntry(RemoteViews views, DatabaseEntry entry, int textViewId) {
        if(entry != null) {
            views.setTextViewText(textViewId, entry.getMeal());
            views.setTextColor(textViewId, Color.BLACK);
        }else {
            views.setTextViewText(textViewId, MEAL_MISSING);
            views.setTextColor(textViewId, Color.RED);
        }
    }
}

