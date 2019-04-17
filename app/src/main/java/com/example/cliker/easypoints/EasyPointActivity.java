package com.example.cliker.easypoints;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.cliker.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class EasyPointActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_point);
        EasyPointFragment fragment = new EasyPointFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.place_holder, fragment);
        fragmentTransaction.commit();
    }
}
