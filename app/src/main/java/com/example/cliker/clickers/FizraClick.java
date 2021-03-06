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
import com.example.cliker.money.MoneyProcessingFizra;
import com.example.cliker.money.MoneyProcessingFizraBalance;

import java.io.IOException;

import static com.example.cliker.BottomActivity.moneyProcessingInfa;
import static com.example.cliker.clickers.AlgemClick.algemFizraProcessing;

public class FizraClick extends Fragment {


    private TextView fizraClickPoints;
    private TextView balance;
    private Button fizraButton;
    private int current;
    MoneyProcessingFizra moneyProcessingFizra = BottomActivity.moneyProcessingFizra;
    MoneyProcessingFizraBalance moneyProcessingFizraBalance = BottomActivity.moneyProcessingFizraBalance;

    public static int number;


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
        balance = view.findViewById(R.id.fizra_balance);
        number = Integer.parseInt(algemFizraProcessing.getText());
        fizraButton.setOnClickListener(x -> {
            try {
                fizraButtonClick();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        fizraClickPoints.setText(moneyProcessingFizra.getText() +"");
        balance.setText(moneyProcessingFizraBalance.getText() + "");
    }


    public void fizraButtonClick() throws IOException {
        current = Integer.parseInt(moneyProcessingFizra.getText())+number;
        String s = Integer.toString(current);
        moneyProcessingFizra.saveText(s);
        fizraClickPoints.setText(s);
        current = Integer.parseInt(moneyProcessingFizraBalance.getText())+number;
        s = Integer.toString(current);
        moneyProcessingFizraBalance.saveText(s);
        balance.setText(s);
    }

}
