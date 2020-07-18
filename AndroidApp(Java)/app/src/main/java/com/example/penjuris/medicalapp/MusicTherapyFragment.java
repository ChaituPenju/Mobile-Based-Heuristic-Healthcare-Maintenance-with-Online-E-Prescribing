package com.example.penjuris.medicalapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;


public class MusicTherapyFragment extends ListFragment implements AdapterView.OnItemClickListener {
    Intent it;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Musics, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent n;
        switch(position){
            case 0:
                String  myUrl = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.song1;
                 n = new Intent(MusicTherapyFragment.this.getActivity() , MediaContr.class);
                n.putExtra("URL",myUrl);
                startActivity(n);
                break;
            case 1:
                String  myUrl1 = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.song2;
                n = new Intent(MusicTherapyFragment.this.getActivity() , MediaContr.class);
                n.putExtra("URL",myUrl1);
                startActivity(n);
                break;
            case 2:
                String  myUrl2 = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.song3;
                n = new Intent(MusicTherapyFragment.this.getActivity() , MediaContr.class);
                n.putExtra("URL",myUrl2);
                startActivity(n);
                break;
            case 3:
                String  myUrl3 = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.song4;
                n = new Intent(MusicTherapyFragment.this.getActivity() , MediaContr.class);
                n.putExtra("URL",myUrl3);
                startActivity(n);
                break;
            case 4:
                String  myUrl4 = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.song5;
                n = new Intent(MusicTherapyFragment.this.getActivity() , MediaContr.class);
                n.putExtra("URL",myUrl4);
                startActivity(n);
                break;
            case 5:
                String  myUrl5 = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.song6;
                n = new Intent(MusicTherapyFragment.this.getActivity() , MediaContr.class);
                n.putExtra("URL",myUrl5);
                startActivity(n);
                break;
            case 6:
                String  myUrl6 = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.song7;
                n = new Intent(MusicTherapyFragment.this.getActivity() , MediaContr.class);
                n.putExtra("URL",myUrl6);
                startActivity(n);
                break;
            case 7:
                String  myUrl7 = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.song8;
                n = new Intent(MusicTherapyFragment.this.getActivity() , MediaContr.class);
                n.putExtra("URL",myUrl7);
                startActivity(n);
                break;
            case 8:
                String  myUrl8 = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.song9;
                n = new Intent(MusicTherapyFragment.this.getActivity() , MediaContr.class);
                n.putExtra("URL",myUrl8);
                startActivity(n);
                break;
            case 9:
                String  myUrl9 = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.song10;
                n = new Intent(MusicTherapyFragment.this.getActivity() , MediaContr.class);
                n.putExtra("URL",myUrl9);
                startActivity(n);
                break;
        }
    }
}
