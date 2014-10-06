package com.example.juanlabrador.ejemplofragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by juanlabrador on 06/10/14.
 */
public class ListEmailsFragment extends Fragment {

    private Email[] emails =
            new Email[]{
                    new Email("Persona 1", "Asunto del correo 1", "Texto del correo 1"),
                    new Email("Persona 2", "Asunto del correo 2", "Texto del correo 2"),
                    new Email("Persona 3", "Asunto del correo 3", "Texto del correo 3"),
                    new Email("Persona 4", "Asunto del correo 4", "Texto del correo 4"),
                    new Email("Persona 5", "Asunto del correo 5", "Texto del correo 5")};

    private ListView listView;
    private EmailsListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        listView = (ListView)getView().findViewById(R.id.listView);

        listView.setAdapter(new AdapterEmails(this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                if (listener != null) {
                    listener.onEmailSelected((Email) listView.getAdapter().getItem(pos));
                }
            }
        });
    }


    class AdapterEmails extends ArrayAdapter<Email> {

        Activity context;

        AdapterEmails(Fragment context) {
            super(context.getActivity(), R.layout.list_item_email, emails);
            this.context = context.getActivity();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.list_item_email, null);

            TextView by = (TextView)item.findViewById(R.id.tvBy);
            by.setText(emails[position].getBy());

            TextView matter = (TextView)item.findViewById(R.id.tvMatter);
            matter.setText(emails[position].getMatter());

            return(item);
        }
    }

    public interface EmailsListener {
        void onEmailSelected(Email e);
    }

    public void setEmailListener(EmailsListener listener) {
        this.listener = listener;
    }
}
