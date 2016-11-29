package com.example.android.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        ArrayAdapter<String> mForecastAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            //Create a fake data ListView
            String[] data = {
                    "Sunday 27/11 - Cloudy - 1/7",
                    "Monday 28/11 - Cloudy - 2/8",
                    "Tuesday 29/11 - Cloudy - 3/12",
                    "Wednesday 30/11 - Rainy - 1/5",
                    "Thursday 01/12 - Rainy - 3/8",
                    "Friday 02/12 - Foggy - 5/-",
                    "Saturday 03/12 - Cloudy - 1/3"
            };
            List<String> weekForecast = new ArrayList<String>(Arrays.asList(data));

            //Adaptor
            mForecastAdapter =
                    new ArrayAdapter<String>(
                            //current context
                            getActivity(),
                            //Id of List item Layout
                            R.layout.list_item_forecast,
                            //Id of the textView to populate
                            R.id.list_item_forecast_textview,
                            //Forecast dat
                            weekForecast
                    );

            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}
