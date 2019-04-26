package com.example.cliker.clickers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cliker.BottomActivity;
import com.example.cliker.R;
import com.example.cliker.money.MoneyProcessingAlgem;
import com.example.cliker.money.MoneyProcessingAlgemBalance;

import java.io.IOException;

public class AlgemClick extends Fragment {


    TextView algemClickPoints;
    Button algemButton;
    int current;
    private TextView balance;
    MoneyProcessingAlgem moneyProcessingAlgem = BottomActivity.moneyProcessingAlgem;
    MoneyProcessingAlgemBalance moneyProcessingAlgemBalance = BottomActivity.moneyProcessingAlgemBalance;

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
        balance = view.findViewById(R.id.algem_balance);
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
        algemClickPoints.setText(moneyProcessingAlgem.getText() +"");
        balance.setText(moneyProcessingAlgemBalance.getText() +"");
    }


    public void algemButtonClick() throws IOException {
        current = Integer.parseInt(moneyProcessingAlgem.getText())+number;
        String s = Integer.toString(current);
        moneyProcessingAlgem.saveText(s);
        algemClickPoints.setText(s);
        current = Integer.parseInt(moneyProcessingAlgemBalance.getText())+number;
        s = Integer.toString(current);
        moneyProcessingAlgemBalance.saveText(s);
        balance.setText(s);
    }


}
