package com.example.cliker.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cliker.BottomActivity;
import com.example.cliker.R;
import com.example.cliker.clickers.AlgemClick;
import com.example.cliker.money.MoneyProcessing;
import com.example.cliker.shop.ShopFragment;

import java.io.FileWriter;
import java.io.IOException;

public class HomeFragment extends Fragment {


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

}
