package org.nieke.esspla;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import org.nieke.esspla.data.DataHolder;
import org.nieke.esspla.data.DatabaseEntry;
import org.nieke.esspla.data.EssPlaDataSource;
import org.nieke.esspla.data.MealTime;
import org.nieke.esspla.fragments.WeekFragment;

import java.util.GregorianCalendar;
import java.util.List;

public class EssPlaActivity extends AppCompatActivity {

    private final static int PAGE_COUNT = 1;

    private WeekFragment weekFragment;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EssPlaDataSource dataSource = new EssPlaDataSource(this);
        dataSource.open();
        DataHolder.getInstance().setEntryList(dataSource.getAllEntries());
        dataSource.close();



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ess_pla);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }

    @Override
    public void onPause() {
        Intent weekWidgetIntent = new Intent(this, EssPlaWeekWidget.class);
        weekWidgetIntent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
        int weekWidgetIds[] = AppWidgetManager.getInstance(getApplication()).getAppWidgetIds(new ComponentName(getApplication(), EssPlaWeekWidget.class));
        weekWidgetIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, weekWidgetIds);
        sendBroadcast(weekWidgetIntent);

        super.onPause();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ess_pla, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            boolean onePopupOpened = false;

            if(weekFragment != null && weekFragment.isPopupOpened()) {
                onePopupOpened = true;
                weekFragment.closePopup();
                return true;
            }
        }

        return super.onKeyDown(keyCode, event);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            switch(position) {
                case 0:
                    weekFragment = WeekFragment.newInstance();
                    return weekFragment;
                default:
                    weekFragment = WeekFragment.newInstance();
                    return weekFragment;
            }
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Week";
            }
            return null;
        }
    }
}
