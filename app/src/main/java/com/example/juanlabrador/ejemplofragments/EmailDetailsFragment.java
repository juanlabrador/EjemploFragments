package com.example.juanlabrador.ejemplofragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by juanlabrador on 06/10/14.
 */
public class EmailDetailsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    public void showDetails(String text) {
        TextView details = (TextView) getView().findViewById(R.id.emailDetails);
        details.setText(text);
    }
}
