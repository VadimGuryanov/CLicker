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

public class AlgemClick extends Fragment {


    TextView algemClickPoints;
    Button algemButton;
    int current;
    MoneyProcessing moneyProcessing = BottomActivity.moneyProcessing;

    public static int number = 1;


    public static AlgemClick newInstance() {
        AlgemClick fragment = new AlgemClick();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_algem_click, container, false);
        algemButton = view.findViewById(R.id.btn_algem);
        algemClickPoints = view.findViewById(R.id.tv_algemClickPoints);
        algemButton.setOnClickListener(x -> {
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
        algemClickPoints.setText(moneyProcessing.getAlgemMoney()+"");
    }


    public void algemButtonClick() throws IOException {
        current = moneyProcessing.getAlgemMoney()+number;
        moneyProcessing.setAlgemMoney(current);
        String s = Integer.toString(current);
        algemClickPoints.setText(s);
    }


}
