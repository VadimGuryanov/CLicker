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
import com.example.cliker.money.MoneyProcessingInfa;
import com.example.cliker.money.MoneyProcessingInfaBalance;

import java.io.IOException;

public class InfaClick extends Fragment {


    TextView infaClickPoints;
    Button infaButton;
    int current;
    private TextView balance;
    MoneyProcessingInfa moneyProcessingInfa = BottomActivity.moneyProcessingInfa;
    MoneyProcessingInfaBalance moneyProcessingInfaBalance = BottomActivity.moneyProcessingInfaBalance;

    public static int number = 1;


    public static InfaClick newInstance() {
        InfaClick fragment = new InfaClick();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_infa_click, container, false);
        infaButton = view.findViewById(R.id.btn_infa);
        infaClickPoints = view.findViewById(R.id.tv_infaClickPoints);
        balance = view.findViewById(R.id.infa_balance);
        infaButton.setOnClickListener(x -> {
            try {
                infaButtonClick();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        infaClickPoints.setText(moneyProcessingInfa.getText() +"");
        balance.setText(moneyProcessingInfaBalance.getText() +"");
    }


    public void infaButtonClick() throws IOException {
        current = Integer.parseInt(moneyProcessingInfa.getText())+number;
        String s = Integer.toString(current);
        moneyProcessingInfa.saveText(s);
        infaClickPoints.setText(s);
        current = Integer.parseInt(moneyProcessingInfaBalance.getText())+number;
        s = Integer.toString(current);
        moneyProcessingInfaBalance.saveText(s);
        balance.setText(s);
    }


}
