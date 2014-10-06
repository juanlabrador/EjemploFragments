package com.example.juanlabrador.ejemplofragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends FragmentActivity implements ListEmailsFragment.EmailsListener {

    ListEmailsFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            //getFragmentManager().beginTransaction()
            //        .add(R.id.container, new PlaceholderFragment())
            //        .commit();

            listFragment = (ListEmailsFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentList);
            listFragment.setEmailListener(this);
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onEmailSelected(Email e) {
        boolean thereIsDetail = (getSupportFragmentManager().findFragmentById(R.id.fragmentDetails) != null);

        if (thereIsDetail) {
            ((EmailDetailsFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentDetails)).showDetails(e.getText());
        } else {
            Intent i = new Intent(this, DetailActivity.class);
            i.putExtra(DetailActivity.TEXT_EXTRA, e.getText());
            startActivity(i);
        }

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_list, container, false);
            return rootView;
        }
    }
}
