package com.example.expansetracker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.expansetracker.Adapter.MainAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ConverterFragment extends Fragment {

    private MainAdapter adapter;
    private RecyclerView mainlist;
    List<String> country = new ArrayList<String>();

    public ConverterFragment() {
        // Required empty public constructor
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_converter, container, false);
       mainlist = view.findViewById(R.id.mainlist);
       country.add("INR");
       country.add("USD");
       country.add("GBP");
       country.add("AED");
       country.add("EUR");
       country.add("CAD");
       country.add("PL");
        setlist();
        return view;
    }
   private void setlist(){
        adapter = new MainAdapter(getActivity(),country);
        mainlist.setAdapter(adapter);
    }
}