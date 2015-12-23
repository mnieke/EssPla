package org.nieke.esspla;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
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


    private static final String MEAL_MISSING = "?";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.ess_pla_week_widget);

        GregorianCalendar startDate = new GregorianCalendar();
        startDate.setFirstDayOfWeek(GregorianCalendar.MONDAY);
        startDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        GregorianCalendar endDate = new GregorianCalendar();
        endDate.setFirstDayOfWeek(GregorianCalendar.MONDAY);
        endDate.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

        DataHolder dataHolder = DataHolder.getInstance();
        EssPlaDataSource dataSource = new EssPlaDataSource(context);
        dataSource.open();
        dataHolder.setEntryList(dataSource.getAllEntries());

        // Entries for monday
        DatabaseEntry mondayBreakfastEntry = dataHolder.findEntryByCalendar(startDate, MealTime.BREAKFAST);
        DatabaseEntry mondayLunchEntry = dataHolder.findEntryByCalendar(startDate, MealTime.LUNCH);
        DatabaseEntry mondayDinnerEntry = dataHolder.findEntryByCalendar(startDate, MealTime.DINNER);

        // Entries for tuesday
        startDate.add(Calendar.DAY_OF_MONTH, 1);
        DatabaseEntry tuesdayBreakfastEntry = dataHolder.findEntryByCalendar(startDate, MealTime.BREAKFAST);
        DatabaseEntry tuesdayLunchEntry = dataHolder.findEntryByCalendar(startDate, MealTime.LUNCH);
        DatabaseEntry tuesdayDinnerEntry = dataHolder.findEntryByCalendar(startDate, MealTime.DINNER);

        // Entries for wednesday
        startDate.add(Calendar.DAY_OF_MONTH, 1);
        DatabaseEntry wednesdayBreakfastEntry = dataHolder.findEntryByCalendar(startDate, MealTime.BREAKFAST);
        DatabaseEntry wednesdayLunchEntry = dataHolder.findEntryByCalendar(startDate, MealTime.LUNCH);
        DatabaseEntry wednesdayDinnerEntry = dataHolder.findEntryByCalendar(startDate, MealTime.DINNER);

        // Entries for thursday
        startDate.add(Calendar.DAY_OF_MONTH, 1);
        DatabaseEntry thursdayBreakfastEntry = dataHolder.findEntryByCalendar(startDate, MealTime.BREAKFAST);
        DatabaseEntry thursdayLunchEntry = dataHolder.findEntryByCalendar(startDate, MealTime.LUNCH);
        DatabaseEntry thursdayDinnerEntry = dataHolder.findEntryByCalendar(startDate, MealTime.DINNER);

        // Entries for friday
        startDate.add(Calendar.DAY_OF_MONTH, 1);
        DatabaseEntry fridayBreakfastEntry = dataHolder.findEntryByCalendar(startDate, MealTime.BREAKFAST);
        DatabaseEntry fridayLunchEntry = dataHolder.findEntryByCalendar(startDate, MealTime.LUNCH);
        DatabaseEntry fridayDinnerEntry = dataHolder.findEntryByCalendar(startDate, MealTime.DINNER);

        // Entries for saturday
        startDate.add(Calendar.DAY_OF_MONTH, 1);
        DatabaseEntry saturdayBreakfastEntry = dataHolder.findEntryByCalendar(startDate, MealTime.BREAKFAST);
        DatabaseEntry saturdayLunchEntry = dataHolder.findEntryByCalendar(startDate, MealTime.LUNCH);
        DatabaseEntry saturdayDinnerEntry = dataHolder.findEntryByCalendar(startDate, MealTime.DINNER);

        // Entries for sunday
        startDate.add(Calendar.DAY_OF_MONTH, 1);
        DatabaseEntry sundayBreakfastEntry = dataHolder.findEntryByCalendar(startDate, MealTime.BREAKFAST);
        DatabaseEntry sundayLunchEntry = dataHolder.findEntryByCalendar(startDate, MealTime.LUNCH);
        DatabaseEntry sundayDinnerEntry = dataHolder.findEntryByCalendar(startDate, MealTime.DINNER);

         //Set meals

         //Images for monday
        setMealFromDatabaseEntry(views, mondayBreakfastEntry, R.id.text_view_week_widget_monday_breakfast);
        setMealFromDatabaseEntry(views, mondayBreakfastEntry, R.id.text_view_week_widget_monday_breakfast);
        setMealFromDatabaseEntry(views, mondayLunchEntry, R.id.text_view_week_widget_monday_lunch);
        setMealFromDatabaseEntry(views, mondayDinnerEntry, R.id.text_view_week_widget_monday_dinner);

        // Images for tuesday
        setMealFromDatabaseEntry(views, tuesdayBreakfastEntry, R.id.text_view_week_widget_tuesday_breakfast);
        setMealFromDatabaseEntry(views, tuesdayLunchEntry, R.id.text_view_week_widget_tuesday_lunch);
        setMealFromDatabaseEntry(views, tuesdayDinnerEntry, R.id.text_view_week_widget_tuesday_dinner);

        // Images for wednesday
        setMealFromDatabaseEntry(views, wednesdayBreakfastEntry, R.id.text_view_week_widget_wednesday_breakfast);
        setMealFromDatabaseEntry(views, wednesdayLunchEntry, R.id.text_view_week_widget_wednesday_lunch);
        setMealFromDatabaseEntry(views, wednesdayDinnerEntry, R.id.text_view_week_widget_wednesday_dinner);

        // Images for thursday
        setMealFromDatabaseEntry(views, thursdayBreakfastEntry, R.id.text_view_week_widget_thursday_breakfast);
        setMealFromDatabaseEntry(views, thursdayLunchEntry, R.id.text_view_week_widget_thursday_lunch);
        setMealFromDatabaseEntry(views, thursdayDinnerEntry, R.id.text_view_week_widget_thursday_dinner);

        // Images for friday
        setMealFromDatabaseEntry(views, fridayBreakfastEntry, R.id.text_view_week_widget_friday_breakfast);
        setMealFromDatabaseEntry(views, fridayLunchEntry, R.id.text_view_week_widget_friday_lunch);
        setMealFromDatabaseEntry(views, fridayDinnerEntry, R.id.text_view_week_widget_friday_dinner);

        // Images for saturday
        setMealFromDatabaseEntry(views, saturdayBreakfastEntry, R.id.text_view_week_widget_saturday_breakfast);
        setMealFromDatabaseEntry(views, saturdayLunchEntry, R.id.text_view_week_widget_saturday_lunch);
        setMealFromDatabaseEntry(views, saturdayDinnerEntry, R.id.text_view_week_widget_saturday_dinner);

        // Images for sunday
        setMealFromDatabaseEntry(views, sundayBreakfastEntry, R.id.text_view_week_widget_sunday_breakfast);
        setMealFromDatabaseEntry(views, sundayLunchEntry, R.id.text_view_week_widget_sunday_lunch);
        setMealFromDatabaseEntry(views, sundayDinnerEntry, R.id.text_view_week_widget_sunday_dinner);


        Intent configIntent = new Intent(context, EssPlaActivity.class);

        PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);

        views.setOnClickPendingIntent(R.id.relative_layout_week_widget, configPendingIntent);


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

