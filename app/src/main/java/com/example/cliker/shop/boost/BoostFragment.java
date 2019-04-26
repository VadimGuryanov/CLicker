package com.example.cliker.shop.boost;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cliker.BottomActivity;
import com.example.cliker.MainFragment;
import com.example.cliker.R;
import com.example.cliker.clickers.AlgemClick;
import com.example.cliker.clickers.FizraClick;
import com.example.cliker.clickers.InfaClick;
import com.example.cliker.money.MoneyProcessingFizraBalance;

import java.io.IOException;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.cliker.BottomActivity.moneyProcessingAlgemBalance;

public class BoostFragment extends Fragment implements BoostCallBack {

    public static ArrayList<Booster> boosters;

    public static BoostFragment newInstance() {
        BoostFragment fragment = new BoostFragment();
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booster, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_forBooster);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new BoostAdapter(getBoosters(), this);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public ArrayList<Booster> getBoosters() {
        if (boosters == null) {
            boosters = new ArrayList<>();
            for (int i = 0; i < BoostData.CAPASITY; i++) {
                boosters.add(new Booster(BoostData.cloth_name[i], BoostData.description[i], BoostData.image[i], BoostData.point[i]
                        , BoostData.boosts[i], BoostData.getIsSold()[i]));
            }
        }
        return boosters;
    }


    @Override
    public void itemClick(int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if (!BoostAdapter.boosters.get(i).isSold()) {
            builder.setTitle("Покупка")
                    .setMessage("Вы действительно хотите приобрести?")
                    .setCancelable(false)
                    .setPositiveButton("Да",
                            (dialog, id) -> {
                        if (Integer.parseInt(moneyProcessingAlgemBalance.getText()) >= BoostAdapter.boosters.get(i).getPoint()) {
                            Toast.makeText(getContext(), "Покупка совершена", Toast.LENGTH_SHORT).show();
                            BoostAdapter.boosters.get(i).setSold(true);
                            BoostData.boostProcessing.saveText(recording());
                            AlgemClick.number += BoostAdapter.boosters.get(i).getBoost();
                            FizraClick.number += BoostAdapter.boosters.get(i).getBoost();
                            int current = Integer.parseInt(moneyProcessingAlgemBalance.getText()) - BoostAdapter.boosters.get(i).getPoint();
                            String s = Integer.toString(current);
                            moneyProcessingAlgemBalance.saveText(s);
                        }
                        else {
                            Toast.makeText(getContext(), "У вас недостаточно кликов по алгему", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Отмена",
                            (dialog, id) -> dialog.cancel());

            AlertDialog alert = builder.create();
            alert.show();
        }
        else {
            Toast.makeText(getContext(), "Этот бустер уже куплен", Toast.LENGTH_SHORT).show();
        }
    }

    private String recording() {
        String bools = "";
        for (int i = 0; i < BoostAdapter.boosters.size(); i++) {
            bools += String.valueOf(BoostAdapter.boosters.get(i).isSold() + " ");
        }
        return bools;
    }
}
