package com.example.penjuris.medicalapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

/**
 * Created by Penjuris on 2/26/2017.
 */

public class HealthTipsFragment extends ListFragment implements AdapterView.OnItemClickListener {
    Intent gs;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment1, container, false);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Tips, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch(position){
            case 0:
                gs = new Intent(HealthTipsFragment.this.getActivity(), HealthTipsWeb.class);
                gs.putExtra("URL", "file:android_asset/Htipz/HT1.html");
                startActivity(gs);
                break;
            case 1:
                gs = new Intent(HealthTipsFragment.this.getActivity(), HealthTipsWeb.class);
                gs.putExtra("URL", "file:android_asset/Htipz/HT2.html");
                startActivity(gs);
                break;
            case 2:
                gs = new Intent(HealthTipsFragment.this.getActivity(), HealthTipsWeb.class);
                gs.putExtra("URL", "file:android_asset/Htipz/HT3.html");
                startActivity(gs);
                break;
            case 3:
                gs = new Intent(HealthTipsFragment.this.getActivity(), HealthTipsWeb.class);
                gs.putExtra("URL", "file:android_asset/Htipz/HT4.html");
                startActivity(gs);
                break;
            case 4:
                gs = new Intent(HealthTipsFragment.this.getActivity(), HealthTipsWeb.class);
                gs.putExtra("URL", "file:android_asset/Htipz/HT5.html");
                startActivity(gs);
                break;
            case 5:
                gs = new Intent(HealthTipsFragment.this.getActivity(), HealthTipsWeb.class);
                gs.putExtra("URL", "file:android_asset/Htipz/HT6.html");
                startActivity(gs);
                break;
            case 6:
                gs = new Intent(HealthTipsFragment.this.getActivity(), HealthTipsWeb.class);
                gs.putExtra("URL", "file:android_asset/Htipz/HT7.html");
                startActivity(gs);
                break;
            case 7:
                gs = new Intent(HealthTipsFragment.this.getActivity(), HealthTipsWeb.class);
                gs.putExtra("URL", "file:android_asset/Htipz/HT8.html");
                startActivity(gs);
                break;
            case 8:
                gs = new Intent(HealthTipsFragment.this.getActivity(), HealthTipsWeb.class);
                gs.putExtra("URL", "file:android_asset/Htipz/HT9.html");
                startActivity(gs);
                break;
            case 9:
                gs = new Intent(HealthTipsFragment.this.getActivity(), HealthTipsWeb.class);
                gs.putExtra("URL", "file:android_asset/Htipz/HT10.html");
                startActivity(gs);
                break;
            case 10:
                gs = new Intent(HealthTipsFragment.this.getActivity(), HealthTipsWeb.class);
                gs.putExtra("URL", "file:android_asset/Htipz/HT11.html");
                startActivity(gs);
                break;
            case 11:
                gs = new Intent(HealthTipsFragment.this.getActivity(), HealthTipsWeb.class);
                gs.putExtra("URL", "file:android_asset/Htipz/HT12.html");
                startActivity(gs);
                break;
        }
    }
}
