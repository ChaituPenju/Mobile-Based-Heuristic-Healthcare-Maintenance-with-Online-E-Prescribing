package com.example.penjuris.medicalapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.ListFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;


public class SymptomsCheckFragment extends ListFragment implements AdapterView.OnItemClickListener {
    EditText search;Intent gs;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }
    ArrayAdapter adapter;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        search = (EditText)getActivity().findViewById(R.id.searchsym);
        adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Symptoms, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SymptomsCheckFragment.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = search.getText().toString();
                SymptomsCheckFragment.this.adapter.getFilter().filter(text);
            }
        });
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getItemAtPosition(position).equals("Allergies")){
                gs = new Intent(SymptomsCheckFragment.this.getActivity(), SymptomsCheckWeb.class);
                gs.putExtra("URL", "file:android_asset/Htipz/Allergies.html");
                startActivity(gs);
        }
        else if(parent.getItemAtPosition(position).equals("Appendicitis")){
                gs = new Intent(SymptomsCheckFragment.this.getActivity(), SymptomsCheckWeb.class);
                gs.putExtra("URL", "file:android_asset/Htipz/Appendicitis.html");
                startActivity(gs);
        }
            else if(parent.getItemAtPosition(position).equals("Astama")) {
            gs = new Intent(SymptomsCheckFragment.this.getActivity(), SymptomsCheckWeb.class);
            gs.putExtra("URL", "file:android_asset/Htipz/Asthama.html");
            startActivity(gs);
        }
            else if(parent.getItemAtPosition(position).equals("Cholera")) {
            gs = new Intent(SymptomsCheckFragment.this.getActivity(), SymptomsCheckWeb.class);
            gs.putExtra("URL", "file:android_asset/Htipz/Cholera.html");
            startActivity(gs);
        }
            else if(parent.getItemAtPosition(position).equals("Dengue")){
                gs = new Intent(SymptomsCheckFragment.this.getActivity(), HealthTipsWeb.class);
                gs.putExtra("URL", "file:android_asset/Htipz/Dengue.html");
                startActivity(gs);
        }
            else if(parent.getItemAtPosition(position).equals("Diabetes")){
                gs = new Intent(SymptomsCheckFragment.this.getActivity(), SymptomsCheckWeb.class);
                gs.putExtra("URL", "file:android_asset/Htipz/Diabetes.html");
                startActivity(gs);
        }
            else if(parent.getItemAtPosition(position).equals("Fever")) {
            gs = new Intent(SymptomsCheckFragment.this.getActivity(), SymptomsCheckWeb.class);
            gs.putExtra("URL", "file:android_asset/Htipz/Fever.html");
            startActivity(gs);
        }
            else if(parent.getItemAtPosition(position).equals("Influenza")) {
            gs = new Intent(SymptomsCheckFragment.this.getActivity(), SymptomsCheckWeb.class);
            gs.putExtra("URL", "file:android_asset/Htipz/Influenza.html");
            startActivity(gs);
        }
            else if(parent.getItemAtPosition(position).equals("Malaria")) {
            gs = new Intent(SymptomsCheckFragment.this.getActivity(), SymptomsCheckWeb.class);
            gs.putExtra("URL", "file:android_asset/Htipz/Malaria.html");
            startActivity(gs);
        }
            else if(parent.getItemAtPosition(position).equals("StomachCancer")) {
            gs = new Intent(SymptomsCheckFragment.this.getActivity(), SymptomsCheckWeb.class);
            gs.putExtra("URL", "file:android_asset/Htipz/StomachCancer.html");
            startActivity(gs);
        }
            else if(parent.getItemAtPosition(position).equals("Tuberculosis")) {
            gs = new Intent(SymptomsCheckFragment.this.getActivity(), SymptomsCheckWeb.class);
            gs.putExtra("URL", "file:android_asset/Htipz/Tuberculosis.html");
            startActivity(gs);
        }
            else if(parent.getItemAtPosition(position).equals("Typhoid")) {
            gs = new Intent(SymptomsCheckFragment.this.getActivity(), SymptomsCheckWeb.class);
            gs.putExtra("URL", "file:android_asset/Htipz/Typhoid.html");
            startActivity(gs);
        }
    }
}

