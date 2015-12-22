package org.nieke.esspla.fragments;

import android.content.Context;
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
import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WeekFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WeekFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeekFragment extends Fragment implements View.OnClickListener, PopupMealListener {

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

    private View buttonSelected;

    protected boolean isPopupOpened = false;
    protected PopupWindow popupWindow;

    public WeekFragment() {
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
        textViewMondayBreakfast.setOnClickListener(this);
        textViewMondayLunch = (TextView) rootView.findViewById(R.id.text_view_mon_lunch);
        textViewMondayLunch.setOnClickListener(this);
        textViewMondayDinner = (TextView) rootView.findViewById(R.id.text_view_mon_dinner);
        textViewMondayDinner.setOnClickListener(this);

        textViewTuesdayBreakfast = (TextView) rootView.findViewById(R.id.text_view_tue_breakfast);
        textViewTuesdayBreakfast.setOnClickListener(this);
        textViewTuesdayLunch = (TextView) rootView.findViewById(R.id.text_view_tue_lunch);
        textViewTuesdayLunch.setOnClickListener(this);
        textViewTuesdayDinner = (TextView) rootView.findViewById(R.id.text_view_tue_dinner);
        textViewTuesdayDinner.setOnClickListener(this);

        textViewWednesdayBreakfast = (TextView) rootView.findViewById(R.id.text_view_wed_breakfast);
        textViewWednesdayBreakfast.setOnClickListener(this);
        textViewWednesdayLunch = (TextView) rootView.findViewById(R.id.text_view_wed_lunch);
        textViewWednesdayLunch.setOnClickListener(this);
        textViewWednesdayDinner = (TextView) rootView.findViewById(R.id.text_view_wed_dinner);
        textViewWednesdayDinner.setOnClickListener(this);

        textViewThursdayBreakfast = (TextView) rootView.findViewById(R.id.text_view_thu_breakfast);
        textViewThursdayBreakfast.setOnClickListener(this);
        textViewThursdayLunch = (TextView) rootView.findViewById(R.id.text_view_thu_lunch);
        textViewThursdayLunch.setOnClickListener(this);
        textViewThursdayDinner = (TextView) rootView.findViewById(R.id.text_view_thu_dinner);
        textViewThursdayDinner.setOnClickListener(this);

        textViewFridayBreakfast = (TextView) rootView.findViewById(R.id.text_view_fri_breakfast);
        textViewFridayBreakfast.setOnClickListener(this);
        textViewFridayLunch = (TextView) rootView.findViewById(R.id.text_view_fri_lunch);
        textViewFridayLunch.setOnClickListener(this);
        textViewFridayDinner = (TextView) rootView.findViewById(R.id.text_view_fri_dinner);
        textViewFridayDinner.setOnClickListener(this);

        textViewSaturdayBreakfast = (TextView) rootView.findViewById(R.id.text_view_sat_breakfast);
        textViewSaturdayBreakfast.setOnClickListener(this);
        textViewSaturdayLunch = (TextView) rootView.findViewById(R.id.text_view_sat_lunch);
        textViewSaturdayLunch.setOnClickListener(this);
        textViewSaturdayDinner = (TextView) rootView.findViewById(R.id.text_view_sat_dinner);
        textViewSaturdayDinner.setOnClickListener(this);

        textViewSundayBreakfast = (TextView) rootView.findViewById(R.id.text_view_sun_breakfast);
        textViewSundayBreakfast.setOnClickListener(this);
        textViewSundayLunch = (TextView) rootView.findViewById(R.id.text_view_sun_lunch);
        textViewSundayLunch.setOnClickListener(this);
        textViewSundayDinner = (TextView) rootView.findViewById(R.id.text_view_sun_dinner);
        textViewSundayDinner.setOnClickListener(this);


        resetDate();
        updateCurrentWeekButtonText();
        updateEntries();
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
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


//            GregorianCalendar calendar = (GregorianCalendar) startDate.clone();
//
//            if(buttonSelected.getId() == imageButtonMondayMorning.getId()) {
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.MORNING);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.MORNING, calendar);
//            } else if(buttonSelected.getId() == imageButtonMondayNoon.getId()) {
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.NOON);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.NOON, calendar);
//            } else if(buttonSelected.getId() == imageButtonMondayEvening.getId()) {
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.EVENING);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.EVENING, calendar);
//            } else if(buttonSelected.getId() == imageButtonTuesdayMorning.getId()) {
//                calendar.add(Calendar.DAY_OF_MONTH, 1);
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.MORNING);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.MORNING, calendar);
//            } else if(buttonSelected.getId() == imageButtonTuesdayNoon.getId()) {
//                calendar.add(Calendar.DAY_OF_MONTH, 1);
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.NOON);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.NOON, calendar);
//            } else if(buttonSelected.getId() == imageButtonTuesdayEvening.getId()) {
//                calendar.add(Calendar.DAY_OF_MONTH, 1);
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.EVENING);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.EVENING, calendar);
//            } else if(buttonSelected.getId() == imageButtonWednesdayMorning.getId()) {
//                calendar.add(Calendar.DAY_OF_MONTH, 2);
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.MORNING);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.MORNING, calendar);
//            } else if(buttonSelected.getId() == imageButtonWednesdayNoon.getId()) {
//                calendar.add(Calendar.DAY_OF_MONTH, 2);
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.NOON);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.NOON, calendar);
//            } else if(buttonSelected.getId() == imageButtonWednesdayEvening.getId()) {
//                calendar.add(Calendar.DAY_OF_MONTH, 2);
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.EVENING);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.EVENING, calendar);
//            } else if(buttonSelected.getId() == imageButtonThursdayMorning.getId()) {
//                calendar.add(Calendar.DAY_OF_MONTH, 3);
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.MORNING);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.MORNING, calendar);
//            } else if(buttonSelected.getId() == imageButtonThursdayNoon.getId()) {
//                calendar.add(Calendar.DAY_OF_MONTH, 3);
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.NOON);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.NOON, calendar);
//            } else if(buttonSelected.getId() == imageButtonThursdayEvening.getId()) {
//                calendar.add(Calendar.DAY_OF_MONTH, 3);
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.EVENING);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.EVENING, calendar);
//            } else if(buttonSelected.getId() == imageButtonFridayMorning.getId()) {
//                calendar.add(Calendar.DAY_OF_MONTH, 4);
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.MORNING);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.MORNING, calendar);
//            } else if(buttonSelected.getId() == imageButtonFridayNoon.getId()) {
//                calendar.add(Calendar.DAY_OF_MONTH, 4);
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.NOON);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.NOON, calendar);
//            } else if(buttonSelected.getId() == imageButtonFridayEvening.getId()) {
//                calendar.add(Calendar.DAY_OF_MONTH, 4);
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.EVENING);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.EVENING, calendar);
//            } else if(buttonSelected.getId() == imageButtonSaturdayMorning.getId()) {
//                calendar.add(Calendar.DAY_OF_MONTH, 5);
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.MORNING);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.MORNING, calendar);
//            } else if(buttonSelected.getId() == imageButtonSaturdayNoon.getId()) {
//                calendar.add(Calendar.DAY_OF_MONTH, 5);
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.NOON);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.NOON, calendar);
//            } else if(buttonSelected.getId() == imageButtonSaturdayEvening.getId()) {
//                calendar.add(Calendar.DAY_OF_MONTH, 5);
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.EVENING);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.EVENING, calendar);
//            } else if(buttonSelected.getId() == imageButtonSundayMorning.getId()) {
//                calendar.add(Calendar.DAY_OF_MONTH, 6);
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.MORNING);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.MORNING, calendar);
//            } else if(buttonSelected.getId() == imageButtonSundayNoon.getId()) {
//                calendar.add(Calendar.DAY_OF_MONTH, 6);
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.NOON);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.NOON, calendar);
//            } else if(buttonSelected.getId() == imageButtonSundayEvening.getId()) {
//                calendar.add(Calendar.DAY_OF_MONTH, 6);
//                entry = dataHolder.findHuPlaEntryByCalendar(calendar, HuPlaTime.EVENING);
//                dataSource.setHuPlaTypeForEntry(entry, huPlaType, HuPlaTime.EVENING, calendar);
//            }


            dataSource.close();
            buttonSelected = null;
            updateEntries();

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

                    EditText editText = (EditText) popupView.findViewById(R.id.edit_text_popup);
                    editText.setText(textView.getText());

                    PopupWindowHandler popupWindowHandler = new PopupWindowHandler(editText, (Button) popupView.findViewById(R.id.button_popup_ok), (Button) popupView.findViewById(R.id.button_popup_cancel), this, textView.getText().toString());

//                    PopupWindowButtonHandler popupWindowButtonHandler = new PopupWindowButtonHandler((android.widget.TableLayout) popupView.findViewById(R.id.table_layout_popup), popupWindow, this);

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

    public void updateEntries() {
        // TODO
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
    }
}
