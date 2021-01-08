package com.example.expansetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomnavigation = findViewById(R.id.bottomnavigation);
        LinearLayout updatetime = findViewById(R.id.updatetime);
        TextView fragmentname = findViewById(R.id.fragmentname);
        showconverterFragment();

        bottomnavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.converter:
                        showconverterFragment();
                        updatetime.setVisibility(View.VISIBLE);
                        fragmentname.setText(R.string.converter);
                        return true;
                    case R.id.chart:
                        showchartFragment();
                        updatetime.setVisibility(View.GONE);
                        fragmentname.setText(R.string.chart);
                        return true;
                    case R.id.compare:
                        showcompareFragment();
                        updatetime.setVisibility(View.GONE);
                        fragmentname.setText(R.string.compare);
                        return true;
                    case R.id.more:
                        showmoreFragment();
                        updatetime.setVisibility(View.GONE);
                        fragmentname.setText(R.string.more);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void showconverterFragment(){
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.mainframe, new ConverterFragment()).commit();
    }
    private void showchartFragment(){
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.mainframe, new ChartFragment()).commit();
    }
    private void showcompareFragment(){
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.mainframe, new CompareFragment()).commit();
    }
    private void showmoreFragment(){
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.mainframe, new MoreFragment()).commit();
    }
}