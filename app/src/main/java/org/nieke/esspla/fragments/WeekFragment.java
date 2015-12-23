package org.nieke.esspla.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import org.nieke.esspla.PopupMealListener;
import org.nieke.esspla.PopupWindowHandler;
import org.nieke.esspla.R;
import org.nieke.esspla.data.DataHolder;
import org.nieke.esspla.data.DatabaseEntry;
import org.nieke.esspla.data.EssPlaDataSource;
import org.nieke.esspla.data.MealTime;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WeekFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WeekFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeekFragment extends Fragment implements View.OnClickListener, PopupMealListener, PopupWindow.OnDismissListener {

    private View rootView;

    private Button buttonCurrentWeek;

    private OnFragmentInteractionListener mListener;

    private GregorianCalendar startDate;
    private GregorianCalendar endDate;

    private TextView textViewMondayBreakfast;
    private TextView textViewMondayLunch;
    private TextView textViewMondayDinner;
    private TextView textViewTuesdayBreakfast;
    private TextView textViewTuesdayLunch;
    private TextView textViewTuesdayDinner;
    private TextView textViewWednesdayBreakfast;
    private TextView textViewWednesdayLunch;
    private TextView textViewWednesdayDinner;
    private TextView textViewThursdayBreakfast;
    private TextView textViewThursdayLunch;
    private TextView textViewThursdayDinner;
    private TextView textViewFridayBreakfast;
    private TextView textViewFridayLunch;
    private TextView textViewFridayDinner;
    private TextView textViewSaturdayBreakfast;
    private TextView textViewSaturdayLunch;
    private TextView textViewSaturdayDinner;
    private TextView textViewSundayBreakfast;
    private TextView textViewSundayLunch;
    private TextView textViewSundayDinner;

    private List<TextView> textViews;

    private View buttonSelected;

    protected boolean isPopupOpened = false;
    protected PopupWindow popupWindow;

    public WeekFragment() {
        textViews = new ArrayList<TextView>();
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment WeekFragment.
     */
    public static WeekFragment newInstance() {
        WeekFragment fragment = new WeekFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_week, container, false);
        buttonCurrentWeek = (Button) rootView.findViewById(R.id.button_current_week);
        buttonCurrentWeek.setOnClickListener(this);

        ((ImageButton) rootView.findViewById(R.id.image_button_next_week)).setOnClickListener(this);
        ((ImageButton) rootView.findViewById(R.id.image_button_previous_week)).setOnClickListener(this);


        textViewMondayBreakfast = (TextView) rootView.findViewById(R.id.text_view_mon_breakfast);
        textViews.add(textViewMondayBreakfast);
        textViewMondayLunch = (TextView) rootView.findViewById(R.id.text_view_mon_lunch);
        textViews.add(textViewMondayLunch);
        textViewMondayDinner = (TextView) rootView.findViewById(R.id.text_view_mon_dinner);
        textViews.add(textViewMondayDinner);

        textViewTuesdayBreakfast = (TextView) rootView.findViewById(R.id.text_view_tue_breakfast);
        textViews.add(textViewTuesdayBreakfast);
        textViewTuesdayLunch = (TextView) rootView.findViewById(R.id.text_view_tue_lunch);
        textViews.add(textViewTuesdayLunch);
        textViewTuesdayDinner = (TextView) rootView.findViewById(R.id.text_view_tue_dinner);
        textViews.add(textViewTuesdayDinner);

        textViewWednesdayBreakfast = (TextView) rootView.findViewById(R.id.text_view_wed_breakfast);
        textViews.add(textViewWednesdayBreakfast);
        textViewWednesdayLunch = (TextView) rootView.findViewById(R.id.text_view_wed_lunch);
        textViews.add(textViewWednesdayLunch);
        textViewWednesdayDinner = (TextView) rootView.findViewById(R.id.text_view_wed_dinner);
        textViews.add(textViewWednesdayDinner);

        textViewThursdayBreakfast = (TextView) rootView.findViewById(R.id.text_view_thu_breakfast);
        textViews.add(textViewThursdayBreakfast);
        textViewThursdayLunch = (TextView) rootView.findViewById(R.id.text_view_thu_lunch);
        textViews.add(textViewThursdayLunch);
        textViewThursdayDinner = (TextView) rootView.findViewById(R.id.text_view_thu_dinner);
        textViews.add(textViewThursdayDinner);

        textViewFridayBreakfast = (TextView) rootView.findViewById(R.id.text_view_fri_breakfast);
        textViews.add(textViewFridayBreakfast);
        textViewFridayLunch = (TextView) rootView.findViewById(R.id.text_view_fri_lunch);
        textViews.add(textViewFridayLunch);
        textViewFridayDinner = (TextView) rootView.findViewById(R.id.text_view_fri_dinner);
        textViews.add(textViewFridayDinner);

        textViewSaturdayBreakfast = (TextView) rootView.findViewById(R.id.text_view_sat_breakfast);
        textViews.add(textViewSaturdayBreakfast);
        textViewSaturdayLunch = (TextView) rootView.findViewById(R.id.text_view_sat_lunch);
        textViews.add(textViewSaturdayLunch);
        textViewSaturdayDinner = (TextView) rootView.findViewById(R.id.text_view_sat_dinner);
        textViews.add(textViewSaturdayDinner);

        textViewSundayBreakfast = (TextView) rootView.findViewById(R.id.text_view_sun_breakfast);
        textViews.add(textViewSundayBreakfast);
        textViewSundayLunch = (TextView) rootView.findViewById(R.id.text_view_sun_lunch);
        textViews.add(textViewSundayLunch);
        textViewSundayDinner = (TextView) rootView.findViewById(R.id.text_view_sun_dinner);
        textViews.add(textViewSundayDinner);

        attachOnClickListenerToTextViews();

        resetDate();
        updateCurrentWeekButtonText();
        updateEntries();
        return rootView;
    }

    private void attachOnClickListenerToTextViews() {
        for(TextView textView: textViews) {
            textView.setOnClickListener(this);
        }
    }

    private void detachOnClickListenerToTextViews() {
        for(TextView textView: textViews) {
            textView.setOnClickListener(null);
        }
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void mealSelectionCanceled() {
        closePopup();
    }

    @Override
    public void mealSelected(String newMeal) {




        DataHolder dataHolder = DataHolder.getInstance();
        DatabaseEntry entry = null;
        EssPlaDataSource dataSource = new EssPlaDataSource(getActivity());
        dataSource.open();


        GregorianCalendar calendar = (GregorianCalendar) startDate.clone();

        MealTime mealTime = null;

        if(buttonSelected.getId() == textViewMondayBreakfast.getId()) {
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.BREAKFAST);
            mealTime = MealTime.BREAKFAST;
        } else if(buttonSelected.getId() == textViewMondayLunch.getId()) {
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.LUNCH);
            mealTime = MealTime.LUNCH;
        } else if(buttonSelected.getId() == textViewMondayDinner.getId()) {
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.DINNER);
            mealTime = MealTime.DINNER;
        }
        else if(buttonSelected.getId() == textViewTuesdayBreakfast.getId()) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.BREAKFAST);
            mealTime = MealTime.BREAKFAST;
        } else if(buttonSelected.getId() == textViewTuesdayLunch.getId()) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.LUNCH);
            mealTime = MealTime.LUNCH;
        } else if(buttonSelected.getId() == textViewTuesdayDinner.getId()) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.DINNER);
            mealTime = MealTime.DINNER;
        }
        else if(buttonSelected.getId() == textViewWednesdayBreakfast.getId()) {
            calendar.add(Calendar.DAY_OF_MONTH, 2);
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.BREAKFAST);
            mealTime = MealTime.BREAKFAST;
        } else if(buttonSelected.getId() == textViewWednesdayLunch.getId()) {
            calendar.add(Calendar.DAY_OF_MONTH, 2);
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.LUNCH);
            mealTime = MealTime.LUNCH;
        } else if(buttonSelected.getId() == textViewWednesdayDinner.getId()) {
            calendar.add(Calendar.DAY_OF_MONTH, 2);
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.DINNER);
            mealTime = MealTime.DINNER;
        }
        else if(buttonSelected.getId() == textViewThursdayBreakfast.getId()) {
            calendar.add(Calendar.DAY_OF_MONTH, 3);
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.BREAKFAST);
            mealTime = MealTime.BREAKFAST;
        } else if(buttonSelected.getId() == textViewThursdayLunch.getId()) {
            calendar.add(Calendar.DAY_OF_MONTH, 3);
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.LUNCH);
            mealTime = MealTime.LUNCH;
        } else if(buttonSelected.getId() == textViewThursdayDinner.getId()) {
            calendar.add(Calendar.DAY_OF_MONTH, 3);
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.DINNER);
            mealTime = MealTime.DINNER;
        }
        else if(buttonSelected.getId() == textViewFridayBreakfast.getId()) {
            calendar.add(Calendar.DAY_OF_MONTH, 4);
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.BREAKFAST);
            mealTime = MealTime.BREAKFAST;
        } else if(buttonSelected.getId() == textViewFridayLunch.getId()) {
            calendar.add(Calendar.DAY_OF_MONTH, 4);
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.LUNCH);
            mealTime = MealTime.LUNCH;
        } else if(buttonSelected.getId() == textViewFridayDinner.getId()) {
            calendar.add(Calendar.DAY_OF_MONTH, 4);
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.DINNER);
            mealTime = MealTime.DINNER;
        }
        else if(buttonSelected.getId() == textViewSaturdayBreakfast.getId()) {
            calendar.add(Calendar.DAY_OF_MONTH, 5);
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.BREAKFAST);
            mealTime = MealTime.BREAKFAST;
        } else if(buttonSelected.getId() == textViewSaturdayLunch.getId()) {
            calendar.add(Calendar.DAY_OF_MONTH, 5);
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.LUNCH);
            mealTime = MealTime.LUNCH;
        } else if(buttonSelected.getId() == textViewSaturdayDinner.getId()) {
            calendar.add(Calendar.DAY_OF_MONTH, 5);
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.DINNER);
            mealTime = MealTime.DINNER;
        }
        else if(buttonSelected.getId() == textViewSundayBreakfast.getId()) {
            calendar.add(Calendar.DAY_OF_MONTH, 6);
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.BREAKFAST);
            mealTime = MealTime.BREAKFAST;
        } else if(buttonSelected.getId() == textViewSundayLunch.getId()) {
            calendar.add(Calendar.DAY_OF_MONTH, 6);
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.LUNCH);
            mealTime = MealTime.LUNCH;
        } else if(buttonSelected.getId() == textViewSundayDinner.getId()) {
            calendar.add(Calendar.DAY_OF_MONTH, 6);
            entry = dataHolder.findEntryByCalendar(calendar, MealTime.DINNER);
            mealTime = MealTime.DINNER;
        }

        dataSource.setMealForEntry(entry, newMeal, mealTime, calendar);


        dataSource.close();
        buttonSelected = null;
        updateEntries();

        closePopup();
    }

    @Override
    public void onDismiss() {
        closePopup();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onClick(View v) {

        System.out.println("OnClick");

        switch (v.getId()) {
            case R.id.image_button_next_week:
                // TODO
                nextWeek();
                break;
            case R.id.image_button_previous_week:
                // TODO
                previousWeek();
                break;
            case R.id.button_current_week:
                // TODO
                resetDate();
                updateCurrentWeekButtonText();
                updateEntries();
                break;
            default:
                if(v instanceof TextView) {
                    detachOnClickListenerToTextViews();

                    TextView textView = (TextView) v;

                    LayoutInflater layoutInflater
                            = (LayoutInflater) getActivity().getBaseContext()
                            .getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
                    View popupView = layoutInflater.inflate(R.layout.popup_meal, null);



                    final PopupWindow popupWindow = new PopupWindow(
                            popupView,
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
                    buttonSelected = v;
                    this.popupWindow = popupWindow;

                    popupWindow.setFocusable(true);
                    popupWindow.update();
                    popupWindow.setOnDismissListener(this);

                    EditText editText = (EditText) popupView.findViewById(R.id.edit_text_popup);
                    editText.setText(textView.getText());

                    String currentText = textView.getText().toString();
                    if(currentText.equals("?")) {
                        currentText = "";
                    }

                    PopupWindowHandler popupWindowHandler = new PopupWindowHandler(editText, (Button) popupView.findViewById(R.id.button_popup_ok), (Button) popupView.findViewById(R.id.button_popup_cancel), this, textView.getText().toString());

                    popupWindow.showAtLocation(rootView, Gravity.CENTER, 0, 0);
                    isPopupOpened = true;
                }
                break;
        }

    }

    public void nextWeek() {
        changeWeekByDays(7);
    }

    public void previousWeek() {
        changeWeekByDays(-7);
    }

    private void changeWeekByDays(int days) {
        startDate.add(Calendar.DAY_OF_MONTH, days);
        endDate.add(Calendar.DAY_OF_MONTH, days);

        updateCurrentWeekButtonText();
        updateEntries();
    }

    private void updateCurrentWeekButtonText() {
        buttonCurrentWeek.setText(startDate.get(Calendar.DAY_OF_MONTH) + "." + (startDate.get(Calendar.MONTH) + 1) + "." + startDate.get(Calendar.YEAR) + " - " + endDate.get(Calendar.DAY_OF_MONTH) + "." + (endDate.get(Calendar.MONTH) + 1) + "." + endDate.get(Calendar.YEAR));
    }

    private void resetDate() {
        startDate = new GregorianCalendar();
        startDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        endDate = new GregorianCalendar();
        endDate.setFirstDayOfWeek(Calendar.MONDAY);
        endDate.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    }

    private void setMealText(TextView textView, DatabaseEntry entry) {
        if(entry != null) {
            textView.setText(entry.getMeal());
            textView.setTextColor(Color.BLACK);
        } else {
            Resources res = getResources();
            textView.setText(res.getString(R.string.missing_meal));
            textView.setTextColor(Color.RED);
        }
    }

    public void updateEntries() {
        DataHolder dataHolder = DataHolder.getInstance();
        GregorianCalendar tempCalendar = (GregorianCalendar) startDate.clone();

        // Get entries for monday and set the image button images
        DatabaseEntry mondayBreakfastEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.BREAKFAST);
        setMealText(textViewMondayBreakfast, mondayBreakfastEntry);

        DatabaseEntry mondayLunchEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.LUNCH);
        setMealText(textViewMondayLunch, mondayLunchEntry);

        DatabaseEntry mondayDinnerEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.DINNER);
        setMealText(textViewMondayDinner, mondayDinnerEntry);

        // Get entries for tuesday and set the image button images
        tempCalendar.add(Calendar.DAY_OF_MONTH, 1);
        DatabaseEntry tuesdayBreakfastEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.BREAKFAST);
        setMealText(textViewTuesdayBreakfast, tuesdayBreakfastEntry);

        DatabaseEntry tuesdayLunchEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.LUNCH);
        setMealText(textViewTuesdayLunch, tuesdayLunchEntry);

        DatabaseEntry tuesdayDinnerEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.DINNER);
        setMealText(textViewTuesdayDinner, tuesdayDinnerEntry);

        // Get entries for wednesday and set the image button images
        tempCalendar.add(Calendar.DAY_OF_MONTH, 1);
        DatabaseEntry wednesdayBreakfastEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.BREAKFAST);
        setMealText(textViewWednesdayBreakfast, wednesdayBreakfastEntry);

        DatabaseEntry wednesdayLunchEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.LUNCH);
        setMealText(textViewWednesdayLunch, wednesdayLunchEntry);

        DatabaseEntry wednesdayDinnerEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.DINNER);
        setMealText(textViewWednesdayDinner, wednesdayDinnerEntry);

        // Get entries for thursday and set the image button images
        tempCalendar.add(Calendar.DAY_OF_MONTH, 1);
        DatabaseEntry thursdayBreakfastEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.BREAKFAST);
        setMealText(textViewThursdayBreakfast, thursdayBreakfastEntry);

        DatabaseEntry thursdayLunchEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.LUNCH);
        setMealText(textViewThursdayLunch, thursdayLunchEntry);

        DatabaseEntry thursdayDinnerEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.DINNER);
        setMealText(textViewThursdayDinner, thursdayDinnerEntry);

        // Get entries for friday and set the image button images
        tempCalendar.add(Calendar.DAY_OF_MONTH, 1);
        DatabaseEntry fridayBreakfastEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.BREAKFAST);
        setMealText(textViewFridayBreakfast, fridayBreakfastEntry);

        DatabaseEntry fridayLunchEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.LUNCH);
        setMealText(textViewFridayLunch, fridayLunchEntry);

        DatabaseEntry fridayDinnerEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.DINNER);
        setMealText(textViewFridayDinner, fridayDinnerEntry);


        // Get entries for saturday and set the image button images
        tempCalendar.add(Calendar.DAY_OF_MONTH, 1);
        DatabaseEntry saturdayBreakfastEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.BREAKFAST);
        setMealText(textViewSaturdayBreakfast, saturdayBreakfastEntry);

        DatabaseEntry saturdayLunchEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.LUNCH);
        setMealText(textViewSaturdayLunch, saturdayLunchEntry);

        DatabaseEntry saturdayDinnerEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.DINNER);
        setMealText(textViewSaturdayDinner, saturdayDinnerEntry);

        // Get entries for sunday and set the image button images
        tempCalendar.add(Calendar.DAY_OF_MONTH, 1);
        DatabaseEntry sundayBreakfastEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.BREAKFAST);
        setMealText(textViewSundayBreakfast, sundayBreakfastEntry);

        DatabaseEntry sundayLunchEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.LUNCH);
        setMealText(textViewSundayLunch, sundayLunchEntry);

        DatabaseEntry sundayDinnerEntry = dataHolder.findEntryByDate(tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH), MealTime.DINNER);
        setMealText(textViewSundayDinner, sundayDinnerEntry);
    }


    public boolean isPopupOpened() {
        return isPopupOpened;
    }

    public void setPopupOpened(boolean isPopupOpened) {
        this.isPopupOpened = isPopupOpened;
    }


    public void closePopup() {
        isPopupOpened = false;
        if(popupWindow != null && popupWindow.isShowing())
            popupWindow.dismiss();

        attachOnClickListenerToTextViews();
    }
}
