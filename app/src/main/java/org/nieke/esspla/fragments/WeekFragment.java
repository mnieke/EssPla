package org.nieke.esspla.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.nieke.esspla.R;

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
public class WeekFragment extends Fragment implements View.OnClickListener {

//    private View rootView;

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

        View view = inflater.inflate(R.layout.fragment_week, container, false);

        buttonCurrentWeek = (Button) view.findViewById(R.id.button_current_week);
        buttonCurrentWeek.setOnClickListener(this);

        ((ImageButton) view.findViewById(R.id.image_button_next_week)).setOnClickListener(this);
        ((ImageButton) view.findViewById(R.id.image_button_previous_week)).setOnClickListener(this);


        textViewMondayBreakfast = (TextView) view.findViewById(R.id.text_view_mon_breakfast);
        textViewMondayBreakfast.setOnClickListener(this);
        textViewMondayLunch = (TextView) view.findViewById(R.id.text_view_mon_lunch);
        textViewMondayLunch.setOnClickListener(this);
        textViewMondayDinner = (TextView) view.findViewById(R.id.text_view_mon_dinner);
        textViewMondayDinner.setOnClickListener(this);

        textViewTuesdayBreakfast = (TextView) view.findViewById(R.id.text_view_tue_breakfast);
        textViewTuesdayBreakfast.setOnClickListener(this);
        textViewTuesdayLunch = (TextView) view.findViewById(R.id.text_view_tue_lunch);
        textViewTuesdayLunch.setOnClickListener(this);
        textViewTuesdayDinner = (TextView) view.findViewById(R.id.text_view_tue_dinner);
        textViewTuesdayDinner.setOnClickListener(this);

        textViewWednesdayBreakfast = (TextView) view.findViewById(R.id.text_view_wed_breakfast);
        textViewWednesdayBreakfast.setOnClickListener(this);
        textViewWednesdayLunch = (TextView) view.findViewById(R.id.text_view_wed_lunch);
        textViewWednesdayLunch.setOnClickListener(this);
        textViewWednesdayDinner = (TextView) view.findViewById(R.id.text_view_wed_dinner);
        textViewWednesdayDinner.setOnClickListener(this);

        textViewThursdayBreakfast = (TextView) view.findViewById(R.id.text_view_thu_breakfast);
        textViewThursdayBreakfast.setOnClickListener(this);
        textViewThursdayLunch = (TextView) view.findViewById(R.id.text_view_thu_lunch);
        textViewThursdayLunch.setOnClickListener(this);
        textViewThursdayDinner = (TextView) view.findViewById(R.id.text_view_thu_dinner);
        textViewThursdayDinner.setOnClickListener(this);

        textViewFridayBreakfast = (TextView) view.findViewById(R.id.text_view_fri_breakfast);
        textViewFridayBreakfast.setOnClickListener(this);
        textViewFridayLunch = (TextView) view.findViewById(R.id.text_view_fri_lunch);
        textViewFridayLunch.setOnClickListener(this);
        textViewFridayDinner = (TextView) view.findViewById(R.id.text_view_fri_dinner);
        textViewFridayDinner.setOnClickListener(this);

        textViewSaturdayBreakfast = (TextView) view.findViewById(R.id.text_view_sat_breakfast);
        textViewSaturdayBreakfast.setOnClickListener(this);
        textViewSaturdayLunch = (TextView) view.findViewById(R.id.text_view_sat_lunch);
        textViewSaturdayLunch.setOnClickListener(this);
        textViewSaturdayDinner = (TextView) view.findViewById(R.id.text_view_sat_dinner);
        textViewSaturdayDinner.setOnClickListener(this);

        textViewSundayBreakfast = (TextView) view.findViewById(R.id.text_view_sun_breakfast);
        textViewSundayBreakfast.setOnClickListener(this);
        textViewSundayLunch = (TextView) view.findViewById(R.id.text_view_sun_lunch);
        textViewSundayLunch.setOnClickListener(this);
        textViewSundayDinner = (TextView) view.findViewById(R.id.text_view_sun_dinner);
        textViewSundayDinner.setOnClickListener(this);


        resetDate();
        updateCurrentWeekButtonText();
        updateEntries();
        return view;
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
}
