package com.example.cliker.clickers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cliker.BottomActivity;
import com.example.cliker.R;
import com.example.cliker.money.MoneyProcessing;

import java.io.IOException;

public class FizraClick extends Fragment {


    TextView fizraClickPoints;
    Button fizraButton;
    int current;
    MoneyProcessing moneyProcessing = BottomActivity.moneyProcessing;

    public static int number = 1;


    public static FizraClick newInstance() {
        FizraClick fragment = new FizraClick();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fizra_click, container, false);
        fizraButton = view.findViewById(R.id.btn_fizra);
        fizraClickPoints = view.findViewById(R.id.tv_fizraClickPoints);
        fizraButton.setOnClickListener(x -> {
            try {
                algemButtonClick();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        fizraClickPoints.setText(moneyProcessing.getFizraMoney()+"");
    }


    public void algemButtonClick() throws IOException {
        current = moneyProcessing.getFizraMoney()+number;
        moneyProcessing.setFizraMoney(current);
        String s = Integer.toString(current);
        fizraClickPoints.setText(s);
    }


}
